package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

	private JdbcTemplate jdbc;
	
	@Autowired
	JdbcIngredientRepository(JdbcTemplate jdbc){
		this.jdbc=jdbc;
	}
	
	@Override
	public Ingredient findOne(String id) {

		return jdbc.queryForObject("select id, name, type from Ingredient from Ingredient where id=?", this::mapRowToIngredient, id);
		
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbc.update("insert into Ingredient (id, name, type) values (?,?,?)",
				ingredient.getId(),
				ingredient.getName(),
				ingredient.getType().toString());
		return ingredient;
	}

	@Override
	public Iterable<Ingredient> findAll() {
	
		return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
		
	}
	
	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(
			rs.getString("id"),
			rs.getString("name"),
			Ingredient.Type.valueOf(rs.getString("type")));
		}

}
