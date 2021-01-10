<template>
  <v-app>
    <Header/>
    <v-main>
      <Product/>
    </v-main>
    <Footer/>
  </v-app>
</template>

<script>
import Product from './components/Product';
import Header from "@/components/Header";
import Footer from "@/components/Footer";

export default {
  name: 'App',

  components: {
    Footer,
    Header,
    Product,
  },

  data: () => ({
    //
  }),
};
</script>
