package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class BookBriefVO {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String author;

    private Float price;

    private String img;



    private String category;
    
    private Integer category_id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", name=" + name +
        ", author=" + author +
        ", price=" + price +
        ", img=" + img +
        ", category=" + category +
        "}";
    }
    
    public void copyFromPojo( Book book ) {
    	this.id = book.getId();
    	this.name = book.getName();
    	this.author = book.getAuthor();
    	this.price = book.getPrice();
    	this.img = book.getImg();
    }
}
