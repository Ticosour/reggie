package com.gdtico.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdtico.common.BaseContext;
import com.gdtico.common.R;
import com.gdtico.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER= new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        log.info(requestURI);
        String[] urls  = new String[]{
          "/employee/login",
          "/employee/logout",
          "/backend/**",
          "/front/**",
          "/common/**",
          "/user/sendMsg",
                "/user/login"
        };
        boolean check = check(urls, requestURI);
        if (check){
            filterChain.doFilter(servletRequest,servletResponse);
            log.info("第一次放行");
            return;
        }
        if (request.getSession().getAttribute("empId")!=null){
            Long empId = (Long) request.getSession().getAttribute("empId");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(servletRequest,servletResponse);
            log.info("第二次放行");
            return;
        }
        if (request.getSession().getAttribute("user")!=null){
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(servletRequest,servletResponse);
            log.info("第三次放行");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(servletResponse.getWriter(),R.error("NOTLOGIN"));
        log.info("被拦截");
    }

    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                return true;
            }
        }
        return false;
    }



}
