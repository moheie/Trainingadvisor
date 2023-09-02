package entity;

import entity.course.Course;

public class UserCourse {
    private int userId;
    private int courseId;
    private int progress;
    private Certificate certificate;

    public UserCourse(int userId, Course course) {
        this.userId = userId;
        this.courseId = course.getId();
        this.progress = 0;
        this.certificate = new Certificate(courseId, course.getDetails().getCertificateCost());
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
