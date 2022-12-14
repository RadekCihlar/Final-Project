package API.RestAPIGardening.Controller;

import API.RestAPIGardening.Model.Article;
import API.RestAPIGardening.Model.Category;
import API.RestAPIGardening.Service.ArticleService;
import API.RestAPIGardening.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {this.articleService = articleService;}

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles(@RequestParam(required = false) String title) {

        try {
            List<Article> articles = articleService.getAllArticles();

            if (articles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(articles, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/articles/newest")
    public ResponseEntity<List<Article>> findAllByOrderByIdDesc(){
        try{
            List<Article> articles = articleService.findAllByOrderByIdDesc();

            if (articles.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/articles/search/{searchTerm}")
    public ResponseEntity<List<Article>> getAllArticlesByTitle(@PathVariable("searchTerm") String searchTerm){
        try{
            List<Article> filteredArticles = articleService.findAllByTitleContainsIgnoreCase(searchTerm);

            if (filteredArticles.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(filteredArticles, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") long id) {
        Article article = articleService.getArticleById(id);

        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {

        try {

            Article _article = articleService.saveArticle(new Article(article.getTitle(),article.getIntroText(),article.getBodyText(), article.getOutroText(), article.getPostedDateTime(), article.getCategory()));

            return new ResponseEntity<>(_article, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable("id") long id, @RequestBody Article article) {
        Article toUpdateArticle = articleService.updateArticleById(id, article);

        if (toUpdateArticle != null) {
            return new ResponseEntity<>(articleService.saveArticle(toUpdateArticle), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> deleteArticleById(@PathVariable("id") long id) {

        try {
            articleService.deleteArticleById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories/{categoryId}/articles")
    public ResponseEntity <List<Article>> findAllArticlesByCategoryId(@PathVariable ("categoryId") long categoryId) {

        try {
            List<Article> articlesFromCategory = articleService.findAllArticlesByCategoryId(categoryId);

            if (articlesFromCategory.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(articlesFromCategory, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}