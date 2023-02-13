package lk.ijse.finalproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Min {
    private String minId;
    private String productID;
    private String productName;
    private String Category;
    private String subCategory;
    private String brandName;
    private String measuredUnits;
    private double unitRate;
    private LocalDate date;
    private String storekeeperID;
    private double qtyIssued;
    private String purpose;
    private String requestPerson;

    public Min() {
    }

    public Min(String minId, String productID, String productName, String category, String subCategory, String brandName, String measuredUnits, double unitRate, LocalDate date, String storekeeperID, double qtyIssued, String purpose, String requestPerson) {
        this.minId = minId;
        this.productID = productID;
        this.productName = productName;
        Category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.date = date;
        this.storekeeperID = storekeeperID;
        this.qtyIssued = qtyIssued;
        this.purpose = purpose;
        this.requestPerson = requestPerson;
    }

    public String getMinId() {
        return minId;
    }

    public void setMinId(String minId) {
        this.minId = minId;
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

    public double getQtyIssued() {
        return qtyIssued;
    }

    public void setQtyIssued(double qtyIssued) {
        this.qtyIssued = qtyIssued;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRequestPerson() {
        return requestPerson;
    }

    public void setRequestPerson(String requestPerson) {
        this.requestPerson = requestPerson;
    }
}
