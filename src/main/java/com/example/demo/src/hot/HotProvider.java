package com.example.demo.src.hot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotProvider {
    private final HotDao hotDao;
}
