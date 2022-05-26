package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.model.News;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {

    public String addNews(String banner);

    public String updateNews(News news, boolean isAdminLoggedIn);

}
