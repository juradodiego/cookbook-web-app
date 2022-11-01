import java.util.List;
import java.util.Optional;

public class RecipeDao implements RecipeDao_Inter{
    @Override
    public Optional<Recipe> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Recipe> getAll() {
        return null;
    }

    @Override
    public void save(Recipe recipe) {

    }

    @Override
    public void update(Recipe recipe, String[] params) {

    }

    @Override
    public void delete(Recipe recipe) {

    }
}
