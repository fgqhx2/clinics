package cn.ali.outpatient.pojo;


public class InspectionItemsContent {

  private long id;
  private long outpatientId;//就诊信息id
  private String part;//部位
  private String name;//检查项目名称
  private long num;//数量
  private String unit;//单位
  private String type;//类型
  private double money;//金额
  private String remark;//备注


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOutpatientId() {
    return outpatientId;
  }

  public void setOutpatientId(long outpatientId) {
    this.outpatientId = outpatientId;
  }

  public String getPart() {
    return part;
  }

  public void setPart(String part) {
    this.part = part;
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


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
