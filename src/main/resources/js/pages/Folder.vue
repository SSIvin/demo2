<template>
    <div>
        <h1>Folder</h1>

        <v-btn
                color="indigo"
                @click="downloadPersons"
        >
            Find
        </v-btn>
    </div>

</template>

<script>
    export default {
        data() {
            return {}
        },
        methods: {
            downloadPersons() {
                this.$store.dispatch('GET_FILE')
            }
        }

    }
</script>

<style scoped>

</style>
