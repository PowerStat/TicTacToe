/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;


/**
 * Players token.
 *
 * @param token Token
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
@ValueObject
public record Token(char token) implements Comparable<Token>
 {
  /**
   * Constructor.
   *
   * @param token Token
   * @throws NullPointerException if token is null
   * @throws IllegalArgumentException if token is not a correct token
   */
  public Token
   {
    if ((token != 'X') && (token != 'O') && (token != ' '))
     {
      throw new IllegalArgumentException("Token with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Token factory.
   *
   * @param token Token
   * @return Token object
   */
  public static Token of(final char token)
   {
    return new Token(token);
   }


  /**
   * Token factory.
   *
   * @param token Token
   * @return Token object
   */
  public static Token of(final String token)
   {
    Objects.requireNonNull(token, "token"); //$NON-NLS-1$
    if ((token.length() != 1))
     {
      throw new IllegalArgumentException("Token with wrong length"); //$NON-NLS-1$
     }
    return new Token(token.charAt(0));
   }


  /**
   * Returns the value of this Token as a string.
   *
   * @return The character value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return String.valueOf(token);
   }


  /**
   * Get opposite token.
   *
   * @return Opposite token X, O, ' '
   */
  public Token getOppositeToken()
   {
    return switch (token)
     {
      case 'X' -> Token.of('O');
      case 'O' -> Token.of('X');
      default ->Token.of(' ');
     };
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Token obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Character.compare(token, obj.token);
   }

 }
