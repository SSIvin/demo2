import Vue from 'vue'
import Vuex from 'vuex'
import dic from "./modules/dic.js";
import general from "./modules/general.js";
import person from "./modules/person.js";
import listPerson from "./modules/listPerson.js";

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        dic,
        general,
        person,
        listPerson
    }
})
