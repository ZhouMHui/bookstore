package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookBriefVO;
import com.example.demo.entity.Category;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.BookService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2020-11-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BookMapper bookMapper;

    private List<BookBriefVO> copyVOFromBook(List<Book> pojo_list){
        List<BookBriefVO> vo_list = new ArrayList<BookBriefVO>(pojo_list.size());
        for( Book i : pojo_list ) {
            BookBriefVO vo = new BookBriefVO();
            vo.copyFromPojo(i);
            Category cat = categoryMapper.selectById(i.getCategory());
            vo.setCategory(cat.getName());
            vo_list.add(vo);
        }
        return vo_list;
    }

    public List<BookBriefVO> all() {
        //return copyVOFromBook(this.list());
        return bookMapper.listAll();
    }

    public IPage<BookBriefVO> listPage(int begin, int size){
        IPage<BookBriefVO> page = new Page<>(begin, size);
        return bookMapper.pageAll(page);
    }
}
