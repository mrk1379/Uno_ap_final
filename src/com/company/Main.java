package com.company;

import com.company.gameServices.Game;

import java.io.IOException;

/**
 * main class
 * run a game
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = Game.welcome();
        game.play();
    }
}
