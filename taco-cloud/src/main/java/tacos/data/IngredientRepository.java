package tacos.data;

import tacos.Ingredient;

public interface IngredientRepository {

	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);
	Iterable<Ingredient> findAll();
	
}
