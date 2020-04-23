package cn.ali.data.mapepr.staff;

import cn.ali.data.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffMapper {

    List<Staff> findStaffByName(String name);

    Staff findStaffById(Integer id);

}
