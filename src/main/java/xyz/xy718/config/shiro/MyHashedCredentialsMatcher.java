package xyz.xy718.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * MD5 密码匹配器
 *
 */
public class MyHashedCredentialsMatcher extends
		HashedCredentialsMatcher {

	public MyHashedCredentialsMatcher(String hashAlgorithmName) {
		super(hashAlgorithmName);
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		boolean matches = super.doCredentialsMatch(token, info);
		return matches;
	}

}