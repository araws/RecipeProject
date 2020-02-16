package pl.antygravity.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.recipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
