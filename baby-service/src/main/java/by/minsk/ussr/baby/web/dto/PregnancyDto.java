package by.minsk.ussr.baby.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PregnancyDto {
    private Integer id;
    @NotNull
    private int period;
    @NotNull
    private boolean isActive;
}
