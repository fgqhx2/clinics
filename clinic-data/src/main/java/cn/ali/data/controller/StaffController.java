package cn.ali.data.controller;

import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.data.mapepr.staff.StaffMapper;
import cn.ali.data.pojo.Patient;
import cn.ali.data.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    StaffMapper staffMapper;


    @GetMapping("/byName")
    public ResponseResult byName(String name) {
        List<Staff> staffs= staffMapper.findStaffByName(name);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(staffs);
    }


    @GetMapping("/byId")
    public ResponseResult byId(Integer id) {
        Staff staff= staffMapper.findStaffById(id);
        return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(staff);
    }




}
