package com.example.demo.src.news;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final NewsDao newsDao;
    private final NewsProvider newsProvider;



}
