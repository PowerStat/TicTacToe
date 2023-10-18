/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertNotNull;

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

 }
