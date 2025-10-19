/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


/**
 * Player AI tests.
 */
final class PlayerAITest
 {
  /**
   * Default constructor.
   */
  /* default */ PlayerAITest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final Token token = Token.of('X');
    final PlayerAI player = new PlayerAI("Test", token);
    assertNotNull(player, "Construtor failed!");
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    final Token token = Token.of(' ');
    assertThrows(IllegalArgumentException.class, () ->
     {
      final PlayerAI player = new PlayerAI("Test", token);
     }, "Illegal argument exception"
    );
   }


  /**
   * Test make move.
   */
  @Test
  /* default */ void testMakeMove1()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Token token = Token.of('X');
    final PlayerAI player = new PlayerAI("Test", token);
    player.makeMove(board);
    final String result = board.toString();
    assertEquals("Board[\n  1 2 3\n-------\nA| | | |\n-------\nB| |X| |\n-------\nC| | | |\n-------\n]\n", result, "No expected move");
   }


  /**
   * Test make move.
   */
  @Test
  /* default */ void testGetName()
   {
    final Token token = Token.of('X');
    final PlayerAI player = new PlayerAI("Test", token);
    assertEquals("Test", player.getName(), "Name is not equal");
   }

 }
