package connexionDB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * class return one instance
 */
public class SingletonDriverManger {
    /**
     * instance of class
     */
    private static SingletonDriverManger singletonDriverManger=null;

    private SingletonDriverManger() {
    }

    /**
     * statid function
     *
     * @return SingletonDriverManger
     */
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

    /**
     * function return
     * connection to database MYSQL
     * using DriverManager
     *
     * @return Connection
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Properties props=new Properties();
        Connection cnx=null;
        try (FileReader fis=new FileReader("config");) {
            props.load(fis);
            String db="jdbc:mysql://127.0.0.1:3306/TEST";
            //create objet Class containt all interfaces of programme
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            cnx=DriverManager.getConnection(db, props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cnx==null ? "Field to connect " : "Connection done !!");
        return cnx;
    }
}
