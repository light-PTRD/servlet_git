package admin;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet",urlPatterns = "/userDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String id=req.getParameter("userid");
        //将这个id传给UserDao的一个方法 deleteUserById(String userId)
        UserDao userDao=new UserDao();
        int row=userDao.deleteUserById(id);
        if (row>0){
            //重定向
            resp.sendRedirect("/userSelectServlet");
        }else {
            //转发
            req.getRequestDispatcher("error.jsp").forward(req,resp);

        }




    }
}
