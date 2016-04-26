package model;

/**
 * Created by sfaxiano on 17/06/2015.
 */
public class Payment {
    private int idPayment;
    private int userId;
    private String paymentCreationTime;
    private String paymentUpdateTime;
    private int paymentState;
    private double paymentAmount;
    private String paymentCurrency;



    public Payment(){};

    public Payment(double paymentAmount,String paymentCreationTime,String paymentCurrency)
    {
        this.paymentAmount=paymentAmount;
        this.paymentCreationTime=paymentCreationTime;
        this.paymentCurrency=paymentCurrency;
    }

    public Payment(int userId, String paymentCreationTime, String paymentUpdateTime, int paymentState, double paymentAmount, String paymentCurrency) {
        this.userId = userId;
        this.paymentCreationTime = paymentCreationTime;
        this.paymentUpdateTime = paymentUpdateTime;
        this.paymentState = paymentState;
        this.paymentAmount = paymentAmount;
        this.paymentCurrency = paymentCurrency;
    }

    public Payment(int idPayment, int userId, String paymentCreationTime, String paymentUpdateTime, int paymentState, double paymentAmount, String paymentCurrency) {
        this.idPayment = idPayment;
        this.userId = userId;
        this.paymentCreationTime = paymentCreationTime;
        this.paymentUpdateTime = paymentUpdateTime;
        this.paymentState = paymentState;
        this.paymentAmount = paymentAmount;
        this.paymentCurrency = paymentCurrency;
    }


    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPaymentCreationTime() {
        return paymentCreationTime;
    }

    public void setPaymentCreationTime(String paymentCreationTime) {
        this.paymentCreationTime = paymentCreationTime;
    }

    public String getPaymentUpdateTime() {
        return paymentUpdateTime;
    }

    public void setPaymentUpdateTime(String paymentUpdateTime) {
        this.paymentUpdateTime = paymentUpdateTime;
    }

    public int getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(int paymentState) {
        this.paymentState = paymentState;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "idPayment=" + idPayment +
                ", userId=" + userId +
                ", paymentCreationTime='" + paymentCreationTime + '\'' +
                ", paymentUpdateTime='" + paymentUpdateTime + '\'' +
                ", paymentState=" + paymentState +
                ", paymentAmount=" + paymentAmount +
                ", paymentCurrency='" + paymentCurrency + '\'' +
                '}';
    }
}
