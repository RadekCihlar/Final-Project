<script>
export default {
    data() {
        return {
            articles: [],
            totalArticles: 0,
            searchTerm: this.$route.query.searchTerm,
            loading: false,
            article: {
                postedDateTime: 1671499609000,
            },
        };
    },
    methods: {
        async getArticles() {
            this.loading = false;
            try {
                let response = await fetch( 'http://localhost:8080/api/articles/search/' + this.$route.query.searchTerm );
                this.articles = await response.json();
                this.totalArticles = this.articles.length;
                console.log( this.articles );


            } catch ( error ) {
                console.log( "Error=", error );
                this.loading = true;
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
    },
    computed: {
        articleDate() {
            return new Date( this.article.postedDateTime ).toDateString()
        },
    }
}
</script>
<template>

    <body>
        <span v-if="!articles.length" v-show="loading">
            <h4>
                No articles found with title: <span v-if="searchTerm === ''">EMPTY SEARCH! </span> <span v-else>
                    {{ searchTerm }}</span>
            </h4>
        </span>
        <span v-else>
            <tr v-for="article of articles" :key="article.id" @click="showInfo(article.id)">
                <div class="article">
                    <h1 :id='article.id'>{{ article.title }}
                        <hr>
                    </h1> ؜
                    <h2>Category: {{ article.category === null ? "Uncategorized" : article.category.name }}, Posted: {{
                            articleDate
                    }}</h2>
                    <p>{{ article.introText }}</p>
                    <!--             <p>{{ article.bodyText }}</p>
                        <p>{{ article.outroText }}</p> -->
                </div>
            </tr>
        </span>
    </body>

</template>

<style scoped>
div {
    margin: 10px;
    padding: 10px;
    background-color: whitesmoke;
    margin-bottom: 5px;
    border: 0px solid black;
}

h1,
h2 {
    text-indent: 2em;
    line-height: 1.2;
    margin: 0;
    padding: 0;
}

p {
    text-indent: 2em;
}

hr {
    width: 80%;
    float: right;
    margin-top: 15px;
}

h2.remove-whitespace {
    margin: 0;
    padding: 0;
    line-height: 30px;
    height: 25px;
}

div:hover {

    cursor: pointer;

}
</style>


