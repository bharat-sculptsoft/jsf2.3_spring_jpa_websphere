package com.ss.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ss.model.LoginModel;
import com.ss.service.LoginService;


@Named
@RequestScoped
public class LoginBean extends SpringBeanAutowiringSupport implements Serializable {

	private String password;
	private String email;

	@Autowired
	private LoginService loginService;

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String saveDetails() {		
		return loginService.save(new LoginModel(email, password));
		
	}
	
}
