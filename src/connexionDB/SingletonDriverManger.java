package connexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDriverManger {
    private static SingletonDriverManger singletonDriverManger=null;

    private SingletonDriverManger() {
    }

    public static SingletonDriverManger getInstance() {
        if (singletonDriverManger==null) {
            synchronized(SingletonDriverManger.class) {
                if (singletonDriverManger==null) {
                    singletonDriverManger=new SingletonDriverManger();
                }
            }
        }
        return singletonDriverManger;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String pilot="com.mysql.cj.jdbc.Driver";
        String db="jdbc:mysql://127.0.0.1:3306/TEST";
        Class.forName(pilot);
        Connection cnx=DriverManager.getConnection(db, "root", "@@@Abdelouahed19");
        System.out.println(cnx==null ? "Field to connect " : "Connection done !!");
        return cnx;
    }
}
