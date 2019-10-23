package by.minsk.ussr.baby.web.rest;

import by.minsk.ussr.baby.web.dto.PregnancyDto;
import by.minsk.ussr.baby.web.facade.PregnancyFacade;
import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pregnancy")
public class PregnancyController {

    private final PregnancyFacade pregnancyFacade;

    public PregnancyController(PregnancyFacade pregnancyFacade) {
        this.pregnancyFacade = pregnancyFacade;
    }

    @GetMapping
    public PregnancyDto activePregnancy() {
        return pregnancyFacade.findActive();
    }

    @PostMapping
    public PregnancyDto savePregnancy(@RequestBody PregnancyDto dto) {
        return pregnancyFacade.createPregnancy(dto);
    }

    @GetMapping("/all")
    public Collection<PregnancyDto> allPregnancies() {
        return pregnancyFacade.allPregnancies();
    }
}
