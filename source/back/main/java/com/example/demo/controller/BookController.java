package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookBriefVO;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import com.sun.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/book")
@CrossOrigin(origins="http://localhost:8081")
public class BookController {
   // List<Book> list3= new ArrayList();
    @Autowired
    BookService bookService;

    @Autowired(required=false)
    BookMapper bookMapper;

    @GetMapping("/all")
    public Object getAll(){
         return bookMapper.booklist();
       // return bookMapper.listAll();
       // return bookService.list();
        //return bookService.all();
    }

    @GetMapping("/list")
    public Object listPage( int begin, int size ) {
        //return bookService.listPage(begin, size);
        IPage<Book> page = new Page<>(begin, size);
        return bookService.page(page);
    }

    @GetMapping("/getbook_categroy")

    public Object getbook_categroy(Integer category)
    {
       // List<Book> list=bookMapper.booklist();
       // List<Book> list2 = new ArrayList();
     //  for(Book c:list){
      //      if (c.getCategory().equals(category))
       //     {
       //         list2.add(c);
       //     }
     // }
        return bookMapper.getbook_categroy(category);
//return list2;
    }


    @GetMapping("/getbook_message")
    public Object getbook_message(Integer id)
    {
        List<Book> list=bookMapper.booklist();
        for(Book c:list){
            if (c.getId()==id)
            {
                return c;
            }
        }
        return list;
    }

    @GetMapping("/search")
    public Object search(String name) {
        return bookMapper.searchlist(name);
    }

   // @GetMapping("/addbook")

    //public Object addbook(Integer id)
   // {

       // int a=0;
      // List<Book> list=bookMapper.booklist();
       // for(Book c:list3){
       //     if (c.getId()==id)
        //    {
        //        a=1;
        //   }
        //}
        //for(Book c:list){
         //  if (c.getId()==id&&a==0)
         //   {
          //      list3.add(c);
          // }
       // }
      // return list3;

   // }

   // @GetMapping("/deletebook")

   // public Object deletebook(Integer id)
   // {
       // List<Book> list=bookMapper.booklist();

      //  for(Book c:list3){
      //      if (c.getId()==id)
      //      {
        //        list3.remove(c);
      //      }
      //  }
      //  return list3;

  //  }

    @GetMapping("search_collection")
    public Object search_collection(Integer user_id)
    {

        return bookMapper.userfavor(user_id);

    }

    @GetMapping("state")
    public boolean state(Integer book_id,Integer user_id)
    {
        for(Book c:bookMapper.userfavor(user_id)){
            if (c.getId()==book_id)
            {
                return false;
            }
        }
        return true;

    }

    @GetMapping("addbook")
    public Object addbook(Integer book_id,Integer user_id) {
        bookMapper.add_favor(book_id,user_id);
        return 0;
    }

    @GetMapping("deletebook")
    public Object deletebook(Integer book_id,Integer user_id) {
        bookMapper.delete_favor(book_id,user_id);
        return 0;
    }

    @GetMapping("searchdb")
    public Object search(Integer user_id) {
        return bookMapper.userfavor(user_id);

    }
}

