package com.yihaoxing.demo.sharding.dao;

import com.yihaoxing.demo.sharding.model.Book;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertOrUpdate(Book record);

    int insertOrUpdateSelective(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int updateBatch(List<Book> list);

    int batchInsert(@Param("list") List<Book> list);
}