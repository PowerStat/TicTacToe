/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Arrays;


/**
 * Game board 3x3.
 *
 * TODO Constructor with size
 * TODO Constructor with width * height
 * TODO Factory
 */
public final class Board
 {
  /**
   * Field chance.
   */
  private static final int[][] FIELD_CHANCE = {{3, 2, 3}, {2, 4, 2}, {3, 2, 3}};

  /**
   * Board array 3x3.
   *
   * Space means empty field, otherwise X/O per player.
   */
  private final char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};


  /**
   * Default constructor.
   */
  public Board()
   {
    super();
   }


  /**
   * Clear board.
   */
  public void clear()
   {
    for (final char[] row : this.board)
     {
      for (char column : row)
       {
        column = ' ';
       }
     }
   }


  /**
   * Clone array.
   *
   * @param src Source array.
   * @return Cloned array
   */
  private static char[][] cloneArray(final char[][] src)
   {
    final char[][] target = new char[src.length][src[0].length];
    for (int i = 0; i < src.length; ++i)
     {
      System.arraycopy(src[i], 0, target[i], 0, src[i].length);
     }
    return target;
   }


  /**
   * Get a copy of the board.
   *
   * @return Copy of board array 3x3
   */
  public char[][] getBoard()
   {
    return cloneArray(this.board);
   }


  /**
   * Is position empty.
   *
   * @param position Position on board
   * @return true: if empty, false otherwise
   */
  private boolean isPositionEmpty(final Coordinate position)
   {
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    return this.board[row][column] == ' ';
   }


  /**
   * Get token from posiion.
   *
   * @param position Position on board
   * @return Token on position X, O, ' '
   */
  private char getToken(final Coordinate position)
   {
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    return this.board[row][column];
   }


  /**
   * Set field with token.
   *
   * @param position Position ob board
   * @param token Token (X,O)
   * @return Successfully set
   * @throws IllegalStateException when the token is not X or O.
   */
  public boolean setField(final Coordinate position, final char token)
   {
    if ((token != 'X') && (token != 'O'))
     {
      throw new IllegalStateException("Token must be X or O!");
     }
    if (isPositionEmpty(position))
     {
      final int row = position.getRow() - 1;
      final int column = position.getColumn() - 1;
      this.board[row][column] = token;
      return true;
     }
    return false;
   }


  /**
   * Detect if a player has 3 horizontal, vertical or diagonal tokens.
   *
   * @return true if a player wins, false otherwise
   */
  public boolean detectWin()
   {
    // Horizontal 3 rows
    for (final char[] row : this.board)
     {
      if ((row[0] != ' ') && (row[0] == row[1]) && (row [0] == row [2]))
       {
        return true;
       }
     }
    // Vertical 3 columns
    for (int col = 0; col < 3; ++col)
     {
      if ((this.board[0][col] != ' ') && (this.board[0][col] == this.board[1][col]) && (this.board[0][col] == this.board[2][col]))
       {
        return true;
       }
     }
    // Diagonal 2 diagonal
    if ((this.board[0][0] != ' ') && (this.board[0][0] == this.board[1][1]) && (this.board[0][0] == this.board[2][2]))
     {
      return true;
     }
    if ((this.board[0][2] != ' ') && (this.board[0][2] == this.board[1][1]) && (this.board[0][2] == this.board[2][0]))
     {
      return true;
     }
    return false;
   }


  /**
   * Field chance to create 3 in a row.
   *
   * @param position Field position
   * @return Chance (0-4)
   */
  public static int fieldChance(final Coordinate position)
   {
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    return FIELD_CHANCE[row][column];
   }


  /**
   * Field chance for 3 of given token for empty field
   *
   * @param position Board position
   * @param token Token X, O
   * @return Chance 0-4
   */
  public int fieldChanceFor3(final Coordinate position, final char token)
   {
    if (!isPositionEmpty(position))
     {
      return 0;
     }
    int chance = 0;
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    // Horizontal row     column 1-3
    if (((this.board[row][0] == ' ') || (this.board[row][0] == token)) && ((this.board[row][1] == ' ') || (this.board[row][1] == token)) && ((this.board[row][2] == ' ') || (this.board[row][2] == token)))
     {
      ++chance;
     }
    // Vertical   column  row=1-3
    if (((this.board[0][column] == ' ') || (this.board[0][column] == token)) && ((this.board[1][column] == ' ') || (this.board[1][column] == token)) && ((this.board[2][column] == ' ') || (this.board[2][column] == token)))
     {
      ++chance;
     }
    // Diagonal? 1,1 0,0 2,2;  1,1 0,2 2,0
    if (((row == 1) && (column == 1)) || ((row == 0) && (column == 0)) || ((row == 2) && (column == 2)))
     {
      if ((this.board[1][1] == ' ') || ((this.board[1][1] == token) && (this.board[0][0] == ' ')) || ((this.board[0][0] == token) && (this.board[2][2] == ' ')) || (this.board[2][2] == token))
       {
        ++chance;
       }
     }
    if (((row == 1) && (column == 1)) || ((row == 0) && (column == 2)) || ((row == 2) && (column == 0)))
     {
      if ((this.board[1][1] == ' ') || ((this.board[1][1] == token) && (this.board[0][2] == ' ')) || ((this.board[0][2] == token) && (this.board[2][0] == ' ')) || (this.board[2][0] == token))
       {
        ++chance;
       }
     }
    return chance;
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Arrays.deepHashCode(this.board);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof Board))
     {
      return false;
     }
    final Board other = (Board)obj;
    return Arrays.deepEquals(this.board, other.board);
   }


  /**
   * Returns the string representation of this Board.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Board[
   *    1 2 3
   *   -------
   *  A| | | |
   *   -------
   *  B| | | |
   *   -------
   *  C| | | |
   *   -------
   *  ]"
   *
   * @return String representation of this Board
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    // return Arrays.deepToString(this.board);
    final StringBuilder builder = new StringBuilder();
    builder.append("Board[\n");
    builder.append("  1 2 3\n"); // TODO Iterator CoordinteSystem columns
    builder.append("-------\n");
    int rowNr = 1;
    for (final char[] row : this.board)
     {
      builder.append((rowNr == 1) ? 'A' : (rowNr == 2 ? 'B' : 'C')); // TODO Iterator CoordinteSystem rows
      builder.append('|');
      for (final char column : row)
       {
        builder.append(column).append('|');
       }
      builder.append("\n-------\n");
      ++rowNr;
     }
    builder.append("]\n"); //$NON-NLS-1$
    return builder.toString();
   }

 }
