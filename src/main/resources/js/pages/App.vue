<template>
    <v-app>
        <v-toolbar flat app>
            <v-toolbar-side-icon class="indigo--text"
                                 @click="drawer.open=!drawer.open"
            ></v-toolbar-side-icon>
            <v-toolbar-title class="text-uppercase grey--text">
                <span class="font-weight-light">Application</span>
            </v-toolbar-title>
            <v-btn flat
                   v-if="profile"
                   :disabled="$route.path === '/'"
                   @click="showMessages">
                Messages
            </v-btn>
            <v-spacer></v-spacer>
            <div v-if="profile">{{profile.name}}</div>
            <v-btn flat color="grey"
                   v-if="profile"
                   icon href="/logout"

            >
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-toolbar>

        <v-navigation-drawer
                class="indigo"
                app
                flat
                v-model="drawer.open"
        >
            <v-list>
                <v-list-tile
                        v-for="link in links"
                        :key="link.text"
                        :to="link.route"
                >
                    <v-list-tile-action>
                        <v-icon class="white--text">{{link.icon}}</v-icon>
                    </v-list-tile-action>
                    <v-list-tile-content>
                        <v-list-tile-title
                                class="white--text">{{link.text}}
                        </v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
        <v-content class="mx-4 mb-4">
        <router-view></router-view>
        </v-content>
    </v-app>
    <!--<div>-->
    <!--<router-view></router-view>-->
    <!--</div>-->
</template>

<script>
    // import Persons from "./pages/Persons.vue";

    export default {
        data() {
            return {
                drawer: {
                    fixed: false,
                    open: true
                },
                links: [
                    {
                        text: 'Persons',
                        icon: 'dashboard',
                        route: '/persons'
                    },
                    {
                        text: 'Folder',
                        icon: 'folder',
                        route: '/folder'
                    },
                    {
                        text: 'Find',
                        icon: 'person',
                        route: '/find'
                    }
                ]
            }
        },
        computed: {
            profile() {
                return this.$store.getters.getprofile
            }
        },
        methods: {
            showMessages() {

            }
        }
    }
</script>

<style scoped>

</style>
