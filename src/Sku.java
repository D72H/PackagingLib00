import java.io.Serializable;

public class Sku implements Comparable<Sku>, Serializable {
    private String merchantSku;
    private String title;
    private String asin;
    private String fnsku;
    private String externalID;
    private String condition;
    private String prep;
    private String prepType;
    private String label;
    private int quantity;

    public Sku(String merchantSku, String title, String asin, String fnsku, String externalID, String condition, String prep, String prepType, String label, int quantity) {
        this.merchantSku = merchantSku;
        this.title = title;
        this.asin = asin;
        this.fnsku = fnsku;
        this.externalID = externalID;
        this.condition = condition;
        this.prep = prep;
        this.prepType = prepType;
        this.label = label;
        this.quantity = quantity;
    }

    public String getMerchantSku() {
        return merchantSku;
    }

    public void setMerchantSku(String merchantSku) {
        this.merchantSku = merchantSku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getPrepType() {
        return prepType;
    }

    public void setPrepType(String prepType) {
        this.prepType = prepType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }


    @Override
    public int compareTo(Sku o) {
        int i;
        i = (asin.compareTo(o.getAsin()) == 0 ) ? 0:-1;
        return i;
    }

    public String toString(){
        String str;
        str = title +"\t"+ merchantSku +"\t"+ externalID +"\t" + asin + "\t" + fnsku;
        //System.out.println(str);
        return str;
    }
}
