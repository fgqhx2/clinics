package cn.ali.medicine.mapper.template;

import cn.ali.medicine.pojo.template.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RecipeTemplateMapper {

    List<RecipeTemplate> findAllRecipeTemplate(@Param("recipeType")String recipeType,@Param("authority")Integer authority,@Param("templateNameOrTemplateNo") String templateNameOrTemplateNo);

    RecipeTemplate findRecipeTemplateById(Integer id);

    List<RecipeTemplateContent> findAllRecipeTemplateContentByRtId(Integer rtId);

    List<InspectionItems> findAllInspectionItems();

    List<InspectionItemsContent> findAllInspectionItemsContentByRtId(Integer rtId);

    List<AdditionalCharge> findAllAdditionalChargeContentByRtId(Integer rtId);

    List<AdditionalCharge> findAllAdditionalCharge();

    int saveRecipeTemplate(RecipeTemplate recipeTemplate);

    int saveAdditionalChargeContent(AdditionalCharge additionalCharge);

    int saveRecipeTemplateContent(RecipeTemplateContent recipeTemplateContent);

    int saveInspectionItemsContent(InspectionItemsContent inspectionItemsContent);

}
