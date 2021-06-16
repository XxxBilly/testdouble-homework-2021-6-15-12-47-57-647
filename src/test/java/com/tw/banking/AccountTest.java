package com.tw.banking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void should_call_addDeposit_of_transactionRepository_when_execute_deposit() {
    // mock
    TransactionRepository mockTransRepo = mock(TransactionRepository.class);

    // when
    Account account = new Account(mockTransRepo, new Printer(new Console()));
    account.deposit(1);

    // then
    verify(mockTransRepo, times(1)).addDeposit(1);
  }

  @Test
  void should_call_addWithdraw_of_transactionRepository_when_execute_withdraw() {
    // mock
    TransactionRepository mockTransRepo = mock(TransactionRepository.class);

    // when
    Account account = new Account(mockTransRepo, new Printer(new Console()));
    account.withdraw(1);

    // then
    verify(mockTransRepo, times(1)).addWithdraw(1);
  }

  @Test
  void should_call_print_of_printer_when_execute_printStatement() {
    // given
    List<Transaction> transactionList = Collections.singletonList(new Transaction("2021-6-16", 100));

    // mock
    TransactionRepository mockTransRepo = mock(TransactionRepository.class);
    Printer mockPrinter = mock(Printer.class);
    when(mockTransRepo.allTransactions()).thenReturn(transactionList);

    // when
    Account account = new Account(mockTransRepo, mockPrinter);
    account.printStatement();

    // then
    verify(mockPrinter, times(1)).print(transactionList);
  }
}