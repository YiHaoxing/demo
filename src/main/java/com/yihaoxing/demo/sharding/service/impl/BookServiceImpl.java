package com.yihaoxing.demo.sharding.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.yihaoxing.demo.sharding.dao.BookMapper;
import com.yihaoxing.demo.sharding.model.Book;
import com.yihaoxing.demo.sharding.service.BookService;
@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Book record) {
        return bookMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Book record) {
        return bookMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Book> list) {
        return bookMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Book> list) {
        return bookMapper.batchInsert(list);
    }

}
