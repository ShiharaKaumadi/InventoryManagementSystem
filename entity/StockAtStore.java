package lk.ijse.finalproject.entity;

import java.sql.Blob;

public class StockAtStore {
    private String productId;
    private String itemDescription;
    private double qtyOnHand;
    private String measuredUnits;
    private double unitRate;
    private String category;
    private String subCategory;
    private String brandName;
    private Blob itemImage;

    public StockAtStore() {
    }

    public StockAtStore(String productId, String itemDescription, double qtyOnHand, String measuredUnits, double unitRate, String category, String subCategory, String brandName) {
        this.productId = productId;
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public StockAtStore(String itemDescription, double qtyOnHand, String measuredUnits, double unitRate, String category, String subCategory, String brandName) {
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
    }

    public StockAtStore(String itemDescription, double qtyOnHand) {
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
    }

    public StockAtStore(String itemDescription, double qtyOnHand, double unitRate) {
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.unitRate = unitRate;
    }

    public StockAtStore(String productId, String itemDescription, double qtyOnHand, String measuredUnits, double unitRate, String category, String subCategory, String brandName, Blob itemImage) {
        this.productId = productId;
        this.itemDescription = itemDescription;
        this.qtyOnHand = qtyOnHand;
        this.measuredUnits = measuredUnits;
        this.unitRate = unitRate;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.itemImage = itemImage;
    }



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Blob getItemImage() {
        return itemImage;
    }

    public void setItemImage(Blob itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public String toString() {
        return "StockAtStore{" +
                "productId='" + productId + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", measuredUnits='" + measuredUnits + '\'' +
                ", unitRate=" + unitRate +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", brandName='" + brandName + '\'' +
                ", itemImage=" + itemImage +
                '}';
    }
}
