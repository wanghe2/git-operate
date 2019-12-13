

package bean;

import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import java.util.Properties;
/**
 * Created by 10412 on 2016/12/27.
 * JDBC的六大步骤
 * JAVA连接Oracle的三种方式
 */
public class JdbcTest
{
    public static void main(String[] args) {
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
           
            Driver driver = new OracleDriver();
            DriverManager.deregisterDriver(driver);


            //第二种方式：直接使用Driver
            Properties pro = new Properties();
            pro.put("user", "system");
            pro.put("password", "oracle");
            connect = driver.connect("jdbc:oracle:thin:@192.168.0.53:1521:orcl", pro);

            //测试connect正确与否
            System.out.println(connect);  

           
            
            stmt = connect.createStatement();
            // 创建statement对象
            rs = stmt.executeQuery("select * from test11 ");
            // 执行executeQuery()方法，用于产生单个结果集。
            while (rs.next()) {
               System.out.println(rs.getString("ID"));
             }
  
            
          
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
                try {
                    if (rs!=null) rs.close();
                    if (stmt!=null) stmt.close();
                    if (connect!=null) connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
