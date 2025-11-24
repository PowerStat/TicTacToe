/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
