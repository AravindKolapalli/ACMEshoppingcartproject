package io.recruitment.assessment.api.serviceImpl;

import io.recruitment.assessment.api.DAO.NewsRepository;
import io.recruitment.assessment.api.model.News;
import io.recruitment.assessment.api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @Override
    public String addNews(String banner) {
        return "News Added Successfully by Admin";
    }

    @Override
    public String updateNews(News news, boolean isAdminLoggedIn) {

        if (isAdminLoggedIn) {
            news.setBanner(news.getBanner());
            newsRepository.save(news);
            return "updated successfully by Admin";
        } else {
            return "We can't update";
        }
    }
}
