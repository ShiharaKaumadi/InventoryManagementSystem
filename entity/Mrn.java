package lk.ijse.finalproject.entity;

import java.time.LocalDate;

public class Mrn {
    private String mrnId;
    private String productID;
    private String productName;
    private String measuredUnits;
    private LocalDate date;
    private LocalDate requiredDate;
    private String storekeeperID;
    private double requestQty;
    private String Category;
    private String subCategory;
    private String brandName;

    public Mrn() {
    }

    public Mrn(String mrnId, String productID, String productName, String measuredUnits, LocalDate date, LocalDate requiredDate, String storekeeperID, double requestQty, String category, String subCategory, String brandName) {
        this.mrnId = mrnId;
        this.productID = productID;
        this.productName = productName;
        this.measuredUnits = measuredUnits;
        this.date = date;
        this.requiredDate = requiredDate;
        this.storekeeperID = storekeeperID;
        this.requestQty = requestQty;
        Category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public Mrn(String mrnId, String productID, String productName, String measuredUnits,LocalDate requiredDate, double requestQty, String category, String subCategory, String brandName ) {
        this.mrnId = mrnId;
        this.productID = productID;
        this.productName = productName;
        this.measuredUnits = measuredUnits;

        this.requiredDate = requiredDate;

        Category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }


    public String getMrnId() {
        return mrnId;
    }

    public void setMrnId(String mrnId) {
        this.mrnId = mrnId;
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

    public String getMeasuredUnits() {
        return measuredUnits;
    }

    public void setMeasuredUnits(String measuredUnits) {
        this.measuredUnits = measuredUnits;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getStorekeeperID() {
        return storekeeperID;
    }

    public void setStorekeeperID(String storekeeperID) {
        this.storekeeperID = storekeeperID;
    }

    public double getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(double requestQty) {
        this.requestQty = requestQty;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
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

    @Override
    public String toString() {
        return "Mrn{" +
                "mrnId='" + mrnId + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", measuredUnits='" + measuredUnits + '\'' +
                ", date=" + date +
                ", requiredDate=" + requiredDate +
                ", storekeeperID='" + storekeeperID + '\'' +
                ", requestQty=" + requestQty +
                ", Category='" + Category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
