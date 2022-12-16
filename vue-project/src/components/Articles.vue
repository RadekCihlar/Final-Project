<script>
export default {
    data() {
        return {
            articles: [],
            totalArticles: 0
        };
    },
    methods: {
        async getArticles() {
            // fetch od Axios
            try {
                // Fetch returns a promise (assynchronous)
                let response = await fetch( 'http://localhost:8080/api/articles' );
                this.articles = await response.json();
                this.totalArticles = this.articles.length;
                console.log( this.articles );

            } catch ( error ) {
                console.log( "Error=", error );
            }
        },
        showInfo( idValue ) {
            this.$router.push( { name: 'Article', params: { id: idValue } } );
        }
    },
    created() {
        this.getArticles() // when we load compononent this method runs
    }
}
</script>
<template>

    <body>
        <tr v-for="article of articles" :key="article.id">
            <h2> Title: {{ article.title }}, Category: {{ article.category.name }}, Date: {{ article.postedDateTime }}
            </h2>
            <p>{{ article.introText }}</p>
            <p>{{ article.bodyText }}</p>
            <p>{{ article.outroText }}</p>
        </tr>
    </body>

</template>

<style scoped>

</style>


