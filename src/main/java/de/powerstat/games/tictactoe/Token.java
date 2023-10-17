/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.util.Objects;


/**
 * Players token.
 */
public final class Token implements Comparable<Token>
 {
  /**
   * Token.
   */
  private final char token;


  /**
   * Constructor.
   *
   * @param token Token
   * @throws NullPointerException if token is null
   * @throws IllegalArgumentException if token is not a correct token
   */
  private Token(final char token)
   {
    super();
    if ((token != 'X') && (token != 'O') && (token != ' '))
     {
      throw new IllegalArgumentException("Token with wrong format"); //$NON-NLS-1$
     }
    this.token = token;
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
   * Returns the value of this Token as a char.
   *
   * @return The character value represented by this object after conversion to type char.
   */
  public char charValue()
   {
    return this.token;
   }


  /**
   * Returns the value of this Token as a string.
   *
   * @return The character value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return String.valueOf(this.token);
   }


  /**
   * Get opposite token.
   *
   * @return Opposite token X, O, ' '
   */
  public Token getOppositeToken()
   {
    switch (this.token)
     {
      case 'X':
        return Token.of('O');
      case 'O':
        return Token.of('X');
      default:
        return Token.of(' ');
     }
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
    return Character.hashCode(this.token);
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
    if (!(obj instanceof Token))
     {
      return false;
     }
    final Token other = (Token)obj;
    return (this.token == other.token);
   }


  /**
   * Returns the string representation of this Token.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Token[token=X]"
   *
   * @return String representation of this Token
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Token[token=").append(this.token).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Token obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Character.compare(this.token, obj.token);
   }

 }
