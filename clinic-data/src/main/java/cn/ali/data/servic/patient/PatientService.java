package cn.ali.data.servic.patient;

import cn.ali.data.pojo.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> findPatientByName(String name);

    Patient findPatientById(Integer id);
}
