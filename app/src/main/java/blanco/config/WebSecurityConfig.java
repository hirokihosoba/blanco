package blanco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/main");
		
        http
            .securityMatcher(mvcMatcherBuilder.pattern("/main"))
                .authorizeHttpRequests(authrization -> authrization
                    .requestMatchers(mvcMatcherBuilder.pattern("/main"))
                    .permitAll())
            .formLogin(login -> login
                .loginPage("/sign/in")
                .permitAll()
                .defaultSuccessUrl("/article", false)
                .failureUrl("/sign/in?error"))
            .logout(logout -> logout
                .logoutUrl("/sign/out")
                .logoutSuccessUrl("/main"))
            .securityMatcher("/**")
                .csrf(Customizer.withDefaults())
                .headers(Customizer.withDefaults())
                .authorizeHttpRequests(authz -> authz.anyRequest().authenticated());
		
		return http.build();
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
}
