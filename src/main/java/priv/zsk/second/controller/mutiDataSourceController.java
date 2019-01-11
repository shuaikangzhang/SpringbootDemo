package priv.zsk.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.zsk.second.entity.UserAddressEntity;
import priv.zsk.second.service.UserAddressService;
import priv.zsk.springbootdemo.entity.User;
import priv.zsk.springbootdemo.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:22
 */
@RequestMapping("/mutiDataSource")
@RestController
public class mutiDataSourceController {
    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private UserService userService;

    @RequestMapping("mutiDataSourceCheck")
    public void mutiDataSourceCheck(){
        /*
        * 存放查询到的信息，用户名对应住址，一对多的关系
        * */
        Map<String,Object> map = new HashMap<>();
        /*
        * 首先从springbootdemo库中的user表查询出user的信息
        * 然后再从springbootdemotwo库中user_adress表中查询出地址信息
        * 实现多数据源的查询
        * */
        /*查询user信息*/
        List<User> userList = userService.findUserList();
        for(User user:userList){
            /*
            * 查询该user的住址信息
            * */
            List<UserAddressEntity> userAddressEntityList = userAddressService.findUserAddressList(user.getId());
            map.put(user.getUserName(),userAddressEntityList);

            System.out.printf("*******************************用户："+user.getUserName()+"的住址有：");
            for(UserAddressEntity userAddressEntity : userAddressEntityList){
                System.out.println(userAddressEntity.getAddress());
            }
        }
    }

}
