package pl.antygravity.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.recipeproject.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
