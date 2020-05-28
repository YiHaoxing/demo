package com.yihaoxing.demo.sharding.service;

import java.util.List;
import com.yihaoxing.demo.sharding.model.Book;
public interface BookService{


    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertOrUpdate(Book record);

    int insertOrUpdateSelective(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int updateBatch(List<Book> list);

    int batchInsert(List<Book> list);

}
