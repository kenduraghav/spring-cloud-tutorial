package sr.demo.microservices.configuration;

import static org.springframework.http.HttpMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
		@Autowired
		public void configGlobalAll(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.httpBasic()
				.disable().authorizeRequests()
					.antMatchers(GET, "/books").permitAll()
					.antMatchers(GET,"/books/*").permitAll()
					.antMatchers(POST,"/books").hasRole("ADMIN")
					.antMatchers(PUT,"/books/*").hasRole("ADMIN")
					.antMatchers(DELETE, "/books/*").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
				.csrf().disable();
			
		}
}
