package com.yihaoxing.demo.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/31 22:19
 */
@Component
public class AService {
    @Autowired
    private BService bService;
}
