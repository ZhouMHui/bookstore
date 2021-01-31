package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookBriefVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2020-11-21
 */
public interface BookMapper extends BaseMapper<Book> {
    @Select("SELECT a.id,a.name,a.price,a.author,a.img, b.name category from book a, category b where a.category = b.id")
    List<BookBriefVO> listAll();

    @Select("SELECT a.id,a.name,a.price,a.author,a.img, b.name category from book a, category b where a.category = b.id and b.id = #{categoryId} ")
     List<BookBriefVO> getbook_categroy(int categoryId);

    @Select("SELECT a.id,a.name,a.price,a.author,a.img, b.name category from book a, category b where a.category = b.id")
    IPage<BookBriefVO> pageAll(IPage<BookBriefVO> page);

    @Select("select a.id, a.name, a.author, a.publisher, a.price, a.img,a.description, b.name category from book a, category b where a.category = b.id ")
     List<Book> booklist();

    @Select("INSERT into favor(book_id,user_id) values (#{book_id},#{user_id})")
    Object add_favor(Integer book_id,Integer user_id);

    @Select("DELETE from favor where book_id=#{book_id} and user_id=#{user_id}")
    Object delete_favor(Integer book_id,Integer user_id);

    @Select("select  a.id,a.name,a.price,a.author,a.img, b.name category \n" +
            "from book a, category b, favor c\n" +
            "where a.category = b.id and c.book_id = a.id and c.user_id = #{user_id}")
    List<Book> userfavor(Integer user_id);

    @Select("SELECT a.id,a.name,a.price,a.author,a.img, b.name category from book a, category b \n" +
            "where a.category = b.id and a.name like concat(\"%\", #{name}, \"%\");")
    List<BookBriefVO> searchlist(String name);
}
