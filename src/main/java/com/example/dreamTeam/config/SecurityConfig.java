package com.example.dreamTeam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http, CustomAuthenticationSuccessHandler successHandler) throws Exception {
        http.authorizeHttpRequests(auth -> auth
//                                .requestMatchers("/users/create").permitAll()
                        .requestMatchers("/home/**").hasAnyAuthority("USER")
                        .requestMatchers("/users/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/roles/**").hasAnyAuthority("ADMIN")
//                        .requestMatchers("//**").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.permitAll().successHandler(successHandler))
                .logout(logout -> logout.permitAll())
                .exceptionHandling(e -> e.accessDeniedHandler(new CustomAccesDeniedHandler()))
        ;

        return http.build();
    }
}
