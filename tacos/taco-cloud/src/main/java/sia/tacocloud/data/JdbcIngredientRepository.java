package sia.tacocloud.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sia.tacocloud.model.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() { //return  a list of objects

        String sql = "SELECT id, name, type " + 
                     "FROM ingredient";

        Iterable<Ingredient> ingredients = jdbcTemplate.query(
            sql, 
            this::mapRowToIngredient
        );

        return ingredients;
    }
    
    @Override
    public Optional<Ingredient> findById(String id) { //return an object

        String sql = "SELECT id, name, type " + 
                     "FROM Ingredient " + 
                     "where id = ?";

        List<Ingredient> ingredients = jdbcTemplate.query(
            sql,
            this::mapRowToIngredient,
            id
        );

        return ingredients.size() == 0 ? //if results returned from the results is zero
            Optional.empty() :       // then return empty optional
            Optional.of(ingredients.get(0)); // else return first result 

    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException { //map each row to an object, recieves ResultSet and row number

        return new Ingredient(
            row.getString("id"),
            row.getString("name"),
            Ingredient.Type.valueOf(row.getString("type"))
        );

    }

    @Override
    public Ingredient save(Ingredient ingredient) {

        String sql = "INSERT INTO Ingredient (id, name, type) " + 
                     "VALUES (?, ?, ?)";

        jdbcTemplate.update( //inserting a row to a database
            sql,
            ingredient.getId(),
            ingredient.getName(),
            ingredient.getType().toString()
        );

        return ingredient;

    }
}