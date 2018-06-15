package com.example.servicezuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Description zuul路由-过滤
 * Create By   Patrick Leee
 * CreateTime  2018/4/3 下午2:59
 * UpdateTime  2018/4/3 下午2:59
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    // pre：路由之前 routing:路由之时 post:路由之后
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 可以写逻辑判断，是否要过滤，为true表示永远过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token si empty");
            } catch (Exception e) {

            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
