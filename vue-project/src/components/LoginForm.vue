<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import ErrorMessage from "@/components/ErrorMessage.vue";

export default defineComponent( {
  name: "LoginForm",
  components: { ErrorMessage },
  data() {
    return {
      user: {
        username: '',
        password: ''
      },
      error: null,
      isLoggedIn: false,
    }
  },
  methods: {
    /* login() {
      this.authStore.login( this.user )
        .then( () => this.authStore.currentUser = this.user,
          localStorage.setItem( 'authStore', JSON.stringify( this.user.username ) ) )
        .catch( error => this.error = { message: "Login failed." } )
        .then(
          this.$router.push( { path: '/' }, alert( "You have been logeed as: " + this.user.username ) ) )
    }, */
    login() {
      this.authStore.login( this.user )
        .then( () =>
          window.location.replace( '/' ),
          localStorage.setItem( 'authStore', JSON.stringify( this.user.username ) ),
        )
        .catch( error => this.error = { message: "Username or Password incorrect." } )
    },

  },
  computed: {
    ...mapStores( useAuthStore ),
    valid() {
      return this.user.username.length > 0 && this.user.password.length > 0;
    },
  },
}
);
</script>

<template>
  <p>To have full access to the page. Please log in!</p>
  <form @submit.prevent="login" v-if="!authStore.isAuthenticated">
    <fieldset>
      <label for="username">
        <span>Username</span>
        <input type="text" id="username" autocomplete="username" v-model="user.username">
      </label>

      <label for="password">
        <span>Password</span>
        <input type="password" id="password" autocomplete="current-password" v-model="user.password">
      </label>

      <button type="submit" :disabled="!valid">Login</button>
    </fieldset>
  </form>

  <ErrorMessage v-if="error?.message" :error="error" />


</template>

<style scoped>
fieldset {
  border: 0;
  flex: auto;
  justify-content: center;
}

fieldset>label {
  display: block;
  width: 10rem;
  margin-bottom: 1rem;
}

label>span {
  display: block;
  margin-bottom: 0.2rem;
}
</style>
