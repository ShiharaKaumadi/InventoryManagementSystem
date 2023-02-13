package lk.ijse.finalproject.views.tm;

public class SupplierTM {
    private String supplierId;
    private String companyName;
    private String address;
    private String email;
    private String contactNo;
    private String contactPerson;
    private String category;
    private String subCategory;
    private String productId;

    public SupplierTM() {
    }

    public SupplierTM(String supplierId, String companyName, String address, String email, String contactNo, String contactPerson, String category, String subCategory, String productId) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
        this.category = category;
        this.subCategory = subCategory;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
