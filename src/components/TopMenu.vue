<script>
export default {

}
</script>
<template>
    <nav class="topMenu">
        <ul>
            <section id ="container">
            <li><router-link to="/">Home</router-link></li>
            <li><router-link to="/home">Home</router-link></li>
            <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
<!--        <li><router-link to="/tabs">Tabs</router-link></li>  or nize s cestoui/jmenem -->
            <li><router-link to="/articles">Articles</router-link></li>
            <li><router-link to="/articles">Links</router-link></li>
            <li><router-link to="/home">News</router-link></li>
            <li><router-link to="/home">About us</router-link></li>
            <li><router-link to="/home">Contact</router-link></li>
            <li><a href="https://duckduckgo.com/" target="_blank">DuckDuckGo</a></li>
            </section>
        </ul>
    </nav>
</template>
<style>
.topMenu {
    font-family: Arial, Helvetica, sans-serif;
    list-style: none;
    /* text-transform: uppercase; */
    font-weight: 900;
    line-height:  2.6;
    margin: -16px;
    padding: 0;
    text-align: center;
    /* box-shadow: 0px 1px 10px white; */
}
.topMenu li {
    display: inline;
}
.topMenu a {
    text-decoration: none;
    color: black;
    padding: 40px 20px;
    display: inline-block;
}
.topMenu a:hover {
    background-color: rgb(123, 166, 67);
    color: white;
}
#container {
    background-image: url('../assets/menu.webp');
}
a {
  transition: color 0.4s ease-in-out, box-shadow 0.3s ease-in-out;
}
a:hover {
  color: #fff;
  box-shadow: inset 200px 0 0 0 rgb(133, 166, 69);
}
</style>