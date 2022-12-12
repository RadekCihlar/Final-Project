package API.RestAPIGardening.Service;

import API.RestAPIGardening.Model.Article;
import API.RestAPIGardening.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
//        return articleRepository.findAll();
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty()) {
            return null;
        }
        return articles;
    }

    @Override
    public Article getArticleByID(long id) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        Article article;

        if (optionalArticle.isPresent()) {
            article = optionalArticle.get();
        } else {
            throw new RuntimeException(id + "article does not exist.");
        }
        return article;
    }

    @Override
    public Article saveArticle(Article article) {
        this.articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticleById(long id) {
        this.articleRepository.deleteById(id);

    }

//    @Override
//    public List<Article> getArticlesByTitle(String title) {
//        return null;
//    }
}
