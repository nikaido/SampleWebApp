package org.example.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.example.service.HogeService;

public class HelloControllerUnitTest {
  @Test
  void hello_returnsGreetingMessage() {
    // Arrange
    HogeService hogeService = Mockito.mock(HogeService.class);
    when(hogeService.getGreetingMessage("Hoge")).thenReturn("Hello, Hoge.");

    HelloController controller = new HelloController(hogeService);

    // Act
    Map<String, String> result = controller.hello("Hoge");

    // Assert
    assertEquals("Hello, Hoge.", result.get("message"));
  }

}
