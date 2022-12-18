import { createRouter, createWebHistory, useRoute} from "vue-router";

import HomeView from '../views/HomeView.vue';
import ArticlesView from '../views/ArticlesView.vue';
import GalleryView from '../views/GalleryView.vue';
import PageNotFoundView from '../views/PageNotFoundView.vue';

const routes = [
    { path: '/', name: 'Home', component: HomeView},
    { path: '/home', redirect: '/'},
    { path: '/articles', name: 'Articles', component: ArticlesView},
    { path: '/gallery', name: 'Gallery', component: GalleryView},
    { path: '/:patchMatch(.*)*', name: '404error', component: PageNotFoundView},

]
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router;