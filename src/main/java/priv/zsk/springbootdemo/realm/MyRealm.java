package priv.zsk.springbootdemo.realm;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import priv.zsk.springbootdemo.entity.*;
import priv.zsk.springbootdemo.service.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 类描述：自定义myRealm
 *
 * @author zsk
 * @create 2017-10-27 17:10
 **/
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAndRoleService userAndRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleAndPermissionService roleAndPermissionService;

    @Autowired
    private PermissionService permissionService;




    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUserAccount = (String) super.getAvailablePrincipal(principals);
        List<String> roleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        //从数据库中查询用户的详细信息
        User user = userService.findUserByAccount(currentUserAccount);
        if(null != user){
            //通过用户账号查询用户id
            int userId = userService.findUserIdByAccount(currentUserAccount);
            //通过用户id查询用户角色id
            List<UserAndRole> roleIdList = userAndRoleService.findRoleIdByUserId(userId);
            //存放角色名信息
            List roleNameList = new ArrayList();
            if(null != roleIdList){
                for(UserAndRole userAndRole:roleIdList){
                    //获取角色id
                    int roleId = userAndRole.getRoleId();
                    //通过角色id查询角色信息
                    Role role = roleService.findRoleById(roleId);
                    roleList.add(role.getRoleCode());

                    //将角色信息放到session中，前端获取
                    roleNameList.add(role.getRoleName());

                    //通过角色id查询权限id信息
                    List<RoleAndPermission> roleAndPermissionList = roleAndPermissionService.findPermissionIdByRoleId(roleId);
                    for(RoleAndPermission roleAndPermission:roleAndPermissionList){
                        //获取权限ID
                        int permissionId = roleAndPermission.getPermissionId();
                        //通过权限id查询权限信息
                        Permission permission = permissionService.findPermissionById(permissionId);
                        permissionList.add(permission.getResourceCode());
                    }

                }
                //为当前用户设置角色和权限
                SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
                simpleAuthorInfo.addRoles(roleList);
                simpleAuthorInfo.addStringPermissions(permissionList);
                this.setSession("roleNameList",roleNameList);
                return simpleAuthorInfo;
            }
        }else {
            throw new AuthorizationException();
        }

        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }


    /**
     * 验证当前登录的Subject
     * 该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
            //获取基于用户名和密码的令牌
            //实际上这个authcToken是从adminController里面currentUser.login(token)传过来的
            //两个token的引用都是一样的
            UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
            String realmName = getName();
            String account = token.getUsername();
            User user = userService.findUserByAccount(account);
            if(null != user){
                String salt = user.getSalt();
                ByteSource passwordSalt = ByteSource.Util.bytes(salt);
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getUserPassword(),passwordSalt,realmName);
                this.setSession("currentUser", user);
                return authcInfo;
            }else{
                return null;
            }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
