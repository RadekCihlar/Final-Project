<script>
export default {
    data() {
        return {
            articles: [],
            totalArticles: 0,
            searchTerm: this.$route.query.searchTerm,
        };
    },
    methods: {
        async getArticles() {
            // fetch od Axios
            try {
                // Fetch returns a promise (assynchronous)
                let response = await fetch( 'http://localhost:8080/api/articles/search/' + this.$route.query.searchTerm );
                this.articles = await response.json();
                this.totalArticles = this.articles.length;
                console.log( this.articles );

            } catch ( error ) {
                console.log( "Error=", error );
            }
        },
        showInfo( idValue ) {
            this.$router.push( { name: 'Article', params: { id: idValue } } );
        },
        refreshPage() {
            location.reload()
        }
    },
    created() {
        this.getArticles()
        // when we load compononent this method runs
    },
    watch: {
        '$route': {
            handler( newValue, oldValue ) {
                location.reload()
            },
            deep: true
        }
    }
}
</script>
<template>

    <body>
        <p v-if="!articles.length">
        <h4>
            No articles found with title: <span v-if="searchTerm === ''">EMPTY SEARCH! </span> <span v-else>
                {{ searchTerm }}</span>
        </h4>
        </p>
        <p v-else>
            <tr v-for="article of articles" :key="article.id">
                <h2> Title: {{ article.title }}, Category: {{ article.category.name }}, Date: {{ article.postedDateTime
                }}
                </h2>
                <p>{{ article.introText }}</p>
                <p>{{ article.bodyText }}</p>
                <p>{{ article.outroText }}</p>
            </tr>
        </p>
    </body>

</template>

<style scoped>

</style>


