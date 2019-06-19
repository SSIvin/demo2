<template>
    <div class="edit container">
        <v-label>{{lableTitle}}</v-label>
        <form v-on:submit="updateItem">
            <div>Дело:{{person.id}}</div>
            <div class="col-md-12 mt-3">
                <!--Дело №: {{find.id}}-->
                <h4></h4>
                <div
                        class="form-group"
                >
                    <label>Фамилия</label>
                    <input type="text" class="form-control" placeholder="Фамилия" v-model="person.f">
                </div>
                <div class="form-group">
                    <label>Имя</label>
                    <input type="text" class="form-control" placeholder="Имя" v-model="person.i">
                </div>
                <div class="form-group">
                    <label>Отчество</label>
                    <input type="text" class="form-control" placeholder="Отчество" v-model="person.o">
                </div>
                <v-flex xs-6 pr-5>

                    <v-menu ref="BirthDateMenuRef"
                            v-model="BirthDateMenuVisibility" :close-on-content-click="false"
                            :nudge-right="40" lazy transition="scale-transition" offset-y full-width
                            min-width="290px">
                        <v-text-field slot="activator" v-model="BirthDateLocal" label="Дата рождения"
                                      prepend-icon="event" readonly></v-text-field>
                        <v-date-picker v-model="BirthDateLocal"
                                       no-title @input="$refs.BirthDateMenuRef.save(BirthDateLocal);"
                        >

                        </v-date-picker>
                    </v-menu>
                </v-flex>
                <v-flex xs3>
                    <v-select
                            label="Место работы"
                            browserAutocomplete="off"
                            item-text="name"
                            item-value="id"
                            :items="getplace_job"
                            v-model="person.placeJob">
                    </v-select>
                </v-flex>
            </div>
            <v-btn
                    @click.prevent="updateItem"
                    class="btn btn-primary"
                    flat=""
            > {{buttonTitle}}
            </v-btn>
            <v-btn
                    :to="{name:'find'}"
                    type="button"
                    class="btn btn-primary"
                    flat=""
            >Close
            </v-btn>
            <v-btn
                    @click.prevent=""
                    class="btn btn-primary"
                    flat=""
            > get
            </v-btn>

            <v-btn
                    @click="settest"
                    class="btn btn-primary"
                    flat=""
            > get2
            </v-btn>

        </form>
    </div>
</template>

<script>
    import {mapState,mapGetters} from 'vuex';

    export default {
        props: ['id'],
        data() {
            return {
                BirthDateMenuVisibility: false,
            }
        },
        methods: {
            updateItem() {
                if (this.person.id != 0) {
                    this.$store.dispatch('updateMessageAction', this.person);
                    console.log('save');
                } else {
                    const newperson = {
                        f: this.person.f,
                        i: this.person.i,
                        o: this.person.o,
                    }
                    this.$store.dispatch('CreateMessageAction', newperson);
                    console.log('add person');
                }

                this.$router.push({name: 'find'});
            },
            settest() {

                console.log(this.listPersonOne.f)
            }

        },
        destroyed() {
            this.$store.commit('CLEAR_PERSON');
        },

        mounted() {

            if (this.$route.params.id) {
                this.$store.dispatch('GET_PLACE_JOB');
                this.$store.dispatch('GET_personOneAction', this.$route.params.id);


            }
        },
        computed: {
            ...mapState({
                person: state => state.person.listPersonOne
            }),
            ...mapGetters(['getplace_job']),
            // place() {
            //     return this.person.placeJob;
            // },
            // personOsn() {
            //     return this.$store.getters.getPersonOne
            // },

            BirthDateLocal: {
                get() {
                    return this.person.id?this.person.birthday:"";
                },
                set(newValue) {
                    console.log('BirthDateLocal Setter: ' + newValue);
                    this.person.birthday = newValue
                    //this.$store.dispatch('update_currentEntity_byEntityPropertyContainer', {collectionId:this.componentCollectionId,propertiesObject:{BirthDate: newValue}});
                },
            },
            lableTitle() {

                return this.person.id ? 'Редактирование' : 'Новое дело'
            },
            buttonTitle() {
                return this.person.id ? 'Save' : 'Create'
            }
        }
    }
</script>

<style scoped>

</style>

