package priv.zsk.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.zsk.springbootdemo.service.UserService;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 16:08
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findUserList")
  //  @ResponseBody
    public String findUserList(){
//        List<User> userList = userService.findUserList();
////        return userList.toString();
        return "test.html";
    }
}
