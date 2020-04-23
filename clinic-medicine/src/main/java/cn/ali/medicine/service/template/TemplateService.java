package cn.ali.medicine.service.template;

import cn.ali.medicine.pojo.template.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateService {

    List<RecipeTemplate> findAllRecipeTemplate(String recipeType,Integer authority,String templateNameOrTemplateNo);

    RecipeTemplate findRecipeTemplateById(Integer id);

    List<RecipeTemplateContent> findAllRecipeTemplateContentByRtId(Integer rtId);

    List<InspectionItems> findAllInspectionItems();

    List<InspectionItemsContent> findAllInspectionItemsContentByRtId(Integer rtId);

    List<AdditionalCharge> findAllAdditionalCharge();

    void saveRecipeTemplate(RecipeTemplate recipeTemplate) throws Exception;






}
