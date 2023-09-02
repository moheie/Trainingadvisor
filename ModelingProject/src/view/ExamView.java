package view;

import dto.ExamDTO;
import dto.ExamSolutionDTO;
import dto.LoginDTO;
import entity.course.material.Question;
import util.ValueBinding;

import java.util.List;
import java.util.Scanner;

public class ExamView extends FormView<ExamSolutionDTO, ExamDTO> {
    public ExamView(ValueBinding<Boolean> active) {
        super(active);
    }

    @Override
    public void display(ExamDTO params) {
        Scanner scanner = new Scanner(System.in);
        ExamSolutionDTO solutionDTO = new ExamSolutionDTO();

        List<Question> questions = params.getQuestions();

        int questionCount = questions.size();
        int counter = 1;

        char answer;

        for (Question question: questions) {
            System.out.printf("Question %d/%d\n", counter, questionCount);
            question.display();

            while (true) {
                System.out.print("Enter your answer: ");
                answer = scanner.next().charAt(0);

                if (question.validateAnswer(answer)) {
                    solutionDTO.addAnswer(answer);
                    break;
                } else {
                    System.out.println("Invalid answer");
                }
            }

            counter++;
        }

        submit(solutionDTO);
    }
}
