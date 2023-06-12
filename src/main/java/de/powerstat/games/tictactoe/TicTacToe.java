/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Random;


/**
 * Tic Tac Toe main game.
 */
public class TicTacToe
 {
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
    switch (args.length)
     {
      case 0: // AI vs AI
        playerA = new PlayerAI("AI1", 'X');
        playerB = new PlayerAI("AI2", 'O');
        break;
      case 1: // Human vs AI
        playerA = new PlayerHuman(args[0], 'X');
        playerB = new PlayerAI("AI", 'O');
        break;
      case 2: // Human vs Human
        playerA = new PlayerHuman(args[0], 'X');
        playerB = new PlayerHuman(args[1], 'O');
        break;
      default:
        System.out.println("TicTacToe [Name player 1 [Name player 2]]");
        return;
     }

    // Init board
    final Board board = new Board();

    // Random start player
    final Random random = new Random();
    final int startingPlayer = random.nextInt(2 - 1) + 1;
    final IPlayer player1 = (startingPlayer == 1) ? playerA : playerB;
    final IPlayer player2 = (startingPlayer == 1) ? playerB : playerA;

    // Game loop
    for (int round = 1; round <= 5; ++round)
     {
      System.out.println(board.toString());
      System.out.println("Make your move: " + player1.getName());
      player1.makeMove(board);
      if (board.detectWin())
       {
        System.out.println(player1.getName() + " wins!");
        System.out.println(board.toString());
        return;
       }
      System.out.println(board.toString());
      if (round < 5)
       {
        System.out.println("Make your move: " + player2.getName());
        player2.makeMove(board);
        if (board.detectWin())
         {
          System.out.println(player2.getName() + " wins!");
          System.out.println(board.toString());
          return;
         }
       }
     }
    System.out.println(board.toString());
    System.out.println("Standoff");
   }

 }
