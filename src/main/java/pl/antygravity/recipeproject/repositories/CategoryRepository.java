package pl.antygravity.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.antygravity.recipeproject.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
