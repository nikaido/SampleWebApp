package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerIntegrationTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  void helloApiReturnsMessage() throws Exception {
    mockMvc.perform(get("/api/v1/hello/aa")).
    andExpect(status().isOk()).
    andExpect(jsonPath("$.message").value("Hello, aa."));
  }

}
