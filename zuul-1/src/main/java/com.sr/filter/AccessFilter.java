package com.sr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/28.
 */
public class AccessFilter extends ZuulFilter {

    /**
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        System.out.println(1);
        return "pre";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序
     * 可以有多个过滤器
     */
    @Override
    public int filterOrder() {
        System.out.println(2);
        return 0;
    }

    /**
     * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，
     * 所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
     */
    @Override
    public boolean shouldFilter() {
        System.out.println(3);
        return true;
    }

    /**
     * run：过滤器的具体逻辑
     */
    @Override
    public Object run() {
        System.out.println(4);
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(request.getRequestURL());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {//如果没有accessToken参数则过滤该请求
            System.out.println("access token is empty");
            ctx.setSendZuulResponse(false);//令zuul过滤该请求
            ctx.setResponseStatusCode(401);//返回错误码
            return null;
        }
        System.out.println("access token ok");
        return null;
    }
}
