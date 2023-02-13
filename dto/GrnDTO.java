package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class GrnDTO {
    private String grnId;
    private String mrnId;
    private LocalDate stockReceivedDate;
    private LocalDate grnDate;
    private String stockCode;
    private String StockItemDescription;
    private String Category;
    private String subCategory;
    private String brandName;
    private String measuredUnits;
    private double qtyReceived;
    private double qtyAccepted;
    private double unitRate;
    private String storeKeeperId;
    private String reasonForRejection;

    public GrnDTO(String grnId, String stockCode, String stockItemDescription, String category, String subCategory, String brandName, String measuredUnits,double unitRate, LocalDate grnDate,  String storeKeeperId, double qtyReceived, double qtyAccepted, LocalDate stockReceivedDate,  String reasonForRejection) {
        this.grnId = grnId;
        this.stockReceivedDate = stockReceivedDate;
        this.grnDate = grnDate;
        this.stockCode = stockCode;
        StockItemDescription = stockItemDescription;
        Category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.measuredUnits = measuredUnits;
        this.qtyReceived = qtyReceived;
        this.qtyAccepted = qtyAccepted;
        this.unitRate = unitRate;
        this.storeKeeperId = storeKeeperId;
        this.reasonForRejection = reasonForRejection;
    }

    public GrnDTO() {
    }

    public GrnDTO(String grnId, String mrnId, LocalDate stockReceivedDate, LocalDate grnDate, String stockCode, String stockItemDescription, String category, String subCategory, String brandName, String measuredUnits, double qtyReceived, double qtyAccepted, double unitRate, String storeKeeperId, String reasonForRejection) {
        this.setGrnId(grnId);
        this.setMrnId(mrnId);
        this.setStockReceivedDate(stockReceivedDate);
        this.setGrnDate(grnDate);
        this.setStockCode(stockCode);
        setStockItemDescription(stockItemDescription);
        setCategory(category);
        this.setSubCategory(subCategory);
        this.setBrandName(brandName);
        this.setMeasuredUnits(measuredUnits);
        this.setQtyReceived(qtyReceived);
        this.setQtyAccepted(qtyAccepted);
        this.setUnitRate(unitRate);
        this.setStoreKeeperId(storeKeeperId);
        this.setReasonForRejection(reasonForRejection);
    }



    public String getGrnId() {
        return grnId;
    }

    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    public String getMrnId() {
        return mrnId;
    }

    public void setMrnId(String mrnId) {
        this.mrnId = mrnId;
    }

    public LocalDate getStockReceivedDate() {
        return stockReceivedDate;
    }

    public void setStockReceivedDate(LocalDate stockReceivedDate) {
        this.stockReceivedDate = stockReceivedDate;
    }

    public LocalDate getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(LocalDate grnDate) {
        this.grnDate = grnDate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockItemDescription() {
        return StockItemDescription;
    }

    public void setStockItemDescription(String stockItemDescription) {
        StockItemDescription = stockItemDescription;
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

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public String getStoreKeeperId() {
        return storeKeeperId;
    }

    public void setStoreKeeperId(String storeKeeperId) {
        this.storeKeeperId = storeKeeperId;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }
}
