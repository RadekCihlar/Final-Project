<template>


  <body>
    <div class="menu">
      <h1>Welcome page!</h1>
      <img class="center" style="height: 500px; width: 500px; position: inherit;" src="src/assets/img/clover.png" alt="logo" />
    </div>
  </body>
</template>
<style scoped>
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
/* img {
    -webkit-animation: mover 3s infinite alternate;
    animation: mover 3s infinite alternate;
    animation-play-state: paused;
} */
img:hover {
    -webkit-animation: mover 6s infinite alternate;
    animation: mover 6s infinite alternate;
}
@keyframes mover {
    0% { transform: rotate(0deg); }
    10% { transform: rotate(36deg); }
    100% { transform: rotate(36000deg); }

}
</style>

