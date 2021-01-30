<template>
  <div>
    <v-container>
      <v-row>
        <v-card
            :loading="loading"
            class="mx-auto my-12"
            max-width="374"
            v-for="(item,index) in products" :key="index"
        >
          <v-col>
            <template slot="progress">
              <v-progress-linear
                  color="deep-purple"
                  height="10"
                  indeterminate
              ></v-progress-linear>
            </template>

            <v-img
                height="250"
                :src="item.image"
            ></v-img>

            <v-card-title>{{ item.name }}</v-card-title>
            <v-divider class="mx-4"></v-divider>
            <v-card-title>{{ item.description }}</v-card-title>
            <v-divider class="mx-4"></v-divider>
            <v-card-text>
              <v-row
                  align="center"
                  class="mx-0"
              >
              </v-row>

              <div>
                <v-list>
                  <v-list-item-title>Seller</v-list-item-title>
                  <v-btn
                      x-small
                      text
                      color="primary"
                      v-bind:href="item.seller.id"
                  >
                    {{ item.seller.name }}
                  </v-btn>
                  <v-list-item-title>Features</v-list-item-title>
                  {{ item.features }}
                </v-list>
              </div>
            </v-card-text>

            <v-divider class="mx-4"></v-divider>

            <v-card-title>Free Delivery:  {{ item.freeDelivery }}</v-card-title>
            <v-card-title>Delivery in : {{ item.deliveryIn }}</v-card-title>
            <v-card-title> {{ item.price }} {{ item.moneySymbol }}</v-card-title>
          </v-col>
          <v-col>
            <v-card-actions>
              <v-btn
                  color="deep-purple lighten-2"
                  @click="reserve"
                  small
              >
                Buy Now
                <v-icon small>mdi-credit-card-outline</v-icon>
              </v-btn>
              <v-btn
                  color="primary lighten-2"
                  @click="reserve"
                  small
              >
                Add To Cart
                <v-icon small>mdi-basket</v-icon>
              </v-btn>
            </v-card-actions>
          </v-col>

        </v-card>
      </v-row>
    </v-container>

  </div>

</template>

<script>
import {getAll} from "@/common/product-service";

export default {
  name: "ProductList",
  components: {},
  props: {},
  created() {
    this.getProducts();
  },
  data: () => ({
    loading: false,
    selection: 1,
    products: []
  }),

  methods: {

    getProducts() {
      getAll().then(response => {
        this.products = response.data;
      })
    },
    reserve() {
    },
  },
}
</script>