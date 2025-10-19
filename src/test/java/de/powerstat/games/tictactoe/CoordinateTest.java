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


/**
 * Coordinate tests.
 */
final class CoordinateTest
 {
  /**
   * Default constructor.
   */
  /* default */ CoordinateTest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final Coordinate position = new Coordinate('A', 1);
    assertNotNull(position, "Construtor failed!");
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final Coordinate position = new Coordinate('D', 1);
     }, "Illegal argument exception"
    );
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final Coordinate position = new Coordinate('A', 0);
     }, "Illegal argument exception"
    );
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('A', 1);
    final Coordinate position3 = new Coordinate('B', 2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(position1.hashCode(), position2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(position1.hashCode(), position3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final Coordinate position1 = new Coordinate('A', 1);
    final Coordinate position2 = new Coordinate('A', 1);
    final Coordinate position3 = new Coordinate('B', 2);
    final Coordinate position4 = new Coordinate('A', 1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(position1.equals(position1), "position11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(position1.equals(position2), "position12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(position2.equals(position1), "position21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(position2.equals(position4), "position24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(position1.equals(position4), "position14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(position1.equals(position3), "position13 are equal"), //$NON-NLS-1$
      () -> assertFalse(position3.equals(position1), "position31 are equal"), //$NON-NLS-1$
      () -> assertFalse(position1.equals(null), "position10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Coordinate position = new Coordinate('A', 1);
    final String result = position.toString();
    assertEquals("Coordinate[row=1, column=1]", result, "toString not equal");
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Coordinate pos1 = new Coordinate('A', 1);
    final Coordinate pos2 = new Coordinate('A', 1);
    final Coordinate pos3 = new Coordinate('B', 2);
    final Coordinate pos4 = new Coordinate('C', 3);
    final Coordinate pos5 = new Coordinate('A', 1);
    final Coordinate pos6 = new Coordinate('A', 2);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos2) == -pos2.compareTo(pos1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos3) == -pos3.compareTo(pos1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((pos4.compareTo(pos3) > 0) && (pos3.compareTo(pos1) > 0) && (pos4.compareTo(pos1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && (Math.abs(pos1.compareTo(pos5)) == Math.abs(pos2.compareTo(pos5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && pos1.equals(pos2), "equals"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos6) != 0), "equal") //$NON-NLS-1$
    );
   }

 }
