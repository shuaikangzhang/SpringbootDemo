package priv.zsk.springbootdemo.controller;

import io.swagger.annotations.*;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id",dataType="int", paramType = "query"),
            @ApiImplicitParam(name="userName",value="用户名",dataType="User", paramType = "query",example="zsk",required = true),
            @ApiImplicitParam(name="account",value="用户账号",dataType="User", paramType = "query",example="zsk") })
    //@ApiImplicitParams({@ApiImplicitParam(name = "",value = "",dataType = "",paramType = "",example = "" )})
    //用于方法，包含多个 @ApiImplicitParam
    //name–参数ming
    //value–参数说明
    //dataType–数据类型，经过测试如果是实体类作为参数，可以写该实体类，也可以写该数据的类型，如：id为该数据类型，用户名和用户账号为实体类
    //paramType–参数类型
    //example–举例说明
    //required–是否必填
    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser( @ApiParam(name = "test",value = "zsk",required = true) String test, User user){
        //@ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
        //name–参数名
        //value–参数说明
        //required–是否必填
        //如果参数是实体类，未找到方法实现该注解。可以使用@ApiImplicitParams注解
        try {
            userService.updateUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
}