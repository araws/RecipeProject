package pl.antygravity.recipeproject.services;

import pl.antygravity.recipeproject.commands.RecipeCommand;
import pl.antygravity.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(long l);

    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
