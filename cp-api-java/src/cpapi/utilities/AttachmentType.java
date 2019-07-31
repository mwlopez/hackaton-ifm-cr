package cpapi.utilities;

public class AttachmentType {

    private String name = null;
    private String path = null;

    public AttachmentType(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isOk() {
        return path != null && name != null && !path.isEmpty() && !name.isEmpty();
    }
}
