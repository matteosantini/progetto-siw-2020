package it.uniroma3.progetto2020.authentication;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class AuthConfig extends WebSecurityEnablerConfiguration{
	
	@Autowired
	DataSource datasource;
	
	

}
