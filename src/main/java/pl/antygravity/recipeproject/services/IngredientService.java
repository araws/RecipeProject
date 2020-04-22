package pl.antygravity.recipeproject.services;

import pl.antygravity.recipeproject.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(long recipeId, long ingredientId);
}
