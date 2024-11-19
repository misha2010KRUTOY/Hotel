package com.hotelbooking.touroperatorservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Извлекаем токен из заголовка Authorization
        String token = extractJwtFromRequest(request);
        String username = null;

        if (token != null && jwtTokenUtil.validateToken(token)) {
            username = jwtTokenUtil.getUsernameFromToken(token);
        }

        // Если имя пользователя найдено и оно не пустое, то устанавливаем аутентификацию в SecurityContext
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);

            // Если пользователь найден и токен действителен, устанавливаем аутентификацию
            if (jwtTokenUtil.validateToken(token, userDetails)) {
                JwtAuthenticationToken authentication = new JwtAuthenticationToken(
                        userDetails.getAuthorities(), userDetails, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Устанавливаем аутентификацию в контекст безопасности
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // Продолжаем цепочку фильтров
        chain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        // Извлекаем токен из заголовка Authorization (формат: "Bearer <token>")
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
