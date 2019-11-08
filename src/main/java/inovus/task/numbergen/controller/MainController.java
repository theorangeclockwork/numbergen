package inovus.task.numbergen.controller;

import inovus.task.numbergen.service.impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class MainController {

    private final NumberServiceImpl numberService;

    @Autowired
    public MainController(NumberServiceImpl numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/random")
    public String getRandomNumber() {
        return numberService.getRandomAlphanumeric();
    }

    @GetMapping("/next")
    public String getNextNumber() {
        return numberService.getNextAlphanumeric();
    }


}
