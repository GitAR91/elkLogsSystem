package com.elkSystem.elkLogSystem.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class MdcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestId = getCorrelationId();
        MDC.put("RequestId", requestId);
        HttpServletRequest req = (HttpServletRequest) request;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
        requestWrapper.addHeader("RequestId", requestId);

        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("RequestId", requestId);

        chain.doFilter(requestWrapper, res);
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
