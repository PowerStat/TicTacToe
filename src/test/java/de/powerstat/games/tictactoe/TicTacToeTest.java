/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tic tac toe tests.
 */
final class TicTacToeTest
 {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;


  /**
   * Default constructor.
   */
  /* default */ TicTacToeTest()
   {
    super();
   }


  /**
   * Before
   */
  @BeforeEach
  public void setUpStreams()
   {
    System.setOut(new PrintStream(this.outContent));
   }


  /**
   * After.
   */
  @AfterEach
  public void restoreStreams()
   {
    System.setOut(this.originalOut);
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain1()
   {
    final String[] arguments = {"A", "B", "C"};
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("TicTacToe [Name player 1 [Name player 2]]"), "Help output not found!");
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain2()
   {
    final String[] arguments = {};
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("Standoff"), "No Standoff!");
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain3()
   {
    final String[] arguments = {"Human"};
    System.setIn(new ByteArrayInputStream("B2\nA3\nB1\nC3\nA2\n".getBytes()));
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("Standoff"), "No Standoff!");
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain4()
   {
    final String[] arguments = {"Human1", "Human2"};
    System.setIn(new ByteArrayInputStream("B2\nA1\nA3\nC1\nB1\nB3\nC3\nC2\nA2\n".getBytes()));
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("Standoff"), "No Standoff!");
    assertTrue(output.contains("Make your move: Human1"), "No move from human1!");
    assertTrue(output.contains("Make your move: Human2"), "No move from human2!");
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain5()
   {
    final String[] arguments = {"Human1", "Human2"};
    System.setIn(new ByteArrayInputStream("B2\nA1\nB1\nA2\nB3\n".getBytes()));
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("Human1 wins!"), "Human1 has not won!");
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain6()
   {
    final String[] arguments = {"Human1", "Human2"};
    System.setIn(new ByteArrayInputStream("A1\nB2\nA2\nA3\nB1\nC1\n".getBytes()));
    TicTacToe.main(arguments);
    final String output = this.outContent.toString();
    assertTrue(output.contains("Human2 wins!"), "Human2 has not won!");
   }

 }
