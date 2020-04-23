package cn.ali.auth.service;

import cn.ali.auth.pojo.User;

public interface UserService {

    User findUserByUserName(String username);

}
