/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;


/**
 * Board coordinate system.
 *
 * Rows A-C, columns 1-3
 *
 * TODO size, width/height
 * TODO Factory
 */
public final class Coordinate implements Comparable<Coordinate>
 {
  /**
   * Row 1-3 = A-C.
   */
  private final int row;

  /**
   * Column 1-3.
   */
  private final int column;


  /**
   * Constructor.
   *
   * @param row Row nr.
   * @param column Column nr.
   */
  public Coordinate(final char row, final int column)
   {
    super();
    if ((row != 'A') && (row != 'B') && (row != 'C'))
     {
      throw new IllegalArgumentException("Row is not between A-C");
     }
    if ((column < 1) || (column > 3))
     {
      throw new IllegalArgumentException("Column not between 1-3");
     }
    this.row = (row - 'A') + 1;
    this.column = column;
   }


  /**
   * Get row.
   *
   * @return Row 1-3
   */
  public int getRow()
   {
    return this.row;
   }


  /**
   * Get column.
   *
   * @return Column 1-3
   */
  public int getColumn()
   {
    return this.column;
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
    return Objects.hash(this.row, this.column);
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
    if (!(obj instanceof Coordinate))
     {
      return false;
     }
    final Coordinate other = (Coordinate)obj;
    return (this.row == other.row) && (this.column == other.column);
   }


  /**
   * Returns the string representation of this Coordinate.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Coordinate[row=1, column=1]"
   *
   * @return String representation of this Coordinate
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Coordinate[row=").append(this.row).append(", column=").append(this.column).append(']'); //$NON-NLS-1$
    return builder.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Coordinate obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = Integer.compare(this.row, obj.row);
    if (result == 0)
     {
      result = Integer.compare(this.column, obj.column);
     }
    return result;
   }

 }
