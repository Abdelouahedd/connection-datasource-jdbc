package connexionDB;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * class return one instance
 */
public class SingletonDataSource {
    /**
     * instance of class
     */
    private static SingletonDataSource singletonDataSource=null;

    private SingletonDataSource() {
    }

    /**
     * statid function
     *
     * @return singletonDataSource
     */
    public static SingletonDataSource getInstance() {
        if (singletonDataSource==null) {
            synchronized(SingletonDataSource.class) {
                if (singletonDataSource==null) {
                    singletonDataSource=new SingletonDataSource();
                }
            }
        }
        return singletonDataSource;
    }

    /**
     * function return
     * connection to database MYSQL
     * using Interface DataSource
     *
     * @return Connection
     */
    public Connection getConnection() throws SQLException {
        Properties props=new Properties();
        MysqlDataSource mysqlDS=null;
        try (FileInputStream fis=new FileInputStream("config")) {
            //config file that contain a information about url,user,password of db
            props.load(fis);
            mysqlDS=new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("DB_URL"));
            mysqlDS.setUser(props.getProperty("DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mysqlDS!=null ? "done datasource connected" : "ERROR-->");
        return mysqlDS.getConnection();
    }
}
