package tacos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	private Date createdAt;
	
	@NotNull
	@Size(min=5, message="Name must be at leat 5 characters long")
	private String name;
	
	@NotNull(message="You must choose at least one ingredient")
	@Size(min=2, max=6, message="You should choose min 2 and max 6 ingrediends")
	private List<Ingredient> ingredients;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
