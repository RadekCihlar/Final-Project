<script>
export default {
    data() {
        return {
            articles: [],
            article: {
                postedDateTime: 1671499609000,
            },
            totalArticles: 0
        };
    },
    computed: {
        articleDate() {
            return new Date( this.article.postedDateTime ).toDateString()
        }
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
            console.log( idValue );
            this.$router.push( { name: 'Article', params: { id: idValue } } );
        }
    },
    created() {
        this.getArticles() // when we load compononent this method runs
    },
}
</script>
<template>

    <body>


        <!-- @click="showInfo(article.id)"> -->
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

div:hover {
    cursor: pointer;
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
    width: 70%;
    float: right;
    margin-top: 15px;
}

h2.remove-whitespace {
    margin: 0;
    padding: 0;
    line-height: 30px;
    height: 25px;
}
</style>
