package cn.ali.auth.service;

import cn.ali.auth.mepper.UserMapper;
import cn.ali.auth.pojo.Role;
import cn.ali.auth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserByUserName(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles= userMapper.findRoleByUserId(user.getId());

        for (Role role:roles) {
            role.setPermissions(userMapper.findPermissionByRoleId(role.getId()));
        }
        user.setRoles(roles);

        return user;
    }
}
