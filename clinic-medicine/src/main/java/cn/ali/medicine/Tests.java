package cn.ali.medicine;

import cn.ali.medicine.mapper.drug.DrugMapper;
import cn.ali.medicine.mapper.template.RecipeTemplateMapper;
import cn.ali.medicine.pojo.drug.Drug;
import cn.ali.medicine.pojo.template.RecipeTemplate;
import cn.ali.medicine.service.template.TemplateServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Tests {
    @Autowired
    DrugMapper drugMapper;

    @Autowired
    RecipeTemplateMapper recipeTemplateMapper;

    @Autowired
    TemplateServiceImpl templateService;
        @Test
        public void test() throws IOException {
        List<Drug> drugs=drugMapper.findDrugByDrug_typeOrDrugNameOrPinYinCode(null,null,null);
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
        hssfWorkbook.write(new FileOutputStream(file));
    }

    @Test
    public void test2() {
        List<Drug> drugs=drugMapper.findDrugByDrug_typeOrDrugNameOrPinYinCode(null,null,"替");
        for (Drug d:drugs
        ) {
            System.out.println("药品信息查询》》》"+d.toString());
        }
        recipeTemplateMapper.findAllRecipeTemplate("中药处方",null,null).forEach(recipeTemplate ->{
            System.out.println("处方模板条件查询》》》"+recipeTemplate.toString());
        });

        System.out.println("处方模板Id查询》》》" + recipeTemplateMapper.findRecipeTemplateById(1).toString());

        recipeTemplateMapper.findAllRecipeTemplateContentByRtId(1).forEach(recipeTemplateContents ->{
            System.out.println("处方模板药品内容Id查询》》》" + recipeTemplateContents.toString());
        });
        recipeTemplateMapper.findAllInspectionItemsContentByRtId(8).forEach(inspectionItemsContents ->{
            System.out.println("处方模板检查项目内容Id查询》》》" + inspectionItemsContents.toString());
        });

        recipeTemplateMapper.findAllInspectionItems().forEach(inspectionItems -> {
            System.out.println("检查项目查询》》》"+inspectionItems.toString());
        });


    }

    @Test
    public void testFinAdditionAll() throws IOException {
      List<RecipeTemplate> list= templateService.findAllRecipeTemplate(null, null, null);
        list.forEach(recipeTemplate -> {
            System.out.println(recipeTemplate.getTemplateName());
        });

    }



}
