package cn.ali.medicine.service.drug;

import cn.ali.medicine.mapper.drug.DrugMapper;
import cn.ali.medicine.pojo.drug.Drug;
import cn.ali.medicine.pojo.drug.DrugType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService{
    @Resource
    DrugMapper drugMapper;

    @Override
    public List<Drug> findDrugByDrug_typeOrDrugNameOrPinYinCode(Integer recipeType, Integer drug_typeId, String drugNameOrPinYinCode) {
        return drugMapper.findDrugByDrug_typeOrDrugNameOrPinYinCode(recipeType,drug_typeId,drugNameOrPinYinCode);
    }

    @Override
    public List<DrugType> findDrugTypeByRecipeType(Integer recipeType) {
        return drugMapper.findDrugTypeByRecipeType(recipeType);
    }
}
