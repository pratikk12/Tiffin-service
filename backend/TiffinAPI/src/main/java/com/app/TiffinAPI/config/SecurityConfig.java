////package com.app.TiffinAPI.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
////            .authorizeHttpRequests(auth -> auth
////                .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll() // Allow all requests under /api/users
////                .anyRequest().authenticated()
////            );
////
////        return http.build();
////    }
////}
//
//package com.app.TiffinAPI.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration  // Ensure the class is recognized as a configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())  // Disable CSRF for APIs
//            .authorizeHttpRequests(auth -> auth
//                // Allow unauthenticated access for auth and users endpoints
//                .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll()
////                .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/api/users/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/api/messowner/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/api/delivery/**")).permitAll()
//                .anyRequest().authenticated() // Other endpoints require authentication
//            );
//        return http.build();
//    }
//}
//

package com.app.TiffinAPI.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for APIs
            .cors(cors -> {})  // Enable CORS (important for frontend communication)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("/api/messowner/**").permitAll()
                .requestMatchers("/api/mess/**").permitAll()
                .requestMatchers("/api/delivery/**").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // API is stateless

        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173")); // Allow frontend
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

