package sia.tacocloud.model;

import java.io.Serializable;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class IngredientRef implements Serializable {
    private final String ingredient;
}
