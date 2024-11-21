package br.com.fiap.EcoSynergy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.fiap.EcoSynergy.Security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final CustomUserDetailsService service;
	
    public SecurityConfig(CustomUserDetailsService service) {
        this.service = service;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return service;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/cadastro", "/login/cadastrar", "/login/entrar", "/api/**", "/css/**", "/js/**", "/images/**", "/webjars/**", "/h2-console/**").permitAll()
                .requestMatchers("/local", "/local/**").hasRole("USER")
                .anyRequest().authenticated()
            )
            .csrf().disable() 
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll() 
                .defaultSuccessUrl("/", true)
                .failureUrl("/login") 
            )
            .headers().frameOptions().sameOrigin() ;; // para h2

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
