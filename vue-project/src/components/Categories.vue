<script>
export default {
    data() {
        return {
            categories: [],
            articles: [],
            searchedId: 1,
            article: {
                postedDateTime: 1671499609000,
            },
        };
    },
    methods: {
        async getCategories() {

            try {
                // Fetch returns a promise (assynchronous)
                let response = await fetch( 'http://localhost:8080/api/categories' );
                this.categories = await response.json();
                console.log( this.categories );
            } catch ( error ) {
                console.log( "Error=", error );
            }
        },
        async getArticlesInCategory( id ) {
            try {
                let response = await fetch( 'http://localhost:8080/api/categories/' + id + '/articles' )
                this.articles = await response.json();
                console.log( this.articles )
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
        this.getCategories() // when we load compononent this method runs
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


        <p style="font-weight: bold;">Categories to choose from:
        <ul>
            <li v-for="category of categories" :id="category.id" @click="getArticlesInCategory(category.id)">{{
                    category.name
            }}</li>
        </ul>
        </p>
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

body {
    background-color: whitesmoke;
    margin: 1%;
    min-height: 40vh;
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

ul,
li {
    cursor: pointer;
    display: inline;
    padding-left: 1%;

}

li:hover {
    color: grey;
    text-decoration: underline;

}

div:hover {

    cursor: pointer;

}
</style>