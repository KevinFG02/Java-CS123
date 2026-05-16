package Week6.Friday.Objects;

public class Person /*implements Comparable<Person>*/ {
    private String fullName;
    private String hair;
    private int height;

    public Person(String fullName, String hair, int height) {
        this.fullName = fullName;
        this.hair = hair;
        this.height = height;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*
    @Override
    public int compareTo(Person other) {
        //return this.fullName.compareTo(other.fullName);
        return -this.fullName.compareTo(other.fullName); // Reverse Order
    }*/

    @Override
    public String toString() {
        return  "fullName: " + fullName +
                ", hair: " + hair +
                ", height: " + height;
    }
}
