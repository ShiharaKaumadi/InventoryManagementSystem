package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private String empId;
    private String name;
    private String address;
    private String nic;
    private LocalDate dob;
    private String email;
    private String designation;
    private LocalDate joinedDate;
    private String employeeType;
    private String contactNo;
    private String userName;
    private String password;

    public EmployeeDTO(String empId, String name, String address, String nic, LocalDate dob, String email, String designation, LocalDate joinedDate, String employeeType, String contactNo, String userName, String password) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.email = email;
        this.designation = designation;
        this.joinedDate = joinedDate;
        this.employeeType = employeeType;
        this.contactNo = contactNo;
        this.userName = userName;
        this.password = password;
    }

    public EmployeeDTO(String name, String empId,String designation,String email, String contactNo, String address){
        this.name = name;
        this.empId = empId;
        this.designation = designation;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public EmployeeDTO(String password) {
        this.password = password;
    }





    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNic() {
        return nic;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", joinedDate=" + joinedDate +
                ", employeeType='" + employeeType + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
