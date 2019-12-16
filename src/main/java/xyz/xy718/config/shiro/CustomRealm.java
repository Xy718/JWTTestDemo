package xyz.xy718.config.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.xy718.model.Operator;
import xyz.xy718.model.Role;
import xyz.xy718.model.User;
import xyz.xy718.model.UserRole;
import xyz.xy718.service.OperatorService;
import xyz.xy718.service.RoleService;
import xyz.xy718.service.UserService;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OperatorService operatorService;
    
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        User user = (User) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库用户的角色和权限
        List<UserRole> userRoles= userService.getUserRoles(user.getUser_id());
        
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        userRoles.forEach(item -> {
        	//添加角色
        	simpleAuthorizationInfo.addRole(
        			roleService.getByID(item.getRole_id()).get().getRole_name()
        			);
        	//添加该角色的权限
        	operatorService.getOpersByRoleID(item.getRole_id()).forEach(perm->{
        		simpleAuthorizationInfo.addStringPermission(perm.getPerms());
        	});
        });
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        User user = (User) authenticationToken.getPrincipal();
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}