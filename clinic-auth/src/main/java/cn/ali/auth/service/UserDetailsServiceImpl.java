package cn.ali.auth.service;

import cn.ali.auth.pojo.Permission;
import cn.ali.auth.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.ali.auth.pojo.User user=userService.findUserByUserName(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role:user.getRoles()) {
            for (Permission permission:role.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
        }
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
