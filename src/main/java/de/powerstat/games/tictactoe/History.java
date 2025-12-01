/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.games.tictactoe;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * History.
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
public class History implements IHistory
 {
  /**
   * History map.
   */
  private final Map<Integer, NTuple3<LocalDateTime, Coordinate, Token>> history = new ConcurrentHashMap<>();


  /**
   * Default constructor.
   */
  public History()
   {
    super();
   }


  /**
   * Make history entry.
   *
   * @param position Board position
   * @param token Players token
   */
  @Override
  public void makeEntry(final Coordinate position, final Token token)
   {
    final var now = LocalDateTime.now(ZoneId.systemDefault());
    final NTuple3<LocalDateTime, Coordinate, Token> entry = NTuple3.of(now, position, token);
    int entryNr = 1;
    final Set<Integer> keys = history.keySet();
    if (!keys.isEmpty())
     {
      entryNr = Collections.max(keys).intValue() + 1;
     }
    history.put(entryNr, entry);
   }

 }
