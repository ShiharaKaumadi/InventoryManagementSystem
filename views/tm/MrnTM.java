package lk.ijse.finalproject.views.tm;

import java.time.LocalDate;

public class MrnTM {
    private String mrnId;
    private String stockCode;
    private String productName;
    private String measuredUnits;
    private LocalDate requiredDate;
    private double requestQty;
    private String category;
    private String subCategory;
    private String brandName;

    public MrnTM() {
    }

    public MrnTM(String stockCode, String productName, String measuredUnits,double requestQty, LocalDate requiredDate, String category, String subCategory, String brandName) {
        this.setStockCode(stockCode);
        this.setProductName(productName);
        this.setMeasuredUnits(measuredUnits);
        this.setRequiredDate(requiredDate);
        this.setRequestQty(requestQty);
        this.setCategory(category);
        this.setSubCategory(subCategory);
        this.setBrandName(brandName);
    }


    public MrnTM(String mrnId, String stockCode, String productName, String measuredUnits, LocalDate requiredDate, double requestQty, String category, String subCategory, String brandName) {
        this.mrnId = mrnId;
        this.stockCode = stockCode;
        this.productName = productName;
        this.measuredUnits = measuredUnits;
        this.requiredDate = requiredDate;
        this.requestQty = requestQty;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public double getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(double requestQty) {
        this.requestQty = requestQty;
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

    public String getMrnId() {
        return mrnId;
    }

    public void setMrnId(String mrnId) {
        this.mrnId = mrnId;
    }
}
