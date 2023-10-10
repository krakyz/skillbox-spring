import java.util.Random;

public class Player {
    private String name;
    private VARIANTS choice;

    public Player() {
        this.name = "Bot";
        this.choice = getRandomChoice();
    }

    public Player(VARIANTS choice, String name) {
        this.name = name;
        this.choice = choice;
    }

    private VARIANTS getRandomChoice() {
        Random random = new Random();
        return VARIANTS.values()[random.nextInt(VARIANTS.values().length)];
    }
    
    public String whoWins(Player player1, Player player2) {
        if (player1.choice == player2.choice) {
            return "Ничья";
        } else if (
                (player1.choice == VARIANTS.ROCK && player2.choice == VARIANTS.SCISSORS) ||
                        (player1.choice == VARIANTS.PAPER && player2.choice == VARIANTS.ROCK) ||
                        (player1.choice == VARIANTS.SCISSORS && player2.choice == VARIANTS.PAPER)
        ) {
            return player1.name + " победил!";
        } else {
            return player2.name + " победил!";
        }
    }
}
