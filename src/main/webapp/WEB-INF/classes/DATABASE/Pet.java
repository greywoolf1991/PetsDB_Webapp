package DATABASE;
import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersion = 1L;

    private int id;
    private String type;
    private String name;

    public Pet(){};

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Pet(int id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
