/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;


/**
 * Artificial intelligence player.
 *
 * hashCode
 * equals
 * toString
 */
public class PlayerAI implements IPlayer
 {
  /**
   * Player name.
   */
  private final String name;

  /**
   * Token.
   */
  private final char token;


  /**
   * Constructor.
   *
   * @param name Player name
   * @param token Token X/O
   */
  public PlayerAI(final String name, final char token)
   {
    super();
    Objects.requireNonNull(name, "name"); //$NON-NLS-1$
    // Max length
    // Regexp
    if ((token != 'X') && (token != 'O'))
     {
      throw new IllegalArgumentException("Tokn must be X or O");
     }
    this.name = name;
    this.token = token;
   }


  /**
   * Make a  move.
   *
   * @param board Board to make the move on
   */
  @Override
  public void makeMove(final Board board)
   {
    // TODO: 1. Coordinate with highest Value
    //       2. Has the Oppenent already two in a row, column or diagonal?
    final Map<Coordinate, Integer> chances = new HashMap<>();
    for (char row = 'A'; row <= 'C'; ++row)
     {
      for (int column = 1; column <= 3; ++column)
       {
        final Coordinate position = new Coordinate(row, column);
        final int chance = board.fieldChanceFor3(position, this.token);
        chances.put(position, chance);
       }
     }
    Entry<Coordinate, Integer> maxEntry = null;
    for (final Entry<Coordinate, Integer> entry : chances.entrySet())
     {
      if ((maxEntry == null) || (entry.getValue().intValue() > maxEntry.getValue().intValue()))
       {
        maxEntry = entry;
       }
     }
    final char[] arr = {'A', 'B', 'C'};
    final char row = arr[maxEntry.getKey().getColumn() - 1];
    final int column = maxEntry.getKey().getRow();
    final boolean result = board.setField(new Coordinate(row, column), this.token);
    // Assume always ok
   }


  /**
   * Get players name.
   *
   * @return Name
   */
  @Override
  public String getName()
   {
    return this.name;
   }

 }
