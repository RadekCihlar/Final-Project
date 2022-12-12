package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.Category;
import API.RestAPIGardening.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category updateCategoryById(long id, Category category);

    Category saveCategory(Category category);

    List<Category> findAll();

    Category findById(long id);

    void deleteById(long id);

    boolean existsById(long id);

    void deleteAll();
    }

