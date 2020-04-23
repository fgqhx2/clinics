package cn.ali.medicine.service.drug;

import cn.ali.medicine.pojo.drug.Drug;
import cn.ali.medicine.pojo.drug.DrugType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugService {
    List<Drug> findDrugByDrug_typeOrDrugNameOrPinYinCode(Integer recipeType, Integer drug_typeId, String drugNameOrPinYinCode);

    List<DrugType> findDrugTypeByRecipeType(Integer recipeType);

}
