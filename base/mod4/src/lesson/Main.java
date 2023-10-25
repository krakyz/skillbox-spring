package lesson;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
//            db.createTable("users");
//            db.insertArticle("Самая новая статья", "Текст статьи", "2023", "Helper");
//            db.getArticles("articles");
            db.updateArticles();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
