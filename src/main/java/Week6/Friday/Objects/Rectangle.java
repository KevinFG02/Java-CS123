package Week6.Friday.Objects;

public class Rectangle implements Comparable<Rectangle> {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public int compareTo(Rectangle other) {
        if(this.height < other.height){
            return -1;
        } else if(this.height > other.height) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return  "h: " + height + " " +
                "w: " + width;
    }
}
