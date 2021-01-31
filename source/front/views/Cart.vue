<template>
   <div>
      <van-nav-bar title="我的收藏"    >
         <template #right>
            <van-icon name="ellipsis" size="18" />
         </template>
      </van-nav-bar>
      <van-card class="vcard" v-for="item in books" :key="item.id" :price="item.price" :title="item.name" :desc="item.author" :thumb="item.img" @click="book(item.id)">
      <template #tags>
        <van-tag plan type="danger">{{item.category}}</van-tag>
      </template>
    </van-card>
   </div>
</template>

<script>
import network from "../network"
export default {
   data () {
      return {
         books:[],
      }
   },

   methods:{
      book:function(id){
         this.$router.push("/book/"+id);
    },

   },
  
   created:function(){
      if(localStorage.getItem("token")==null){
            alert("尚未登录，请先登录");
            this.$router.push("/info");
            return;
        }
      else{
      let _this = this;
      network.search_collection(localStorage.getItem("id"))
      .then(res => {
       _this.books = res.data;
      })
      }
   }
}
</script>
<style scoped>
</style>