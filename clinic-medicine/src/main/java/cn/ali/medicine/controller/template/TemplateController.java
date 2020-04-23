package cn.ali.medicine.controller.template;

import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.medicine.pojo.template.*;
import cn.ali.medicine.service.template.TemplateService;
import cn.ali.medicine.service.template.TemplateServiceImpl;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/template")
public class TemplateController {
    @Resource
    private TemplateServiceImpl templateService;

    /**
     * 查询所有模板，或按条件查询
     * @param recipeType
     * @param authority
     * @param templateNameOrTemplateNo
     * @return
     */
    @GetMapping("/recipe/list")
    public ResponseResult recipeList(String recipeType,Integer authority,String templateNameOrTemplateNo) {
        List<RecipeTemplate> recipeTemplateList = templateService.findAllRecipeTemplate(recipeType, authority, templateNameOrTemplateNo);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(recipeTemplateList);
    }

    @PostMapping("/recipe/list")
    public ResponseResult recipeLists(String recipeType,Integer authority,String templateNameOrTemplateNo) {
        List<RecipeTemplate> recipeTemplateList = templateService.findAllRecipeTemplate(recipeType, authority, templateNameOrTemplateNo);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(recipeTemplateList);
    }


    /**
     * 按处方模板id查询药品模板内容
     * @param rtId
     * @return
     */
    @GetMapping("/recipe/content")
    public ResponseResult recipeContent(Integer rtId) {
        List<RecipeTemplateContent> contentList=templateService.findAllRecipeTemplateContentByRtId(rtId);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(contentList);
    }
    /**
     * 按处方模板id查询检查模板内容
     * @param rtId
     * @return
     */
    @GetMapping("/check/content")
    public ResponseResult checkContent(Integer rtId) {
        List<InspectionItemsContent> contentList = templateService.findAllInspectionItemsContentByRtId(rtId);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(contentList);
    }

    /**
     * 查询全部的检查项目
     * @return
     */
    @GetMapping("/check/list")
    public ResponseResult checkList() {
        List<InspectionItems> list = templateService.findAllInspectionItems();
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(list);
    }

    /**
     * 查询全部附加费用
     * @return
     */
    @GetMapping("/additionalCharge/list")
    public ResponseResult AdditionalCharge() {
        List<AdditionalCharge> chargeList = templateService.findAllAdditionalCharge();
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(chargeList);
    }

    @GetMapping("/recipe/save")
    public ResponseResult save(RecipeTemplate recipeTemplate,String name) {
        System.out.println("save>>>"+recipeTemplate.getTemplateName());

        try {
            recipeTemplate= new ObjectMapper().readValue(name, RecipeTemplate.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(recipeTemplate.getTemplateName());
    }



}
