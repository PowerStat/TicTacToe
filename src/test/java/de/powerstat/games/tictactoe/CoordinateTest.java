/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertAll;
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
      /* final Coordinate position = */ new Coordinate('D', 1);
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
      /* final Coordinate position = */ new Coordinate('A', 0);
     }, "Illegal argument exception"
    );
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
