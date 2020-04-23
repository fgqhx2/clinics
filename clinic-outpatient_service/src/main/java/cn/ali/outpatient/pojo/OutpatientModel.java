package cn.ali.outpatient.pojo;

import java.util.List;

public class OutpatientModel {
    private Integer patientId;
    private Outpatient outpatient;//就诊信息
    private List<AdditionalCharges> westernAdditionals;//西药附加费用
    private List<AdditionalCharges> centreAdditionals;//中药附加费用
    private List<Recipe> recipes;//处方类型
    private List<RecipeContent> westerns;//西药
    private List<RecipeContent> centres;//中药
    private List<InspectionItemsContent> inspectionItems;//检查项目

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Outpatient getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Outpatient outpatient) {
        this.outpatient = outpatient;
    }

    public List<AdditionalCharges> getWesternAdditionals() {
        return westernAdditionals;
    }

    public void setWesternAdditionals(List<AdditionalCharges> westernAdditionals) {
        this.westernAdditionals = westernAdditionals;
    }

    public List<AdditionalCharges> getCentreAdditionals() {
        return centreAdditionals;
    }

    public void setCentreAdditionals(List<AdditionalCharges> centreAdditionals) {
        this.centreAdditionals = centreAdditionals;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<RecipeContent> getWesterns() {
        return westerns;
    }

    public void setWesterns(List<RecipeContent> westerns) {
        this.westerns = westerns;
    }

    public List<RecipeContent> getCentres() {
        return centres;
    }

    public void setCentres(List<RecipeContent> centres) {
        this.centres = centres;
    }

    public List<InspectionItemsContent> getInspectionItems() {
        return inspectionItems;
    }

    public void setInspectionItems(List<InspectionItemsContent> inspectionItems) {
        this.inspectionItems = inspectionItems;
    }
}
