package router;

import app.Session;
import controller.Controller;
import event.NavigationHandler;
import util.Params;

import java.util.HashMap;
import java.util.Stack;

public class Router implements NavigationHandler {
    public static int OFFSET_START = 0;

    private HashMap<String, Controller> routes = new HashMap<>();
    private Stack<HistoryRecord> history = new Stack<>();
    private String currentPath;

    private Controller getController(String path) {
        return routes.get(path);
    }

    public void register(String path, Controller controller) {
        controller.onNavigate(this);

        routes.put(path, controller);
    }

    private void popCurrentPath(Params params) {
        Controller currController = getController(currentPath);

        currController.setActive(false);

        boolean shouldAddToHistory = params.getBoolean("addToHistory").orElse(true);

        if (shouldAddToHistory) {
            HistoryRecord historyRecord = new HistoryRecord(currentPath, params);

            history.push(historyRecord);
        }
    }

    private void navigate(String path, Params params) {
        Session session = Session.getInstance();
        Controller controller = getController(path);

        if (controller != null) {
            if (currentPath != null) {
                popCurrentPath(params);
            }

            currentPath = path;

            session.setRequestParams(params);

            controller.setActive(true);
            controller.render();
        } else {
            session.setRequestParams(new Params());

            System.out.printf("Path not found: %s\n", path);
        }
    }

    public void navigate(String path) {
        Params params = new Params();

        navigate(path, params);
    }

    @Override
    public void handleNavigate(String path, Params params) {
        if (path == "@back") {
            goBack(params);
        } else {
            navigate(path, params);
        }
    }

    public void goBack(Params params) {
        params.put("addToHistory", false);

        if (!history.empty()) {
            int offset = params.getInt("offset").orElse(OFFSET_START);
            HistoryRecord lastRecord = history.pop();

            for (int i = OFFSET_START; i < offset; i++) {
                lastRecord = history.pop();
            }

            navigate(
                    lastRecord.getPath(),
                    lastRecord.getParams().add(params)
            ); // do not add the current page to history, we can't go back to the page we are currently at
        } else {
            popCurrentPath(params);
        }
    }
}
