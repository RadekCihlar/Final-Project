<script>
export default {
    data() {
        return {
            todos: [],
            totalArticles: 0
        };
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
            this.$router.push({ name: 'Article', params: {id: idValue} });
        }
    },
    created() {
        this.getArticles() // when we load compononent this method runs
    }
}
</script>
<template>
    <table class="dataTable">
        <thead>
            <tr>
                <th>Title</th>
                <th>Text Intro</th>
                <th>Text Body</th>
                <th>Text Outro</th>
                <th>Created</th>
                <th>Category</th>
            </tr>
        </thead>

        <tbody>
            <!-- :key is for optimization, we providing it with primary id -->
            <tr v-for="article of articles" :key="article.id"
                @click="showInfo(article.id)">
            <!-- ^ kdyz klikneme kamkoliv na radek invokujeme metodu s parametrem id -->
                <td>{{ article.id }}</td>
                <td>{{ article.title }}</td>
                <td>{{ article.text intro}}</td>
                <td>{{ article.text body}}</td>
                <td>{{ article.text outro}}</td>
                <td>{{ article.category }}</td>
                </tr>
        </tbody>

        <tfoot>
            <tr>
                <td colspan="6">Total number of articles: <span>{{ totalArticles }}</span></td>
            </tr>
        </tfoot>
    </table>
</template>