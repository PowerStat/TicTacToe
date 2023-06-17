/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Player AI tests.
 */
public class PlayerAITest
 {
  /**
   * Default constructor.
   */
  public PlayerAITest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  public void constructor1()
   {
    final Token token = Token.of('X');
    final PlayerAI player = new PlayerAI("Test", token);
    assertNotNull(player, "Construtor failed!");
   }

 }
