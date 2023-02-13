package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class MrnDTO {
    private String mrnId;
    private String stockCode;
    private String stockDescription;
    private String measuredUnits;
    private LocalDate requestDate;
    private LocalDate requiredDate;
    private String recommendBy;
    private double requestedQty;
    private String category;
    private String subCategory;
    private String brandName;

    private String skId;

    public MrnDTO() {
    }

    public MrnDTO(String stockCode, String stockDescription, String measuredUnits, double requestedQty, LocalDate requiredDate,  String category, String subCategory, String brandName) {
        this.stockCode = stockCode;
        this.stockDescription = stockDescription;
        this.measuredUnits = measuredUnits;
        this.requestedQty = requestedQty;
        this.requiredDate = requiredDate;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public MrnDTO(String mrnId, String stockCode, String stockDescription, String measuredUnits, LocalDate requiredDate, double requestedQty, String category, String subCategory, String brandName) {
        this.mrnId = mrnId;
        this.stockCode = stockCode;
        this.stockDescription = stockDescription;
        this.measuredUnits = measuredUnits;
        this.requiredDate = requiredDate;
        this.requestedQty = requestedQty;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public MrnDTO(String mrnId, String stockCode, String stockDescription, String measuredUnits, LocalDate requestDate, LocalDate requiredDate, String recommendBy, double requestedQty, String category, String subCategory, String brandName) {
        this.mrnId = mrnId;
        this.stockCode = stockCode;
        this.stockDescription = stockDescription;
        this.measuredUnits = measuredUnits;
        this.requestDate = requestDate;
        this.requiredDate = requiredDate;
        this.recommendBy = recommendBy;
        this.requestedQty = requestedQty;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }
    public MrnDTO(String mrnId, String stockCode, String stockDescription, String measuredUnits, LocalDate requestDate, LocalDate requiredDate, String recommendBy, double requestedQty, String category, String subCategory, String brandName,String skId) {
        this.mrnId = mrnId;
        this.stockCode = stockCode;
        this.stockDescription = stockDescription;
        this.measuredUnits = measuredUnits;
        this.requestDate = requestDate;
        this.requiredDate = requiredDate;
        this.recommendBy = recommendBy;
        this.requestedQty = requestedQty;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.skId=skId;
    }

    public String getMrnId() {
        return mrnId;
    }

    public void setMrnId(String mrnId) {
        this.mrnId = mrnId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }

    public String getMeasuredUnits() {
        return measuredUnits;
    }

    public void setMeasuredUnits(String measuredUnits) {
        this.measuredUnits = measuredUnits;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getRecommendBy() {
        return recommendBy;
    }

    public void setRecommendBy(String recommendBy) {
        this.recommendBy = recommendBy;
    }

    public double getRequestedQty() {
        return requestedQty;
    }

    public void setRequestedQty(double requestedQty) {
        this.requestedQty = requestedQty;
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

    public String getSkId() {
        return skId;
    }

    public void setSkId(String skId) {
        this.skId = skId;
    }
}
