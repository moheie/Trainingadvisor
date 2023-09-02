package entity.course.material;

public class TrueOrFalse extends Question {
    private String question;
    private boolean answer;

    public TrueOrFalse(String question) {
        this.question = question;
    }

    public TrueOrFalse(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public void display() {
        System.out.printf("%s (T/F)\n", question);
    }

    @Override
    public void displayPreview() {
        System.out.printf("[T/F] %s\n", question);
    }

    @Override
    public boolean validateAnswer(char answer) {
        answer = Character.toLowerCase(answer);

        return answer == 't' || answer == 'f';
    }

    @Override
    public boolean checkAnswer(char answer) {
        answer = Character.toLowerCase(answer);
        boolean boolAnswer = false;

        if (answer == 't') {
            boolAnswer = true;
        } else if (answer == 'f') {
            boolAnswer = false;
        }

        return boolAnswer == getAnswer();
    }
}
