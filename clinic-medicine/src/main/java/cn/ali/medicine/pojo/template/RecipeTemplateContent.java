package cn.ali.medicine.pojo.template;

import lombok.ToString;

@ToString
public class RecipeTemplateContent {

  private Integer id;//序号
  private Integer groupId;//组号
  private Integer rtId;//处方模板序号
  private Integer drugId;//药品id
  private String name;//药品通用名
  private Integer a_single_dose;//单次用量
  private String aunit;//单次用量单位
  private String usages;//用法名称
  private String frequency;//频次
  private Integer gross;//总量
  private String gross_unit;//单位名称
  private float retail_price;//单价

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getA_single_dose() {
    return a_single_dose;
  }

  public void setA_single_dose(Integer a_single_dose) {
    this.a_single_dose = a_single_dose;
  }

  public String getAunit() {
    return aunit;
  }

  public void setAunit(String aunit) {
    this.aunit = aunit;
  }

  public String getUsages() {
    return usages;
  }

  public void setUsages(String usages) {
    this.usages = usages;
  }

  public String getGross_unit() {
    return gross_unit;
  }

  public void setGross_unit(String gross_unit) {
    this.gross_unit = gross_unit;
  }

  public float getRetail_price() {
    return retail_price;
  }

  public void setRetail_price(float retail_price) {
    this.retail_price = retail_price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }


  public Integer getRtId() {
    return rtId;
  }

  public void setRtId(Integer rtId) {
    this.rtId = rtId;
  }


  public Integer getDrugId() {
    return drugId;
  }

  public void setDrugId(Integer drugId) {
    this.drugId = drugId;
  }


  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }


  public Integer getGross() {
    return gross;
  }

  public void setGross(Integer gross) {
    this.gross = gross;
  }

}
