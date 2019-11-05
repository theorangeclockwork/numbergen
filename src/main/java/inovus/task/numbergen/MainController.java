package inovus.task.numbergen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class MainController {

    private final NumberService numberService;

    @Autowired
    public MainController(NumberService numberService) {
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
