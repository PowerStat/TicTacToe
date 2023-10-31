/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
 
 
/**
 * Module for PowerStat's tictctoe.
 */
open module de.powerstat.games.tictactoe
 {
  exports de.powerstat.games.tictactoe;

  // requires java.io;
  // requires java.nio;

  requires org.apache.logging.log4j;

  requires com.github.spotbugs.annotations;
  requires org.junit.jupiter.api;
  requires org.junit.platform.launcher;
  requires org.junit.platform.suite.api;
  requires io.cucumber.java;
  requires io.cucumber.junit.platform.engine;
  // requires nl.jqno.equalsverifier;

 }
