package lk.ijse.finalproject.views.tm;

import org.hibernate.repackage.cglib.core.Local;

import java.time.LocalDate;

public class MinTM {
    private String minStockCode;
    private String minStockItemDescription;
    private String minMeasuredUnits;
    private double minQtyIssued;
    private LocalDate minIssueDate;
    private String minCategory;
    private String minSubCategory;
    private String minBrandName;
    private double minUnitRate;

    private String minId;

    public MinTM() {
    }

    public MinTM(String minStockCode, String minStockItemDescription, String minMeasuredUnits, double minQtyIssued, LocalDate minIssueDate, String minCategory, String minSubCategory, String minBrandName, double minUnitRate, String minId) {
        this.minStockCode = minStockCode;
        this.minStockItemDescription = minStockItemDescription;
        this.minMeasuredUnits = minMeasuredUnits;
        this.minQtyIssued = minQtyIssued;
        this.minIssueDate = minIssueDate;
        this.minCategory = minCategory;
        this.minSubCategory = minSubCategory;
        this.minBrandName = minBrandName;
        this.minUnitRate = minUnitRate;
        this.minId = minId;
    }

    public MinTM(String minStockCode, String minStockItemDescription, String minMeasuredUnits, double minQtyIssued, LocalDate minIssueDate, String minCategory, String minSubCategory, String minBrandName, double minUnitRate) {
        this.minStockCode = minStockCode;
        this.minStockItemDescription = minStockItemDescription;
        this.minMeasuredUnits = minMeasuredUnits;
        this.minQtyIssued = minQtyIssued;
        this.minIssueDate = minIssueDate;
        this.minCategory = minCategory;
        this.minSubCategory = minSubCategory;
        this.minBrandName = minBrandName;
        this.minUnitRate = minUnitRate;
    }

    public String getMinStockCode() {
        return minStockCode;
    }

    public void setMinStockCode(String minStockCode) {
        this.minStockCode = minStockCode;
    }

    public String getMinStockItemDescription() {
        return minStockItemDescription;
    }

    public void setMinStockItemDescription(String minStockItemDescription) {
        this.minStockItemDescription = minStockItemDescription;
    }

    public String getMinMeasuredUnits() {
        return minMeasuredUnits;
    }

    public void setMinMeasuredUnits(String minMeasuredUnits) {
        this.minMeasuredUnits = minMeasuredUnits;
    }

    public double getMinQtyIssued() {
        return minQtyIssued;
    }

    public void setMinQtyIssued(double minQtyIssued) {
        this.minQtyIssued = minQtyIssued;
    }

    public LocalDate getMinIssueDate() {
        return minIssueDate;
    }

    public void setMinIssueDate(LocalDate minIssueDate) {
        this.minIssueDate = minIssueDate;
    }

    public String getMinCategory() {
        return minCategory;
    }

    public void setMinCategory(String minCategory) {
        this.minCategory = minCategory;
    }

    public String getMinSubCategory() {
        return minSubCategory;
    }

    public void setMinSubCategory(String minSubCategory) {
        this.minSubCategory = minSubCategory;
    }

    public String getMinBrandName() {
        return minBrandName;
    }

    public void setMinBrandName(String minBrandName) {
        this.minBrandName = minBrandName;
    }

    public double getMinUnitRate() {
        return minUnitRate;
    }

    public void setMinUnitRate(double minUnitRate) {
        this.minUnitRate = minUnitRate;
    }

    public String getMinId() {
        return minId;
    }

    public void setMinId(String minId) {
        this.minId = minId;
    }
}
