<template>
    <!--<v-form>-->
        <!--<v-container>-->
            <!--<v-layout row wrap>-->

                <!--<v-flex xs12 sm6>-->
                    <!--<v-text-field-->
                            <!--v-model="message1"-->
                            <!--label="Regular"-->
                            <!--clearable-->
                    <!--&gt;</v-text-field>-->
                <!--</v-flex>-->

                <!--<v-flex xs12 sm6>-->
                    <!--<v-text-field-->
                            <!--v-model="message2"-->
                            <!--solo-->
                            <!--label="Solo"-->
                            <!--clearable-->
                    <!--&gt;</v-text-field>-->
                <!--</v-flex>-->

                <!--<v-flex xs12 sm6>-->
                    <!--<v-text-field-->
                            <!--v-model="message3"-->
                            <!--box-->
                            <!--label="Box"-->
                            <!--clearable-->
                    <!--&gt;</v-text-field>-->
                <!--</v-flex>-->

                <!--<v-flex xs12 sm6>-->
                    <!--<v-text-field-->
                            <!--v-model="message4"-->
                            <!--label="Outline"-->
                            <!--outline-->
                            <!--clearable-->
                    <!--&gt;</v-text-field>-->
                <!--</v-flex>-->

            <!--</v-layout>-->
        <!--</v-container>-->
    <!--</v-form>-->
    <v-container fluid fill-height class="home-hero" style="max-height: 100vh;">
        <v-layout justify-center align-center column pa-5>
            <v-layout row wrap>

            <v-flex xs12 sm6>
            <v-text-field
            v-model="message1"
            label="Regular"
            clearable
            ></v-text-field>
            </v-flex>

            <v-flex xs12 sm6>
            <v-text-field
            v-model="message2"
            solo
            label="Solo"
            clearable
            ></v-text-field>
            </v-flex>

            <v-flex xs12 sm6>
            <v-text-field
            v-model="message3"
            box
            label="Box"
            clearable
            ></v-text-field>
            </v-flex>

            <v-flex xs12 sm6>
            <v-text-field
            v-model="message4"
            label="Outline"
            outline
            clearable
            ></v-text-field>
            </v-flex>

            </v-layout>
        </v-layout>
    </v-container>

</template>

<script>
    export default {
        data() {
            return {
                message1: 'Hey!',
                message2: 'Hey!',
                message3: 'Hey!',
                message4: 'Hey!'
            }
        }
    }
</script>

<style scoped>

</style>
