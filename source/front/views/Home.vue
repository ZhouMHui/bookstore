<template>
  <div class="home">
    <van-search placeholder="商品搜索" v-model="searchData" @search="search(searchData)"></van-search>
   
    <div class="swipe-container">
    <van-swipe :autoplay="5000">
      <van-swipe-item v-for="(image,index) in slider_images" :key="index">
        <img :src="'slider/'+image+'.jpg'" alt="">
      </van-swipe-item>
    </van-swipe>
    </div>
    <div>
      <van-grid :gutter="10" :column-num="3">
        <van-grid-item v-for="item in category" :key="item.id" icon="orders-o" :text="item.name" :class="{active:active_category==item.id}" @click="change_cat(item.id)"/>
      </van-grid>

      <van-list v-model="loading" :finished="finished" finished-text="没有了" @load="onLoad">
        <van-cell v-for="item in books" :key="item.id">
          <van-card class="vcard" :price="item.price" :title="item.name" :desc="item.author" :thumb="item.img" @click="book(item.id)">
            <template  #tags >
              <van-tag   plan type="danger"  >
             {{item.category}}
                

              </van-tag>
            </template>
          </van-card>
        </van-cell>
      </van-list>
    </div>
  </div>
</template>

<style>
  .my-swipe .van-swipe-item {
    font-size: 20px;
    line-height: 100px;
    text-align: center;
  }
  .swipe-container img{
    height: 200px;
    text-align:center;
  }
  .active{
    color:#1989fa;

  }
  .vcard{
    text-align:left;
  }
</style>

<script>

import network from "../network"
import axios from "axios"

export default {
  name: 'Home',
  data: function(){
    return {
      active_category:0,
      searchData:"",
      slider_images:[
        1,2,3,4,5
      ],
      category:[
      ],
      books:[],
      loading:false,
      finished:false,
    }
  },
  components: {
  },
  methods:{
    book: function(id){
      this.$router.push("/book/"+id);
    },
    change_cat : function(cat_id){
      this.active_category = cat_id;
      let self = this;
      if(cat_id==0)
      {
      network.get_bookmessage()
    .then(function(res){
      self.books = res.data;
    })
      };
      network.get_books_by_category(cat_id)
      .then(function(res){
        self.books = res.data;
      })
    },
    search : function(name){
      let self = this;
      network.get_books_by_name(name)
      .then(function(res){
        self.books = res.data;
      })
    },
    onLoad(){
    }
  },
  created:function(){
    let self = this;
    network.get_category()
    .then(function(res){
      self.category = res.data;
      self.category.unshift({id:0,name:"全部"});
    })
    network.get_bookmessage()
    .then(function(res){
      self.books = res.data;
    })
  }
}
</script>
