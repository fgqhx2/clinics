package cn.ali.medicine.pojo.template;

import lombok.ToString;

@ToString
public class InspectionItems {

  private Integer id; //序号
  private String name; //检查项目名
  private String type; //类型
  private double unit_price;//单价
  private String unit;//单位


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public double getUnit_price() {
    return unit_price;
  }

  public void setUnit_price(double unit_price) {
    this.unit_price = unit_price;
  }


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

}
