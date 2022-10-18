package web.controller;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
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

  // private static Logger logger =
  // LoggerFactory.getLogger(HelloController.class);
  private static final Logger logger = LogManager.getLogger(HelloController.class);

  @GetMapping(value = "/hello")
  public String printWelcome(ModelMap model) {
    LocalTime lt = LocalTime.now();
    List<String> messages = new ArrayList<>();
    messages.add("\u0411\u0412\u0413\u0414\u0415\u0416\u0416");
    messages.add("здрасти, забор подкрасьте...");
    messages.add("I'm Spring MVC application");
    messages.add("5.3.14 version by oct'2022 ");
    messages.add("Now time is:" + lt.toString());
    model.addAttribute("messages", messages);
    logger.info("\u001B[1,32m messages: {} \u001B[0m", messages);
    /*
     * logger.debug("scard Debug log message");
     * logger.info("scard Info log message");
     * logger.error("scard Error log message");
     * logger.warn("scard Warn log message");
     * logger.fatal("scard Fatal log message");
     * logger.trace("scard Trace log message");
     */
    return "index";
  }

}
