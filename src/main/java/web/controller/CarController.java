package web.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.time.LocalTime;

import web.model.Car;
import web.service.CarService;

@Controller
public class CarController {

  private static final Logger logger = LogManager.getLogger(CarController.class);

  @Autowired
  private CarService carService;

  @GetMapping(value = "/cars")
  public String showCarList(@RequestParam(required = false) String count,
      ModelMap model) {
    LocalTime lt = LocalTime.now();
    int show = 0;
    int showCount = 0;
    String message = "";
    try {
      if (count == null || Integer.parseInt(count) > 5) {
        showCount = Integer.MAX_VALUE;
        message = "Все авто";
      } else if (Integer.parseInt(count) > 0 && Integer.parseInt(count) < 6) {
        showCount = Integer.parseInt(count);
        message = "Первые " + count + " авто";
      } else if (Integer.parseInt(count) < 0) {
        showCount = 0;
        message = "Значение count только ПОЛОЖИТЕЛЬНОЕ число!";
      }
    } catch (Exception e) {
      // Show nothing
      message = "Ошибка обработки параметра count:" + e.getMessage() + " допускаются только "
          + "положительные числа";
      showCount = 0;
    }
    List<Car> cars = null;
    if (showCount > 0 && showCount < 6) {
      cars = carService.getCars();
    } else if (showCount == Integer.MAX_VALUE) {
      cars = carService.getCars(showCount);
    }
    model.addAttribute("message", message);
    model.addAttribute("cars", cars);
    model.addAttribute("local_time", lt);
    logger.info("\u001B[1;33m Cars: {} \u001B[0m", cars);
    return "cars";
  }

}
