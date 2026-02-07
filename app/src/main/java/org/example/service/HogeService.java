package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class HogeService {
  public HogeService() {

  }

  public String getGreetingMessage(String name) {
    return String.format("Hello, %s.", name);
  }
}
