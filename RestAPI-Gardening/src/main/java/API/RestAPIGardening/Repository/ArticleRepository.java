package API.RestAPIGardening.Repository;

import API.RestAPIGardening.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitle(String title);

    List<Article> findAllByTitleContainsIgnoreCase(String title);

    List<Article> findAllByCategoryId(long id);

    List<Article> findAllByOrderByIdDesc();
}


