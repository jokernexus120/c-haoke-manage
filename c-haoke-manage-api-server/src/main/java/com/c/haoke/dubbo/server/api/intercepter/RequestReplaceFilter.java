package com.c.haoke.dubbo.server.api.intercepter;

import javassist.expr.Instanceof;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestReplaceFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!(request instanceof MyServletRequestWrapper))
        {
            try {
                request = new MyServletRequestWrapper(request);
                System.out.println("变成MyServletRequestWrapper");
            }catch (Exception e){

            }

        }
        doFilter(request,response,filterChain);

    }
}
