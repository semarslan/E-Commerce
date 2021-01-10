<template>
  <v-footer
      color="primary lighten-1"
      padless
  >
    <v-row
        justify="center"
        no-gutters
    >
      <v-btn
          color="white"
          text
          rounded
          class="my-2"
      >
        <strong><v-icon>mdi-store</v-icon>E-Commerce</strong>
      </v-btn>
      <v-col
          class="primary lighten-2 py-4 text-center white--text"
          cols="12"
      >
        {{ new Date().getFullYear() }}
      </v-col>
    </v-row>
  </v-footer>
</template>

<script>
export default {
  name: "Footer",
  data: () => ({
    links: [
      'Home',
      'About Us',
      'Team',
      'Services',
      'Blog',
      'Contact Us',
    ],
  }),
}
</script>

<style scoped>

</style>