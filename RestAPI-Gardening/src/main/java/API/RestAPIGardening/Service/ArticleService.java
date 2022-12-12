package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleByID(long id);

    Article saveArticle(Article article);

    void deleteArticleById(long id);

//    List<Article> getArticlesByTitle(String title);

}
