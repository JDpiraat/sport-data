package be.johan40.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class CreateSecurityFilter extends WebSecurityConfigurerAdapter {
	
	private static final String  ADMINISTRATOR = "admin";
	private static final String SPORTSMEN = "sportsmen";
	
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
		.withUser("joe").password("theboss").authorities(ADMINISTRATOR)
		.and().withUser("averell").password("hungry")
		.authorities(SPORTSMEN, ADMINISTRATOR);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//TODO specifieke admin zaken nog te bekijken (sportsmen, track, session verwijderen?)
		http.formLogin()
		.and().authorizeRequests()
		.antMatchers("/tracks/new").hasAuthority(SPORTSMEN)
		.antMatchers(HttpMethod.POST, "/tracks").hasAuthority(SPORTSMEN) 
//		.antMatchers(HttpMethod.PUT, "/filialen/*").hasAuthority(SPORTSMEN)
//		.antMatchers(HttpMethod.DELETE, "/filialen/*").hasAuthority(ADMINISTRATOR)
		;
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/images/**")
		.antMatchers("/styles/**")
		;// not needed (yet?) .antMatchers("/scripts/**")
	}
	
}