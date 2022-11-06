package cookbook.cookbook;

import java.util.List;
import java.util.Optional;

public class FilterDao implements FilterDao_Inter{
    @Override
    public Optional<Filter> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Filter> getAll() {
        return null;
    }

    @Override
    public void save(Filter filter) {

    }

    @Override
    public void update(Filter filter, String[] params) {

    }

    @Override
    public void delete(Filter filter) {

    }
}
