package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseUtils {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(DataBaseUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
            Class.forName(properties.getProperty("jdbc.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
