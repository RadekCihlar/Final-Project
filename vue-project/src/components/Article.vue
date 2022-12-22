<script>
export default {
    data() {
        return {
            articles: [],
            article: {
                postedDateTime: 1671499609000,
            },
/*             totalArticles: 0, */
            idValue: 0,
            currentUrl: "",
            articleNumber: 0,
        }
    },
    computed: {
        articleDate() {
            return new Date(this.article.postedDateTime).toDateString()
        },
    },
    methods: {
        async getArticles() {
            // fetch od Axios
            try {
                // Fetch returns a promise (assynchronous)
                let response = await fetch('http://localhost:8080/api/articles');
                this.articles = await response.json();
                this.totalArticles = this.articles.length;
                console.log(this.articles);

            } catch (error) {
                console.log("Error=", error);
            }
        },
        showInfo(idValue) {
            console.log(idValue);
            this.$router.push({ name: 'Article', params: { id: idValue } });
        },
        getSelectedArticleId(currentUrl) {
            return this.articleNumber = currentUrl.slice(-1);
        },
    },
    created() {
        this.getArticles() // when we load compononent this method runs
        this.currentUrl = window.location.href;
        console.log(this.currentUrl);
    },
}
</script>
<template>
    <!-- <p>{{ currentUrl }}</p>
    <p>{{ getSelectedArticleId(currentUrl) }}</p>
    <p>{{ parseInt(getSelectedArticleId(currentUrl)) }}</p>
    <h1 v-if="parseInt(getSelectedArticleId(currentUrl)) === 1">equals</h1> -->
    <p><p><router-link :to="{ name: 'Articles' }">Go back to articles list.</router-link></p></p>

    <!-- lame code prevending onVnodeUnmounted=fn<onVnodeUnmounted> ref=Ref< null > > -->
    <tr v-for="article of articles" :key="article.id">
        <div class="article" v-if="article.id === parseInt(getSelectedArticleId(currentUrl))">
            <h1 :id='article.id'>{{ article.title }}
                <hr>
            </h1> ؜
            <h2>Category: {{ article.category === null ? "Uncategorized" : article.category.name }}, Posted: {{
                    articleDate
            }}</h2>
            <p>{{ article.introText }}</p>

            <p> <img src="/src/assets/img/2.jpg" alt="Some nature" id="photo">

                {{ article.bodyText }}</p>

            <p><img src="/src/assets/img/3.jpg" alt="Some nature" id="photo2">
                {{ article.outroText }}</p>
        </div>
    </tr>
</template>
<style scoped>
a:link {
    color: black;
    font-weight: bold;
}

a:visited {
    color: black;
    font-weight: bold;
}

a:hover {
    color: black;
    font-weight: bold;
}

a:active {
    color: black;
    font-weight: bold;
}

#photo {
    width: 500px;
    float: left;
    border: 1px solid gray;
    padding: 20px;
    margin-right: 20px;
    margin-bottom: 10px;
}

#photo2 {
    width: 500px;
    float: right;
    border: 1px solid gray;
    padding: 20px;
    margin-right: 20px;
    margin-bottom: 10px;
}

div {
    margin: 20px;
    padding: 20px;
    background-color: whitesmoke;
    margin-bottom: 5px;
    border: 0px solid black;
    font-size: 18px;
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
