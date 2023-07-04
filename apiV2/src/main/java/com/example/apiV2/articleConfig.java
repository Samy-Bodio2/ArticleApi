package com.example.apiV2;

import com.example.apiV2.Entity.Article;
import com.example.apiV2.Repository.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class articleConfig {
    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository articleRepos) {
        return args -> {
            Article wimbledon = new Article(
                    "Wimbledon",
                    "Wimbledon est l'un des tournois de tennis les plus prestigieux et les plus anciens au monde." +
                            " C'est l'un des quatre tournois du Grand Chelem, les autres étant l'Open d'Australie," +
                            " Roland-Garros (Open de France) et l'US Open. Il se déroule chaque année à Wimbledon, un quartier de Londres," +
                            " au Royaume-Uni.",
                    "Samy Bodio",
                    LocalDate.now(),
                            "WimbledonWimbledon est l'un des tournois de tennis les plus prestigieux et les plus anciens au monde."
            );
            Article FootBall = new Article(
                    "Football",
                    "Le football est un sport collectif populaire impliquant deux équipes " +
                            "de onze joueurs cherchant à marquer des buts avec un ballon.",
                    "Samy Bodio",
                    LocalDate.now(),
                    "Football"+
                            "Le football est un sport collectif populaire impliquant deux équipes " +
                                    "de onze joueurs cherchant à marquer des buts avec un ballon."
            );
            articleRepos.saveAll(
                    List.of(FootBall,wimbledon)
            );
        };
    }
}
