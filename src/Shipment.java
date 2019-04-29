import java.io.Serializable;
import java.util.ArrayList;


public class Shipment implements Comparable<Shipment>, Serializable {
    private String planID;
    private String shipmentID;
    private String location;
    private  ArrayList<Sku> skusInShipment = new ArrayList<Sku>();
    private int totalSkus;
    private int totalUnits;


    public Shipment(String planID, String shipmentID, String location, ArrayList<Sku> skusInShipment, int totalSkus, int totalUnits) {
        this.planID = planID;
        this.shipmentID = shipmentID;
        this.location = location;
        copy(this.skusInShipment,skusInShipment);
        this.totalSkus = totalSkus;
        this.totalUnits = totalUnits;
    }



    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Sku> getSkusInShipment() {
        return skusInShipment;
    }

    public void setSkusInShipment(ArrayList<Sku> skusInShipment) {
        this.skusInShipment = skusInShipment;
    }

    public int getTotalSkus() {
        return totalSkus;
    }

    public void setTotalSkus(int totalSkus) {
        this.totalSkus = totalSkus;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public void copy(ArrayList<Sku> list0, ArrayList<Sku> list1){
        for (int i = 0; i < list1.size(); i++){
            list0.add(list1.get(i));
        }
    }

    public int compareTo(Shipment o) {
        int i;
        i = (shipmentID.compareTo(o.getShipmentID()) != 0 ) ? 1:-1;
        return i;
    }
    //this prints what is currently being used as the box sheets
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("~\n");
        str.append(planID +"\t"+ shipmentID +"\t"+ location+ "\t\n");


        for (int i = 0 ; i <skusInShipment.size(); i++){

            str.append(skusInShipment.get(i).toString() + "\t" + skusInShipment.get(i).getQuantity());
            str.append("\n");
        }

        String out = str.toString();

        return out;
    }
}
