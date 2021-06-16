package com.tw.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class PrinterTest {

  private List<Transaction> transactionList = new ArrayList<>();

  @Test
  void should_print_reverse_result_when_print_given_transaction_list() {
    // given
    transactionList.add(new Transaction("14/06/2021", 100));
    transactionList.add(new Transaction("16/06/2021", 300));
    transactionList.add(new Transaction("15/06/2021", 200));

    // mock
    Console console = mock(Console.class);
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    // when
    Printer printer = new Printer(console);
    printer.print(transactionList);

    // then
    verify(console, times(4)).printLine(captor.capture());
    List<String> printLineList = captor.getAllValues();
    assertEquals("DATE | AMOUNT | BALANCE", printLineList.get(0));
    assertEquals("16/06/2021 | 300 | 600", printLineList.get(1));
    assertEquals("15/06/2021 | 200 | 300", printLineList.get(2));
    assertEquals("14/06/2021 | 100 | 100", printLineList.get(3));
  }

  @Test
  void should_only_print_header_when_print_given_empty_transaction_list() {
    // give
    transactionList = new ArrayList<>();

    // mock
    Console console = mock(Console.class);
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

    // when
    Printer printer = new Printer(console);
    printer.print(transactionList);

    // then
    verify(console, times(1)).printLine(captor.capture());
    List<String> printLineList = captor.getAllValues();
    assertEquals("DATE | AMOUNT | BALANCE", printLineList.get(0));
  }

}