import java.util.ArrayList;



public class Payload {
    Shipment shipment;
    ArrayList<Box> boxes = new ArrayList<>();

    public Payload(Shipment shipment, ArrayList<Box> boxes){
        this.shipment = shipment;
        copy(this.boxes, boxes);
    }

    private <T> void copy(ArrayList<T> list0, ArrayList<T> list1) {
        for (int i = 0; i < list1.size(); i++) {
            list0.add(list1.get(i));
        }
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
}
