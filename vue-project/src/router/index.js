import { createRouter, createWebHistory, useRoute } from "vue-router";
import { useAuthStore } from "@/store/auth";

import HomeView from "../views/HomeView.vue";
import ArticlesView from "../views/ArticlesView.vue";
import ArticlesSearchView from "../views/ArticlesSearchView.vue";
import PageNotFoundView from "../views/PageNotFoundView.vue";
import AboutUs from "../components/AboutUs.vue";
import Register from "../components/RegistrationForm.vue";
import Login from "../components/LoginForm.vue";
import Logout from "../components/LogoutButton.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/home",
    redirect: "/",
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/articles",
    name: "Articles",
    component: ArticlesView,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/ArticlesSearch",
    name: "SearchArticles",
    component: ArticlesSearchView,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: "/AboutUs",
    name: "AboutUsPage",
    component: AboutUs,
    meta: {
      requiresAuth: false,
    },
  },
  {
    name: "register",
    path: "/register",
    component: Register,
    meta: {
      requiresAuth: false,
    },
  },
  {
    name: "login",
    path: "/login",
    component: Login,
    meta: {
      requiresAuth: false,
    },
  },
  {
    name: "logout",
    path: "/logout",
    component: Logout,
    meta: {
      requiresAuth: true,
    },
  },
  /*   {
    name: "userList",
    path: "/user",
    component: UserList,
    meta: {
      requiresAuth: true,
    },
  },
  {
    name: "userInfo",
    path: "/user/:userId",
    component: UserInfo,
    props: (route) => ({ userId: Number(route.params.userId) }),
    meta: {
      requiresAuth: true,
    },
  },
  {
    name: "profile",
    path: "/profile",
    component: UserProfile,
    meta: {
      requiresAuth: true,
    },
  }, */
  {
    path: "/:patchMatch(.*)*",
    name: "404error",
    component: PageNotFoundView,
    meta: {
      requiresAuth: true,
    },
  },

  /*    { path: '/articles/:id', name: 'Article', component: ArticleView},*/
];
// const nelze po prirazeni menit referenci, muzeme pridavat, menit, nelze priradit znovu prvky celemu array
const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;

router.beforeEach((to, _) => {
  const authStore = useAuthStore();
  if (to.meta.requiresAuth && !authStore.isAuthenticated) {
    return { name: "login" };
  }
});
