package cn.ali.data.servic.patient;

import cn.ali.data.mapepr.patient.PatientMapper;
import cn.ali.data.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientMapper patientMapper;
    @Override
    public List<Patient> findPatientByName(String name) {
        return patientMapper.findPatientByName(name);
    }

    @Override
    public Patient findPatientById(Integer id) {
        return patientMapper.findPatientById(id);
    }
}
