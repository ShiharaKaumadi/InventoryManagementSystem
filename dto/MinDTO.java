package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class MinDTO {
    private String minId;
    private String purpose;
    private LocalDate issuedDate;
    private String requestPersonId;
    private String stockCode;
    private String stockItemDescription;
    private String category;
    private String subCategory;
    private String brandName;
    private double qtyIssued;
    private String storekeeperId;
    private double unitRate;
    private String measuredUnits;

    public MinDTO(String minId,String stockCode,String stockItemDescription, String category, String subCategory, String brandName,String measuredUnits,double unitRate,LocalDate issuedDate,String storekeeperId,double qtyIssued,String purpose,String requestPersonId ){
        this.minId = minId;
        this.purpose = purpose;
        this.issuedDate = issuedDate;
        this.requestPersonId = requestPersonId;
        this.stockCode = stockCode;
        this.stockItemDescription = stockItemDescription;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.qtyIssued = qtyIssued;
        this.storekeeperId = storekeeperId;
        this.unitRate = unitRate;
        this.measuredUnits = measuredUnits;
    }



    public MinDTO(String minId, String purpose, LocalDate issuedDate, String requestPersonId, String stockCode, String stockItemDescription, String category, String subCategory, String brandName, double qtyIssued, String storekeeperId, double unitRate, String measuredUnits) {
        this.minId = minId;
        this.purpose = purpose;
        this.issuedDate = issuedDate;
        this.requestPersonId = requestPersonId;
        this.stockCode = stockCode;
        this.stockItemDescription = stockItemDescription;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.qtyIssued = qtyIssued;
        this.storekeeperId = storekeeperId;
        this.unitRate = unitRate;
        this.measuredUnits = measuredUnits;
    }

    public MinDTO() {
    }

    public MinDTO(String minId, String purpose, LocalDate issuedDate, String requestPersonId, String stockCode, String stockItemDescription, String category, String subCategory, String brandName, double qtyIssued) {
        this.minId = minId;
        this.purpose = purpose;
        this.issuedDate = issuedDate;
        this.requestPersonId = requestPersonId;
        this.stockCode = stockCode;
        this.stockItemDescription = stockItemDescription;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.qtyIssued = qtyIssued;
    }

    public MinDTO(String minId, String purpose, LocalDate issuedDate, String requestPersonId, String stockCode, String stockItemDescription, String category, String subCategory, String brandName, double qtyIssued, String storekeeperId, double unitRate) {
        this.minId = minId;
        this.purpose = purpose;
        this.issuedDate = issuedDate;
        this.requestPersonId = requestPersonId;
        this.stockCode = stockCode;
        this.stockItemDescription = stockItemDescription;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.qtyIssued = qtyIssued;
        this.storekeeperId = storekeeperId;
        this.unitRate = unitRate;
    }

    public String getMinId() {
        return minId;
    }

    public void setMinId(String minId) {
        this.minId = minId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getRequestPersonId() {
        return requestPersonId;
    }

    public void setRequestPersonId(String requestPersonId) {
        this.requestPersonId = requestPersonId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockItemDescription() {
        return stockItemDescription;
    }

    public void setStockItemDescription(String stockItemDescription) {
        this.stockItemDescription = stockItemDescription;
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

    public double getQtyIssued() {
        return qtyIssued;
    }

    public void setQtyIssued(double qtyIssued) {
        this.qtyIssued = qtyIssued;
    }

    public String getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(String storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public String getMeasuredUnits() {
        return measuredUnits;
    }

    public void setMeasuredUnits(String measuredUnits) {
        this.measuredUnits = measuredUnits;
    }
}
