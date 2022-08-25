package com.elkSystem.elkLogSystem.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class MdcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestId = getCorrelationId();
        MDC.put("CorrelationId", requestId);
        HttpServletRequest req = (HttpServletRequest) request;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
        requestWrapper.addHeader("CorrelationId", requestId);
        chain.doFilter(requestWrapper, response);
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
