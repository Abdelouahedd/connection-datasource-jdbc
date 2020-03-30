package Test;

import connexionDB.SingletonDataSource;
import connexionDB.SingletonDriverManger;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            SingletonDriverManger.getInstance().getConnection();
            SingletonDataSource.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
