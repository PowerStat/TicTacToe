/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Token tests.
 */
public class TokenTest
 {
  /**
   * Default constructor.
   */
  public TokenTest()
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
    assertNotNull(token, "Factory failed!");
   }

 }
