package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeRepository repo;
	
	@Override
	public String addRecipe(String recipe) {
		// TODO Auto-generated method stub
		if(recipe.contains("onion")) {
			return "That's gross, dude. No onions.";
		}
		return repo.createRecipe(recipe);
	}

	
	public String getAllRecipes() {
		// TODO Auto-generated method stub
		return repo.getAllRecipes();
	}

	@Override
	public String getARecipe(Long id) {
		// TODO Auto-generated method stub
		return repo.getARecipe(id);
	}

	@Override
	public String updateRecipe(String recipe, Long id) {
		// TODO Auto-generated method stub
		return repo.updateRecipe(recipe, id);
	}

	@Override
	public String deleteRecipe(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteRecipe(id);
	}

	public void setRepo(RecipeRepository repo) {
		this.repo = repo;
	}
}
