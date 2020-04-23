package cn.ali.medicine.mapper.drug;

import cn.ali.medicine.pojo.drug.Drug;
import cn.ali.medicine.pojo.drug.DrugType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DrugMapper {

    List<Drug> findDrugByDrug_typeOrDrugNameOrPinYinCode(@Param("recipeType")Integer recipeType,@Param("drug_typeId")Integer drug_typeId,@Param("drugNameOrPinYinCode")String drugNameOrPinYinCode);

    List<DrugType> findDrugTypeByRecipeType(Integer recipeType);


}
