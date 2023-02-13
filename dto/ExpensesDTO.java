package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class ExpensesDTO {
    private String expId;
    private String description;
    private String cashierId;
    private LocalDate date;
    private double amount;

    public ExpensesDTO() {
    }

    public ExpensesDTO(String expId, String description, String cashierId, LocalDate date, double amount) {
        this.expId = expId;
        this.description = description;
        this.cashierId = cashierId;
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

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
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
