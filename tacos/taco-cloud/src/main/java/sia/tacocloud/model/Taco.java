package sia.tacocloud.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class Taco {
    
    @NotNull
    @Size(min = 5, message = "Name must be atleast 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    private List<Ingredient> ingredients;
}