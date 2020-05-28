package com.yihaoxing.demo.test.sharding;

import com.yihaoxing.demo.sharding.model.Book;
import com.yihaoxing.demo.sharding.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author YiHaoxing
 * @date 2020/5/28 11:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void insertTest() {
        Book book = new Book();
        book.setUserId(30L);
        book.setName("张三");
        bookService.insert(book);
    }
}
