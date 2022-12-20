<script>
import HeaderMain from './components/HeaderMain.vue';
import FooterMain from './components/FooterMain.vue';

export default {
  data() {
    return {};
  },
  methods: {},
  components: {
    HeaderMain,
    FooterMain,
  },
};
</script>
<template>
  <HeaderMain />
  <main>
    <body>
    <router-view></router-view>
    </body>
  </main>
  <FooterMain />
</template>
<style>

</style>