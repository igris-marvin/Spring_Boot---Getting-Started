package sia.tacocloud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Table
public class Taco implements Serializable {
    
    @Id
    private Long id;
    
    private Date createdAt = new Date();
    
    @NotNull
    @Size(min = 5, message = "Name must be atleast 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    private List<Ingredient> ingredients;
}