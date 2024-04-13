package sia.tacocloud.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data; // <- provides common method for domain java classes at runtime 

@Data
@Table
public class Ingredient implements Serializable {
    
    @Id
    private final String id;

    @Column
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
