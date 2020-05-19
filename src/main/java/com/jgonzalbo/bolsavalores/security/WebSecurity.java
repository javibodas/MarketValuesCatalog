package com.jgonzalbo.bolsavalores.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.jgonzalbo.bolsavalores.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private UserDetailsServiceImpl userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource datasource;
	
	public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			
			auth.jdbcAuthentication().dataSource(datasource)
			.usersByUsernameQuery("select user_name , password , status from table_user where user_name = ?")
			.authoritiesByUsernameQuery("select u.user_name , r.role from table_user2role ur " + 
										"inner join table_user u on u.objid = ur.user_objid " +
										"inner join table_role r on r.objid = ur.role_objid " +
										"where u.user_name = ?");
			
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
			
			// CORS AND CSRF DISABLED
			http.cors().and().csrf().disable()
			.authorizeRequests()
			// CLIENT SOURCES WITHOUT AUTHENTICATION
			.antMatchers("/dist/**").permitAll()
			// API ACCESS POINT DOESNT REQUIRE AUTHENTICATION
			.antMatchers("/", "/index","/index/**","/values/**", "/country", "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.antMatchers(HttpMethod.GET, "/user/encrypted/**").permitAll()
			// ANY OTHER ACCESS POINTS REQUIRES AUTHENTICATION
			.anyRequest().authenticated()
			//.anyRequest().permitAll()
			.and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            // this disables session creation on Spring Security
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }
}
