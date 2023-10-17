/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Arrays;
import java.util.Objects;


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
   * Board array 3x3.
   *
   * Space means empty field, otherwise X/O per player.
   */
  private final Token[][] board = {{Token.of(' '), Token.of(' '), Token.of(' ')}, {Token.of(' '), Token.of(' '), Token.of(' ')}, {Token.of(' '), Token.of(' '), Token.of(' ')}};

  /**
   * History.
   */
  private final IHistory history;


  /**
   * Constructor.
   *
   * @param history History
   */
  public Board(final IHistory history)
   {
    super();
    Objects.requireNonNull(history, "history"); //$NON-NLS-1$
    this.history = history;
   }


  /**
   * Clear board.
   */
  public void clear()
   {
    for (final Token[] row : this.board)
     {
      for (Token column : row) // TODO Column not writable
       {
        column = Token.of(' ');
       }
     }
   }


  /**
   * Clone array.
   *
   * @param src Source array.
   * @return Cloned array
   */
  private static Token[][] cloneArray(final Token[][] src)
   {
    final Token[][] target = new Token[src.length][src[0].length];
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
  public Token[][] getBoard()
   {
    return cloneArray(this.board);
   }


  /**
   * Get token from posiion.
   *
   * @param position Position on board
   * @return Token on position X, O, ' '
   */
  private Token getToken(final Coordinate position)
   {
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    return this.board[row][column];
   }


  /**
   * Is position empty.
   *
   * @param position Position on board
   * @return true: if empty, false otherwise
   */
  public boolean isPositionEmpty(final Coordinate position)
   {
    return Token.of(' ').equals(getToken(position));
   }


  /**
   * Set field with token.
   *
   * @param position Position ob board
   * @param token Token (X,O)
   * @return Successfully set
   * @throws IllegalStateException when the token is not X or O.
   */
  public boolean setField(final Coordinate position, final Token token)
   {
    if ((token.charValue() != 'X') && (token.charValue() != 'O'))
     {
      throw new IllegalStateException("Token must be X or O!");
     }
    if (isPositionEmpty(position))
     {
      final int row = position.getRow() - 1;
      final int column = position.getColumn() - 1;
      this.board[row][column] = token;
      this.history.makeEntry(position, token);
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
    for (final Token[] row : this.board)
     {
      if ((Token.of(' ').equals(row[0])) && (row[0] == row[1]) && (row[0] == row[2]))
       {
        return true;
       }
     }
    // Vertical 3 columns
    for (int col = 0; col < 3; ++col)
     {
      if ((Token.of(' ').equals(this.board[0][col])) && (this.board[0][col] == this.board[1][col]) && (this.board[0][col] == this.board[2][col]))
       {
        return true;
       }
     }
    // Diagonal 2 diagonal
    if ((Token.of(' ').equals(this.board[0][0])) && (this.board[0][0] == this.board[1][1]) && (this.board[0][0] == this.board[2][2]))
     {
      return true;
     }
    if ((Token.of(' ').equals(this.board[0][2])) && (this.board[0][2] == this.board[1][1]) && (this.board[0][2] == this.board[2][0]))
     {
      return true;
     }
    return false;
   }


  /**
   * Row/column chance.
   *
   * @param token Token
   * @param row Row
   * @param column Column
   * @return chance: 0-2
   */
  private int rowColumnChance(final Token token, final int row, final int column)
   {
    final Token fieldToken = this.board[row][column];
    if (Token.of(' ').equals(fieldToken))
     {
      return 1;
     }
    else if (token.equals(fieldToken))
     {
       return 2;
     }
    return 0;
   }


  /**
   * Get horizontal chance.
   *
   * @param token Token
   * @param row Row
   * @param column Column
   * @return Chance
   */
  private int horizontalChance(final Token token, final int row, final int column)
   {
    // Horizontal row     column 1-3
    final int column0 = rowColumnChance(token, row, 0);
    final int column1 = rowColumnChance(token, row, 1);
    final int column2 = rowColumnChance(token, row, 2);
    final int bonus = ((column0 + column1 + column2) == 5) ? 10 : 0;
    if ((column0 > 0) && (column1 > 0) && (column2 > 0))
     {
      return column0 + column1 + column2 + bonus;
     }
    return 0;
   }


  /**
   * Get vertical chance.
   *
   * @param token Token
   * @param row Row
   * @param column Column
   * @return Chance
   */
  private int verticalChance(final Token token, final int row, final int column)
   {
    // Vertical   column  row=1-3
    final int row0 = rowColumnChance(token, 0, column);
    final int row1 = rowColumnChance(token, 1, column);
    final int row2 = rowColumnChance(token, 2, column);
    final int bonus = ((row0 + row1 + row2) == 5) ? 10 : 0;
    if ((row0 > 0) && (row1 > 0) && (row2 > 0))
     {
      return row0 + row1 + row2 + bonus;
     }
    return 0;
   }


  /**
   * Get diagonalTopLeftToBottomRight chance.
   *
   * @param token Token
   * @param row Row
   * @param column Column
   * @return Chance
   */
  private int diagonalTopLeftToBottomRight(final Token token, final int row, final int column)
   {
    if (((row == 1) && (column == 1)) || ((row == 0) && (column == 0)) || ((row == 2) && (column == 2)))
     {
      final int topLeft = rowColumnChance(token, 0, 0);
      final int middle = rowColumnChance(token, 1, 1);
      final int bottomRight = rowColumnChance(token, 2, 2);
      final int bonus = ((topLeft + middle + bottomRight) == 5) ? 10 : 0;
      if ((topLeft > 0) && (middle > 0) && (bottomRight > 0))
       {
        return topLeft + middle + bottomRight + bonus;
       }
     }
    return 0;
   }


  /**
   * Get diagonalTopRightToBottomLeft chance.
   *
   * @param token Token
   * @param row Row
   * @param column Column
   * @return Chance
   */
  private int diagonalTopRightToBottomLeft(final Token token, final int row, final int column)
   {
    if (((row == 1) && (column == 1)) || ((row == 0) && (column == 2)) || ((row == 2) && (column == 0)))
     {
      final int topRight = rowColumnChance(token, 0, 2);
      final int middle = rowColumnChance(token, 1, 1);
      final int bottomLeft = rowColumnChance(token, 2, 0);
      final int bonus = ((topRight + middle + bottomLeft) == 5) ? 10 : 0;
      if ((topRight > 0) && (middle > 0) && (bottomLeft > 0))
       {
        return topRight + middle + bottomLeft + bonus;
       }
     }
    return 0;
   }


  /**
   * Field chance for 3 of given token for empty field.
   *
   * @param position Board position
   * @param token Token X, O
   * @return Chance 0-4
   */
  public int fieldChanceFor3(final Coordinate position, final Token token)
   {
    if (!isPositionEmpty(position))
     {
      return 0;
     }
    int chance = 0;
    final int row = position.getRow() - 1;
    final int column = position.getColumn() - 1;
    chance += horizontalChance(token, row, column);
    chance += verticalChance(token, row, column);
    chance += diagonalTopLeftToBottomRight(token, row, column);
    chance += diagonalTopRightToBottomLeft(token, row, column);
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
   *
   * TODO Color if 3 in a row, column or diagonal
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
    for (final Token[] row : this.board)
     {
      builder.append((rowNr == 1) ? 'A' : (rowNr == 2 ? 'B' : 'C')); // TODO Iterator CoordinteSystem rows
      builder.append('|');
      for (final Token column : row)
       {
        builder.append(column.charValue()).append('|');
       }
      builder.append("\n-------\n");
      ++rowNr;
     }
    builder.append("]\n"); //$NON-NLS-1$
    return builder.toString();
   }

 }
