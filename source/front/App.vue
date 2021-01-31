<template>
  <div id="app">
    <router-view/>
    <van-tabbar placeholder route v-model="active" v-if="$route.meta.showNav">
      <van-tabbar-item replace to="/" icon="home-o">主页</van-tabbar-item>
      <van-tabbar-item replace to="/cart" icon="star-o">收藏夹</van-tabbar-item>
      <van-tabbar-item replace to="/info" icon="manager">我的书城</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<style>
</style>
<script>
export default {
  data:function(){
    return {
      active:1,
    }
  },
}
</script>
