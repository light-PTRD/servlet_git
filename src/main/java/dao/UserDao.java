package dao;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //封装一个方法根据管理员的名字查询管理员的信息
    public User selectAdminInfo(String name){
        //获取数据库连接对象
        Connection conn = DBUtil.getConn();
        User user = null;

        String sql="select * from tb_user where user_name=?";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet r=ps.executeQuery();
            if(r.next()){
                //取出数据的每个字段值
                Integer id=r.getInt("ID");
                String userName=r.getString("USER_NAME");
                String pwd=r.getString("USER_PASSWORD");
                Integer userType=r.getInt("USER_TYPE");
                Integer userState=r.getInt("USER_STATE");
                //将取出的对象放到封装类中
                user=new User();
                user.setID(id);
                user.setUSER_NAME(userName);
                user.setUSER_PASSWORD(pwd);
                user.setUSER_STATE(userType);
                user.setUSER_STATE(userState);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;


    }

    //查询用户信息   currentPage 当前页数  pageSize 每页显示多少条
    public List<User> userSelect(String id ,int currentPage,int pageSize){
        List<User> list=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        String sql="";
        try {
        //偏移量
        int offset=(currentPage-1)*pageSize;

        if (id==null||id.equals("")){
            sql="select * from tb_user limit "+offset+" , "+pageSize;

        }else {
            sql="select * from tb_user where id="+ id +" limit "+offset+" , "+pageSize;

        }

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet r=ps.executeQuery();
        //遍历结果集
        while (r.next()){
            //取出数据的每个字段值
            Integer id1=r.getInt("ID");
            String userName=r.getString("USER_NAME");
            String pwd=r.getString("USER_PASSWORD");
            Integer userType=r.getInt("USER_TYPE");
            Integer userState=r.getInt("USER_STATE");
            //将取出的对象放到封装类中
            User user=new User();
            user.setID(id1);
            user.setUSER_NAME(userName);
            user.setUSER_PASSWORD(pwd);
            user.setUSER_STATE(userType);
            user.setUSER_STATE(userState);
            list.add(user);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;

    }

    //根据id查询用户信息
    public User selectUserInfoById(String id){
        //连接数据库
        Connection conn=DBUtil.getConn();
        User user=null;
        String sql="select * from tb_user where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ResultSet r=ps.executeQuery();
            if (r.next()){
                Integer id1 = r.getInt("ID");
                String userName = r.getString("USER_NAME");
                String pwd = r.getString("USER_PASSWORD");
                Integer userType = r.getInt("USER_TYPE");
                Integer userState = r.getInt("USER_STATE");
                //将取出的数据封装到对象
                user=new User();
                user.setID(id1);
                user.setUSER_NAME(userName);
                user.setUSER_PASSWORD(pwd);
                user.setUSER_STATE(userType);
                user.setUSER_STATE(userState);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;




    }

    //根据id删除用户信息
    public int deleteUserById(String id){
        Connection conn=DBUtil.getConn();
        int row=0;
        String sql="delete from tb_user where id=?";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,Integer.parseInt(id));
            //执行
            row=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;


    }

    //根据id修改用户信息
    public int updateUserInfoById(User user){
        Connection conn=DBUtil.getConn();
        int row=0;
        String sql="update tb_user set user_password=? where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUSER_PASSWORD());
            ps.setInt(2,user.getID());
            row=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }

    //获取数据库tb_user表数据条数
    public int getDataTotal(){
        int row=0;
        Connection conn = DBUtil.getConn();
        String sql="select * from tb_user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                row++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;

    }




}
