package lk.ijse.finalproject.entity;

public class OrderDetail {
    private String orderID;
    private String productID;
    private String description;
    private double qty;
    private String measuredUnits;
    private double unitPrice;

    private double dailyIncome;
    private String category;
    private String subCategory;
    private String brandName;

    public OrderDetail() {
    }

    public OrderDetail(double dailyIncome) {

        this.dailyIncome = dailyIncome;
    }

    public OrderDetail(String orderID, String productID, String description, double qty, String measuredUnits, double unitPrice, double dailyIncome, String category, String subCategory, String brandName) {
        this.orderID = orderID;
        this.productID = productID;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;
        this.dailyIncome=qty*unitPrice;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public OrderDetail(String orderID, String productID, String description, double qty, String measuredUnits, double unitPrice, String category, String subCategory, String brandName) {
        this.orderID = orderID;
        this.productID = productID;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;

        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }
    public OrderDetail(String productID,  double qty, String description,double unitPrice) {

        this.productID = productID;
        this.description = description;
        this.qty = qty;

        this.unitPrice = unitPrice;


    }

    public OrderDetail( String description, double qty, String measuredUnits, double unitPrice, String category, String subCategory, String brandName) {


        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;
        this.dailyIncome=qty*unitPrice;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }




    public String getOrderId() {
        return orderID;
    }

    public void setOrderId(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getMeasuredUnits() {
        return measuredUnits;
    }

    public void setMeasuredUnits(String measuredUnits) {
        this.measuredUnits = measuredUnits;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getDailyIncome() {
        dailyIncome=qty*unitPrice;
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderID='" + orderID + '\'' +
                ", productID='" + productID + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", measuredUnits='" + measuredUnits + '\'' +
                ", unitPrice=" + unitPrice +
                ", dailyIncome=" + dailyIncome +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
