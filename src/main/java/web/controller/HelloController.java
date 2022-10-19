package web.controller;

/*
Stage 4 
*/

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
public class HelloController {

  private static final Logger logger = LogManager.getLogger(HelloController.class);

  @GetMapping(value = "/hello")
  public String printWelcome(ModelMap model) {
    LocalTime lt = LocalTime.now();
    List<String> messages = new ArrayList<>();
    messages.add("I'm Spring MVC application");
    messages.add("5.3.14 version by oct'2022 ");
    messages.add("Now time is:" + lt.toString());
    model.addAttribute("messages", messages);
    logger.info("\u001B[32m messages: {} \u001B[0m", messages);
    return "index";
  }

}
