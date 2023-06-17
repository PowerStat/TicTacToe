/**
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.games.tictactoe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * History tests.
 */
public class HistoryTest
 {
  /**
   * Default constructor.
   */
  public HistoryTest()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  public void constructor1()
   {
    final History history = new History();
    assertNotNull(history, "Construtor failed!");
   }

 }
