package priv.zsk.springbootdemo.controller;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	/*跳转到登录页面*/
	@RequestMapping("findLoginView")
	public String findLoginView(){
		System.out.println("hello world");
		return "/login.html";
	}


	/*实现登录功能*/
	@RequestMapping("login")
	@ResponseBody
	public String login(String account,String userPassword,HttpServletRequest request){
		System.out.println("sdfsafsdafasdfasdf");
		String loginFlag = "false";
		UsernamePasswordToken token = new UsernamePasswordToken(account, userPassword);
		//   token.setRememberMe(true);
		System.out.println("controller:::::为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		//获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			//每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证开始");
			currentUser.login(token);
			loginFlag = "success";
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证通过");
		}catch(UnknownAccountException uae){
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证未通过,未知账户");
			request.setAttribute("message_login", "未知账户");
		}catch(IncorrectCredentialsException ice){
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证未通过,错误的凭证");
			request.setAttribute("message_login", "密码不正确");
		}catch(LockedAccountException lae){
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证未通过,账户已锁定");
			request.setAttribute("message_login", "账户已锁定");
		}catch(ExcessiveAttemptsException eae){
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证未通过,错误次数过多");
			request.setAttribute("message_login", "用户名或密码错误次数过多");
		}catch(AuthenticationException ae){
			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			System.out.println("controller:::::对用户[" + account + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			request.setAttribute("message_login", "用户名或密码不正确");
		}
		//验证是否登录成功
		if(currentUser.isAuthenticated()){
			System.out.println("controller:::::用户[" + account + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
		}else{
			token.clear();
		}
		return loginFlag;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}

}
