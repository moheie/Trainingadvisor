package entity.course.material;

import java.util.ArrayList;
import java.util.List;

public class CourseContent {
    private List<Material> materials;
    private List<Video> videos;
    private List<Exam> exams;

    public CourseContent() {
        this.materials = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.exams = new ArrayList<>();
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }
}
