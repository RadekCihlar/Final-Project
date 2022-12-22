<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";


export default defineComponent( {
    data() {
        return {
            searchTerm: "",
            // This row lets us get information for loggedUsername
            loggedUsername: JSON.parse( localStorage.getItem( 'authStore' ) )
        }
    },
    computed: {
        ...mapStores( useAuthStore )
    },
    methods: {
        logout() {
            this.authStore.logout()
                .then( () =>
                    localStorage.removeItem( 'authStore' ),
                    this.$router.push( { path: '/' } ) )
        }
    }
},
);

</script>
<template>
    <nav class="topMenu">
        <section id="container">

            <ul>
                <li>
                    {{ authStore.isAuthenticated ? "Current username is: " + loggedUsername : "" }}
                </li>
                <li v-if="!authStore.$state.isAuthenticated" id="login"> <router-link to="/login">Login</router-link>
                </li>
                <li v-if="!authStore.$state.isAuthenticated" id="login"> <router-link to="/register">Sign
                        up</router-link></li>
                <li v-else id="login" @click="logout"><router-link to="/logout">Logout</router-link></li>
                <li><router-link to="/"></router-link></li>
                <li><router-link to="/home">Home</router-link></li>
                <li><router-link to="/articles">Articles</router-link></li>
                <li><router-link to="/categories">Categories</router-link></li>
                <li><router-link to="/gallery">Gallery</router-link></li>
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
#login {
    text-align: left;
}

.topMenu {
    font-family: Arial, Helvetica, sans-serif;
    list-style: none;
    font-weight: 900;
    line-height: 4.6;
    padding-left: 1px;
    text-align: center;
    top: 0;
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


ul {
    padding-left: 0;
    margin-top: 0;
}

#container {
    background-image: url('../assets/menu.webp');
}

.logo {
    background-image: url("src/assets/img/clover.png");
    width: 200px;
    height: 200px;
    background-size: contain;
    background-repeat: no-repeat;
    background-position: center;
}

a {

    transition: color .6s ease-in-out, box-shadow .2s ease-in-out;

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