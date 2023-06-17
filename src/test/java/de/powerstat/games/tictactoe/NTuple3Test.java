/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

/**
 * NTuple 3 tests.
 */
public class NTuple3Test
 {
  /**
   * Default constructor.
   */
  public NTuple3Test()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  public void of1()
   {
    final LocalDateTime now = LocalDateTime.now();
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3<LocalDateTime, Coordinate, Token> ntuple = NTuple3.of(now, position, token);
    assertNotNull(ntuple, "Factory failed!");
   }

 }
