<template>
<v-card class="pb-lg-12 mb-12">
  <v-app-bar class="overflow-hidden"
      absolute
      color="primary"
      elevate-on-scroll
      scroll-target="#scrolling-techniques-7"
  >
    <!--    <template v-slot:img="{ props }">-->
    <!--      <v-img-->
    <!--          v-bind="props"-->
    <!--          gradient="to top right, rgba(100,115,201,.7), rgba(25,32,72,.7)"-->
    <!--      ></v-img>-->
    <!--    </template>-->

    <v-toolbar-title @click="$router.push('/')" class="white--text p-4">
      <v-icon color="white">mdi-store</v-icon><h4>E-Commerce</h4>
    </v-toolbar-title>

    <v-toolbar-items>
      <v-btn text
             @click="$router.push('/')" color="white"> Home
      </v-btn>
        <v-btn text
                @click="$router.push('/products')" color="white"> Product List
        </v-btn>
        <v-btn text
               @click="$router.push('/details')" color="white"> Product Details
        </v-btn>
        <v-btn text
               @click="$router.push('/about')" color="white"> About
        </v-btn>
    </v-toolbar-items>

    <v-spacer></v-spacer>

    <v-item-group>
      <v-btn
          href="/"
          target="_blank"
          text
      >
        Kayıt Ol
      </v-btn>
      <v-btn
          href="/"
          target="_blank"
          text
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
</v-card>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      collapseOnScroll: true,
      links: [
        {text: "Home", route: '/'},
        {text: "Product List", route: '/products'},
        {text: "About", route: '/about'},
        {text: "Product Detail", route: '/detail'}
      ]
    }
  }
}
</script>

<style scoped>

</style>