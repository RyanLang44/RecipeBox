package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.RecipeService;

@Path("/recipe")
public class RecipeEndPoint {
	
	@Inject
	private RecipeService service;

	@Path("/getAllrecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllrecipes() {
		return service.getAllRecipes();
	}
	
	
	
	
	@Path("/getArecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public String getArecipe(@PathParam("id") Long id) {
		return service.getARecipe(id);
	}

	@Path("/createrecipe")
	@POST
	@Produces({ "application/json" })
	public String addrecipe(String recipe) {
		return service.addRecipe(recipe);
	}

	@Path("/deleterecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleterecipe(@PathParam("id") Long id) {
		return service.deleteRecipe(id);
	}

	public void setService(RecipeService service) {
		this.service = service;
	}


}
