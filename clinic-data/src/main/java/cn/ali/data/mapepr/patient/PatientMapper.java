package cn.ali.data.mapepr.patient;

import cn.ali.data.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    List<Patient> findPatientByName(String name);

    Patient findPatientById(Integer id);

}
