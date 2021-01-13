import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import vuetify from './plugins/vuetify';
import VueAxios from "vue-axios";
import axios from "axios";
import {BASE_URL} from "@/common/config";

Vue.config.productionTip = false
axios.defaults.baseURL = BASE_URL;
Vue.use(VueAxios, axios)
new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
