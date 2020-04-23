package cn.ali.data.servic.staff;

import cn.ali.data.pojo.Patient;
import cn.ali.data.pojo.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StaffService {
    List<Staff> findStaffByName(String name);

    Staff findStaffById(Integer id);
}
