package com.logs.thirdPartyApi.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MDCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
        String requestId = requestWrapper.getHeader("RequestId");
        MDC.put("RequestId", requestId);

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setHeader("RequestId", requestId);
        filterChain.doFilter(requestWrapper, res);
    }
}
