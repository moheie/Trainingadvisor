package router;

import util.Params;

public class HistoryRecord {
    private String path;
    private Params params;

    public HistoryRecord(String path, Params params) {
        this.path = path;
        this.params = params;
    }

    public String getPath() {
        return path;
    }

    public Params getParams() {
        return params;
    }
}
