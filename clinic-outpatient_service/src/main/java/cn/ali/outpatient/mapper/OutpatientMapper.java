package cn.ali.outpatient.mapper;

import cn.ali.outpatient.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutpatientMapper {

    int saveAdditionalCharge(AdditionalCharges additionalCharges);

    int saveOutpatient(Outpatient reception);

    int saveRecipe(Recipe recipe);

    int saveRecipeContent(RecipeContent recipeContent);

    int saveInspectionItemsContent(InspectionItemsContent inspectionItemsContent);

    List<Advice> findAdvice();

    List<Diagnose> findDiagnose();

}
