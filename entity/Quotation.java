package lk.ijse.finalproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Quotation {
    private String quotationId;
    private String supplierCategory;
    private String description;
    private double qty;
    private String measuredUnits;
    private double maximumAmount;
    private LocalDate calledDate;
    private LocalDate openedDate;
    private String storekeeperID;
    private String supplierID;

    public Quotation() {
    }

    public Quotation(String quotationId, String supplierCategory, String description, double qty, String measuredUnits, double maximumAmount, LocalDate calledDate, LocalDate openedDate, String storekeeperID, String supplierID) {
        this.quotationId = quotationId;
        this.supplierCategory = supplierCategory;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.maximumAmount = maximumAmount;
        this.calledDate = calledDate;
        this.openedDate = openedDate;
        this.storekeeperID = storekeeperID;
        this.supplierID = supplierID;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getSupplierCategory() {
        return supplierCategory;
    }

    public void setSupplierCategory(String supplierCategory) {
        this.supplierCategory = supplierCategory;
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

    public double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public LocalDate getCalledDate() {
        return calledDate;
    }

    public void setCalledDate(LocalDate calledDate) {
        this.calledDate = calledDate;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }

    public String getStorekeeperID() {
        return storekeeperID;
    }

    public void setStorekeeperID(String storekeeperID) {
        this.storekeeperID = storekeeperID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
}
