// todo: separate views and controllers

import app.Application;
import database.CourseDB;
import database.UserDB;
import entity.course.Category;
import entity.course.Course;
import entity.course.CourseDetails;
import entity.course.QuestionBank;
import entity.course.material.*;
import entity.user.Role;
import entity.user.User;
import entity.user.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        populateDatabases();

        Application app = new Application();
        app.start();
    }

    public static void populateDatabases() {
        UserDB userDB = UserDB.getInstance();
        CourseDB courseDB = CourseDB.getInstance();

        // insert trainee user
        UserDetails userDetails = new UserDetails(
                "trainee",
                "hehe@gmail.com",
                "pass",
                "012",
                "giza",
                "photo",
                Role.TRAINEE
        );

        User user = userDB.add(userDetails);

        System.out.printf("Dev note : trainee ID : %d , password : %s\n", user.getId(), userDetails.getPassword());

        List<Integer> prerequisites = new ArrayList<Integer>();
        CourseDetails courseDetails = new CourseDetails(
                "Programming 1",
                "The First Course",
                50,
                1,
                4.5F,
                prerequisites,
                new ArrayList<>(),
                900,
                Category.PROGRAMMING,
                100
        );

        Course course = courseDB.add(courseDetails);

        CourseContent courseContent = course.getContent();
        QuestionBank questionBank = course.getQuestionBank();

        Material lecture1 = new Material("lecture 1");
        Material lecture2 = new Material("lecture 2");

        courseContent.addMaterial(lecture1);
        courseContent.addMaterial(lecture2);

        Video video1 = new Video("video 1");
        Video video2 = new Video("video 2");

        courseContent.addVideo(video1);
        courseContent.addVideo(video2);

        MCQ mcq = new MCQ("What is 1+1?");

        mcq.addChoice("4");
        mcq.addChoice("7");
        mcq.addChoice("3");
        mcq.addChoice("2");

        mcq.setCorrectChoiceIndex(3);

        TrueOrFalse tof = new TrueOrFalse("Is this the greatest course of all time?", true);

        questionBank.addMCQ(mcq);
        questionBank.addTrueOrFalse(tof);

        Exam exam = new Exam();

        exam.addQuestion(mcq);
        exam.addQuestion(tof);

        courseContent.addExam(exam);

        System.out.printf("Dev note : course ID : %d\n", course.getId());
    }
}
