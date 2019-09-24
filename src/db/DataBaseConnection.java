package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/4.
 */
public class DataBaseConnection {

    public static Connection getConnection(){
        Connection con = null;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名login
        String url = "jdbc:mysql://localhost:3306/xbingdb?serverTimezone=CTT&characterEncoding=utf-8&useSSL=false";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try
        {
            //加载驱动程序UserDaoImpl
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(con == null){
                System.out.println("连接数据库失败");
            }
        }
        catch(ClassNotFoundException e)
        {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            //数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally
        {
            System.out.println("数据库数据成功获取！！");
        }
        return con;
    }

}
