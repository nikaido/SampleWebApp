package org.example.controller;

import java.util.Map;

import org.example.service.HogeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private static final Logger log = LoggerFactory.getLogger(HelloController.class);
  private final HogeService hogeService;
  
  public HelloController(HogeService hogeService) {
    this.hogeService = hogeService;
  }
  
  @GetMapping("/api/v1/hello/{name}")
  public Map<String, String> hello(@PathVariable String name) {
    log.info("INFO LOG EXAMPLE.");
    return Map.of("message", hogeService.getGreetingMessage(name));
  }
}
