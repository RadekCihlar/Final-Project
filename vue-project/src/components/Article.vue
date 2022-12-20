<script>
</script>
>

<template>
    <p>Id: {{ $route.params.id }}</p>
    <!-- <p>Title: {{ $route.query.title}}</p> -->
    <p><router-link :to="{ name: 'Articles' }">Go back to articles list.</router-link></p>
</template>