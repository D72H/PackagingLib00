import java.io.Serializable;
import java.util.ArrayList;

public class ShippingPlan implements Serializable {
    private String planID;
    private ArrayList<Shipment> fufillmentCenters = new ArrayList<Shipment>();
    private ArrayList<Sku> skusInPlan = new ArrayList<>();
    private int totalSkus;
    private int totalUnits;

    public ShippingPlan(ArrayList<Shipment> fufillmentCenters) {
        this.planID = fufillmentCenters.get(0).getPlanID();
        copy(this.fufillmentCenters, fufillmentCenters);
        skusInPlan = setSkusInPlan(fufillmentCenters);
        totalSkus = skusInPlan.size();
        setTotalUnits();
    }


    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public ArrayList<Shipment> getFufillmentCenters() {
        return fufillmentCenters;
    }

    public void setFufillmentCenters(ArrayList<Shipment> fufillmentCenters) {
        this.fufillmentCenters = fufillmentCenters;
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

    public void setTotalUnits() {
        for(int i = 0 ; i < fufillmentCenters.size(); i++)
            this.totalUnits += fufillmentCenters.get(i).getTotalUnits();
    }

    private void copy(ArrayList<Shipment> list0, ArrayList<Shipment> list1) {
        for (int i = 0; i < list1.size(); i++) {
            list0.add(list1.get(i));
        }
    }
    public ArrayList<Sku> getSkusInPlan(){
        return skusInPlan;
    }

    private ArrayList<Sku> setSkusInPlan(ArrayList<Shipment> list) {
        ArrayList<Sku> temp = new ArrayList<>();
        Sku tempVar;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getSkusInShipment().size(); j++) {
                temp.add(list.get(i).getSkusInShipment().get(j));
            }
        }

        for (int i = 0 ; i <temp.size(); i++) {
            tempVar = temp.get(i);
            for(int j = i+1 ; j<temp.size(); j++){
                if(tempVar.compareTo(temp.get(j)) == 0){
                    temp.remove(j);
                }
            }
        }
        return temp;
    }
    //THis prints the form that is currently being used as the workorder
    public String toString(){
        String out;

        StringBuffer str = new StringBuffer();
        str.append(" / "+planID+ "\t\n" + "Total number of Shipments: " + getFufillmentCenters().size() +"\nTotal Skus: " + totalSkus + "\nTotal Units: " + totalUnits + "\n");

        for (int i = 0; i < fufillmentCenters.size(); i++){
            str.append("FC"+(i+1)+" - "+fufillmentCenters.get(i).getShipmentID()+" - "+fufillmentCenters.get(i).getLocation() + "\n");
        }
        str.append("\n\nTitle\t Merchant Sku\tASIN\tFNSKU\tFC1\tFC2\tFC3\tFC4\tFC5\tTotal\tDate\tInititials\tVerified\n");


        //traverse all of the skus in the plan
        for (int i = 0; i < skusInPlan.size(); i++){

            //traverse all of the shipments in the plan
            str.append(skusInPlan.get(i).toString()+ "\t");
            for(int j = 0; j<fufillmentCenters.size(); j++){
                int check = 1;
                //traverse each sku in the each shipment and compare it to see if the current sku in the plan is contained in that shipment.
                for ( int k = 0; k < fufillmentCenters.get(j).getSkusInShipment().size(); k++){

                    if(skusInPlan.get(i).compareTo(fufillmentCenters.get(j).getSkusInShipment().get(k)) == 0){
                        str.append(fufillmentCenters.get(j).getSkusInShipment().get(k).getQuantity() + "\t");
                        check = -1;
                        break;
                    }

                    else;
                }
                if(check ==1){
                    str.append("\t");
                }
                else;

            }
            str.append("\n");
        }

        out = str.toString();
        return out;
    }



}
