package com.example.demo.src.hot;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/hot")
public class HotController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HotProvider hotProvider;
}
