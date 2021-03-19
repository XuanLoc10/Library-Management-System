package com.dxc.webapp.configs;

import com.dxc.webapp.api.UserApi;
import com.dxc.webapp.model.UserDetail;
import com.dxc.webapp.model.UserLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserApi userApi;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		//shouldAuthenticateAgainstThirdPartySystem
		UserDetail userDetail = auth(name, password);
		if (userDetail != null) {
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			grantList.add(new SimpleGrantedAuthority("ROLE_" + userDetail.getRole()));
			return new UsernamePasswordAuthenticationToken(
					name, password, grantList);
		} else {
			return null;
		}
	}

	private UserDetail auth(String user, String pass) {
		UserLogin userData = new UserLogin(user, pass);
		String authResult = userApi.auth(userData);
		ObjectMapper mapper = new ObjectMapper();
		UserDetail userDetail = null;
		try {
			userDetail = mapper.readValue(authResult, UserDetail.class);
		} catch (IOException e) {
			throw new UsernameNotFoundException("User " + user + " was not found in the database", e);
		}
		return userDetail;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
