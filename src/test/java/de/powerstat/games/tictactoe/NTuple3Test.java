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
import nl.jqno.equalsverifier.*;


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
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(NTuple3.class).withNonnullFields("object1", "object2", "object3").verify();
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
