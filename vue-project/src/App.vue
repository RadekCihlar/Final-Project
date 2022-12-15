<script>
import HeaderMain from './components/HeaderMain.vue';
import FooterMain from './components/FooterMain.vue';

/* import TestingStuff from './components/TestingStuff.vue';
import List from './components/List.vue';
import Cards from './components/Cards.vue';
import Tabs from './components/Tabs.vue';
import RegistrationForm from './components/RegistrationForm.vue';
import TodosJson from './components/TodosJson.vue';
import CardsView from './views/CardsView.vue';
 */

export default {
  data() {
    return {};
  },
  methods: {},
  components: {
    HeaderMain,
    FooterMain,
    /* TestingStuff,
    List,
    Cards,
    Tabs,
    RegistrationForm,
    TodosJson,
    CardsView */
  },
};
</script>
<template>
  <HeaderMain />
  <main>
    <router-view></router-view>

  </main>
  <FooterMain />
</template>
<style>

</style>