package com.cwz.controller;

import com.cwz.pojo.ResponseObject;
import com.cwz.pojo.UserInfo;
import com.cwz.serivce.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: springboot-team7-chengweizhao
 * @Package: com.cwz.controller
 * @ClassName: UserInfoController
 * @Author: 程伟钊
 * @Description: controller层
 * @Date: 2020/1/1 22:32
 */

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    //删除用户
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseObject("删除成功","200",null);
    }

    //修改用户
    @PutMapping
    public ResponseObject update(@RequestBody UserInfo userInfo){
        System.out.println("更新用户："+userInfo);
        service.save(userInfo);
        return new ResponseObject("更新成功","200",null);
    }

    //新增用户
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo){
        System.out.println("新增用户："+userInfo);
        service.save(userInfo);
        return new ResponseObject("新增成功","200",null);
    }

    //查询所有用户
    @GetMapping
    public List<UserInfo> query(){
        return service.findAll();
    }
}
