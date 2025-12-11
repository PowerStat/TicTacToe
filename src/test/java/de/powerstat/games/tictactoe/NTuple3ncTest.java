/**
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;


/**
 * NTuple 3 tests.
 */
final class NTuple3ncTest
 {
  /**
   * Default constructor.
   */
  NTuple3ncTest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testOf1()
   {
    final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3nc<LocalDateTime, Coordinate, Token> ntuple = NTuple3nc.of(now, position, token);
    assertNotNull(ntuple, "Factory failed!");
   }


  /**
   * Test t1Value.
   */
  @Test
  /* default */ void testT1Value()
   {
    final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3nc<LocalDateTime, Coordinate, Token> ntuple = NTuple3nc.of(now, position, token);
    assertEquals(now, ntuple.obj1(), "Not equal!");
   }


  /**
   * Test t2Value.
   */
  @Test
  /* default */ void testT2Value()
   {
    final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3nc<LocalDateTime, Coordinate, Token> ntuple = NTuple3nc.of(now, position, token);
    assertEquals(position, ntuple.obj2(), "Not equal!");
   }


  /**
   * Test t3Value.
   */
  @Test
  /* default */ void testT3Value()
   {
    final LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
    final Coordinate position = new Coordinate('A', 1);
    final Token token = Token.of('X');
    final NTuple3nc<LocalDateTime, Coordinate, Token> ntuple = NTuple3nc.of(now, position, token);
    assertEquals(token, ntuple.obj3(), "Not equal!");
   }

 }
