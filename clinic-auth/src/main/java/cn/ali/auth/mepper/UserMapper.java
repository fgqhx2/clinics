package cn.ali.auth.mepper;

import cn.ali.auth.pojo.Permission;
import cn.ali.auth.pojo.Role;
import cn.ali.auth.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findUserByUserName(String username);

    List<Role> findRoleByUserId(Integer id);

    List<Permission> findPermissionByRoleId(Integer id);

}
