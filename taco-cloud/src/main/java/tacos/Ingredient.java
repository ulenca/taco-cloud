package tacos;

import lombok.Data;

@Data
public class Ingredient {
	
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
		
	}

	
	public Ingredient (String id, String name, Type type) {
		
		this.id = id;
		this.name = name;
		this.type = type;
		
	}
	


	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}



	@Override
	public String toString() {
		return "Ingredient [name=" + name + "]";
	}
	
	

}
