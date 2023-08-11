package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         * Below is the custom security configuration
         */

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll()
        )
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
        return http.build();


        /**
         * Configuration to deny all the requests
         */
//        http.authorizeHttpRequests((authorize) -> authorize
//                .anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();

        /**
         * Configuration to allow all the requests
         */
//        http.authorizeHttpRequests((authorize) -> authorize
//                .anyRequest().permitAll());
//                return http.build();
    }
}
