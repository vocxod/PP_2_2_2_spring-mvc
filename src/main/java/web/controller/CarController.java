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
public class CarController {

  private static final Logger logger = LogManager.getLogger(CarController.class);

  @GetMapping(value = "/car")
  public String printWelcome(ModelMap model) {
    LocalTime lt = LocalTime.now();
    List<String> cars = new ArrayList<>();
    cars.add("москвиТч");
    model.addAttribute("cars", cars);
    model.addAttribute("local_time", lt);
    logger.info("\u001B[1;33m Cars: {} \u001B[0m", cars);
    return "car";
  }

}
