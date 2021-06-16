package com.tw.banking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;


class ConsoleTest {

  @Test
  void should_call_System_out_print_when_execute_printLine() {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bo));
    String printLine = "Hello world";

    // when
    Console console = new Console();
    console.printLine(printLine);

    // then
    assertTrue(bo.toString().contains(printLine));
  }
}