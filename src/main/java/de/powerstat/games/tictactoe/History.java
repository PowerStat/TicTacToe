/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * History.
 */
public class History implements IHistory
 {
  /**
   * History map.
   */
  Map<Integer, NTuple3<LocalDateTime, Coordinate, Token>> history = new HashMap<>();


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
    final LocalDateTime now = LocalDateTime.now();
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
