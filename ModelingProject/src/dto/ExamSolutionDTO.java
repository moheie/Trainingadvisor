package dto;

import java.util.ArrayList;
import java.util.List;

public class ExamSolutionDTO {
    private List<Character> answers;

    public List<Character> getAnswers() {
        return answers;
    }

    public void addAnswer(char answer) {
        answers.add(answer);
    }

    public ExamSolutionDTO() {
        this.answers = new ArrayList<>();
    }
}
