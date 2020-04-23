package cn.ali.outpatient.pojo;


public class RecipeContent {

  private long id;
  private long groupId;//组号
  private long recipeId;//处方模板序号
  private long drugId;//药品id
  private String drugName;//药品名称
  private long a_single_dose;//单次用量
  private String a_single_dose_unit;//单次用量单位
  private String frequency;//频次
  private long gross;//总量
  private String grossUnitId;//总量单位
  private double unit_price;//单价
  private double money;//金额
  private double discount;//折扣
  private double discount_money;//折扣金额


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public long getDrugId() {
    return drugId;
  }

  public void setDrugId(long drugId) {
    this.drugId = drugId;
  }


  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }


  public long getA_single_dose() {
    return a_single_dose;
  }

  public void setA_single_dose(long a_single_dose) {
    this.a_single_dose = a_single_dose;
  }


  public String getA_single_dose_unit() {
    return a_single_dose_unit;
  }

  public void setA_single_dose_unit(String a_single_dose_unit) {
    this.a_single_dose_unit = a_single_dose_unit;
  }


  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }


  public long getGross() {
    return gross;
  }

  public void setGross(long gross) {
    this.gross = gross;
  }


  public String getGrossUnitId() {
    return grossUnitId;
  }

  public void setGrossUnitId(String grossUnitId) {
    this.grossUnitId = grossUnitId;
  }


  public double getUnit_price() {
    return unit_price;
  }

  public void setUnit_price(double unit_price) {
    this.unit_price = unit_price;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }


  public double getDiscount_money() {
    return discount_money;
  }

  public void setDiscount_money(double discount_money) {
    this.discount_money = discount_money;
  }

}
