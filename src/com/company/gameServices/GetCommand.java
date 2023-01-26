package com.company.gameServices;

import com.company.design.UI;
import com.company.enums.Color;

import java.util.Scanner;

/**
 * class for handling commands
 *
 * @author Mohammad Reza Karimi
 */
public class GetCommand {
    private static GetCommand INSTANCE = null;
    private final Scanner scanner;

    /**
     * get the command
     */
    private GetCommand(){
        scanner = new Scanner(System.in);
    }

    /**
     * make an instance of ui
     * @return INSTANCE
     */
    public static GetCommand getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GetCommand();
        return INSTANCE;
    }

    /**
     * get chosen player for penalty
     * @param player
     * @return index-1
     */

    public int chooseIndex(Player player) {
        int index = scanner.nextInt();
        while (index < 1 || index > player.getCards().size()) {
            UI.getInstance().errorOutOfRange(player);
            index = scanner.nextInt();
        }
        return index - 1;
    }

    /**
     * recive name
     * @return name
     */
    public String insertName() {
        return scanner.next();
    }

    /**
     * choose color
     * for changing color for WC ANd WD4 cards
     * @return color
     */
    public Color chooseColor() {
        String input = scanner.next();
        Color toReturn;
        switch (input) {
            case "BLACK":
                toReturn = Color.BLACK;
                break;
            case "R":
                toReturn = Color.RED;
                break;
            case "G":
                toReturn = Color.GREEN;
                break;
            case "B":
                toReturn = Color.BLUE;
                break;
            case "Y":
                toReturn = Color.Yellow;
                break;
            default:
                UI.getInstance().errorWrongInput();
                toReturn = chooseColor();
        }
        return toReturn;
    }

    /**
     * choose player for penalty
     * @param game
     * @return
     */
    public int choosePlayer(Game game) {
        int index = scanner.nextInt();
        while (index < 0 || index > game.getPlayers().size()) {
            UI.getInstance().errorWrongInput();
            index = scanner.nextInt();
        }
        return index - 1;
    }

    /**
     *  ask for game mode
     * @return game mode
     */
    public Game.GameMode askForGameMode() {
        int answer = scanner.nextInt();
        while (answer != 1 && answer != 2) {
            UI.getInstance().errorWrongInput();
            answer = scanner.nextInt();
        }
        if (answer == 1)
            return Game.GameMode.SINGLE_PLAYER;
        else
            return Game.GameMode.MULTI_PLAYER;
    }

    /**
     * ask number of players
     *
     * @return
     */
    public int askForNumberOfPlayers() {
        int answer = scanner.nextInt();
        while (answer < 2 || answer > 5) {
            UI.getInstance().errorWrongInput();
            answer = scanner.nextInt();
        }
        return answer;
    }

}
