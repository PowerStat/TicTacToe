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
   * Make max entry coordinate from chance board.
   *
   * @param chanceBoard Chance board
   * @return Coordinate
   */
  private Coordinate makeMaxEntryCoordinate(final Entry<Coordinate, Integer> maxEntry)
   {
    final char[] arr = {'A', 'B', 'C'};
    final char row = arr[maxEntry.getKey().getRow() - 1];
    final int column = maxEntry.getKey().getColumn();
    return new Coordinate(row, column);
   }


  /**
   * Show chances.
   *
   * @param chances Chances on board
   */
  private void showChances(final Map<Coordinate, Integer> chances)
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Board[\n");
    builder.append("  1 2 3\n");
    builder.append("-------\n");
    for (char row = 'A'; row <= 'C'; ++row)
     {
      builder.append(row).append('|');
      for (int column = 1; column <= 3; ++column)
       {
        final Integer value = chances.get(new Coordinate(row, column));
        builder.append(value).append('|');
       }
      builder.append("\n-------\n");
     }
    builder.append("]\n"); //$NON-NLS-1$
    System.out.println(builder.toString());
   }


  /**
   * Get max entry.
   *
   * @param board Board
   * @param token Players token
   * @return Max entry
   */
  private Entry<Coordinate, Integer> getPositionWithHighestChance(final Board board, final char token)
   {
    final Map<Coordinate, Integer> chances = new HashMap<>();
    for (char row = 'A'; row <= 'C'; ++row)
     {
      for (int column = 1; column <= 3; ++column)
       {
        final Coordinate position = new Coordinate(row, column);
        final int chance = board.fieldChanceFor3(position, token);
        chances.put(position, chance);
       }
     }

    // showChances(chances);

    Entry<Coordinate, Integer> maxEntry = null; // List if maxEntries - choose per random
    for (final Entry<Coordinate, Integer> entry : chances.entrySet())
     {
      if ((maxEntry == null) || (entry.getValue().intValue() > maxEntry.getValue().intValue()))
       {
        maxEntry = entry;
       }
     }
    return maxEntry;
   }


  /**
   * Make a  move.
   *
   * @param board Board to make the move on
   */
  @Override
  public void makeMove(final Board board)
   {
    final char oppositeToken = board.getOppositeToken(this.token);
    Entry<Coordinate, Integer> maxEntry = getPositionWithHighestChance(board, oppositeToken);
    Coordinate position = makeMaxEntryCoordinate(maxEntry);
    if (maxEntry.getValue().intValue() < 1)
     {
      maxEntry = getPositionWithHighestChance(board, this.token);
      position = makeMaxEntryCoordinate(maxEntry);
     }
    final boolean result = board.setField(position, this.token);
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
