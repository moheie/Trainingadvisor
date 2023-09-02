package entity.course.material;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private List<Question> questions;

    public Exam() {
        this.questions = new ArrayList<>();
    }

    public Exam(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void displayPreview() {
        int counter = 1;
        int questionCount = questions.size();

        for (Question question: questions) {
            System.out.printf("Question %d/%d\n", counter++, questionCount);
            question.displayPreview();
        }
    }
}
