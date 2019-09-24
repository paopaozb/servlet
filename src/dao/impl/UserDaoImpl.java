package dao.impl;

import Entity.User;
import dao.UserDao;
import db.DataBaseConnection;

import java.sql.*;
import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */
public class UserDaoImpl implements UserDao {
    private Connection mConnection = null;
    private Statement mStatement = null;
    private ResultSet mResultSet = null;
    // 开启事务标志
    private boolean mAutoCommit = true;

    public UserDaoImpl(){
        init();
    }

    /**
     * 核心方法，获取数据库连接
     */
    private void init() {
        try {
            mConnection = DataBaseConnection.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 核心方法：释放资源
     */
    private void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 核心方法：为PreparedStatement设置参数
     *
     * @param pstmt
     *            PreparedStatement
     * @param params
     *            参数
     */
    private void setParams(PreparedStatement pstmt, Object... params) {
        try {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean addUser(User user) {
        boolean ret = false;
        String sql = "INSERT INTO t_user(name, password) VALUES ('"+user.getName()+"', '"+user.getPassword()+"');";
        try{
            if(mConnection != null){
                mStatement = mConnection.createStatement();
                mStatement.execute(sql);
            }else{
                System.out.println("connect failed ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(mResultSet,mStatement,mConnection);
        return ret;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> getUserList() {
        return null;
    }
}
