package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhaobing04 on 2019/9/24.
 */
public class LogFilter implements Filter {
    private static String logFilter = "";

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        logFilter = config.getInitParameter("log");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 输出站点名称
        System.out.println("站点网址：localhost:8080:" + logFilter);
        // 把请求传回过滤链
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
