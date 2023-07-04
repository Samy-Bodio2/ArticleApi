package com.example.apiV2.Controller;

import com.example.apiV2.Entity.Article;
import com.example.apiV2.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }
    @GetMapping
    public List<Article> GetArticles(){
        return articleService.getArticles();
    }
    @GetMapping(path = "{articleTitle}")
    public Article GetArticle(@PathVariable("articleTitle") String title){
        return articleService.getArticle(title);
    }
    @GetMapping(path="search/{searchArticle}")
    public List<Article> SearchArticles(@PathVariable("searchArticle") String title){
        return articleService.SearchArticles(title);
    }
    @PostMapping
    public ResponseEntity<String> CreateArticle(@RequestBody Article article){
        articleService.CreateArticle(article);
        return ResponseEntity.ok("Insertion reussit");
    }
    @PutMapping(path = "{articleId}")
    public ResponseEntity<String> UpdateArticle(@PathVariable("articleId") Long articleId,@RequestBody Article art){
        articleService.updateArticle(articleId,art);
        return ResponseEntity.ok("Mise a jour reussit");
    }
    @DeleteMapping(path = "{articleId}")
    public ResponseEntity<String> DeleteArticle(@PathVariable("articleId") String articleId){
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok("Suppression reussit");
    }
}
