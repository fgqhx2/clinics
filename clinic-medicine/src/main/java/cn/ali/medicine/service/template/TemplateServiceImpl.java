package cn.ali.medicine.service.template;

import cn.ali.medicine.mapper.template.RecipeTemplateMapper;
import cn.ali.medicine.pojo.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private RecipeTemplateMapper recipeTemplateMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<RecipeTemplate> findAllRecipeTemplate(String recipeType, Integer authority, String templateNameOrTemplateNo) {
        List<RecipeTemplate> list = null;
        if (recipeType == null && authority == null && templateNameOrTemplateNo == null) {
            list = (List<RecipeTemplate>) redisTemplate.opsForValue().get("RecipeTemplate");
            if (list == null) {
                list = recipeTemplateMapper.findAllRecipeTemplate(recipeType, authority, templateNameOrTemplateNo);
                redisTemplate.opsForValue().set("RecipeTemplate", list, 60, TimeUnit.MINUTES);
            }
        } else {
            list = recipeTemplateMapper.findAllRecipeTemplate(recipeType, authority, templateNameOrTemplateNo);
        }
        return list;
    }

    @Override
    public RecipeTemplate findRecipeTemplateById(Integer id) {
        RecipeTemplate recipeTemplate = recipeTemplateMapper.findRecipeTemplateById(id);
        recipeTemplate.setRecipeTemplateCList(recipeTemplateMapper.findAllRecipeTemplateContentByRtId(recipeTemplate.getId()));
        recipeTemplate.setInspectionItemList(recipeTemplateMapper.findAllInspectionItemsContentByRtId(recipeTemplate.getId()));
        recipeTemplate.setAdditionalCharges(recipeTemplateMapper.findAllAdditionalChargeContentByRtId(recipeTemplate.getId()));
        return recipeTemplate;
    }

    @Override
    public List<RecipeTemplateContent> findAllRecipeTemplateContentByRtId(Integer rtId) {
        return recipeTemplateMapper.findAllRecipeTemplateContentByRtId(rtId);
    }

    @Override
    public List<InspectionItems> findAllInspectionItems() {
        return recipeTemplateMapper.findAllInspectionItems();
    }

    @Override
    public List<InspectionItemsContent> findAllInspectionItemsContentByRtId(Integer rtId) {
        return recipeTemplateMapper.findAllInspectionItemsContentByRtId(rtId);
    }

    @Override
    public List<AdditionalCharge> findAllAdditionalCharge() {
        return recipeTemplateMapper.findAllAdditionalCharge();
    }

    @Override
    public void saveRecipeTemplate(RecipeTemplate recipeTemplate) throws Exception {


    }


}
