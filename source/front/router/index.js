import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      showNav:true,
    }
  },
  {
    path: '/cart',
    name: 'Cart',
    component: () => import('../views/Cart.vue'),
    meta: {
      showNav:true,
    },
  },
  {
    path: '/info',
    name: 'Info',
    component: () => import('../views/Info.vue'),
    meta: {
      showNav:true,
    },
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue'),
    meta: {
      showNav:true,
    },
  },
  {
    path: '/book/:id',
    name: 'Book',
    component: () => import('../views/Book.vue'),
    meta:{
      showNav:false,
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
