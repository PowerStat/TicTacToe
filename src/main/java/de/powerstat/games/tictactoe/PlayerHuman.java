/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;
import java.util.Scanner;


/**
 * Human player.
 *
 * hashCode
 * equals
 * toString
 */
public class PlayerHuman implements IPlayer
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
  public PlayerHuman(final String name, final char token)
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
    boolean result = false;
    do
     {
      System.out.print("Coordinate: ");
      final Scanner scan = new Scanner(System.in);
      final String coordStr = scan.nextLine();
      // scan.close();
      if ((coordStr.length() != 2) || (coordStr.charAt(0) < 'A') || (coordStr.charAt(0) > 'C') || (coordStr.charAt(1) < '1') || (coordStr.charAt(1) > '3'))
       {
        continue;
       }
      result = board.setField(new Coordinate(coordStr.charAt(0), Character.getNumericValue(coordStr.charAt(1))), this.token);
     }
    while (!result);
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
