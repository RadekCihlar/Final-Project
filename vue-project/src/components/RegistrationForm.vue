<script>
import { defineComponent } from "vue";
import { mapStores } from "pinia";
import { useAuthStore } from "@/store/auth";
import ErrorMessage from "@/components/ErrorMessage.vue";

export default defineComponent( {
  name: "RegistrationForm",
  components: { ErrorMessage },
  data() {
    return {
      registrationData: {
        username: '',
        password1: '',
        password2: ''
      },
      response: null,
      error: null,
    }
  },
  computed: {
    ...mapStores( useAuthStore ),
    valid() {
      const usernameValid = this.registrationData.username.length > 0;
      const passwordValid = this.registrationData.password1.length > 7
      const passwordRepeatValid = this.registrationData.password1 === this.registrationData.password2
      return usernameValid && passwordValid && passwordRepeatValid;
    },
  },
  methods: {
    register() {
      this.error = null;
      this.authStore.register( this.registrationData )
        .then( data => {
          window.location.replace( '/' ),
            localStorage.setItem( 'authStore', JSON.stringify( this.registrationData.username ) )
          this.authStore.currentUser = this.registrationData.username
          this.response = data;
        } )
        .catch( error => this.error = { message: "Account already exists" } )
    }
  }
} );
</script>

<template>
  <!-- <form @submit.prevent="register" v-if="!response">
    <fieldset>
      <label for="username">
        <span>Username</span>
        <input type="text" id="username" autocomplete="username" v-model="registrationData.username">
      </label>
      <ul>
        <li v-if="registrationData.username === ''">Username cannot be empty</li>
      </ul>

      <label for="password1">
        <span>Password</span>
        <input type="password" id="password1" autocomplete="new-password" v-model="registrationData.password1">
      </label>

      <label for="password2">
        <span>Password repeat</span>
        <input type="password" id="password2" autocomplete="new-password" v-model="registrationData.password2">
      </label>
      <ul>
        <li v-if="registrationData.password1 !== registrationData.password2">Passwords do not match</li>
        <li v-if="registrationData.password1.length < 8 || registrationData.password2.length < 8">Password needs to be
          atleast 8 characters long</li>
      </ul>

      <button type="submit" :disabled="!valid">Register</button>
    </fieldset>
  </form> -->

  <div class="overlay">
    <form @submit.prevent="register" v-if="!response">
      <header class="head-form">
        <h2>Registration</h2>
        <p>Register here using your username and password to gain full access to the page!</p>
      </header>
      <br>
      <div class="field-set">

        <span class="input-item">
          <i class="fa fa-user-circle"></i>
        </span>
        <input class="form-input" id="txt-input" type="text" placeholder="@UserName" v-model="registrationData.username"
          required>
        <br>


        <span class="input-item">
          <i class="fa fa-key"></i>
        </span>
        <input class="form-input" type="password" placeholder="Password" id="pwd" name="password"
          v-model="registrationData.password1" required>
        <span class="input-item">
          <i class="fa fa-key"></i>
        </span>
        <input class="form-input" type="password" placeholder="Password Repeated" id="pwdRepeated" name="password"
          v-model="registrationData.password2" required>
        <ul>
          <li v-if="registrationData.password1 !== registrationData.password2">Passwords do not match</li>
          <li v-if="registrationData.password1.length < 8 || registrationData.password2.length < 8">Password needs to be
            atleast 8 characters long</li>
          <li v-if="error?.message" :error="error">
            <ErrorMessage v-if="error?.message" :error="error" />
          </li>
        </ul>



        <br>
        <button class="log-in" type="submit" :disabled="!valid"> Register </button>
      </div>
    </form>
  </div>

</template>

<style scoped>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}


body {
  background-image: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);
  background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
  background-attachment: fixed;
  background-repeat: no-repeat;

  opacity: .95;
}


form {
  width: 450px;
  min-height: 500px;
  height: auto;
  border-radius: 5px;
  margin: 2% auto;
  box-shadow: 0 9px 50px hsla(20, 67%, 75%, 0.31);
  padding: 2%;
  background-image: url('../assets/menu.webp');
}

form .con {
  display: -webkit-flex;
  display: flex;

  -webkit-justify-content: space-around;
  justify-content: space-around;

  -webkit-flex-wrap: wrap;
  flex-wrap: wrap;

  margin: 0 auto;
}

header {
  margin: 2% auto 10% auto;
  text-align: center;
}

header h2 {
  font-size: 250%;
  font-family: 'Playfair Display', serif;
  color: #3e403f;
}

header p {
  letter-spacing: 0.05em;
}

input[class="form-input"] {
  width: 250px;
  height: 50px;

  margin-top: 2%;
  padding: 15px;

  font-size: 16px;
  font-family: 'Abel', sans-serif;
  color: #5E6472;

  outline: none;
  border: none;

  border-radius: 0px 5px 5px 0px;
  transition: 0.2s linear;

}

input[id="txt-input"] {
  width: 250px;
}

input:focus {
  transform: translateX(-2px);
  border-radius: 5px;
}

button {
  display: inline-block;
  color: #252537;

  width: 280px;
  height: 50px;

  padding: 0 20px;
  background: #fff;
  border-radius: 5px;

  outline: none;
  border: none;

  cursor: pointer;
  text-align: center;
  transition: all 0.2s linear;

  margin: 7% auto;
  letter-spacing: 0.05em;
}

.submits {
  width: 48%;
  display: inline-block;
  float: left;
  margin-left: 2%;
}

.frgt-pass {
  background: transparent;
}

.sign-up {
  background: #B8F2E6;
}


button:hover {
  transform: translatey(3px);
  box-shadow: none;
}

button:hover {
  animation: ani9 0.4s ease-in-out infinite alternate;
}

@keyframes ani9 {
  0% {
    transform: translateY(3px);
  }

  100% {
    transform: translateY(5px);
  }
}

li{
  color: white;
  margin-top: 2%;
}
</style>
