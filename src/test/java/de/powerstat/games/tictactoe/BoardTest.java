/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


/**
 * Test Board.
 */
public class BoardTest
 {
  /**
   * Test constructor.
   */
  @Test
  public void constructor()
   {
    final Board board = new Board();
    assertNotNull(board, "No Board created");
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Board board = new Board();
    final String result = board.toString();
    assertEquals("[[ ,  ,  ], [ ,  ,  ], [ ,  ,  ]]", result, "Board not empty");
   }


  /**
   * Test field chance.
   */
  @Test
  public void testFieldChance()
   {
    final StringBuilder buffer = new StringBuilder();
    buffer.append('[');
    for (char row = 'A'; row <= 'C'; ++row)
     {
      buffer.append('[');
      for (int column = 1; column <= 3; ++column)
       {
        final Coordinate position = new Coordinate(row, column);
        final int result = Board.fieldChance(position);
        buffer.append(result);
        if (column != 3)
         {
          buffer.append(", ");
         }
       }
      buffer.append(']');
      if (row != 'C')
       {
        buffer.append(", ");
       }
     }
    buffer.append(']');
    System.out.println(buffer);
   }


  /**
   * Test field chance for 3.
   */
  @Test
  public void testFieldChanceFor3()
   {
    final Board board = new Board();
    board.setField(new Coordinate('B', 2), 'O');
    final StringBuilder buffer = new StringBuilder();
    buffer.append('[');
    for (char row = 'A'; row <= 'C'; ++row)
     {
      buffer.append('[');
      for (int column = 1; column <= 3; ++column)
       {
        final Coordinate position = new Coordinate(row, column);
        final int result = board.fieldChanceFor3(position, 'X');
        buffer.append(result);
        if (column != 3)
         {
          buffer.append(", ");
         }
       }
      buffer.append(']');
      if (row != 'C')
       {
        buffer.append(", ");
       }
     }
    buffer.append(']');
    System.out.println(buffer);
   }

 }
