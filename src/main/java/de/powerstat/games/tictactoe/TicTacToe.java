/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;


/**
 * Tic Tac Toe main game.
 *
 * TODO Replay
 * TODO Hexagonal Architecture
 */
@SuppressWarnings("java:S106")
public final class TicTacToe
 {
  /**
   * Make your move text.
   */
  private static final String MAKE_YOUR_MOVE = "Make your move: ";

  /**
   * Wins text.
   */
  private static final String WINS = " wins!";


  /**
   * Private default constructor.
   */
  private TicTacToe()
   {
    super();
   }


  /**
   * Main.
   *
   * @param args Commandline arguments
   */
  public static void main(final String[] args)
   {
    // Arguments
    IPlayer playerA;
    IPlayer playerB;
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    switch (args.length)
     {
      case 0: // AI vs AI
        playerA = new PlayerAI("AI1", Token.of('X'));
        playerB = new PlayerAI("AI2", Token.of('O'));
        break;
      case 1: // Human vs AI
        playerA = new PlayerHuman(args[0], Token.of('X'), scan);
        playerB = new PlayerAI("AI", Token.of('O'));
        break;
      case 2: // Human vs Human
        playerA = new PlayerHuman(args[0], Token.of('X'), scan);
        playerB = new PlayerHuman(args[1], Token.of('O'), scan);
        break;
      default:
        System.out.println("TicTacToe [Name player 1 [Name player 2]]");
        return;
     }

    // Init board
    final var board = new Board(new History());

    // Random start player
    final Random random = new SecureRandom();
    final int startingPlayer = random.nextInt(2 - 1) + 1;
    final IPlayer player1 = (startingPlayer == 1) ? playerA : playerB;
    final IPlayer player2 = (startingPlayer == 1) ? playerB : playerA;

    // Game loop
    for (int round = 1; round <= 5; ++round)
     {
      System.out.println(board.toString());
      System.out.println(MAKE_YOUR_MOVE + player1.getName());
      player1.makeMove(board);
      if (board.detectWin())
       {
        System.out.println(player1.getName() + WINS);
        System.out.println(board.toString());
        return;
       }
      System.out.println(board.toString());
      if (round < 5)
       {
        System.out.println(MAKE_YOUR_MOVE + player2.getName());
        player2.makeMove(board);
        if (board.detectWin())
         {
          System.out.println(player2.getName() + WINS);
          System.out.println(board.toString());
          return;
         }
       }
     }
    System.out.println(board.toString());
    System.out.println("Standoff");
   }

 }
