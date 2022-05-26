package io.recruitment.assessment.api.DAO;

import io.recruitment.assessment.api.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, String> {

    //String updateNews(News news, boolean isAdminLoggedIn);
}
