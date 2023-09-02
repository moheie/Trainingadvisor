package entity.course.material;

public abstract class Question {
    public abstract void display();

    public abstract void displayPreview();

    public abstract boolean validateAnswer(char answer);

    public abstract boolean checkAnswer(char answer);
}
