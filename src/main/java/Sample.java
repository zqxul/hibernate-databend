package databend_cloud;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class Sample {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:databend://tn3ftqihs--xsmall-8cg3.gw.aws-us-east-2.default.databend.com:443/book_db?ssl=true";
        Properties properties = new Properties();
        properties.setProperty("user", "cloudapp");
        properties.setProperty("password", "75wwsz0izzf4");
        properties.setProperty("SSL", "true");
        Connection connection = DriverManager.getConnection(url, properties);

        Statement statement = connection.createStatement();
        statement.execute("SELECT 1, 2;");
        ResultSet r = statement.getResultSet();
        r.next();
        System.out.println(r.getInt(1));
    }
}
