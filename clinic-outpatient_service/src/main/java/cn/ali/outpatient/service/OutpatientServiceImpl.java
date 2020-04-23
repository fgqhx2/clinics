package cn.ali.outpatient.service;

import cn.ali.outpatient.mapper.OutpatientMapper;
import cn.ali.outpatient.pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OutpatientServiceImpl implements OutpatientService {
    @Resource
    OutpatientMapper outpatientMapper;


    @Override
    public void saveOutpatient(OutpatientModel model) throws Exception {
        try {
            Outpatient outpatient = model.getOutpatient();
            outpatientMapper.saveOutpatient(outpatient);
           model.getRecipes().forEach(recipe -> {
               recipe.setoutpatientId(outpatient.getId());
               outpatientMapper.saveRecipe(recipe);
               Long rid = recipe.getId();
               if (recipe.getRecipeName().equals("中药处方")){
                   model.getCentres().forEach(recipeContent -> {
                       recipeContent.setRecipeId(rid);
                       outpatientMapper.saveRecipeContent(recipeContent);
                   });
                   model.getCentreAdditionals().forEach(additionalCharges -> {
                       additionalCharges.setRecipeId(rid);
                       outpatientMapper.saveAdditionalCharge(additionalCharges);
                   });
               }else{
                   model.getWesterns().forEach(recipeContent -> {
                       recipeContent.setRecipeId(rid);
                       outpatientMapper.saveRecipeContent(recipeContent);
                   });
                   model.getWesternAdditionals().forEach(additionalCharges -> {
                       additionalCharges.setRecipeId(rid);
                       outpatientMapper.saveAdditionalCharge(additionalCharges);
                   });
               }

           });
            if (model.getInspectionItems() != null) {
                model.getInspectionItems().forEach(inspectionItemsContent -> {
                    inspectionItemsContent.setOutpatientId(outpatient.getId());
                    outpatientMapper.saveInspectionItemsContent(inspectionItemsContent);
                });
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }



    @Override
    public List<Advice> findAdvice() {
        return outpatientMapper.findAdvice();
    }

    @Override
    public List<Diagnose> findDiagnose() {
        return outpatientMapper.findDiagnose();
    }
}
