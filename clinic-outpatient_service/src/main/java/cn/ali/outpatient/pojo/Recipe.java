package cn.ali.outpatient.pojo;


public class Recipe {

  private long id;
  private long outpatientId;//接诊信息id
  private String recipeName;//处方名称


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getoutpatientId() {
    return outpatientId;
  }

  public void setoutpatientId(long outpatientId) {
    this.outpatientId = outpatientId;
  }


  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

}
