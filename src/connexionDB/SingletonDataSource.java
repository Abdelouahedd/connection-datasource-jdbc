package connexionDB;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SingletonDataSource {
    private static SingletonDataSource singletonDataSource=null;

    private SingletonDataSource() {
    }

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

    public DataSource getConnection() {
        Properties props=new Properties();
        FileInputStream fis=null;
        MysqlDataSource mysqlDS=null;
        try {
            fis=new FileInputStream("config");
            props.load(fis);
            mysqlDS=new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mysqlDS!=null ? "done datasource connected" : "ERROR-->");
        return mysqlDS;
    }
}
