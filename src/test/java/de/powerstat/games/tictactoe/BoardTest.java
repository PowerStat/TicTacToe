/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.*;


/**
 * Test Board.
 */
final class BoardTest
 {
  /**
   * Comma text.
   */
  private static final String COMMA = ", ";


  /**
   * Default constructor.
   */
  /* default */ BoardTest()
   {
    super();
   }


  /**
   * Is board empty.
   *
   * @param board Board
   * @return true: empty; false: not empty
   */
  private boolean emptyBoard(final Token[][] board)
   {
    int counter = 0;
    for (final Token[] row : board)
     {
      for (final Token column : row)
       {
        if (column.equals(Token.of(' ')))
         {
          ++counter;
         }
       }
     }
    return counter == 9;
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    assertNotNull(board, "No Board created");
   }


  /**
   * Test clear.
   */
  @Test
  /* default */ void testClear()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    board.clear();
    assertTrue(emptyBoard(board.getBoard()), "Board not empty");
   }


  /**
   * Test is position empty.
   */
  @Test
  /* default */ void testIsPositionEmpty1()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate cord = new Coordinate('A', 1);
    assertTrue(board.isPositionEmpty(cord), "Position not empty");
   }


  /**
   * Test place on field.
   */
  @Test
  /* default */ void testPlaceOnField1()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final boolean result = board.placeOnField(position, token);
    assertTrue(result, "Not successfully set");
    assertFalse(board.isPositionEmpty(position), "Position is empty");
    // TODO assert History
   }


  /**
   * Test place on field.
   */
  @Test
  /* default */ void testPlaceOnField2()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('O');
    final boolean result = board.placeOnField(position, token);
    assertTrue(result, "Not successfully set");
    assertFalse(board.isPositionEmpty(position), "Position is empty");
    // TODO assert History
   }


  /**
   * Test place on field.
   */
  @Test
  /* default */ void testPlaceOnField3()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of(' ');
    assertThrows(IllegalStateException.class, () ->
     {
      /* final boolean result = */ board.placeOnField(position, token);
     }, "Illegal state exception"
    );
   }


  /**
   * Test place on field.
   */
  @Test
  /* default */ void testPlaceOnField4()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position = new Coordinate('A', 1);
    final Token token1 = Token.of('O');
    final Token token2 = Token.of('X');
    /* final boolean result = */ board.placeOnField(position, token1);
    final boolean result = board.placeOnField(position, token2);
    assertFalse(result, "Not successfully set");
    // TODO assert History
   }


  /**
   * Test detect win.
   */
  @Test
  /* default */ void testDetectWin1()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('A', 2);
    final Coordinate position3 = new Coordinate('A', 3);
    final Token token1 = Token.of('X');
    boolean success = board.placeOnField(position1, token1);
    success = board.placeOnField(position2, token1);
    success = board.placeOnField(position3, token1);
    final boolean result = board.detectWin();
    assertTrue(result, "No horizontal win");
   }


  /**
   * Test detect win.
   */
  @Test
  /* default */ void testDetectWin2()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 1);
    final Coordinate position3 = new Coordinate('C', 1);
    final Token token1 = Token.of('X');
    boolean success = board.placeOnField(position1, token1);
    success = board.placeOnField(position2, token1);
    success = board.placeOnField(position3, token1);
    final boolean result = board.detectWin();
    assertTrue(result, "No vertical win");
   }


  /**
   * Test detect win.
   */
  @Test
  /* default */ void testDetectWin3()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final boolean result = board.detectWin();
    assertFalse(result, "No win");
   }


  /**
   * Test detect win.
   */
  @Test
  /* default */ void testDetectWin4()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 2);
    final Coordinate position3 = new Coordinate('C', 3);
    final Token token1 = Token.of('X');
    boolean success = board.placeOnField(position1, token1);
    success = board.placeOnField(position2, token1);
    success = board.placeOnField(position3, token1);
    final boolean result = board.detectWin();
    assertTrue(result, "No diagonal win");
   }


  /**
   * Test detect win.
   */
  @Test
  /* default */ void testDetectWin5()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final Coordinate position1 = new Coordinate('A', 3);
    final Coordinate position2 = new Coordinate('B', 2);
    final Coordinate position3 = new Coordinate('C', 1);
    final Token token1 = Token.of('X');
    boolean success = board.placeOnField(position1, token1);
    success = board.placeOnField(position2, token1);
    success = board.placeOnField(position3, token1);
    final boolean result = board.detectWin();
    assertTrue(result, "No diagonal win");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3a()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 1);
    final int chance = board.fieldChanceFor3(position1, token1);
    assertEquals(9, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3b()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 3);
    final int chance = board.fieldChanceFor3(position1, token1);
    assertEquals(9, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3c()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 1);

    board.placeOnField(position1, token1);

    final int chance = board.fieldChanceFor3(position1, token1);
    assertEquals(0, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3d()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Token token2 = Token.of('O');
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('A', 2);

    board.placeOnField(position1, token2);

    final int chance = board.fieldChanceFor3(position2, token1);
    assertEquals(3, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3e()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('A', 2);
    final Coordinate position3 = new Coordinate('A', 3);

    board.placeOnField(position1, token1);
    board.placeOnField(position2, token1);

    final int chance = board.fieldChanceFor3(position3, token1);
    assertEquals(21, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3f()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 1);
    final Coordinate position3 = new Coordinate('C', 1);

    board.placeOnField(position1, token1);
    board.placeOnField(position2, token1);

    final int chance = board.fieldChanceFor3(position3, token1);
    assertEquals(21, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3g()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 2);
    final Coordinate position3 = new Coordinate('C', 3);

    board.placeOnField(position1, token1);
    board.placeOnField(position2, token1);

    final int chance = board.fieldChanceFor3(position3, token1);
    assertEquals(21, chance, "Not the expected chance");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  /* default */ void testFieldChanceFor3h()
   {
    final IHistory history = new History();
    final Board board = new Board(history);

    final Token token1 = Token.of('X');
    final Coordinate position1 = new Coordinate('A', 3);
    final Coordinate position2 = new Coordinate('B', 2);
    final Coordinate position3 = new Coordinate('C', 1);

    board.placeOnField(position1, token1);
    board.placeOnField(position2, token1);

    final int chance = board.fieldChanceFor3(position3, token1);
    assertEquals(21, chance, "Not the expected chance");
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Board.class).withNonnullFields("history").withIgnoredFields("history").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final String result = board.toString();
    assertEquals("Board[\n  1 2 3\n-------\nA| | | |\n-------\nB| | | |\n-------\nC| | | |\n-------\n]\n", result, "toString not equal");
   }

 }
