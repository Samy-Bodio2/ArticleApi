package com.example.apiV2.Repository;

import com.example.apiV2.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public
interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a WHERE a.title = :title")
    Optional<Article> getArticleByTitle(String title);
    @Modifying
    @Query("DELETE FROM Article a WHERE a.title = :title")
    void deleteByTitle(String title);
}
