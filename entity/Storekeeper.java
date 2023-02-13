package lk.ijse.finalproject.entity;

public class Storekeeper {
    private String storeKeeperId;
    private String empID;

    public Storekeeper() {
    }

    public Storekeeper(String storeKeeperId, String empID) {
        this.storeKeeperId = storeKeeperId;
        this.empID = empID;
    }

    public String getStoreKeeperId() {
        return storeKeeperId;
    }

    public void setStoreKeeperId(String storeKeeperId) {
        this.storeKeeperId = storeKeeperId;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    @Override
    public String toString() {
        return "Storekeeper{" +
                "storeKeeperId='" + storeKeeperId + '\'' +
                ", empID='" + empID + '\'' +
                '}';
    }
}
