<template>
    <h1>{{message}}</h1>
</template>
<script>
    export default {
        mounted: function() {
          this.fetchData();
        },
        data: function() {
            return {
                message: 'Looking for change '
            };
        },
        methods: {
            fetchData: function() {
                this.$http.get('/api/hello/msg').then((response) =>{
                  var data = response.body;
                console.log(data);
                this.message = data.apiresponse;

                });
            }
        }
    }
</script>