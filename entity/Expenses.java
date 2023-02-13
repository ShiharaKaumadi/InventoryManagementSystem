package lk.ijse.finalproject.entity;

import java.time.LocalDate;

public class Expenses {
    private String expId;
    private String description;
    private String cashierID;
    private LocalDate date;
    private double amount;

    public Expenses() {
    }

    public Expenses(String expId, String description, String cashierID, LocalDate date, double amount) {
        this.expId = expId;
        this.description = description;
        this.cashierID = cashierID;
        this.date = date;
        this.amount = amount;
    }

    public String getExpId() {
        return expId;
    }

    public void setExpId(String expId) {
        this.expId = expId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCashierID() {
        return cashierID;
    }

    public void setCashierID(String cashierID) {
        this.cashierID = cashierID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
