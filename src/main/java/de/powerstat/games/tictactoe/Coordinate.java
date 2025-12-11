/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;


/**
 * Board coordinate system.
 *
 * @param row Row nr 1-3 = A-C.
 * @param column Column nr 1-3.
 *
 * TODO size, width/height
 * TODO Factory
 */
@ValueObject
public record Coordinate(char row, int column) implements Comparable<Coordinate>
 {
  /**
   * Constructor.
   *
   * @param row Row nr 1-3 = A-C.
   * @param column Column nr 1-3.
   */
  public Coordinate
   {
    if ((row != 'A') && (row != 'B') && (row != 'C'))
     {
      throw new IllegalArgumentException("Row is not between A-C");
     }
    if ((column < 1) || (column > 3))
     {
      throw new IllegalArgumentException("Column not between 1-3");
     }
   }


  /**
   * Get row.
   *
   * @return Row 1-3
   */
  public int getRow()
   {
    return (row - 'A') + 1;
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
    int result = Integer.compare(row, obj.row);
    if (result == 0)
     {
      result = Integer.compare(column, obj.column);
     }
    return result;
   }

 }
