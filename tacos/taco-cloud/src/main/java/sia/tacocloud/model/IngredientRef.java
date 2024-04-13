package sia.tacocloud.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class IngredientRef implements Serializable {
    private final String ingredient;
}
