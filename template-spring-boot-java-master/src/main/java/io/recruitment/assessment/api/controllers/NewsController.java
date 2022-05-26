package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.DAO.NewsRepository;
import io.recruitment.assessment.api.model.News;
import io.recruitment.assessment.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @PostMapping("/addNews")
    public ResponseEntity<News> addNews(@RequestBody News news){
        return ResponseEntity.ok().body(this.newsRepository.save(news));
    }

    @PutMapping("/updateNews")
    public ResponseEntity<String> updateNews(@RequestBody News news , @RequestParam boolean isAdminLoggedIn){
        return ResponseEntity.ok().body(this.newsService.updateNews(news, isAdminLoggedIn));
    }

}
