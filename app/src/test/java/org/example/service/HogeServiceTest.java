package org.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HogeServiceTest {
  @Test
  void getGreetingMessage_returnsFormattedMessage() {
    // Arrange
    HogeService service = new HogeService();

    // Act
    String result = service.getGreetingMessage("AAA");

    // Assert
    assertEquals("Hello, AAA.", result);
  }

}
