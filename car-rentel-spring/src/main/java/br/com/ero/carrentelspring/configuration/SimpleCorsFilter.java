package br.com.ero.carrentelspring.configuration;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogRecord;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        Map<String, String> map = new HashMap<>();
        String originHeader = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(req, res);
        }
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .formLogin(form -> form.disable())
//                .httpBasic(basic -> basic.disable())
//                .authorizeHttpRequests( auth -> auth
//                        .requestMatchers(HttpMethod.POST, "/authenticate").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/admin/car", "/admin/cars", "/auth/login", "/auth/signup", "/customer/cars", "/customer/car").permitAll()
//                        .requestMatchers("/api/**").permitAll()
//                        .anyRequest().authenticated()
//                ).sessionManagement(
//                        session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                ).addFilterBefore(
//                        requestFilter, UsernamePasswordAuthenticationFilter.class
//                )
//                .build();
//    }

    @Override
    public void init(FilterConfig filterConfig) {

    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
