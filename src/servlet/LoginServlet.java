package servlet;

import Entity.User;
import dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bing.zhao on 2017/6/7.
 */
@WebServlet(name = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init()初始化");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet destroy()销毁");
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名：" + username + ",密码：" + password);
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        UserDaoImpl dao = new UserDaoImpl();

        User user = new User();
        user.setPassword(password);
        user.setName(username);
        dao.addUser(user);
//        //返回html页面
//        response.getWriter().println("<html>");
//        response.getWriter().println("<head>");
//        response.getWriter().println("<title>登录信息</title>");
//        response.getWriter().println("</head>");
//        response.getWriter().println("<body algin=center>");
//        if(username != null && username.length()>0){
//            response.getWriter().println("欢迎【" + username + "】用户登录成功！！！");
//        }else{
//            response.getWriter().println("用户名不能为空");
//        }
//        response.getWriter().println("</body>");
//        response.getWriter().println("</html>");
        String jsonStr = "{\"msg\":\"ok\",\"code\":\"0\",\"name\":\""+username+"\",\"password\":\""+password+"\"}";
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
//        destroy();
    }
}
