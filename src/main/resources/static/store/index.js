import Vue from 'vue'
import Vuex from 'vuex'
import dic from "./modules/dic";
import general from "./modules/general";
import person from "./modules/person";
import listPerson from "./modules/listPerson";

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        dic,
        general,
        person,
        listPerson
    }
})
