package com.example.demo.src.news;

import com.example.demo.config.BaseException;
import com.example.demo.src.news.model.GetNewRes;
import com.example.demo.src.news.model.News;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
@Service
@RequiredArgsConstructor
public class NewsProvider {
    private final NewsDao newsDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GetNewRes> getNews() {

            List<GetNewRes> getNewRes = newsDao.getNews();
            return getNewRes;


    /*public List<GetNewRes> getNews() throws BaseException {
        try{
            List<GetNewRes> getNewRes = newsDao.getNews();
            return getNewRes;
        }
        catch(Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }*/
    }
}
