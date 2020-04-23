package cn.ali.medicine.pojo.template;


import lombok.ToString;

import java.util.Date;
import java.util.List;
@ToString
public class RecipeTemplate {

  private Integer id;//序号
  private String templateName;//模板名称
  private String templateNo;//模板编号
  private String recipeType;//模板类型
  private String diagnose;//诊断
  private Integer authority;//模板权限
  private String explain;//模板说明
  private Date creation_time;//创建时间
  private String creator;//创建人
  private List<RecipeTemplateContent> RecipeTemplateCList;//处方模板药品内容
  private List<InspectionItemsContent> InspectionItemList;//检查项目内容
  private List<AdditionalCharge> additionalCharges;//附加费内容

  public List<AdditionalCharge> getAdditionalCharges() {
    return additionalCharges;
  }

  public void setAdditionalCharges(List<AdditionalCharge> additionalCharges) {
    this.additionalCharges = additionalCharges;
  }

  public List<RecipeTemplateContent> getRecipeTemplateCList() {
    return RecipeTemplateCList;
  }

  public void setRecipeTemplateCList(List<RecipeTemplateContent> recipeTemplateCList) {
    RecipeTemplateCList = recipeTemplateCList;
  }

  public List<InspectionItemsContent> getInspectionItemList() {
    return InspectionItemList;
  }

  public void setInspectionItemList(List<InspectionItemsContent> inspectionItemList) {
    InspectionItemList = inspectionItemList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }


  public String getTemplateNo() {
    return templateNo;
  }

  public void setTemplateNo(String templateNo) {
    this.templateNo = templateNo;
  }


  public String getRecipeType() {
    return recipeType;
  }

  public void setRecipeType(String recipeType) {
    this.recipeType = recipeType;
  }


  public String getDiagnose() {
    return diagnose;
  }

  public void setDiagnose(String diagnose) {
    this.diagnose = diagnose;
  }


  public Integer getAuthority() {
    return authority;
  }

  public void setAuthority(Integer authority) {
    this.authority = authority;
  }


  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }


  public Date getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Date creation_time) {
    this.creation_time = creation_time;
  }


  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

}
