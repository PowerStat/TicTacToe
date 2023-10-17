/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


/**
 * History interface.
 */
public interface IHistory
 {
  /**
   * Make history entry.
   *
   * @param position Position on board
   * @param token Token
   */
  void makeEntry(Coordinate position, Token token);

 }
