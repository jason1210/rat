<template>
  <div>
    <rat-header></rat-header>
    <hr/>
    <div>
      这是首页，嘻嘻嘻。
    </div>
    <hr/>
    <rat-footer></rat-footer>
  </div>
</template>

<script>
  import ratHeader from '@/components/common/RatHeader.vue'
  import ratFooter from '@/components/common/RatFooter.vue'

  export default {
    name: 'RatIndex',
    // ratHeader/ratFooter组件给申明到components里面然后在template里面使用
    components: { ratHeader, ratFooter }
  }
</script>
