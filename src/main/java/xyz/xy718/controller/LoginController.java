package xyz.xy718.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.xy718.model.User;
import xyz.xy718.service.UserService;
import xyz.xy718.util.JwtHelper;
import xyz.xy718.util.ResultBean;

@RestController
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	
	@PostMapping("/login")
    public ResultBean login(
    		@RequestBody User user
    		, HttpServletRequest request
    		, HttpServletResponse response
    		) {
		 Subject subject = SecurityUtils.getSubject();
	        try {
	            //将用户请求参数封装后，直接提交给Shiro处理
	            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
	            subject.login(token);
	            //Shiro认证通过后会将user信息放到subject内，生成token并返回
	            String username = (String) subject.getPrincipal();
	            User getUser=userService.getUserByUsername(username);
	            String newToken = JwtHelper.createJWT(getUser.getUsername());
	            response.setHeader("Authorization", newToken);
	            Map<String, Object> retData=new HashMap<String,Object>();
	            retData.put("jwt", newToken);
	            return ResultBean.success("登录成功",retData);
	        } catch (AuthenticationException e) { 
	           // 如果校验失败，shiro会抛出异常，返回客户端失败
	            logger.error("User {} login fail, Reason:{}", user.getUsername(), e.getMessage());
	            return ResultBean.error("登陆失败,用户名或密码错误");
	        } catch (Exception e) {
	            return ResultBean.error("500Exception:"+e.getMessage());
	        }
    }
	
    @GetMapping("/logout")
    public ResultBean logout(HttpSession session) {
    	session.invalidate();
        SecurityUtils.getSubject().logout();
        return ResultBean.success("登出成功");
    }
}
