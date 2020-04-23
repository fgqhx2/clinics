package cn.ali.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApiController {

    @GetMapping("api/user")
    public Map user() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("url", "api");
        return map;
    }
    @GetMapping("list/user")
    public Map list() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("url", "list");
        return map;
    }

}
