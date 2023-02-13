package lk.ijse.finalproject.entity;

public class Income {
    private String incomeId;
    private double dailyIncome;
    private double weeklyIncome;
    private double monthlyIncome;
    private double yearlyIncome;

    public Income() {
    }

    public Income(String incomeId, double dailyIncome, double weeklyIncome, double monthlyIncome, double yearlyIncome) {
        this.incomeId = incomeId;
        this.dailyIncome = dailyIncome;
        this.weeklyIncome = weeklyIncome;
        this.monthlyIncome = monthlyIncome;
        this.yearlyIncome = yearlyIncome;
    }

    public String getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(String incomeId) {
        this.incomeId = incomeId;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public double getWeeklyIncome() {
        return weeklyIncome;
    }

    public void setWeeklyIncome(double weeklyIncome) {
        this.weeklyIncome = weeklyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeId='" + incomeId + '\'' +
                ", dailyIncome=" + dailyIncome +
                ", weeklyIncome=" + weeklyIncome +
                ", monthlyIncome=" + monthlyIncome +
                ", yearlyIncome=" + yearlyIncome +
                '}';
    }
}
