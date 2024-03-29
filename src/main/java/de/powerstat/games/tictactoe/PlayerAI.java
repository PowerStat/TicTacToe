/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


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
  private final Token token;


  /**
   * Constructor.
   *
   * @param name Player name
   * @param token Token X/O
   */
  public PlayerAI(final String name, final Token token)
   {
    super();
    Objects.requireNonNull(name, "name"); //$NON-NLS-1$
    // Max length
    // Regexp
    if ((token.charValue() != 'X') && (token.charValue() != 'O'))
     {
      throw new IllegalArgumentException("Token must be X or O");
     }
    this.name = name;
    this.token = token;
   }


  /**
   * Make max entry coordinate from chance board.
   *
   * @param maxEntry Maximum entry
   * @return Coordinate
   */
  private static Coordinate makeMaxEntryCoordinate(final Entry<Coordinate, Integer> maxEntry)
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
  @SuppressWarnings("java:S106")
  private static void showChances(final Map<Coordinate, Integer> chances)
   {
    final var builder = new StringBuilder(42);
    builder.append("Board[\n  1 2 3\n-------\n");
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
  private static Entry<Coordinate, Integer> getPositionWithHighestChance(final Board board, final Token token)
   {
    final Map<Coordinate, Integer> chances = new ConcurrentHashMap<>();
    for (char row = 'A'; row <= 'C'; ++row)
     {
      for (int column = 1; column <= 3; ++column)
       {
        final var position = new Coordinate(row, column);
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
   * Get first free entry.
   *
   * @param board Board
   * @return Coordinate or null if no free position is available
   */
  private static Coordinate getFirstFreePosition(final Board board)
   {
    for (char row = 'A'; row <= 'C'; ++row)
     {
      for (int column = 1; column <= 3; ++column)
       {
        final var position = new Coordinate(row, column);
        if (board.isPositionEmpty(position))
         {
          return position;
         }
       }
     }
    return null;
   }


  /**
   * Make a  move.
   *
   * @param board Board to make the move on
   */
  @Override
  public void makeMove(final Board board)
   {
    final Token oppositeToken = this.token.getOppositeToken();
    Entry<Coordinate, Integer> maxEntry = getPositionWithHighestChance(board, oppositeToken);
    Coordinate position = null;
    if (maxEntry != null)
     {
      position = makeMaxEntryCoordinate(maxEntry);
     }
    if ((maxEntry == null) || (maxEntry.getValue().intValue() < 1))
     {
      maxEntry = getPositionWithHighestChance(board, this.token);
      if (maxEntry != null)
       {
        position = makeMaxEntryCoordinate(maxEntry);
       }
      if ((maxEntry == null) || (maxEntry.getValue().intValue() < 1))
       {
        position = getFirstFreePosition(board);
       }
     }
    if (position != null)
     {
      /* final boolean result = */ board.placeOnField(position, this.token);
      // Assume always ok
     }
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
