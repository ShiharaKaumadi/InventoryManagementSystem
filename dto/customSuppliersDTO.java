package lk.ijse.finalproject.dto;

public class customSuppliersDTO {
    private String skId;
    private String empId;
    private String email;

    public customSuppliersDTO() {
    }
    public customSuppliersDTO(String skId, String empId, String email) {
        this.skId = skId;
        this.empId = empId;
        this.email = email;
    }
    public String getSkId() {
        return skId;
    }

    public void setSkId(String skId) {
        this.skId = skId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
