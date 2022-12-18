<script>
export default {

}
</script>
<template>
    <nav class="topMenu">
        <ul>
            <section id="container">
                <li><router-link to="/"></router-link></li>
                <li><router-link to="/home">Home</router-link></li>
                <li><router-link to="/articles">Articles</router-link></li>
                <li><router-link to="/articles">Categories</router-link></li>
                <li><router-link to="/gallery">Gallery</router-link></li>
                <li><router-link to="/home">News</router-link></li>
                <li><router-link to="/home">About us</router-link></li>
                <li><router-link to="/home">Contact</router-link></li>
            </section>
        </ul>
    </nav>
</template>
<style scoped>
.topMenu {
    font-family: Arial, Helvetica, sans-serif;
    list-style: none;
    /* text-transform: uppercase; */
    font-weight: 900;
    line-height: 4.6;
    padding-left: 0;
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

a {
    transition: color .6s ease-in-out, box-shadow .2s ease-in-out;
}

a:hover {
    color: #fff;
    box-shadow: inset 0 0 0 0 rgb(123, 166, 67);
}
</style>