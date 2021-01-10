<template>
  <div>
    <v-container>
      <v-row>
        <v-card
            :loading="loading"
            class="mx-auto my-12"
            max-width="374"
            v-for="(item,index) in items" :key="index"
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

          <v-card-title>{{ item.title }}</v-card-title>

          <v-card-text>
            <v-row
                align="center"
                class="mx-0"
            >
            </v-row>

            <div>Small plates, salads & sandwiches - an intimate setting with 12 indoor seats plus patio seating.</div>
          </v-card-text>

          <v-divider class="mx-4"></v-divider>

<!--          <v-card-title>{{item.freeDelivery}}</v-card-title>-->
        </v-col>
          <v-col>
            <v-card-actions>
              <v-btn
                  color="deep-purple lighten-2"
                  @click="reserve"
                  small
              >
                Buy Now <v-icon small>mdi-credit-card-outline</v-icon>
              </v-btn>
              <v-btn
                  color="primary lighten-2"
                  @click="reserve"
                  small
              >
                Add To Cart <v-icon small>mdi-basket</v-icon>
              </v-btn>
            </v-card-actions>
          </v-col>

        </v-card>
      </v-row>
    </v-container>

  </div>

</template>

<script>
export default {
  name : "Product",
  data: () => ({
    loading: false,
    selection: 1,
  }),

  computed:{
    items() {
      return [
        {
          'title' : 'title1',
          'image' : 'https://cdn.vuetifyjs.com/images/cards/cooking.png',
          'description' : 'description1',
          'seller' : 'seller1',
          'features' : 'feature1',
          'available' : 2,
          'freeDelivery' : true,
          'deliveryIn' : 'In 3 days',
          'price' : '5000'
        },
        {
          'title' : 'title2',
          'image' : 'https://cdn.vuetifyjs.com/images/cards/cooking.png',
          'description' : 'description1',
          'seller' : 'seller2',
          'features' : 'feature2',
          'available' : 2,
          'freeDelivery' : true,
          'deliveryIn' : 'In 3 days',
          'price' : '5000'
        }
      ]
    }
  },

  methods: {
    reserve () {
      this.loading = true

      setTimeout(() => (this.loading = false), 2000)
    },
  },
}
</script>