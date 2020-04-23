package cn.ali.data.servic.staff;

import cn.ali.data.mapepr.staff.StaffMapper;
import cn.ali.data.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    StaffMapper staffMapper;

    @Override
    public List<Staff> findStaffByName(String name) {
        return staffMapper.findStaffByName(name);
    }

    @Override
    public Staff findStaffById(Integer id) {
        return staffMapper.findStaffById(id);
    }
}
