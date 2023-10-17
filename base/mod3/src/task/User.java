package task;

import java.io.Serializable;

public class User implements Serializable {
    private String username, nickname;
    private byte age;
    private String[] hobbies;

    public User(String username, String nickname, byte age, String[] hobbies) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
        this.hobbies = hobbies;

    }

    public String toString() {
        return "Пользователь: " + username
                + " с логином: " + nickname
                + ". Его возраст: " + age
                + ". Все хобби: \n" + String.join("\n", hobbies).replaceAll(" ", "");
    }


}
