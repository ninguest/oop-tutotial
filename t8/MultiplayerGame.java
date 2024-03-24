import java.util.*;

// Superclass representing a player
class Player {
    protected String name;
    protected String character;

    public Player(String name) {
        this.name = name;
    }

    public void intro(){
        System.out.println("Hello, my name is " + name + " and I am playing " + character);
    }

    public void intro(Integer number){
        System.out.println("I'm Ready for "+ number + " rounds");
    }

    // Method to perform a basic attack
    public void attack() {
        System.out.println(name + " attacks with a basic attack.");
    }

    // Method to defend
    public void defend() {
        System.out.println(name + " defends.");
    }
}

// Subclass representing Elsa character
class Elsa extends Player {
    public Elsa(String name) {
        super(name);
        this.character = "Elsa";
    }

    // Override attack method for Elsa's special ability
    @Override
    public void attack() {
        System.out.println(name + " casts ice magic attack!");
    }
}

// Subclass representing Anna character
class Anna extends Player {
    public Anna(String name) {
        super(name);
        this.character = "Anna";
    }

    // Override attack method for Anna's special ability
    @Override
    public void attack() {
        System.out.println(name + " uses sword attack!");
    }
}

// Subclass representing Olaf character
class Olaf extends Player {
    public Olaf(String name) {
        super(name);
        this.character = "Olaf";
    }

    // No special ability for Olaf, so use the basic attack
}

// Subclass representing Kristoff character
class Kristoff extends Player {
    public Kristoff(String name) {
        super(name);
        this.character = "Kristoff";
    }

    // Override attack method for Kristoff's special ability
    @Override
    public void attack() {
        System.out.println(name + " throws a rock!");
    }
}

public class MultiplayerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of players
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        // Create an array to store players
        Player[] players = new Player[numPlayers];

        // Get player names and character selections
        for (int i = 0; i < numPlayers; i++) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            System.out.println("Choose character (Elsa, Anna, Olaf, Kristoff) for " + playerName + ": ");
            String character = scanner.nextLine();

            // Create player based on character selection
            switch (character.toLowerCase()) {
                case "elsa":
                    players[i] = new Elsa(playerName);
                    break;
                case "anna":
                    players[i] = new Anna(playerName);
                    break;
                case "olaf":
                    players[i] = new Olaf(playerName);
                    break;
                case "kristoff":
                    players[i] = new Kristoff(playerName);
                    break;
                default:
                    System.out.println("Invalid character selection. Defaulting to Elsa.");
                    players[i] = new Elsa(playerName);
            }
        }

        // Simulate gameplay
        for (Player player : players) {
            player.intro();
            player.intro(3); // Method overloading
            player.attack(); // Polymorphism, when there is '@Override' in subclass, it will use the subclass method (method overriding)
            player.defend();
        }

        scanner.close();
    }
}
