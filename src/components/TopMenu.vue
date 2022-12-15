<script>
export default {

}
</script>
<template>
    <nav class="topMenu">
        <ul>
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
        </ul>
    </nav>
</template>
<style>
.topMenu {
    list-style: none;
    text-transform: uppercase;
    font-weight: 900;
    font-style: italic;
    font-size: 1rem;
    line-height:  0.7;
    margin: 0;
    padding: 0;
    text-align: center;
    box-shadow: 0px 1px 10px #000;
}
.topMenu li {
    display: inline;
}
.topMenu a {
    text-decoration: none;
    color: black;
    padding: 30px 30px;
    display: inline-block;
}
.topMenu a:hover {
    background-color: green;
    color: white;
}
</style>