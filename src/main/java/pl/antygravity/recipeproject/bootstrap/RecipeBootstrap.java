package pl.antygravity.recipeproject.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.antygravity.recipeproject.domain.*;
import pl.antygravity.recipeproject.repositories.CategoryRepository;
import pl.antygravity.recipeproject.repositories.RecipeRepository;
import pl.antygravity.recipeproject.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");

        if (!poundUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Find");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure teaSpoon = teaSpoonUomOptional.get();
        UnitOfMeasure tableSpoon = tableSpoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure poundUom = poundUomOptional.get();

        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        if (!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();

        //Perfect Guacamole
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilies. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Be careful handling chilies if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");

        guacamoleNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNotes);

        guacamoleRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(0.25), teaSpoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tableSpoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("serrano chilies, stems and seeds removed, minced", new BigDecimal(2), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tableSpoon, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("tomato, seeds and pulp removed, chopped", new BigDecimal(0.5), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Red radishes or jicama, to garnish", new BigDecimal(1), eachUom, guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("Tortilla chips, to serve", new BigDecimal(1), eachUom, guacamoleRecipe));

        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(guacamoleRecipe);

        //Caprese Pasta Salad
        Recipe capresePastaSaladRecipe = new Recipe();
        capresePastaSaladRecipe.setDescription("Caprese Pasta Salad");
        capresePastaSaladRecipe.setPrepTime(10);
        capresePastaSaladRecipe.setCookTime(15);
        capresePastaSaladRecipe.setDifficulty(Difficulty.EASY);
        capresePastaSaladRecipe.setDirections("1 Cook the pasta: Bring a large pot of water to boil and add 1 tablespoon of kosher salt. Add the pasta and cook according to package instructions, or until the pasta reaches al dente stage. If the pasta is too soft or overcooked, it will break apart when mixed with the other ingredients.\n" +
                "\n" +
                "2 Make the sauce: In a large serving bowl, stir together the oil, minced garlic, pepper, and ½ teaspoon kosher salt.\n" +
                "\n" +
                "3 Drain the pasta: When the pasta is done, drain it into a colander and tap it a few times to make sure you get most of the water off the pasta. Add the pasta to the bowl with the olive oil. Stir to coat.\n" +
                "\n" +
                "4 Bring it all together: While the pasta is cooling, slice the mozzarella in rounds, then tear those rounds into smaller pieces about the size of a nickel or a quarter, though they will range in shape and size. Don’t worry if the pasta isn’t completely cool. Just toss it a couple of times before you add the cheese. Add the torn cheese to the pasta. Slice the tomatoes in half, and tear the basil leaves, adding each as you go.\n" +
                "\n" +
                "5 To Serve: Give everything a quick stir to coat it in the olive oil, and you’re done! Serve cold, warm, or at room temperature.");

        Notes capresePastaSaladNotes = new Notes();
        capresePastaSaladNotes.setRecipeNotes("Fresh basil and tomatoes are always best served straight away, but life is life, and sometimes you have to make salads ahead of time. If that’s what’s happening in your world, we’ve got you covered!\n" +
                "\n" +
                "The oil will solidify once you store this salad in the refrigerator, and it will look weird and a little unappetizing. To make it presentation-worthy again, do the following:\n" +
                "\n" +
                "If you have leftovers you want to serve the next day: Just zap your refrigerated leftovers in the microwave for 30 seconds, and toss before you serve it for round two. That should be enough time to return the oil to a liquid state. If not, keep heating it gently, 15 seconds at a time.\n" +
                "If you want to take this to a picnic or a potluck: Then make the whole thing a day ahead of time, but wait to add the mozzarella. Keep the salad in the fridge. Zap it in the microwave following the instructions above, then add the torn mozzarella just before leaving for your get together.");

        capresePastaSaladNotes.setRecipe(capresePastaSaladRecipe);
        capresePastaSaladRecipe.setNotes(capresePastaSaladNotes);

        capresePastaSaladRecipe.getIngredients().add(new Ingredient("small shaped pasta, such as orecchiette, farfalle, or campanelle", new BigDecimal(0.5), poundUom, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(1), tableSpoon, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(0.5), teaSpoon, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(0.33), cupUom, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("garlic cloves, minced", new BigDecimal(4), eachUom, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("freshly ground pepper", new BigDecimal(1), teaSpoon, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("cherry or grape tomatoes, halved", new BigDecimal(1), poundUom, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("mozzarella, torn", new BigDecimal(8), ounceUom, capresePastaSaladRecipe));
        capresePastaSaladRecipe.getIngredients().add(new Ingredient("large fresh basil leaves, torn", new BigDecimal(10), eachUom, capresePastaSaladRecipe));

        capresePastaSaladRecipe.getCategories().add(italianCategory);

        recipes.add(capresePastaSaladRecipe);

        return recipes;
    }
}
