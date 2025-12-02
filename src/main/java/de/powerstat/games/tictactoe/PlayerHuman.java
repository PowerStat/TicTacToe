/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;
import java.util.Scanner;

import org.jmolecules.ddd.annotation.ValueObject;


/**
 * Human player.
 *
 * hashCode
 * equals
 * toString
 */
@ValueObject
public final class PlayerHuman implements IPlayer
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
   * Scanner.
   */
  private final Scanner scan;


  /**
   * Constructor.
   *
   * @param name Player name
   * @param token Token X/O
   * @param scan Scanner
   * @throws IllegalArgumentException when token is not X or O
   */
  public PlayerHuman(final String name, final Token token, final Scanner scan)
   {
    super();
    Objects.requireNonNull(name, "name"); //$NON-NLS-1$
    Objects.requireNonNull(scan, "scan"); //$NON-NLS-1$
    // Max length
    // Regexp
    if ((token.charValue() != 'X') && (token.charValue() != 'O'))
     {
      throw new IllegalArgumentException("Token must be X or O");
     }
    this.name = name;
    this.token = token;
    this.scan = scan;
   }


  /**
   * Make a  move.
   *
   * @param board Board to make the move on
   */
  @Override
  @SuppressWarnings("java:S106")
  public void makeMove(final Board board)
   {
    boolean result = false;
    do
     {
      System.out.print("Coordinate: ");
      final String coordStr = scan.nextLine();
      if ((coordStr.length() != 2) || (coordStr.charAt(0) < 'A') || (coordStr.charAt(0) > 'C') || (coordStr.charAt(1) < '1') || (coordStr.charAt(1) > '3'))
       {
        continue;
       }
      result = board.placeOnField(new Coordinate(coordStr.charAt(0), Character.getNumericValue(coordStr.charAt(1))), token);
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
    return name;
   }

 }
