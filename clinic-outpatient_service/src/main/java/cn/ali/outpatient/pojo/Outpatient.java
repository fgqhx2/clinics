package cn.ali.outpatient.pojo;


import java.util.Date;

public class Outpatient {

  private long id;
  private String code;//门诊编码
  private long   patientId;//患者Id
  private String doctor;//医生
  private String department;//科室
  private String receptionType;//接诊类型
  private String diagnose;//诊断
  private String advice;//医嘱
  private Date   creation_time;//接诊时间


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public long getPatientId() {
    return patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }


  public String getDoctor() {
    return doctor;
  }

  public void setDoctor(String doctor) {
    this.doctor = doctor;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  public String getReceptionType() {
    return receptionType;
  }

  public void setReceptionType(String receptionType) {
    this.receptionType = receptionType;
  }


  public String getDiagnose() {
    return diagnose;
  }

  public void setDiagnose(String diagnose) {
    this.diagnose = diagnose;
  }


  public String getAdvice() {
    return advice;
  }

  public void setAdvice(String advice) {
    this.advice = advice;
  }


  public Date getCreation_time() {
    return creation_time;
  }

  public void setCreation_time(Date creation_time) {
    this.creation_time = creation_time;
  }

}
