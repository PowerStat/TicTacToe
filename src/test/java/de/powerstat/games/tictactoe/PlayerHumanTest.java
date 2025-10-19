/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


/**
 * Player human tests.
 */
final class PlayerHumanTest
 {
  /**
   * Default constructor.
   */
  /* default */ PlayerHumanTest()
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
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    final PlayerHuman player = new PlayerHuman("Test", token, scan);
    assertNotNull(player, "Construtor failed!");
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    final Token token = Token.of(' ');
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    assertThrows(IllegalArgumentException.class, () ->
     {
      final PlayerHuman player = new PlayerHuman("Test", token, scan);
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
    System.setIn(new ByteArrayInputStream("B2".getBytes()));
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    final PlayerHuman player = new PlayerHuman("Test", token, scan);
    player.makeMove(board);
    final String result = board.toString();
    assertEquals("Board[\n  1 2 3\n-------\nA| | | |\n-------\nB| |X| |\n-------\nC| | | |\n-------\n]\n", result, "No expected move");
   }


  /**
   * Test make move.
   */
  @Test
  /* default */ void testMakeMove2()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Token token = Token.of('X');
    System.setIn(new ByteArrayInputStream("A\nD1\nA4\nB2\n".getBytes()));
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    final PlayerHuman player = new PlayerHuman("Test", token, scan);
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
    final var scan = new Scanner(System.in, StandardCharsets.US_ASCII);
    final PlayerHuman player = new PlayerHuman("Test", token, scan);
    assertEquals("Test", player.getName(), "Name is not equal");
   }

 }
