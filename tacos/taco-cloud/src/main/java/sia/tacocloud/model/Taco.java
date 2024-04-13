package sia.tacocloud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Taco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Date createdAt = new Date();
    
    @NotNull
    @Size(min = 5, message = "Name must be atleast 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;
}