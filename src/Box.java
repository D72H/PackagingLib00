import java.io.Serializable;
import java.util.ArrayList;

public class Box implements Serializable {
    ArrayList<Sku> boxContents = new ArrayList<>();
    int boxNumber;
    double length, width, height, weight;

    public Box(int boxNumber){
        this.boxNumber = boxNumber;
    }

    public Box(ArrayList<Sku> boxContents, int boxNumber, double length, double width, double height, double weight) {
        this.boxContents = boxContents;
        this.boxNumber = boxNumber;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public ArrayList<Sku> getBoxContents() {
        return boxContents;
    }

    public void setBoxContents(ArrayList<Sku> boxContents) {
        this.boxContents = boxContents;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
