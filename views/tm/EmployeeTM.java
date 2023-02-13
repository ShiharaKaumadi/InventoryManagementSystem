package lk.ijse.finalproject.views.tm;

public class EmployeeTM {
    private String name;
    private String empId;
    private String designation;
    private String email;
    private String contactNo;
    private String address;

    public EmployeeTM() {
    }

    public EmployeeTM(String name, String empId, String designation, String email, String contactNo, String address) {
        this.name = name;
        this.empId = empId;
        this.designation = designation;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
