package web.controller;

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
public class StartController {

  private static final Logger logger = LogManager.getLogger(StartController.class);

  @GetMapping(value = "/")
  public String printWelcome(ModelMap model) {
    LocalTime lt = LocalTime.now();
    List<String> messages = new ArrayList<>();
    messages.add("\u0411\u0412\u0413\u0414\u0415\u0416\u0416");
    messages.add("Start task PP_2_2_2 page.");
    messages.add("Now time is:" + lt.toString());
    model.addAttribute("messages", messages);
    logger.info("\u001B[1,33m Start page message: {} \u001B[0m", messages);
    return "start";
  }

}
