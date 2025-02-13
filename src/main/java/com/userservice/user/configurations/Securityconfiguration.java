//package com.userservice.user.configurations;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class Securityconfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) ->
//                        requests
//                                .anyRequest().permitAll())
//                         .cors((cors) -> cors.disable()) // Disable CORS
//                         .csrf((csrf) -> csrf.disable()); // Disable CSRF
//                         return http.build();}
//}