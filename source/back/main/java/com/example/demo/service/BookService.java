package com.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookBriefVO;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2020-11-21
 */
public interface BookService extends IService<Book> {

    public List<BookBriefVO> all();
    public IPage<BookBriefVO> listPage(int begin, int size);
}
