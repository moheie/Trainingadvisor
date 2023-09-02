package controller;

import database.CourseDB;
import dto.ExamDTO;
import dto.ExamSolutionDTO;
import dto.LoginDTO;
import entity.course.Course;
import entity.course.material.CourseContent;
import entity.course.material.Exam;
import entity.course.material.Question;
import event.SubmitHandler;
import util.Params;
import view.ExamView;
import view.SignInView;

import java.util.List;

public class ExamController extends ViewController<ExamDTO, ExamView> implements SubmitHandler<ExamSolutionDTO> {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new ExamView(isActive);

        view.onExit(this);
        view.onSubmit(this);
    }

    private int getCourseId() {
        Params requestParams = getRequestParams();
        int courseId = requestParams.getInt("courseId").orElseThrow();

        return courseId;
    }

    private Course getCourse() {
        int courseId = getCourseId();
        Course course = courseDB.get(courseId);

        return course;
    }

    // exams are stored in a list which is 0-indexed, but it's better for human readability to start at 1
    private int getExamId() {
        Params requestParams = getRequestParams();
        int examId = requestParams.getInt("examId").orElseThrow();

        return examId - 1;
    }

    private Exam getExam() {
        Course course = getCourse();
        CourseContent content = course.getContent();
        Exam exam = content.getExams().get(getExamId());

        return exam;
    }

    @Override
    protected ExamDTO buildViewParams(Params params) {
        Exam exam = getExam();
        ExamDTO dto = new ExamDTO(exam.getQuestions());

        return dto;
    }

    @Override
    public void handleSubmit(ExamSolutionDTO data) {
        Exam exam = getExam();
        List<Question> questions = exam.getQuestions();

        int counter = 0;
        double score = 0;

        for (char answer: data.getAnswers()) {
            Question question = questions.get(counter);

            if (question.checkAnswer(answer)) {
                score++;
            }

            counter++;
        }

        double totalScore = questions.size();
        double percentage = (score / totalScore) * 100;

        System.out.printf("Your score is: %.2f%%\n", percentage);
        navigateBackwards();
    }
}
