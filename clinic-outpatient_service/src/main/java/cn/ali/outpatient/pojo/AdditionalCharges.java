package cn.ali.outpatient.pojo;


public class AdditionalCharges {

  private long id;
  private long recipeId;//处方模板序号
  private String name;//附加费名
  private long num;//数量
  private double price;//金额


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
