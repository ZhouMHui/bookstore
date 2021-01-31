<template>
    <div>
        <van-nav-bar :title="book.name" left-arrow right-text="..." @click-left="$router.go(-1)"></van-nav-bar>
        <div style="text-align:center" class="van-hairline--surround">
            <van-image :src="'/'+book.img"></van-image>
        </div>
        <van-card :price="book.price" :title="book.name" :desc="book.author"> 
            <template #tags>
                <div style="margin:3px 0px">
                <van-tag plain type="primary">{{book.publisher}}</van-tag>
                </div>
                <van-tag plan type="danger">{{book.category}}</van-tag>
            </template>
        </van-card>
        <van-cell>
            <p v-for="(p,index) in book.desc" :key="index">
                {{p}}
            </p>
        </van-cell>
        <div style="height: 3rem;"></div>
        <van-goods-action v-if="temp">
            <van-goods-action-icon icon="chat-o" text="客服" />
            <van-goods-action-icon icon="cart-o" text="购物车"/>
            <van-goods-action-icon icon="shop-o" text="店铺" />
            <van-goods-action-button
            type="danger"
            text="立即收藏"
            @click="onAddToCart"
            
        />
        </van-goods-action>
         <van-goods-action v-if="!temp">
            <van-goods-action-icon icon="chat-o" text="客服" />
            <van-goods-action-icon icon="cart-o" text="购物车"/>
            <van-goods-action-icon icon="shop-o" text="店铺" />
            <van-goods-action-button
            type="info"
            text="取消收藏"
            @click="cancelCart"
            
        />
        </van-goods-action>
    </div>
</template>

<script>
import network from "../network"

export default {
    data () {
        return {
            book:{},
            temp:true,
        }
    },
    components:{},
    computed:{},
    methods:{
        
        onAddToCart(){
            if(localStorage.getItem("token")==null){
            alert("尚未登录，请先登录");
            this.$router.push("/info");
            return;
           
        }
        network.addbook(this.$route.params.id,localStorage.getItem("id"));
            this.temp = false;
        },
       
        cancelCart(){
            network.deletebook(this.$route.params.id,localStorage.getItem("id"));
            this.temp = true;
        }
    },

    created:function(){
        let self = this;
        network.state(this.$route.params.id,localStorage.getItem("id"))
        .then(function(res){
            self.temp=res.data;
            if(localStorage.getItem("token")==null)self.temp=true;
        })

        network.get_book(this.$route.params.id)
        .then(function(res){
            self.book = res.data;
           if(self.book.description||""){
            self.book.desc = self.book.description.split("</br>")}
        })
     
    },
}
</script>

<style scoped>
</style>