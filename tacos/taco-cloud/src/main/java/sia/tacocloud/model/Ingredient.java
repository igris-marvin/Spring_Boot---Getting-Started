package sia.tacocloud.model;

import lombok.Data; // <- provides common method for domain java classes at runtime 

@Data
public class Ingredient {
    
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
