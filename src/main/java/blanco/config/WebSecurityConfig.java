package blanco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/main");
		
        http.securityMatcher(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                .headers(headers -> headers.frameOptions(
                         frame -> frame.sameOrigin()))
            .securityMatcher(mvcMatcherBuilder.pattern("/main"))
            	.authorizeHttpRequests(authrization -> authrization
            			.requestMatchers(mvcMatcherBuilder.pattern("/main")).permitAll())
            .securityMatcher("/**")
            	.formLogin(Customizer.withDefaults())
            	.csrf(Customizer.withDefaults())
            	.headers(Customizer.withDefaults())
            	.authorizeHttpRequests(authz -> authz.anyRequest().authenticated());
		
		return http.build();
	}
}