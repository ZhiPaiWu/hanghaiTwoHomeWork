package cn.crud.controller;

import cn.crud.pojo.ResponseObject;
import cn.crud.service.UserInfoService;
import cn.crud.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudController {

    //注入业务层
    @Autowired
    private UserInfoService service;
    /**
     * 显示所有
     * url:"http://localhost/user/findall"
     * @return List<UserInfo>
     */
    @GetMapping("findall") //或@GetMapping写法也行
    public List<UserInfo> findAll(){
        return service.findAll();
    }

   /**
     * 增加 restful 风格
     * url:"http://localhost/user/save"
     * 通过<form>表单模拟验证
     * @param userInfo
    * @return ResponseObject
     */
    @PostMapping
    public ResponseObject save(@RequestBody UserInfo userInfo) {
        System.out.println("新增成功"+userInfo);
        service.save(userInfo);
        return  new ResponseObject("新增成功","200",null);
    }
    /**
     * 修改 restful 风格
     * url:"http://localhost/user/update"
     * 验证：可以通过 jquery的 $.ajax方法，并type="put",同时注意data形式——A=a&B=b&C=c
     * @param userInfo
     * @return ResponseObject
     */
    @PutMapping
    public ResponseObject update(@RequestBody UserInfo userInfo) {
        System.out.println("修改成功"+userInfo);
        service.update(userInfo);
        return  new ResponseObject("修改成功","200",null);
    }
    /**
     * 删除 restful 风格
     * url:"http://localhost/user/delete"
     * 验证：可以通过 jquery的 $.ajax方法，并type="delete/"+id
     * @param id
     * @return ResponseObject
     */
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        service.deleteById(id);
        return  new ResponseObject("删除成功","200",null);
    }

}
