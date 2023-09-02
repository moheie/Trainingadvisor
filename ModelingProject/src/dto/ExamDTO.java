package dto;

import entity.course.material.Question;

import java.util.List;

public class ExamDTO {
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public ExamDTO(List<Question> questions) {
        this.questions = questions;
    }
}
