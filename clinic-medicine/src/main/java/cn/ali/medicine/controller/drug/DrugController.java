package cn.ali.medicine.controller.drug;

import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.medicine.mapper.drug.DrugMapper;
import cn.ali.medicine.pojo.drug.Drug;
import cn.ali.medicine.pojo.drug.DrugType;
import cn.ali.medicine.service.drug.DrugService;
import cn.ali.medicine.service.drug.DrugServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/drugs")
public class DrugController {
    @Resource
    private DrugServiceImpl drugService;
    @GetMapping("/list")
    public ResponseResult drugList(Integer recipeType ,Integer drug_typeId, String nameOrCode) {
        List<Drug> drugs = drugService.findDrugByDrug_typeOrDrugNameOrPinYinCode(recipeType,drug_typeId, nameOrCode);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(drugs);
    }

    @GetMapping("/DrugType")
    public ResponseResult drug(Integer recipeType) {
        List<DrugType> drugTypes=drugService.findDrugTypeByRecipeType(recipeType);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(drugTypes);
    }

    @GetMapping("/poi")
    public void poi(Integer recipeType ,Integer drug_typeId, String nameOrCode) {
        List<Drug> drugs=drugService.findDrugByDrug_typeOrDrugNameOrPinYinCode(null,null,null);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("123");
        Row titleRow = sheet.createRow(0);
        String[] str = {"序号", "药品名称", "用法", "金额"};
        for (int i = 0; i < str.length; i++) {
            titleRow.createCell(i).setCellValue(str[i]);
        }
        for (Drug drug :
                drugs) {
            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);
            row.createCell(0).setCellValue(drug.getId());
            row.createCell(1).setCellValue(drug.getName());
            row.createCell(2).setCellValue(drug.getUsages());
            row.createCell(3).setCellValue(drug.getRetail_price());
        }
        File file = new File("F:\\APP\\drug.xls");
        if (file.exists()) {
            file.mkdirs();
        }
        try {
            hssfWorkbook.write(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
