<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";

export default defineComponent( {
  methods: {
    logout() {
      this.authStore.logout()
        .then( () =>
          localStorage.removeItem( 'authStore' ),
          this.$router.push( { path: '/' } ) )
    },
  },
  computed: {
    ...mapStores( useAuthStore )
  }
} );
</script>

<template>
  <p>Are you sure that you want to logout?</p>
  <button @click="logout" v-if="authStore.isAuthenticated">Logout</button>
</template>
<style scoped>

</style>
