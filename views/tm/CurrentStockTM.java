package lk.ijse.finalproject.views.tm;

import javafx.scene.control.Label;

public class CurrentStockTM {
    private String stockId;
    private String stockDescription;
    private String measuredUnits;
    private double qtyOnHand;
    private double unitRate;
    private double stockValue;
    private String category;
    private String subCategory;
    private String brandName;
    private Label label;

    public CurrentStockTM() {
    }

    public CurrentStockTM(String stockId, String stockDescription, String measuredUnits, double qtyOnHand, double unitRate, double stockValue, String category, String subCategory, String brandName, Label label) {
        this.stockId = stockId;
        this.stockDescription = stockDescription;
        this.measuredUnits = measuredUnits;
        this.qtyOnHand = qtyOnHand;
        this.unitRate = unitRate;
        this.stockValue = stockValue;
        this.category = category;
        this.subCategory = subCategory;
        this.brandName = brandName;
        this.label = label;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
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

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
