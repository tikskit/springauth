package ru.vluzhnykh.authbasics.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        return new CustomAuthenticationProvider(passwordEncoder, userDetailsService);
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, AuthenticationProvider authenticationProvider,
                                         AuthenticationFailureHandler authenticationFailureHandler) {
        //http.httpBasic(Customizer.withDefaults());
        http.formLogin(
                c -> c.defaultSuccessUrl("/index")
                        .failureHandler(authenticationFailureHandler)
        );
        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests(
                c -> c
                        .requestMatchers("/failure").permitAll()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
}
