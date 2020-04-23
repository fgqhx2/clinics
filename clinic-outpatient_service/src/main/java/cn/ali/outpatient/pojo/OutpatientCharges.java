package cn.ali.outpatient.pojo;

public class OutpatientCharges {

  private long id;
  private long receptionId;//门诊信息id
  private double receivables;//应收金额
  private double discount_amount;//优惠金额
  private double discount;//折扣
  private double medicare_payments;//医保支付
  private double money_received;//实收金额
  private double change;//找零
  private String payType;//支付方式
  private String remark;//收款备注


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getReceptionId() {
    return receptionId;
  }

  public void setReceptionId(long receptionId) {
    this.receptionId = receptionId;
  }


  public double getReceivables() {
    return receivables;
  }

  public void setReceivables(double receivables) {
    this.receivables = receivables;
  }


  public double getDiscount_amount() {
    return discount_amount;
  }

  public void setDiscount_amount(double discount_amount) {
    this.discount_amount = discount_amount;
  }


  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }


  public double getMedicare_payments() {
    return medicare_payments;
  }

  public void setMedicare_payments(double medicare_payments) {
    this.medicare_payments = medicare_payments;
  }


  public double getMoney_received() {
    return money_received;
  }

  public void setMoney_received(double money_received) {
    this.money_received = money_received;
  }


  public double getChange() {
    return change;
  }

  public void setChange(double change) {
    this.change = change;
  }


  public String getPayType() {
    return payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
