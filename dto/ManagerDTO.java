package lk.ijse.finalproject.dto;

public class ManagerDTO {
    private String managerId;
    private String empID;

    public ManagerDTO() {
    }

    public ManagerDTO(String managerId, String empID) {
        this.setManagerId(managerId);
        this.setEmpID(empID);
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }
}
