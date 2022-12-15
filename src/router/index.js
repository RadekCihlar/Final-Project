import { createRouter, createWebHistory, useRoute} from "vue-router";

/* import HomeView from '@/views/HomeView.vue'; */
import HomeView from '../views/HomeView.vue';
/* import CardsView from '../views/CardsView.vue';
import TabsView from '../views/TabsView.vue';
import ListView from '../views/ListView.vue';
import TodosJsonView from '../views/TodosJsonView.vue';
import TodoView from '../views/TodoView.vue';
import RegistrationFormView from '../views/RegistrationFormView.vue';
import TestingStuffView from '../views/TestingStuffView.vue'

import PageNotFoundView from '../views/PageNotFoundView.vue'; */

const routes = [
    { path: '/', name: 'Home', component: HomeView},
    { path: '/home', redirect: '/'},
   /*  { path: '/cards', name: 'Cards', component: CardsView},
    { path: '/tabs', name: 'Tabs', component: TabsView},
    { path: '/list', name: 'List', component: ListView},
    { path: '/todos', name: 'Todos', component: TodosJsonView},
    { path: '/todos/:id', name: 'Todo', component: TodoView},
    { path: '/users', name: 'Users', component: RegistrationFormView},
    { path: '/testing', name: 'Testing', component: TestingStuffView},

    { path: '/:patchMatch(.*)*', name: '404error', component: PageNotFoundView}, */

]
// const nelze po prirazeni menit referenci, muzeme pridavat, menit, nelze priradit znovu prvky celemu array
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router;