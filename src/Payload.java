import java.io.Serializable;
import java.util.ArrayList;



public class Payload implements Serializable {
    Shipment shipment;
    ArrayList<CardboardBox> cardboardBoxes = new ArrayList<>();

    public Payload(Shipment shipment, ArrayList<CardboardBox> cardboardBoxes){
        this.shipment = shipment;
        copy(this.cardboardBoxes, cardboardBoxes);
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

    public ArrayList<CardboardBox> getCardboardBoxes() {
        return cardboardBoxes;
    }

    public void setCardboardBoxes(ArrayList<CardboardBox> cardboardBoxes) {
        this.cardboardBoxes = cardboardBoxes;
    }
}
