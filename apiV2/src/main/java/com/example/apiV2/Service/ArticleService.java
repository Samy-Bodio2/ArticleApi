package com.example.apiV2.Service;

import com.example.apiV2.Entity.Article;
import com.example.apiV2.Repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public List<Article> getArticles() {
       return articleRepository.findAll();
    }

    public Article getArticle(String Title) {
        Optional<Article> opArt = articleRepository.getArticleByTitle(Title);
        if(opArt.isEmpty()){
            throw new IllegalStateException("The article don't exists");
        }
        return  opArt.get();
    }

    public void CreateArticle(Article article) {
        Optional<Article> articleOptional = articleRepository.getArticleByTitle(article.getTitle());
        if(articleOptional.isPresent()){
            throw new IllegalStateException("The article already exists");
        }
        articleRepository.save(article);
        System.out.println("OPERATION REUSSI");
    }

    public List<Article> SearchArticles(String title) {
        return articleRepository.findAll().stream().filter(s ->{
            return s.getTitle().contains(title) || s.getContent().contains(title);
        }).collect(Collectors.toList());
    }
    @Transactional
    public void updateArticle(Long articleId, Article art) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if(optionalArticle.isEmpty()){
            throw new IllegalStateException(
                    "student with id "+articleId+" does not exists"
            );
        }
        optionalArticle.get().setAuthor(art.getAuthor());
        optionalArticle.get().setTitle(art.getTitle());
        optionalArticle.get().setContent(art.getContent());
        optionalArticle.get().setDate(art.getDate());
    }
    @Transactional
    public void deleteArticle(String articleId) {
        Optional<Article> OptArt = articleRepository.getArticleByTitle(articleId);
        if(OptArt.isEmpty()){
            throw new IllegalStateException(
                    "Article with id "+articleId+" does not exists"
            );
        }
        articleRepository.deleteByTitle(articleId);
    }
}
