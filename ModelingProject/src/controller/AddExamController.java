package controller;

import database.CourseDB;
import dto.CreateExamDTO;
import entity.course.Course;
import entity.course.QuestionBank;
import entity.course.material.CourseContent;
import entity.course.material.Exam;
import entity.course.material.Question;
import event.SubmitHandler;
import util.Params;
import view.AddExamView;

import java.util.List;

public class AddExamController extends DefaultViewController<AddExamView> implements SubmitHandler<CreateExamDTO> {
    private CourseDB courseDB = CourseDB.getInstance();

    @Override
    protected void initialize() {
        view = new AddExamView(this.isActive);

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

    @Override
    public void handleSubmit(CreateExamDTO data) {
        Course course = getCourse();

        QuestionBank questionBank = course.getQuestionBank();
        CourseContent content = course.getContent();

        Exam exam = new Exam();

        List<Integer> mcqList = data.getMcqList();
        List<Integer> tofList = data.getTofList();

        for (Integer mcqId: mcqList) {
            Question question = questionBank.getMCQ(mcqId);

            if (question != null) {
                exam.addQuestion(question);
            } else {
                System.out.printf("MCQ Question %d doesn't exist\n", mcqId);
            }
        }

        for (Integer tofId: tofList) {
            Question question = questionBank.getTrueOrFalse(tofId);

            if (question != null) {
                exam.addQuestion(question);
            } else {
                System.out.printf("TOF Question %d doesn't exist\n", tofId);
            }
        }

        content.addExam(exam);
        System.out.println("Exam added successfully");
    }
}
