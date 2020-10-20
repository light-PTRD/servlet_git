package admin;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 根据userid或者无条件查询用户表
 */
@WebServlet(name = "UserSelectServlet",urlPatterns = "/userSelectServlet")
public class UserSelectServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String userId=req.getParameter("userid");
        String currentPage1=req.getParameter("currentPage1");


        //将这个参数传给UserDao的userSelect(String userid)
        UserDao userDao=new UserDao();

        //获取数据库tb_user的数据条数
        int totals=userDao.getDataTotal();//得到所有数据的条数
        //一页显示5条数据
        int pageSize=5;
        //算出有多少页
        int page = totals%pageSize !=0 ? totals/pageSize+1:totals/pageSize;
        //设计当前页 currentPage=1;
        int currentPage=1;
        currentPage= Integer.parseInt(currentPage1);

        if (currentPage>page){
            currentPage=page;
        }
        if (currentPage<1){
            currentPage=1;
        }




        List<User> list=userDao.userSelect(userId,currentPage,pageSize);
        System.out.println(list.toString());
        //将数据绑定到userlist.jsp页面
        req.setAttribute("list",list);
        //将当前页绑定到页面  作为一个参数值传进服务器端
        req.setAttribute("currentPage",1);
        //将page绑定到HttpServletRequest 将页数显示到页面
        req.setAttribute("page",page);
        req.getRequestDispatcher("resources/admin/userlist.jsp").forward(req,resp);

    }
}
