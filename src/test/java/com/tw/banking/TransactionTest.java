package com.tw.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransactionTest {

  @Test
  void should_return_minus_1_when_compare_date_given_subsequent_transaction() {
    Transaction previousTrans = new Transaction("15/06/2021", 200);
    Transaction subsequentTrans = new Transaction("16/06/2021", 100);

    int result = previousTrans.compareTo(subsequentTrans);

    assertEquals(-1, result);
  }

  @Test
  void should_return_1_when_compare_date_given_previous_transaction() {
    Transaction previousTrans = new Transaction("15/06/2021", 200);
    Transaction subsequentTrans = new Transaction("16/06/2021", 100);

    int result = subsequentTrans.compareTo(previousTrans);

    assertEquals(1, result);
  }

  @Test
  void should_return_1_when_compare_date_given_same_date_transaction() {
    Transaction transaction1 = new Transaction("16/06/2021", 200);
    Transaction transaction2 = new Transaction("16/06/2021", 100);

    int result = transaction1.compareTo(transaction2);

    assertEquals(1, result);
  }
}