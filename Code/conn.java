package h.m.s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    Statement statement;

    public conn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=HMS;encrypt=true;trustServerCertificate=true;user=sqlUser;password=1234567"
            );

           // statement = connection.createStatement();
            System.out.println("✅ Connected to SQL Server!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
