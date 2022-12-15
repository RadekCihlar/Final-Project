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
                    <h4>About us:</h4>
                    <p>Sem se musím domluvit co zda něco nebo short about us: Jsme malej tým hodnej kluků </p>
               </div>
               <div class="column">
                    <h4>Navigation</h4>
                    <p>
                         Sem přidat další navigaci menší menu, aby se dalo přeskakovat
                    </p>
               </div>
               <div class="column">
                    <div class="socialsContainer">
                         <h4>Socials: </h4>
                         <ul class="socials">
                              <li @mouseover="hoverF = false" @mouseleave="hoverF = true">
                                   <img v-if="hoverF" class="icons" src="src/components/icons/Facebook.png"
                                        alt="Facebook Icon">
                                   <img v-else class="icons" src="src/components/icons/FacebookHover.png"
                                        alt="Facebook Icon">
                              </li>
                              <li @mouseover="hoverI = false" @mouseleave="hoverI = true">
                                   <img v-if="hoverI" class="icons" src="src/components/icons/Instagram.png"
                                        alt="Instagram Icon">
                                   <img v-else class="icons" src="src/components/icons/InstagramHover.png"
                                        alt="Instagram Icon">
                              </li>
                              <li @mouseover="hoverT = false" @mouseleave="hoverT = true">
                                   <img v-if="hoverT" class="icons" src="src/components/icons/Twitter.png"
                                        alt="Twitter Icon">
                                   <img v-else class="icons" src="src/components/icons/TwitterHover.png"
                                        alt="Twitter Icon">
                              </li>
                              <li @mouseover="hoverY = false" @mouseleave="hoverY = true">
                                   <img v-if="hoverY" class="icons" src="src/components/icons/Youtube.png"
                                        alt="Youtube Icon">
                                   <img v-else class="icons" src="src/components/icons/YoutubeHover.png"
                                        alt="Youtube Icon">
                              </li>
                         </ul>
                         <div>&copy; 2022 Luky & Radek </div>
                    </div>

                    <!-- site map, social networks, legal stuff -->

               </div>
          </div>

     </footer>
</template>
<style scoped>
.column {
     float: left;
/* Bacha tady mi to může úteéct :() */
     width: 30.33%;
     padding: 10px;
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