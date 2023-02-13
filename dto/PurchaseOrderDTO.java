package lk.ijse.finalproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrderDTO {
    private String purchaseOrderId;
    private String purchaseCategory;
    private String productID;
    private String productName;
    private String measuredUnits;
    private double qty;
    private double unitRate;
    private LocalDate orderDate;
    private LocalDate deliverBefore;
    private String supplierID;
    private String storeKeeperID;

    public PurchaseOrderDTO() {

    }

    public PurchaseOrderDTO(String purchaseOrderId, String purchaseCategory, String productID, String productName, String measuredUnits, double qty, double unitRate, LocalDate orderDate, LocalDate deliverBefore, String supplierID, String storeKeeperID) {
        this.purchaseOrderId = purchaseOrderId;
        this.purchaseCategory = purchaseCategory;
        this.productID = productID;
        this.productName = productName;
        this.measuredUnits = measuredUnits;
        this.qty = qty;
        this.unitRate = unitRate;
        this.orderDate = orderDate;
        this.deliverBefore = deliverBefore;
        this.supplierID = supplierID;
        this.storeKeeperID = storeKeeperID;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseCategory() {
        return purchaseCategory;
    }

    public void setPurchaseCategory(String purchaseCategory) {
        this.purchaseCategory = purchaseCategory;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(double unitRate) {
        this.unitRate = unitRate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliverBefore() {
        return deliverBefore;
    }

    public void setDeliverBefore(LocalDate deliverBefore) {
        this.deliverBefore = deliverBefore;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getStoreKeeperID() {
        return storeKeeperID;
    }

    public void setStoreKeeperID(String storeKeeperID) {
        this.storeKeeperID = storeKeeperID;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderId='" + purchaseOrderId + '\'' +
                ", purchaseCategory='" + purchaseCategory + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", measuredUnits='" + measuredUnits + '\'' +
                ", qty=" + qty +
                ", unitRate=" + unitRate +
                ", orderDate=" + orderDate +
                ", deliverBefore=" + deliverBefore +
                ", supplierID='" + supplierID + '\'' +
                ", storeKeeperID='" + storeKeeperID + '\'' +
                '}';
    }
}
