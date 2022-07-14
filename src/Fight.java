import java.util.Scanner;

public class Fight {
    public static int randomBetween(int min, int max) {
        return min + (int)(Math.random() * (max - min));
    }

    public static void main(String[] args) {
        Player player = new Player(80);
        Player bot = new Player(80);

        boolean isPlayerTurn = true; //or botTurn

        System.out.println("Hello!!! Welcome to Fight battle. Try to beat BOT!");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("-------------------------");
            if (isPlayerTurn) {
                System.out.println("Please select your hit to the bot");
                System.out.println("1. In head. 2. In chest. 3. In leg");
                int decision = scanner.nextInt();
                int damage = player.hit(decision);
                bot.takeDamage(damage);
                //todo add BodyPartBlock
                System.out.println("Your damage is " + damage + " Bot HP is " + bot.getHp());
                isPlayerTurn = !isPlayerTurn;
            }

            if (!isPlayerTurn) {
                System.out.println("Now bot will hit");
                int bodyPart = randomBetween(1,3);
                int damage = bot.hit(bodyPart);
                player.takeDamage(damage);
                //todo add BodyPartBlock
                System.out.println("Bot damage is " + damage + " Player HP is " + player.getHp());
                isPlayerTurn = !isPlayerTurn;
            }

        } while (bot.isAlive() && player.isAlive());

        if (bot.isAlive()) {
            System.out.println("YOU loose, BOT WINS!");
        }
        if (player.isAlive()) {
            System.out.println("YOU WIN!");
        }
    }
}
