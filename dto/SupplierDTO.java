package lk.ijse.finalproject.dto;

public class SupplierDTO {
    private String supplierId;
    private String companyName;
    private String address;
    private String email;
    private String contactNo;
    private String contactPerson;
    private String supplierCategory;

    private String supplierSubCategory;
    private String brandName;
    private String productId;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierId, String companyName, String address, String email, String contactNo, String contactPerson, String supplierCategory, String supplierSubCategory, String brandName,String productId) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
        this.supplierCategory = supplierCategory;
        this.supplierSubCategory=supplierSubCategory;
        this.brandName = brandName;
        this.productId = productId;
    }

    public SupplierDTO(String supplierId, String companyName, String address, String email, String contactNo, String contactPerson, String supplierCategory, String supplierSubCategory, String productId) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
        this.supplierCategory = supplierCategory;
        this.supplierSubCategory = supplierSubCategory;
        this.productId = productId;
    }

    public SupplierDTO(String supplierId, String companyName, String address, String email, String contactNo, String contactPerson) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getSupplierCategory() {
        return supplierCategory;
    }

    public void setSupplierCategory(String supplierCategory) {
        this.supplierCategory = supplierCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSupplierSubCategory() {
        return supplierSubCategory;
    }

    public void setSupplierSubCategory(String supplierSubCategory) {
        this.supplierSubCategory = supplierSubCategory;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", supplierCategory='" + supplierCategory + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
