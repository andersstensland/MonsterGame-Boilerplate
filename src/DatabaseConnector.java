import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private static final String PROPERTIES_FILE = "application.properties";
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConnector() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            props.load(input);
            this.url = props.getProperty("db.url");
            this.username = props.getProperty("db.username");
            this.password = props.getProperty("db.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}