package com.example.demo.src.news;

import com.example.demo.src.news.model.GetNewRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
