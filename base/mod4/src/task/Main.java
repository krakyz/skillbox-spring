package task;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB database = new DB();

        try {
//            database.insertToOrders();
            database.getOrders();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
