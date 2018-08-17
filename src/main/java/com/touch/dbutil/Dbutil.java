package com.touch.dbutil;

import com.touch.entity.Person;
import com.touch.servlet.Login;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Dbutil {
    static private String user;
    static private String password;
    static private String url;
    static private LinkedList<Connection> connections=new LinkedList<Connection>();
    static private int max_connect;
    static
    {
        try {
            InputStream inputStream=new FileInputStream(new File(Dbutil.class.getResource("/").getPath()+"db.properties"));
            Properties properties=new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver"));
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            url=properties.getProperty("url");
            max_connect=Integer.parseInt(properties.getProperty("max_connect"));
//          创建5个连接池
           for(int i=0;i<max_connect;i++){
               Connection connection=DriverManager.getConnection(url,user,password);
               connections.add(connection);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static <T> List<T> find(String sql,Class<T> object) {
        List list=new ArrayList();
        try {
            Connection connection=getconnection();
            PreparedStatement pre=connection.prepareStatement(sql);
            ResultSet resultSet= pre.executeQuery();
            ResultSetMetaData rsmd=resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (resultSet.next()){
                Object j=object.newInstance();
                for (int i=0;i<columnCount;i++){
//                    获取字段名
                    String clname=rsmd.getColumnName(i+1);
                    Object col=resultSet.getObject(clname);
//                    根据字段名找到对应的set方法
                    Method mothod=object.getMethod("set"+clname,new Class[]{col.getClass()});
//                    获取该列字段下的object

                    mothod.invoke(j,col);
                }
                list.add(j);

            }
            close(connection,pre,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }
        return  list;
    }

    public static void close(Connection connection, PreparedStatement pre, ResultSet resultSet) {
        try {
            resultSet.close();
            pre.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    public static Object findone(String sql, String name, String password) {
//        Connection connection= null;
//        try {
//            connection = DriverManager.getConnection(url,user,password);
//            PreparedStatement pre=connection.prepareStatement(sql);
//            ResultSet resultSet= pre.executeQuery();
//            ResultSetMetaData rsmd=resultSet.getMetaData();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    获取连接
    public static Connection getconnection(){
        if(connections.size()!=0) {
            final Connection connection = connections.removeFirst();
            Connection cns=(Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(), connection.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("close")){
                        connections.add(connection);
                        System.out.println("i am ok");
                        return null;
                    }
                    return method.invoke(connection,args);
                }
            });
            return cns;
        }
        else {
            return null;
        }
    }
//    关闭连接

}
