package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(long id);

    Article saveArticle(Article article);

    void deleteArticleById(long id);

    List<Article> findAllByTitleContainsIgnoreCase(String title);

    Article updateArticleById(long id, Article article);

    List<Article> findAllArticlesByCategoryId(long id);

    List<Article> findAllByOrderByIdDesc();
}
