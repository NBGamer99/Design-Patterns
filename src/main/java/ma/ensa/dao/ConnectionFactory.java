package ma.ensa.dao;

public class ConnectionFactory {
    public static IConnection createConnection() {
        return new MySqlConnection();
    }

}
