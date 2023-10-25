package task;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void insertToOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Integer> usersIDs = new ArrayList<>();
        String usersSelection = "SELECT * FROM users WHERE `login` = 'john'";

        Statement usersStatement = getDbConnection().createStatement();
        ResultSet res = usersStatement.executeQuery(usersSelection);

        while (res.next()) {
            usersIDs.add(res.getInt("id"));
        }

        ArrayList<Integer> itemsIDs = new ArrayList<>();
        String itemsSelection = "SELECT * FROM items WHERE `category` = 'hats'";

        Statement itemsStatement = getDbConnection().createStatement();
        ResultSet res2 = itemsStatement.executeQuery(itemsSelection);

        while (res2.next()) {
            itemsIDs.add(res2.getInt("id"));
        }

        Object[] usersIDsList = usersIDs.toArray();
        Object[] itemsIDsList = itemsIDs.toArray();


        if (usersIDsList.length < itemsIDsList.length) {
            for (int i = 1; i < itemsIDsList.length; i++) {
                usersIDs.add((int) usersIDsList[usersIDsList.length - 1]);
            }
        }

        for (int i = 0; i < itemsIDsList.length; i++) {
            int currentUserID = (int) usersIDs.get(i);
            int currentItemID = (int) itemsIDs.get(i);

            String sql = "INSERT INTO `orders` (user_id, item_id) VALUES (?, ?)";

            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setInt(1, currentUserID);
            prSt.setInt(2, currentItemID);

            prSt.executeUpdate();
        }
    }

    public void getOrders() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `orders`";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<Integer> usersInOrders = new ArrayList<>();
        ArrayList<Integer> itemsInOrders = new ArrayList<>();

        while (res.next()) {
            usersInOrders.add(res.getInt("user_id"));
            itemsInOrders.add(res.getInt("item_id"));
        }

        System.out.println(usersInOrders);
        System.out.println(itemsInOrders);

        System.out.println("Все заказы:\n");

        for (int i = 0; i < itemsInOrders.size(); i++) {
            String usersQ = "SELECT login FROM `users` WHERE (?) IN id";

            PreparedStatement prStUser = getDbConnection().prepareStatement(usersQ);
            prStUser.setInt(1, usersInOrders.get(i));

            prStUser.executeUpdate();

        }
    }

//        int currentUserID = res.getInt("user_id");
//
//        String selectUsers = "SELECT login FROM `users` WHERE id = (?)";
//
//        PreparedStatement prStUser = getDbConnection().prepareStatement(selectUsers);
//        prStUser.setInt(1, currentUserID);
//
//        prStUser.executeUpdate();

//        Statement userStatement = getDbConnection().createStatement();
//        ResultSet userRes = userStatement.executeQuery(selectUsers);
//
//        int currentItemID = res.getInt("item_id");
//
//        String selectItem = "SELECT login FROM `items` WHERE id = (?)";
//
//        PreparedStatement prStItem = getDbConnection().prepareStatement(selectItem);
//        prStItem.setInt(1, currentItemID);
//
//        Statement itemStatement = getDbConnection().createStatement();
//        ResultSet itemRes = itemStatement.executeQuery(selectItem);
//
//        System.out.println(userRes.getString(1));
//        System.out.println(itemRes.getString(1));
}
