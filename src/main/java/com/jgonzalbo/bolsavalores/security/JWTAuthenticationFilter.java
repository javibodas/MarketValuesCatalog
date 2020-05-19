package com.jgonzalbo.bolsavalores.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.jgonzalbo.bolsavalores.security.SecurityConstants.SECRET;
import static com.jgonzalbo.bolsavalores.security.SecurityConstants.EXPIRATION_TIME;
import static com.jgonzalbo.bolsavalores.security.SecurityConstants.TOKEN_PREFIX;
import static com.jgonzalbo.bolsavalores.security.SecurityConstants.HEADER_STRING;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgonzalbo.bolsavalores.models.users.ApplicationUser;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
        	ApplicationUser creds = new ObjectMapper()
                    .readValue(req.getInputStream(), ApplicationUser.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	 @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {

	        String token = JWT.create()
	                .withSubject(((User) auth.getPrincipal()).getUsername())
	                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	                .sign(HMAC512(SECRET.getBytes()));
	        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	    }

}
