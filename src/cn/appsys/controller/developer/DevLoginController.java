package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value = "/dev")
public class DevLoginController {
	private Logger logger = Logger.getLogger(DevLoginController.class);

	@Resource
	private DevUserService devUserService;

	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem develpor==================");
		return "devlogin";
	}
	
	/**
	 * 登录
	 * @param devCode
	 * @param devPassword
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public String doLogin(@RequestParam String devCode, @RequestParam String devPassword, HttpServletRequest request,
			HttpSession session) {
		logger.debug("doLogin====================================");
		DevUser devUser = null;
		try {
			devUser = devUserService.login(devCode, devPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 登录成功
		if (devUser != null) {
			session.setAttribute(Constants.DEV_USER_SESSION, devUser);
			return "redirect:/dev/flatform/main";
		} else {
			// 页面跳转(login.jsp)带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "devlogin";
		}
	}

	@RequestMapping(value = "/flatform/main")
	public String main(HttpSession session) {
		if (session.getAttribute(Constants.DEV_USER_SESSION) == null) {
			return "redirect:/dev/login";
		}
		return "developer/main";
	}
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除session
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
}
