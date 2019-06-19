import Axios from 'axios'

export default {
    state: {
        listPersons: []
    },
    mutations: {
        SET_Persons(state, payLoad) {
            state.listPersons = payLoad
        }
    },
    getters: {
        listPersons: state => state.listPersons
    },
    actions:{
        async GET_personAction({commit}, data) {
            commit('SET_PROCESSING',true)
            await Axios.post('http://localhost:9001/api/find', data)
                .then(resp => {
                    commit('SET_Persons', resp.data);
                    commit('SET_PROCESSING',false)
                })
                .catch(function (error) {
                    commit('SET_PROCESSING',false)
                    commit('SET_ERROR',error.message)
                })
        },
    }


}
