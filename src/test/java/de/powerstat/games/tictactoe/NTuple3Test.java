/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


/**
 * NTuple 3 tests.
 */
final class NTuple3Test
 {
  /**
   * Default constructor.
   */
  /* default */ NTuple3Test()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testOf1()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    assertNotNull(ntuple, "Factory failed!");
   }


  /**
   * Test t1Value.
   */
  @Test
  /* default */ void testT1Value()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    assertEquals(now, ntuple.t1Value(), "Not equal!");
   }


  /**
   * Test t2Value.
   */
  @Test
  /* default */ void testT2Value()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    assertEquals(position, ntuple.t2Value(), "Not equal!");
   }


  /**
   * Test t3Value.
   */
  @Test
  /* default */ void testT3Value()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    assertEquals(token, ntuple.t3Value(), "Not equal!");
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 2);
    final Token token1 = Token.of('X');
    final Token token2 = Token.of('O');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple1 = NTuple3.of(now, position1, token1);
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple2 = NTuple3.of(now, position1, token1);
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple3 = NTuple3.of(now, position2, token2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(ntuple1.hashCode(), ntuple2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(ntuple1.hashCode(), ntuple3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('B', 2);
    final Token token1 = Token.of('X');
    final Token token2 = Token.of('O');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple1 = NTuple3.of(now, position1, token1);
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple2 = NTuple3.of(now, position1, token1);
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple3 = NTuple3.of(now, position2, token2);
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple4 = NTuple3.of(now, position1, token1);

    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(ntuple1.equals(ntuple1), "ntuple11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(ntuple1.equals(ntuple2), "ntuple12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(ntuple2.equals(ntuple1), "ntuple21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(ntuple2.equals(ntuple4), "ntuple24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(ntuple1.equals(ntuple4), "ntuple14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(ntuple1.equals(ntuple3), "ntuple13 are equal"), //$NON-NLS-1$
      () -> assertFalse(ntuple3.equals(ntuple1), "ntuple31 are equal"), //$NON-NLS-1$
      () -> assertFalse(ntuple1.equals(null), "ntuple10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    final String result = ntuple.toString();
    assertEquals("NTuple3[object1=" + now.toString() + ", object2=Coordinate[row=1, column=1], object3=Token[token=X]]", result, "toString not equal");
   }

 }
