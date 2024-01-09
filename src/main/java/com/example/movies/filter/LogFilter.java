package com.example.movies.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.logging.LogRecord;
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(req,res);
        String reqUri = req.getRequestURI();
        String reqBody = new String(req.getContentAsByteArray());
        log.info("req uri : {},req body : {}",reqUri,reqBody);
        String resBody = new String(res.getContentAsByteArray());
        res.copyBodyToResponse();
        log.info("res body : {}",resBody);
    }
}
