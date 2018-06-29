package priv.zsk.springbootdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.zsk.springbootdemo.entity.User;
import priv.zsk.springbootdemo.service.UserService;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 16:08
 */
@RequestMapping("/user")
@Controller
@Api(value="用户controller",tags={"用户操作接口"})
//@Api用于类；表示标识这个类是swagger的资源
//    tags–表示说明
//    value–也是说明，可以使用tags替代
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="展示用户信息", notes = "查询用户信息",tags={"获取用户信息copy"})
        //@ApiOperation() 用于方法；表示一个http请求的操作
        //value用于方法描述
        //notes用于提示内容
        //tags可以重新分组（将相同的tags值分为一组）

    @RequestMapping("findUserList")
    @ResponseBody
    public String findUserList(){
        List<User> userList = userService.findUserList();
        return userList.toString();
    }

    @ApiOperation(value = "修改用户信息",notes = "更新用户信息",tags={"获取用户信息copy"})
    @ApiParam(name = "id",value = "用户实体类",required = true)
    //@ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
    //name–参数名
    //value–参数说明
    //required–是否必填
    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(User user){
        try {
            userService.updateUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
}
