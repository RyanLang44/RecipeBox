package com.qa.persistence.repository;

public interface RecipeRepository {
	
	String createRecipe(String recipe);
	
	String getAllRecipes();
	
	String getARecipe(Long id);
	
	String updateRecipe(String recipe, Long id);
	
	String deleteRecipe(Long id);

}
