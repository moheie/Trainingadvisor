package entity.course.material;

public class Material {
    private String url;

    public Material(String url) {
        this.url = url;
    }

    public Material() {
        this.url = "";
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}
