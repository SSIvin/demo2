import Vue from 'vue'
import VueRouter from 'vue-router'
import Persons from "../pages/Persons.vue";
import Folder from "../pages/Folder.vue";
import Find from "../pages/Find.vue";
import OsnPerson from "../pages/OsnPerson.vue";

Vue.use(VueRouter)

export default new VueRouter({
    routes: [
        {
            path: '/persons',
            component: Persons
        },
        {
            path: '/folder',
            component: Folder
        },
        {
            path: '/find',
            component: Find,
            name: 'find'
        },
        {
            path: '/message/edit/:id',
            component: OsnPerson,
            // props: true,
            name:'OsnPerson'
        },
        {
            path: '/message/add',
            component: OsnPerson,
            name:'addPerson'
        },
        {
            path: '*',
            component: Persons
        },
    ],
    mode: 'history'
})
