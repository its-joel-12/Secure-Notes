package com.secure.notes.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CsrfLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String method = request.getMethod();

        if ("POST".equalsIgnoreCase(method) || 
            "PUT".equalsIgnoreCase(method) || 
            "DELETE".equalsIgnoreCase(method)) {

            CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
            String headerToken = request.getHeader("X-XSRF-TOKEN");

            logger.info("==== CSRF Debug ====");
            logger.info("Session CSRF Token : " + (csrfToken != null ? csrfToken.getToken() : "null"));
            logger.info("Header X-XSRF-TOKEN: " + headerToken);
            logger.info("====================");
        }

        filterChain.doFilter(request, response);
    }
}
