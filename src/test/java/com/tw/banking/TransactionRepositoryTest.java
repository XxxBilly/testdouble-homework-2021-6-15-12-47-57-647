package com.tw.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

  @Test
  void should_add_transaction_record_when_addDeposit() {
    Clock mockClock = mock(Clock.class);
    when(mockClock.todayAsString()).thenReturn("16/06/2021");

    TransactionRepository transRepo = new TransactionRepository(mockClock);
    List<Transaction> transactions = transRepo.allTransactions();

    assertEquals(0, transactions.size());
    transRepo.addDeposit(200);
    assertEquals(1, transactions.size());
    assertEquals("16/06/2021", transactions.get(0).date());
    assertEquals(200, transactions.get(0).amount());
  }

  @Test
  void should_add_transaction_record_and_deduce_amount_when_addWithdraw() {
    Clock mockClock = mock(Clock.class);
    when(mockClock.todayAsString()).thenReturn("16/06/2021");

    TransactionRepository transRepo = new TransactionRepository(mockClock);
    List<Transaction> transactions = transRepo.allTransactions();

    assertEquals(0, transactions.size());
    transRepo.addWithdraw(200);
    assertEquals(1, transactions.size());
    assertEquals("16/06/2021", transactions.get(0).date());
    assertEquals(-200, transactions.get(0).amount());
  }
}