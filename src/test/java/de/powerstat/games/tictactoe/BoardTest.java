/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/**
 * Test Board.
 */
public class BoardTest
 {
  /**
   * Comma text.
   */
  private static final String COMMA = ", ";


  /**
   * Default constructor.
   */
  public BoardTest()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  public void constructor()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    assertNotNull(board, "No Board created");
   }


  /**
   * Test toString.
   */
  @Test
  @Disabled
  public void testToString()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    final String result = board.toString();
    assertEquals("[[ ,  ,  ], [ ,  ,  ], [ ,  ,  ]]", result, "Board not empty");
   }


  /**
   * Test field chance for 3.
   */
  @Test
  @Disabled
  public void testFieldChanceFor3()
   {
    final IHistory history = new History();
    final Board board = new Board(history);
    board.setField(new Coordinate('B', 2), Token.of('O'));
    final StringBuilder buffer = new StringBuilder();
    buffer.append('[');
    for (char row = 'A'; row <= 'C'; ++row)
     {
      buffer.append('[');
      for (int column = 1; column <= 3; ++column)
       {
        final Coordinate position = new Coordinate(row, column);
        final int result = board.fieldChanceFor3(position, Token.of('X'));
        buffer.append(result);
        if (column != 3)
         {
          buffer.append(COMMA);
         }
       }
      buffer.append(']');
      if (row != 'C')
       {
        buffer.append(COMMA);
       }
     }
    buffer.append(']');
    System.out.println(buffer);
   }

 }
