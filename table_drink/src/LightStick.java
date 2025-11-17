public class LightStick {
    private String color;
    private String shape;
    private boolean status;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void open() {
        setStatus(true);
    }

    public void close() {
        setStatus(false);
    }
}
