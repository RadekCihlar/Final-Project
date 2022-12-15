<script>
export default {

}
</script>
<template>
    <nav class="topMenu">
        <ul>
            <section id ="container">
            <li><router-link to="/"></router-link></li>
            <li><router-link to="/home">Home</router-link></li>
            <!-- <li><router-link :to="{ name: 'Tabs'}">Tabs</router-link></li> -->
            <li><router-link to="/articles">Articles</router-link></li>
            <li><router-link to="/articles">Categories</router-link></li>
            <li><router-link to="/home">News</router-link></li>
            <li><router-link to="/home">About us</router-link></li>
            <li><router-link to="/home">Contact</router-link></li>
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
    line-height:  4.6;
    margin: -16px;
    padding: 0;
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
.topMenu a:hover {
    background-color: rgb(123, 166, 67);
    color: white;
}
#container {
    background-image: url('../assets/menu.webp');
}
a {
  box-shadow: inset 0 0 0 0 rgb(115, 150, 63);
/*   padding: .25rem 0;
  margin: -.25rem 0; */
  transition: color .5s ease-in-out, box-shadow .25s ease-in-out;
}
a:hover {
  color: #fff;
  box-shadow: inset 50px 0 0 0 rgb(123, 166, 67);
}
</style>