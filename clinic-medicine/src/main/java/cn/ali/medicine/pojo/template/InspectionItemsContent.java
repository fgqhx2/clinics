package cn.ali.medicine.pojo.template;

import lombok.ToString;

@ToString
public class InspectionItemsContent {

  private Integer id;
  private Integer rtId;//模板Id
  private Integer checkId;//检查项目
  private String checkName;//检查项目名
  private String part;//部位
  private Integer num;//次数
  private String unit;//单位
  private String type;//类型
  private double unit_price;//单价
  private double money;//金额
  private String remark;//备注

  public double getUnit_price() {
    return unit_price;
  }

  public void setUnit_price(double unit_price) {
    this.unit_price = unit_price;
  }

  public String getCheckName() {
    return checkName;
  }

  public void setCheckName(String checkName) {
    this.checkName = checkName;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getRtId() {
    return rtId;
  }

  public void setRtId(Integer rtId) {
    this.rtId = rtId;
  }


  public Integer getCheckId() {
    return checkId;
  }

  public void setCheckId(Integer checkId) {
    this.checkId = checkId;
  }


  public String getPart() {
    return part;
  }

  public void setPart(String part) {
    this.part = part;
  }


  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
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
