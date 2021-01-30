import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import vuetify from './plugins/vuetify';
import VueAxios from "vue-axios";
import axios from "axios";
import {BASE_URL} from "@/common/config";
import router from './router/router'

Vue.config.productionTip = false
axios.defaults.baseURL = BASE_URL;
Vue.use(VueAxios, axios)
new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
