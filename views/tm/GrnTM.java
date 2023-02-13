package lk.ijse.finalproject.views.tm;

import java.math.BigDecimal;

public class GrnTM {
    private String receivedStockCode;
    private String grnStockItemDescription;
    private String grnCategory;
    private String grnSubCategory;
    private String grnBrandName;
    private String grnMeasuredUnits;
    private double unitPrice;
    private double qtyReceived;
    private double qtyAccepted;
    private String reasonForRejection;

    public GrnTM() {
    }

    public GrnTM(String receivedStockCode, String grnStockItemDescription, String grnCategory, String grnSubCategory, String grnBrandName, String grnMeasuredUnits, double unitPrice, double qtyReceived, double qtyAccepted, String reasonForRejection) {
        this.receivedStockCode = receivedStockCode;
        this.grnStockItemDescription = grnStockItemDescription;
        this.grnCategory = grnCategory;
        this.grnSubCategory = grnSubCategory;
        this.grnBrandName = grnBrandName;
        this.grnMeasuredUnits = grnMeasuredUnits;
        this.unitPrice = unitPrice;
        this.qtyReceived = qtyReceived;
        this.qtyAccepted = qtyAccepted;
        this.reasonForRejection = reasonForRejection;
    }

    public String getReceivedStockCode() {
        return receivedStockCode;
    }

    public void setReceivedStockCode(String receivedStockCode) {
        this.receivedStockCode = receivedStockCode;
    }

    public String getGrnStockItemDescription() {
        return grnStockItemDescription;
    }

    public void setGrnStockItemDescription(String grnStockItemDescription) {
        this.grnStockItemDescription = grnStockItemDescription;
    }

    public String getGrnCategory() {
        return grnCategory;
    }

    public void setGrnCategory(String grnCategory) {
        this.grnCategory = grnCategory;
    }

    public String getGrnSubCategory() {
        return grnSubCategory;
    }

    public void setGrnSubCategory(String grnSubCategory) {
        this.grnSubCategory = grnSubCategory;
    }

    public String getGrnBrandName() {
        return grnBrandName;
    }

    public void setGrnBrandName(String grnBrandName) {
        this.grnBrandName = grnBrandName;
    }

    public String getGrnMeasuredUnits() {
        return grnMeasuredUnits;
    }

    public void setGrnMeasuredUnits(String grnMeasuredUnits) {
        this.grnMeasuredUnits = grnMeasuredUnits;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }
}
