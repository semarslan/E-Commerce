<template>
  <v-app-bar
      app
      color="primary"
  >
    <div class="d-flex align-center">
      <v-btn
             color="white"
             text
             rounded

      >
        <v-icon>mdi-store</v-icon>
        E-Commerce
      </v-btn>
      <!--      <v-img
                alt="Vuetify Logo"
                class="shrink mr-2"
                contain
                src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
                transition="scale-transition"
                width="40"
            />-->
    </div>

    <v-spacer></v-spacer>

    <v-item-group>
      <v-btn
          href="/"
          target="_blank"
          text
          small
      >
        Kayıt Ol
      </v-btn>
      <v-btn
          href="/"
          target="_blank"
          text
          small
      >
        Giriş Yap
      </v-btn>
      <v-btn
          href="/"
          target="_blank"
          text
          small
      >
        <v-icon small>mdi-basket</v-icon>
      </v-btn>
    </v-item-group>
  </v-app-bar>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>