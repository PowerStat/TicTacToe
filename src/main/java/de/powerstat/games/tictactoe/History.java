/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.time.LocalDateTime;
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
    final var now = LocalDateTime.now();
    final NTuple3<LocalDateTime, Coordinate, Token> entry = NTuple3.of(now, position, token);
    int entryNr = 1;
    final Set<Integer> keys = this.history.keySet();
    if (!keys.isEmpty())
     {
      entryNr = Collections.max(keys).intValue() + 1;
     }
    this.history.put(entryNr, entry);
   }

 }
