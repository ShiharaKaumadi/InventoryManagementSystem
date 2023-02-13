package lk.ijse.finalproject.views.tm;

import javafx.scene.control.Button;

public class PlaceOrderTM {
    private String code;
    private String description;
    private int qty;

    private String measuredUnits;

    private double unitPrice;

    private String category;

    private String subCategory;

    private String brandName;
    private double total;
    private Button btnDelete;

    public PlaceOrderTM() {
    }

    public PlaceOrderTM(String code, String description, int qty, String measuredUnits, double unitPrice, String category, String subCategory, String brandName, double total, Button btnDelete) {
        this.setCode(code);
        this.setDescription(description);
        this.setQty(qty);
        this.setMeasuredUnits(measuredUnits);
        this.setUnitPrice(unitPrice);
        this.setCategory(category);
        this.setSubCategory(subCategory);
        this.setBrandName(brandName);
        this.setTotal(total);
        this.setBtnDelete(btnDelete);
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
}
