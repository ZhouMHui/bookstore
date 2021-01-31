<template>
   <div>
        <van-nav-bar title="个人资料"/>
        <br />
         <div style="text-align: center;" >
             <van-image v-if="!(id > 0)" round width="10rem" height="10rem" src="icons/user.png" />

             <van-image v-if="id > 0"  round width="10rem" height="10rem" src="icons/cyx.jpg" />
            <h2 v-if="id > 0">
              你好：{{  username }}
              <div style="margin: 16px 72px;">
                <van-button round block type="info" @click="logout()">注销</van-button>
              </div>
            </h2>
         </div>
         <br />
         <br />
         <van-form @submit="onSubmit" v-if="!(id > 0)">
            <van-field
               v-model="username"
               name="用户名"
               label="用户名"
               placeholder="用户名"
               :rules="[{ required: true, message: '请填写用户名' }]"
            />
            <van-field
               v-model="password"
               type="password"
               name="密码"
               label="密码"
               placeholder="密码"
               :rules="[{ required: true, message: '请填写密码' }]"
            />
            <div style="margin: 16px;">
               <van-button round block type="info" native-type="submit">提交</van-button>
            </div>
         </van-form>


   </div>
   
</template>

<script>
import network from '../network'
export default {
   data: () => ({
     id: 0,
     username: "",
     password: "",
   }),
  methods: {
    onSubmit() {
       let self = this;
      network.user_login(self.username,self.password)
      .then(function(res) {
        if (res.data.id > 0)
        {
          localStorage.setItem("token",res.data.token);
          localStorage.setItem("username",res.data.username);
          localStorage.setItem("password",res.data.password);
          localStorage.setItem("id",res.data.id);
          self.id = res.data.id; 
    
        }
        else
        {
          alert("账号或密码有误");
        }
      });
    },
    logout() {
      this.id = 0;
      this.password = "";
  localStorage.removeItem("token");
  localStorage.removeItem("username");
  localStorage.removeItem("password");
   localStorage.removeItem("id");
    },
  },
  created:function() {
    let self = this;
    if(localStorage.getItem("token")!=null)
    {
self.username=localStorage.getItem("username");
self.password=localStorage.getItem("password");
self.id=localStorage.getItem("id");
    }
 
  }
}
</script>

<style scoped>
</style>