<template>
  <div>
    <rat-header></rat-header>
    <hr/>
    <div class="code">
      用户名:<input type="text" v-model="loginInfoVo.username" placeholder="请输入用户名" />
      <br/>
      密码：<input type="password" v-model="loginInfoVo.password" placeholder="请输入密码" />
      <br/>
      验证码：<input type="password" v-model="loginInfoVo.code" placeholder="请输入密码" />
      <img  :src="vcodeUrl" width="116" height="36" @click="getVcode">
      <br/>
      <button v-on:click="login">登录</button>
      <br/>
      登录验证情况：<textarea cols="30" rows="10" v-model="responseResult"></textarea>
    </div>
    <hr/>
    <rat-footer></rat-footer>
  </div>
</template>

<script>
  import ratHeader from '@/components/common/RatHeader.vue'
  import ratFooter from '@/components/common/RatFooter.vue'

  export default {
    name: 'RatLogin',
    // ratHeader、ratFooter组件给申明到components里面然后在template里面使用
    components: { ratHeader, ratFooter },
    data () {
      return {
        loginInfoVo: { username: '', password: '' , code: '' },
        vcodeUrl: '',
        responseResult: []
      }
    },
    mounted: function() {
      this.getVcode(); //获取验证码
    },
    methods: {
      login () {
        console.log(this.loginInfoVo.username+";"+this.loginInfoVo.password+";"+this.loginInfoVo.code)
        this.$axios
          .post('/login', {
            username: this.loginInfoVo.username,
            password: this.loginInfoVo.password,
            code: this.loginInfoVo.code
          })
          .then(successResponse => {
            this.responseResult = JSON.stringify(successResponse.data)
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/index'})
            }
          })
          .catch(failResponse => {})
      },
      getVcode (){
        let baseSrc = this.$axios.defaults.baseURL + '/getVCode';
        this.vcodeUrl = baseSrc += '?' + Date.now();
      }
    }
  }
</script>
