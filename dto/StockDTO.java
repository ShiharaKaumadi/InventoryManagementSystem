package lk.ijse.finalproject.dto;

import java.sql.Blob;

public class StockDTO {
    private String stockCode;
    private String itemDescription;
    private double qtyOnHand;
    private String measuredUnits;
    private double unitRate;
    private String category;
    private String subCategory;

    private Blob imgSrc;
    private String brand;
    private double stockValue;

    public StockDTO(String itemDescription, double qtyOnHand) {
        this.itemDescription=itemDescription;
        this.qtyOnHand=qtyOnHand;
    }

    public StockDTO(String stockCode, String itemDescription, double qtyOnHand, String measuredUnits, double unitRate, String category, String subCategory, String brand, Blob imgSrc) {
        this.stockCode = stockCode;
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
        this.imgSrc = imgSrc;
    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public StockDTO(String itemDescription, double qtyOnHand, double unitRate, double stockValue) {
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.unitRate = unitRate;
        stockValue=qtyOnHand*unitRate;
        this.stockValue = stockValue;
    }

    public StockDTO(String itemDescription, double qtyOnHand, double unitRate) {
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.unitRate = unitRate;
    }

    public StockDTO() {
    }

    public StockDTO(String stockCode, String itemDescription, double unitRate, double qtyOnHand, Blob imgSrc) {
        this.stockCode = stockCode;
        this.itemDescription = itemDescription;
        this.unitRate = unitRate;
        this.qtyOnHand =qtyOnHand;
        this.imgSrc = imgSrc;
    }

    public StockDTO(String stockCode, String itemDescription, String measuredUnits, String category, String subCategory, String brand) {
        this.stockCode = stockCode;
        this.itemDescription = itemDescription;
        this.measuredUnits = measuredUnits;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
    }

    public StockDTO(String stockCode, String itemDescription, double qtyOnHand, String measuredUnits, double unitRate, String category, String subCategory, String brand) {
        this.stockCode = stockCode;
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
    }


    public StockDTO(String stockCode, String itemDescription, double unitRate) {
        this.stockCode = stockCode;
        this.itemDescription = itemDescription;
        this.unitRate = unitRate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Blob getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(Blob imgSrc) {
        this.imgSrc = imgSrc;
    }
}
