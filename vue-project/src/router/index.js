import { createRouter, createWebHistory, useRoute } from "vue-router";

import HomeView from "../views/HomeView.vue";
import ArticlesView from "../views/ArticlesView.vue";
import ArticlesSearchView from "../views/ArticlesSearchView.vue";
import PageNotFoundView from "../views/PageNotFoundView.vue";

/* import CardsView from '../views/CardsView.vue';*/

const routes = [
  
  { path: "/", name: "Home", component: HomeView },
  { path: "/home", redirect: "/" },
  { path: "/articles", name: "Articles", component: ArticlesView },
  {
    path: "/ArticlesSearch",
    name: "SearchArticles",
    component: ArticlesSearchView,
  },
  { path: "/:patchMatch(.*)*", name: "404error", component: PageNotFoundView },

  /*    { path: '/articles/:id', name: 'Article', component: ArticleView},*/
];
// const nelze po prirazeni menit referenci, muzeme pridavat, menit, nelze priradit znovu prvky celemu array
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;
