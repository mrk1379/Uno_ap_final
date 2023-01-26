package com.company.design;

import com.company.gameServices.Game;
import com.company.gameServices.Player;
import com.company.cards.Card;
import com.company.enums.Color;

/**
 * ui class
 * contain design patterns and messages
 *
 * @author Mohammad Reza Karimi
 */
public class UI {
    private static UI INSTANCE = null;

    public static UI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UI();
        return INSTANCE;
    }

    public void welcome() {
        System.out.println("The number of players can be 3, 4 or 5.");
        System.out.println();
    }

    public void askForGameMode() {
        System.out.println("single-player mode or multiplayer type the wanted mode?");
        System.out.println("single-player: 1");
        System.out.println("multi-player: 2");
    }

    public void askForNumberOfPlayers() {
        System.out.println("type number of players in game game.");
    }

    public void nameMessage(int index) {
        System.out.println("Player n." + index + ", please enter your name:");
    }

    public void nameMessage() {
        System.out.println("Enter your name:");
    }

    public void displayPlayers(Game game) {

        if (game.getDirection() == Game.Direction.CLOCKWISE)
            System.out.println("\u2193");
        else
            System.out.println("\u2191");

        for (Player player : game.getPlayers()) {
            if (game.getPlayerOnTurn().equals(player))
                System.out.print("* ");
            System.out.println(player.getName() + " with " + player.getCards().size() + " cards");
        }
        System.out.println();
    }

    public void displayCard(Card card) {
        String displayColor = switch (card.getColor()) {
            case RED -> ConsoleColors.RED;
            case BLUE -> ConsoleColors.BLUE;
            case GREEN -> ConsoleColors.GREEN;
            case BLACK -> ConsoleColors.WHITE;
            case Yellow -> ConsoleColors.YELLOW;
        };

        System.out.println(ConsoleColors.WHITE_BACKGROUND + displayColor + "\u250D\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2511");
        System.out.println("\u2502       \u2502");

        if (!card.getSign().equals("10"))
            System.out.println("\u2502  " +" "  + card.getSign() +" "  + "  \u2502");
        else
            System.out.println("\u2502 "+" " + card.getSign() +" "  + "  \u2502");

        System.out.println("\u2502       \u2502");
        System.out.println("\u2515\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2519" + ConsoleColors.RESET);

    }

    public void displayPlayerCard(Player player) {
        for (Card card : player.getCards()) {
            String displayColor = switch (card.getColor()) {
                case RED -> ConsoleColors.RED;
                case BLUE -> ConsoleColors.BLUE;
                case GREEN -> ConsoleColors.GREEN;
                case BLACK -> ConsoleColors.WHITE;
                case Yellow -> ConsoleColors.YELLOW;
            };
            System.out.print(displayColor + "\u250D" + "\u2501\u2501\u2501\u2501");
        }
        System.out.println("\u2501" + "\u2511");

        for (Card card : player.getCards()) {
            String displayColor = switch (card.getColor()) {
                case RED -> ConsoleColors.RED;
                case BLUE -> ConsoleColors.BLUE;
                case GREEN -> ConsoleColors.GREEN;
                case BLACK -> ConsoleColors.WHITE;
                case Yellow -> ConsoleColors.YELLOW;
            };
            System.out.print(displayColor + "\u2502" + "    ");
        }
        System.out.println(" " + "\u2502");

        for (Card card : player.getCards()) {
            String displayColor = switch (card.getColor()) {
                case RED -> ConsoleColors.RED;
                case BLUE -> ConsoleColors.BLUE;
                case GREEN -> ConsoleColors.GREEN;
                case Yellow -> ConsoleColors.YELLOW;
                case BLACK -> ConsoleColors.WHITE;
            };
            if (!card.getSign().equals("10"))
                System.out.print(displayColor + "\u2502" + "  " + card.getSign() + " ");
            else
                System.out.print(displayColor + "\u2502" + " " + card.getSign() + " ");
        }
        System.out.println(" " + "\u2502");

        for (Card card : player.getCards()) {
            String displayColor = switch (card.getColor()) {
                case RED -> ConsoleColors.RED;
                case BLUE -> ConsoleColors.BLUE;
                case GREEN -> ConsoleColors.GREEN;
                case BLACK -> ConsoleColors.WHITE;
                case Yellow -> ConsoleColors.YELLOW;
            };
            System.out.print(displayColor + "\u2502" + "    ");
        }
        System.out.println(" " + "\u2502");

        for (Card card : player.getCards()) {
            String displayColor = switch (card.getColor()) {
                case RED -> ConsoleColors.RED;
                case BLUE -> ConsoleColors.BLUE;
                case GREEN -> ConsoleColors.GREEN;
                case BLACK -> ConsoleColors.WHITE;
                case Yellow -> ConsoleColors.YELLOW;
            };
            System.out.print(displayColor + "\u2515" + "\u2501\u2501\u2501\u2501");
        }
        System.out.println("\u2501" + "\u2519" + ConsoleColors.RESET);

        for (int i = 1; i <= player.getCards().size(); i++)
            System.out.printf("  %d  ", i);
        System.out.println();
    }

    public void declareWhoseTurn(Game game) {
        System.out.printf("It's %s's turn.\n", game.getPlayerOnTurn().getName());
    }

    public void printToChooseCard() {
        System.out.println("Choose the card you want to play by their number");
    }

    public void errorOutOfRange(Player player) {
        System.out.println("wrong number");
        System.out.println("Please choose a card with the number between 1 and " + player.getCards().size() + ".");
    }

    public void errorWrongInput() {
        System.out.println("Wrong input. Try again.");
    }

    public void printColors() {
        System.out.println("Choose a color by typing one of these: Y - R - G - B");
    }

    public void printBotChoice(Color color) {
        System.out.println("chose " + color.toString());
    }

    public void printBotChoice(int index) {
        System.out.println("choose player number " + index);
    }

    public void choosePlayer(Game game) {
        System.out.println("Choose a player with his index to give a random card to him.");
        System.out.println("Insert a number between 1 and " + game.getPlayers().size());
    }

    public void printLine() {
        System.out.println("_________________________________________");
    }

    public void gameOver(Game game) {
        System.out.println("game finished and "+game.getPlayers().get(0).getName() + " won the game!");
        System.out.println("scores:");
        int index = 1;
        for(Player player : game.getPlayers()) {
            System.out.println(index + "- " + player.getName() + " : " + player.calculateScore());
            index++;
        }
        System.out.println();

    }
}
