package sr.demo.microservices.configuration;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

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
				.regexMatchers("^/ratings\\?bookId.*$").authenticated()
					.antMatchers(POST,"/ratings").authenticated()
					.antMatchers(PUT,"/ratings/*").hasRole("ADMIN")
					.antMatchers(DELETE, "/ratings/*").hasRole("ADMIN")
					.antMatchers(GET,"/ratings").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
				.csrf().disable();
			
		}
}