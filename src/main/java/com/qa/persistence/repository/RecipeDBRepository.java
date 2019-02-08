package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Recipe;
import com.qa.business.service.RecipeService;
import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class RecipeDBRepository implements RecipeRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	

	@Override
	public String createRecipe(String recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllRecipes() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM Recipe a");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();
		return util.getJSONForObject(recipes);
	}

	@Override
	public String getARecipe(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	@Override
	public String updateRecipe(String recipe, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRecipe(Long id) {
		// TODO Auto-generated method stub
		Recipe recipeInDB = util.getObjectForJSON(getARecipe(id), Recipe.class);
		
		if (manager.contains(manager.find(Recipe.class, id))) {
			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"recipe successfully deleted\"}";
	}
	
	public void setManager(EntityManager manage) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
