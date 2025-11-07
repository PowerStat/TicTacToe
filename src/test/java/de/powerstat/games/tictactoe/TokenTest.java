/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.*;


/**
 * Token tests.
 */
final class TokenTest
 {
  /**
   * Default constructor.
   */
  /* default */ TokenTest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final Token token = Token.of('X');
    assertNotNull(token, "Factory failed!");
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final Token token = Token.of('A');
     }, "Illegal argument exception"
    );
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor3()
   {
    final Token token = Token.of("X");
    assertNotNull(token, "Factory failed!");
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor4()
   {
    assertThrows(NullPointerException.class, () ->
     {
      final Token token = Token.of(null);
     }, "Null pointer exception"
    );
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final Token token = Token.of("XX");
     }, "Illegal argument exception"
    );
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Token token = Token.of("X");
    assertEquals("X", token.stringValue(), "Token not as expected!");
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testGetOpositeToken()
   {
    final Token token = Token.of(' ');
    assertEquals(token, token.getOppositeToken(), "Token not as expected!");
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Token.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Token token = Token.of('X');
    final String result = token.toString();
    assertEquals("Token[token=X]", result, "toString not equal");
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Token token1 = Token.of('X');
    final Token token2 = Token.of('X');
    final Token token3 = Token.of('O');
    final Token token4 = Token.of(' ');
    final Token token5 = Token.of('X');
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(token1.compareTo(token2) == -token2.compareTo(token1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(token1.compareTo(token3) == -token3.compareTo(token1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((token3.compareTo(token4) > 0) && (token1.compareTo(token3) > 0) && (token1.compareTo(token4) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((token1.compareTo(token2) == 0) && (Math.abs(token1.compareTo(token5)) == Math.abs(token2.compareTo(token5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((token1.compareTo(token2) == 0) && token1.equals(token2), "equals") //$NON-NLS-1$
    );
   }

 }
