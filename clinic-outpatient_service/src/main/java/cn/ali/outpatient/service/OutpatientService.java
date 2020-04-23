package cn.ali.outpatient.service;

import cn.ali.outpatient.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OutpatientService {

    void saveOutpatient(OutpatientModel model) throws Exception;

    List<Advice> findAdvice();

    List<Diagnose> findDiagnose();

}
