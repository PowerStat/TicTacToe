/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;


/**
 * Interface for players.
 */
public interface IPlayer
 {
  /**
   * Make a  move.
   *
   * @param board Board to make the move on
   */
  void makeMove(Board board);

  /**
   * Get players name.
   *
   * @return Name
   */
  String getName();

 }
