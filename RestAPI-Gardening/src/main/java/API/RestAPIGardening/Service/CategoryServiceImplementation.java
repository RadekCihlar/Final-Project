package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.Category;
import API.RestAPIGardening.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category updateCategoryById(long id, Category category) {
        Category _category = findById(id);

        if (_category != null){
            _category.setName(category.getName());
            return _category;
        }
        return null;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()){
            return null;
        }
        return categories;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElse(null);
    }

    @Override
    public void deleteById(long id) {
    categoryRepository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void deleteAll() {
    categoryRepository.deleteAll();
    }

}
