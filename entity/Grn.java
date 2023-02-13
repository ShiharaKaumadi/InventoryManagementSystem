package lk.ijse.finalproject.entity;

import java.time.LocalDate;

public class Grn {
    private String grnId;
    private String productID;
    private String productName;
    private String Category;
    private String SubCategory;
    private String brandName;
    private String measuredUnits;
    private double unitRate;
    private LocalDate date;
    private String storekeeperID;
    private double qtyReceived;
    private double qtyAccepted;
    private LocalDate stockReceivedDate;
    private String reasonForRejection;

    public Grn() {
    }

    public Grn(String grnId, String productID, String productName, String category, String subCategory, String brandName, String measuredUnits, double unitRate, LocalDate date, String storekeeperID, double qtyReceived, double qtyAccepted, LocalDate stockReceivedDate, String reasonForRejection) {
        this.setGrnId(grnId);
        this.setProductID(productID);
        this.setProductName(productName);
        setCategory(category);
        setSubCategory(subCategory);
        this.setBrandName(brandName);
        this.setMeasuredUnits(measuredUnits);
        this.setUnitRate(unitRate);
        this.setDate(date);
        this.setStorekeeperID(storekeeperID);
        this.setQtyReceived(qtyReceived);
        this.setQtyAccepted(qtyAccepted);
        this.setStockReceivedDate(stockReceivedDate);
        this.setReasonForRejection(reasonForRejection);
    }

    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSubCategory() {
        return SubCategory;
    }

    public void setSubCategory(String subCategory) {
        SubCategory = subCategory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMeasuredUnits() {
        return measuredUnits;
    }

    public void setMeasuredUnits(String measuredUnits) {
        this.measuredUnits = measuredUnits;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStorekeeperID() {
        return storekeeperID;
    }

    public void setStorekeeperID(String storekeeperID) {
        this.storekeeperID = storekeeperID;
    }

    public double getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(double qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    public double getQtyAccepted() {
        return qtyAccepted;
    }

    public void setQtyAccepted(double qtyAccepted) {
        this.qtyAccepted = qtyAccepted;
    }

    public LocalDate getStockReceivedDate() {
        return stockReceivedDate;
    }

    public void setStockReceivedDate(LocalDate stockReceivedDate) {
        this.stockReceivedDate = stockReceivedDate;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    @Override
    public String toString() {
        return "Grn{" +
                "grnId='" + grnId + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", Category='" + Category + '\'' +
                ", SubCategory='" + SubCategory + '\'' +
                ", brandName='" + brandName + '\'' +
                ", measuredUnits='" + measuredUnits + '\'' +
                ", unitRate=" + unitRate +
                ", date=" + date +
                ", storekeeperID='" + storekeeperID + '\'' +
                ", qtyReceived=" + qtyReceived +
                ", qtyAccepted=" + qtyAccepted +
                ", stockReceivedDate=" + stockReceivedDate +
                ", reasonForRejection='" + reasonForRejection + '\'' +
                '}';
    }
}
