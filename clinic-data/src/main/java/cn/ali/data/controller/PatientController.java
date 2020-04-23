package cn.ali.data.controller;

import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.data.pojo.Patient;
import cn.ali.data.servic.patient.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    @GetMapping("/byName")
    public ResponseResult byName(String name) {
        List<Patient> patients= patientService.findPatientByName(name);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(patients);
    }


    @GetMapping("/byId")
    public ResponseResult byId(Integer id) {
        Patient patients= patientService.findPatientById(id);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(patients);
    }

}
