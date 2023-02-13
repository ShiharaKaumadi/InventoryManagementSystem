package lk.ijse.finalproject.dto;

import java.sql.Blob;

public class OrderDetailDTO {
    private String orderId;
    private String code;
    private String description;
    private double qty;
    private String measuredUnits;
    private double unitPrice;

    private double dailyIncome;
    private String category;
    private String subCategory;
    private String brandName;
    private Blob imageSrc;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String code, String description, double qty, String measuredUnits, double unitPrice, double dailyIncome, String category, String subCategory, String brandName, Blob imageSrc) {
        this.orderId = orderId;
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;
        this.dailyIncome = dailyIncome;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.imageSrc = imageSrc;
    }

    public OrderDetailDTO(double dailyIncome) {

        this.dailyIncome = dailyIncome;
    }

    public OrderDetailDTO(String orderId, String code, String description, double qty, String measuredUnits, double unitPrice, double dailyIncome, String category, String subCategory, String brandName) {
        this.orderId = orderId;
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;
        this.dailyIncome=qty*unitPrice;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public OrderDetailDTO(String orderId, String code, String description, double qty, String measuredUnits, double unitPrice, String category, String subCategory, String brandName) {
        this.orderId = orderId;
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.measuredUnits = measuredUnits;
        this.unitPrice = unitPrice;

        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public OrderDetailDTO(String code, double soldQty, String description,double unitPrice) {
        this.code = code;
        this.qty=soldQty;
        this.description=description;
        this.unitPrice=unitPrice;
    }

    public OrderDetailDTO(String description, double qty) {
        this.description = description;
        this.qty=qty;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Blob getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(Blob imageSrc) {
        this.imageSrc = imageSrc;
    }

    public double getDailyIncome() {
        dailyIncome=qty*unitPrice;
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
