package org.example.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.MDC;

@Component
public class AccessLogFilter extends OncePerRequestFilter {

  private static final Logger log = LoggerFactory.getLogger("ACCESS_LOG");

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    long start = System.currentTimeMillis();
    filterChain.doFilter(request, response);
    long time = System.currentTimeMillis() - start;
    MDC.put("method", request.getMethod());
    MDC.put("uri", request.getRequestURI());
    MDC.put("status", String.valueOf(response.getStatus()));
    MDC.put("time_ms", String.valueOf(time));
    log.info("access log");
    MDC.clear();
  }
}
