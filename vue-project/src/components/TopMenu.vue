<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";


export default defineComponent( {
    data() {
        return {
            searchTerm: "",
        }
    },
    computed: {
        ...mapStores( useAuthStore )
    }
},

);

</script>
<template>
    <p>{{ authStore.user }}</p>
    <nav class="topMenu">
        <ul v-if="!authStore.$state.isAuthenticated">
            <li><router-link to="/login">Login</router-link></li>
            <li><router-link to="/register">Sign up</router-link></li>
        </ul>
        <ul v-else>
            <li><router-link to="/logout">Logout</router-link></li>
        </ul>
        <section id="container">
            <ul>
                <li><router-link to="/"></router-link></li>
                <li><router-link to="/home">Home</router-link></li>
                <li><router-link to="/articles">Articles</router-link></li>
                <li><router-link to="/categories">Categories</router-link></li>
                <li><router-link to="/news">News</router-link></li>
                <li><router-link to="/AboutUs">About us</router-link></li>
                <li><router-link to="/Contact">Contact</router-link></li>

                <li class="search">
                    <input type="text" v-model="searchTerm">
                    <img @click="this.$router.push({
                        name: 'SearchArticles',
                        query: {
                            searchTerm: searchTerm,
                        }
                    }), this.searchTerm = ''" src="src/components/icons/searchIcon.png" alt="Search">
                </li>
            </ul>
        </section>
    </nav>
</template>
<style scoped>
.topMenu {
    font-family: Arial, Helvetica, sans-serif;
    list-style: none;
    font-weight: 900;
    line-height: 4.6;
    padding-left: 1px;
    text-align: center;
}

.topMenu li {
    display: inline;
}

.topMenu a {
    text-decoration: none;
    color: black;
    padding: 20px 20px;
    display: inline-block;
}

#container {
    background-image: url('../assets/menu.webp');
}

a {
    transition: color .4s ease-in-out, box-shadow .2s ease-in-oute;
}

ul {
    padding-left: 0;
    margin-top: 0;

}

a:hover {
    color: #fff;
    box-shadow: inset 0 0 0 0 rgb(123, 166, 67);
}

.search {
    flex: auto;
    justify-content: right;

}

img {
    width: 1%;
    height: 1%;
    margin-left: 3px;
    cursor: pointer;
}
</style>