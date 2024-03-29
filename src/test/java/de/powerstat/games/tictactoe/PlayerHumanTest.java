/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Player human tests.
 */
final class PlayerHumanTest
 {
  /**
   * Default constructor.
   */
  /* default */ PlayerHumanTest()
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
    final PlayerHuman player = new PlayerHuman("Test", token);
    assertNotNull(player, "Construtor failed!");
   }

 }
