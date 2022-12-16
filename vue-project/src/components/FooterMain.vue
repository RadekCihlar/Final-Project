<script>

export default {
     data() {
          return {
               hoverF: true,
               hoverI: true,
               hoverT: true,
               hoverY: true,
          };
     }
}
</script>

<template>
     <footer>
          <div class="row">
               <div class="column">
                    <div class="aboutUs">
                         <h4>About us</h4>
                         <p>We are small team of nice chaps that like some fine gardening and stuff :') </p>
                    </div>
               </div>
               <div class="column">
                    <h4>Navigation</h4>
                    <nav class="footerMenu">
                         <ul class="footerMenuList">
                              <li>
                                   <router-link class="navigationLinks" to="/">Home</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/articles">Articles</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/categories">Categories</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/news">News</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/aboutus">About us</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/contacts">Contacts</router-link>
                              </li>
                              <li>
                                   <router-link class="navigationLinks" to="/home">Contact</router-link>
                              </li>
                              <li>
                                   <a class="navigationLinks" href="https://duckduckgo.com/"
                                        target="_blank">DuckDuckGo</a>
                              </li>
                         </ul>
                    </nav>
               </div>
               <div class="column">
                    <div class="socialsContainer">
                         <h4>Socials </h4>
                         <ul class="socials">
                              <li @mouseover="hoverF = false" @mouseleave="hoverF = true">
                                   <a href="https://www.facebook.com/me" target="_blank">
                                        <img v-if="hoverF" class="icons" src="src/components/icons/Facebook.png"
                                             alt="Facebook Icon">
                                        <img v-else class="icons" src="src/components/icons/FacebookHover.png"
                                             alt="Facebook Icon">
                                   </a>
                              </li>
                              <li @mouseover="hoverI = false" @mouseleave="hoverI = true">
                                   <a href="https://www.instagram.com" target="_blank">
                                        <img v-if="hoverI" class="icons" src="src/components/icons/Instagram.png"
                                             alt="Instagram Icon">
                                        <img v-else class="icons" src="src/components/icons/InstagramHover.png"
                                             alt="Instagram Icon">
                                   </a>
                              </li>
                              <li @mouseover="hoverT = false" @mouseleave="hoverT = true">
                                   <a href="https://www.twitter.com" target="_blank">
                                        <img v-if="hoverT" class="icons" src="src/components/icons/Twitter.png"
                                             alt="Twitter Icon">
                                        <img v-else class="icons" src="src/components/icons/TwitterHover.png"
                                             alt="Twitter Icon">
                                   </a>
                              </li>
                              <li @mouseover="hoverY = false" @mouseleave="hoverY = true">
                                   <a href="https://www.youtube.com" target="_blank">
                                        <img v-if="hoverY" class="icons" src="src/components/icons/Youtube.png"
                                             alt="Youtube Icon">
                                        <img v-else class="icons" src="src/components/icons/YoutubeHover.png"
                                             alt="Youtube Icon">
                                   </a>

                              </li>
                         </ul>
                         <div class="copyright">&copy; 2022 Luky & Radek </div>
                    </div>

                    <!-- site map, social networks, legal stuff -->

               </div>
          </div>

     </footer>
</template>
<style scoped>
.aboutUs {
     padding-right: 20%;
}

.footerMenuList {
     column-count: 2;
     list-style: none;
     padding-left: 0;
     width: 50%;
     margin: 0 auto;
}

.navigationLinks {
     text-decoration: none;
     color: black;
     text-decoration-line: underline;
}
h4{
     text-align: center;
}

.navigationLinks:hover {
     color: grey;
}

.footerMenu {
     list-style: none;
}

.column {
     float: left;
     /* Bacha tady mi to může úteéct :() */
     width: 33.33%;
}

/* Clear floats after the columns */
.row:after {
     content: "";
     display: table;
     clear: both;
}

.icons {
     width: 35px;
     height: 35px;
     margin-right: 4px;
     
}

.socials {
     list-style: none;
     display: flex;
     flex-direction: row;
     padding-left: 0;
     justify-content: center;
}

.socialsContainer {
     background: none;
}

.icons:hover {
     cursor: pointer;
}

.copyright {
     color: white;
     float: right;
}
</style>