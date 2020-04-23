package cn.ali.outpatient.controller;

import cn.ali.common.http.HttpClientHelper;
import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.outpatient.pojo.*;
import cn.ali.outpatient.service.OutpatientService;
import cn.ali.outpatient.service.OutpatientServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api
@RestController
@RequestMapping("/api/outpatient")
public class OutpatientController {
    private final String CURRENT_SERVER_URL="http://localhost:8081";
    @Resource
    OutpatientServiceImpl outpatientService;

    @Resource
    HttpClientHelper httpClientHelper;

    @ApiOperation(value = "就诊信息保存")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "outpatient.code", value = "就诊信息门诊编码"),
            @ApiImplicitParam( name = "outpatient.patientId", value = "就诊信息患者Id"),
            @ApiImplicitParam( name = "outpatient.doctor", value = "就诊信息医生"),
            @ApiImplicitParam( name = "outpatient.department", value = "就诊信息科室"),
            @ApiImplicitParam( name = "outpatient.receptionType", value = "就诊信息接诊类型"),
            @ApiImplicitParam( name = "outpatient.diagnose", value = "就诊信息诊断"),
            @ApiImplicitParam( name = "outpatient.advice", value = "就诊信息医嘱"),
            @ApiImplicitParam( name = "outpatient.creation_time", value = "就诊信息接诊时间"),
            @ApiImplicitParam( name = "outpatient.id", value = "就诊信息id"),
            @ApiImplicitParam( name = "centreAdditionals[0].id", value = "中药附加费用id"),
            @ApiImplicitParam( name = "centreAdditionals[0].name", value = "中药附加费用"),
            @ApiImplicitParam( name = "centreAdditionals[0].num", value = "中药附加费用"),
            @ApiImplicitParam( name = "centreAdditionals[0].price", value = "中药附加费用"),
            @ApiImplicitParam( name = "centreAdditionals[0].recipeId", value = "中药附加费用"),
            @ApiImplicitParam( name = "westernAdditionals[0].id", value = "西药附加费用id"),
            @ApiImplicitParam( name = "westernAdditionals[0].name", value = "西药附加费用"),
            @ApiImplicitParam( name = "westernAdditionals[0].num", value = "西药附加费用"),
            @ApiImplicitParam( name = "westernAdditionals[0].price", value = "西药附加费用"),
            @ApiImplicitParam( name = "westernAdditionals[0].recipeId", value = "西药附加费用"),
            @ApiImplicitParam( name = "westerns[0].a_single_dose", value = "西药处方详情单次用量"),
            @ApiImplicitParam( name = "westerns[0].a_single_dose_unit", value = "西药处方详情单次用量单位"),
            @ApiImplicitParam( name = "westerns[0].discount", value = "西药处方详情折扣"),
            @ApiImplicitParam( name = "westerns[0].discount_money", value = "西药处方详情折扣金额"),
            @ApiImplicitParam( name = "westerns[0].drugId", value = "西药处方详情药品id"),
            @ApiImplicitParam( name = "westerns[0].drugName", value = "西药处方详情药品名称"),
            @ApiImplicitParam( name = "westerns[0].frequency", value = "西药处方详情频次"),
            @ApiImplicitParam( name = "westerns[0].gross", value = "西药处方详情总量"),
            @ApiImplicitParam( name = "westerns[0].grossUnitId", value = "西药处方详情总量单位"),
            @ApiImplicitParam( name = "westerns[0].groupId", value = "西药处方详情组号"),
            @ApiImplicitParam( name = "westerns[0].id", value = "西药处方详情id"),
            @ApiImplicitParam( name = "westerns[0].money", value = "西药处方详情金额"),
            @ApiImplicitParam( name = "westerns[0].recipeId", value = "西药处方模板序号"),
            @ApiImplicitParam( name = "westerns[0].unit_price", value = "西药处方详情单价"),
            @ApiImplicitParam( name = "centres[0].a_single_dose", value = "中药处方详情单次用量"),
            @ApiImplicitParam( name = "centres[0].a_single_dose_unit", value = "中药处方详情单次用量单位"),
            @ApiImplicitParam( name = "centres[0].discount", value = "中药处方详情折扣"),
            @ApiImplicitParam( name = "centres[0].discount_money", value = "中药处方详情折扣金额"),
            @ApiImplicitParam( name = "centres[0].drugId", value = "中药处方详情药品id"),
            @ApiImplicitParam( name = "centres[0].drugName", value = "中药处方详情药品名称"),
            @ApiImplicitParam( name = "centres[0].frequency", value = "中药处方详情频次"),
            @ApiImplicitParam( name = "centres[0].gross", value = "中药处方详情总量"),
            @ApiImplicitParam( name = "centres[0].grossUnitId", value = "中药处方详情总量单位"),
            @ApiImplicitParam( name = "centres[0].groupId", value = "中药处方详情组号"),
            @ApiImplicitParam( name = "centres[0].id", value = "中药处方详情id"),
            @ApiImplicitParam( name = "centres[0].money", value = "中药处方详情金额"),
            @ApiImplicitParam( name = "centres[0].recipeId", value = "中药处方模板序号"),
            @ApiImplicitParam( name = "centres[0].unit_price", value = "中药处方详情单价"),
            @ApiImplicitParam( name = "inspectionItems[0].id", value = "检查项目id"),
            @ApiImplicitParam( name = "inspectionItems[0].money", value = "检查项目金额"),
            @ApiImplicitParam( name = "inspectionItems[0].name", value = "检查项目名称"),
            @ApiImplicitParam( name = "inspectionItems[0].num", value = "检查项目数量"),
            @ApiImplicitParam( name = "inspectionItems[0].outpatientId", value = "就诊信息id"),
            @ApiImplicitParam( name = "inspectionItems[0].part", value = "检查项目部位"),
            @ApiImplicitParam( name = "inspectionItems[0].remark", value = "检查项目备注"),
            @ApiImplicitParam( name = "inspectionItems[0].type", value = "检查项目类型"),
            @ApiImplicitParam( name = "inspectionItems[0].unit", value = "检查项目单位"),
            @ApiImplicitParam( name = "recipes[0].id", value = "处方类型id"),
            @ApiImplicitParam( name = "recipes[0].outpatientId", value = "接诊信息id"),
            @ApiImplicitParam( name = "recipes[0].recipeName", value = "处方名称"),
            @ApiImplicitParam( name = "recipes[1].id", value = "处方类型id"),
            @ApiImplicitParam( name = "recipes[1].outpatientId", value = "处方类型接诊信息id"),
            @ApiImplicitParam( name = "recipes[1].recipeName", value = "处方类型处方名称")
    })
    @GetMapping("/save")
    public ResponseResult saveOutpatient(OutpatientModel model) {
        try {
            outpatientService.saveOutpatient(model);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(ResponseEnum.ERROR).setResponseBody("添加失败");
        }
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody("添加成功");
    }
    @ApiOperation(value = "获取医嘱")
    @GetMapping("/advice")
    public ResponseResult advice() {
        List<Advice> advice = outpatientService.findAdvice();
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(advice);
    }
    @ApiOperation(value = "获取诊断")
    @GetMapping("/template")
    public ResponseResult template() {
        List<Diagnose> list = outpatientService.findDiagnose();
        return new ResponseResult().setResponseBody(list);
    }
    /**
     * 查询所有模板，或按条件查询
     * @param recipeType
     * @param authority
     * @param templateNameOrTemplateNo
     * @return
     */
    @ApiOperation(value = "查询所有模板，或按条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "recipeType", value = "处方模板类型"),
            @ApiImplicitParam( name = "authority", value = "模板权限"),
            @ApiImplicitParam( name = "templateNameOrTemplateNo", value = "模板名称或编号")
    })
    @GetMapping("/recipe/list")
    public ResponseResult recipeList(String recipeType,Integer authority,String templateNameOrTemplateNo) {
        Map<String, Object> params = new HashMap<>();
        if (recipeType !=null){
            params.put("recipeType", recipeType);
        }else if (authority !=null){
            params.put("authority", authority);
        }else if (templateNameOrTemplateNo !=null){
            params.put("drugNameOrPinYinCode", templateNameOrTemplateNo);
        }
        return   httpClientHelper.getForResponse(CURRENT_SERVER_URL+"/api/template/recipe/list",params);
    }

    /**
     * 按处方模板id查询药品模板内容
     * @param rtId
     * @return
     */
    @ApiOperation(value = "按处方模板id查询药品模板内容")
    @ApiImplicitParam( name = "rtId", value = "处方模板id")
    @GetMapping("/recipe/content")
    public ResponseResult recipeContent(Integer rtId) {
        Map<String, Object> params = new HashMap<>();
        if (rtId !=null){
            params.put("rtId", rtId);
        }
        return httpClientHelper.getForResponse(CURRENT_SERVER_URL+"/api/template/recipe/content",params);
    }
    /**
     * 按处方模板id查询检查模板内容
     * @param rtId
     * @return
     */
    @ApiOperation(value = "按处方模板id查询检查模板内容")
    @ApiImplicitParam( name = "rtId", value = "处方模板id")
    @GetMapping("/check/content")
    public ResponseResult checkContent(Integer rtId) {
        Map<String, Object> params = new HashMap<>();
        if (rtId !=null){
            params.put("rtId", rtId);
        }
        return httpClientHelper.getForResponse(CURRENT_SERVER_URL+"/api/template/check/content",params);
    }

}
