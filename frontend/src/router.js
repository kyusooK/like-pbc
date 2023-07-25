
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LikeLikeManager from "./components/listers/LikeLikeCards"
import LikeLikeDetail from "./components/listers/LikeLikeDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/likes/likes',
                name: 'LikeLikeManager',
                component: LikeLikeManager
            },
            {
                path: '/likes/likes/:id',
                name: 'LikeLikeDetail',
                component: LikeLikeDetail
            },



    ]
})
