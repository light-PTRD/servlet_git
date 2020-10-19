package admin;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据id查询用户信息
 */
@WebServlet(name = "SelectUserByIdForUpdate",urlPatterns = "/selectUserByIdForUpdate")
public class SelectUserByIdForUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String id=req.getParameter("userid");
        //将这个参数传给UserDao的selectUserInfoById(String id)
        UserDao userDao=new UserDao();
        User user=userDao.selectUserInfoById(id);
        //将user对象绑定到HttpServletRequest对象  转发到用户信息修改页面
        req.setAttribute("user",user);
        req.getRequestDispatcher("resources/admin/userupdate.jsp").forward(req,resp);


    }
}
