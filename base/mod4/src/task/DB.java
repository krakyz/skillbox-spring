package task;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "mod4";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConnection = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConnection;
    }

    private ResultSet statementToCreate(String query) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();

        return statement.executeQuery(query);
    }

    public void insertToOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> usersIDs = new ArrayList<>();
        ArrayList<Integer> itemsIDs = new ArrayList<>();

        ResultSet userSelection = statementToCreate("SELECT * FROM users WHERE `login` = 'john'");

        while (userSelection.next()) {
            usersIDs.add(userSelection.getInt("id"));
        }

        ResultSet itemSelection = statementToCreate("SELECT * FROM items WHERE `category` = 'hats'");

        while (itemSelection.next()) {
            itemsIDs.add(itemSelection.getInt("id"));
        }


        if (usersIDs.size() < itemsIDs.size()) {
            for (int i = 1; i < itemsIDs.size(); i++) {
                usersIDs.add(usersIDs.get(usersIDs.size() - 1));
            }
        }

        for (int i = 0; i < itemsIDs.size(); i++) {
            int currentUserID = usersIDs.get(i);
            int currentItemID = itemsIDs.get(i);

            PreparedStatement prSt = getDbConnection().prepareStatement("INSERT INTO `orders` (user_id, item_id) VALUES (?, ?)");
            prSt.setInt(1, currentUserID);
            prSt.setInt(2, currentItemID);

            prSt.executeUpdate();
        }
    }

    public void getOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> usersInOrders = new ArrayList<>();
        ArrayList<Integer> itemsInOrders = new ArrayList<>();

        ResultSet orderSelection = statementToCreate("SELECT * FROM `orders`");

        while (orderSelection.next()) {
            usersInOrders.add(orderSelection.getInt("user_id"));
            itemsInOrders.add(orderSelection.getInt("item_id"));
        }

        System.out.println("Все заказы:\n");

        for (int i = 0; i < itemsInOrders.size(); i++) {
            PreparedStatement userStatement = getDbConnection().prepareStatement("SELECT login FROM `users` WHERE id = (?)");
            userStatement.setInt(1, usersInOrders.get(i));
            ResultSet resultUser = userStatement.executeQuery();

            while (resultUser.next()) {
                System.out.print(resultUser.getString("login") + " – ");
            }

            PreparedStatement itemStatement = getDbConnection().prepareStatement("SELECT title FROM `items` WHERE id = (?)");
            itemStatement.setInt(1, itemsInOrders.get(i));
            ResultSet resultItem = itemStatement.executeQuery();

            while (resultItem.next()) {
                System.out.println(resultItem.getString("title"));
            }

        }
    }
}
