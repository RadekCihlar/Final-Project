<template>
    <section id="gallery">
        <p>
            <a class="prev" @click="prev" href="#">&#10094;&#10094; Previous</a>
            <a class="next" @click="next" href="#">Next &#10095;&#10095;</a>
        </p>
        <transition-group tag="div">
            <div v-for="i in [currentIndex]" :key="i">
                <img :src="currentImg" />
            </div>
        </transition-group>
    </section>
    <p></p>
</template>
<script>
export default {
    name: "Slider",
    data() {
        return {
            images: [
                "./src/assets/img/1.jpg",
                "./src/assets/img/2.jpg",
                "./src/assets/img/3.jpg",
                "./src/assets/img/4.jpg",
                "./src/assets/img/5.jpg",
                "./src/assets/img/6.jpg",
                "./src/assets/img/7.jpg",
                "./src/assets/img/8.jpg",
            ],
            timer: null,
            currentIndex: 0
        };
    },

    mounted: function () {
        this.startSlide();
    },

    methods: {
        startSlide: function () {
            this.timer = setInterval(this.next, 4000);
        },

        next: function () {
            this.currentIndex += 1;
        },
        prev: function () {
            this.currentIndex -= 1;
        }
    },

    computed: {
        currentImg: function () {
            return this.images[Math.abs(this.currentIndex) % this.images.length];
        }
    }
};
</script>
<style scoped>
#gallery {
    text-align: center;
    background-color: whitesmoke;
}

#gallery img {
    width: 50%;
    height: 50%;
    cursor: pointer;
}

.prev {
    cursor: pointer;
    position: fixed;
    top: 47%;
    width: auto;
    padding: 20px;
    color: black;
    font-weight: bold;
    font-size: 18px;
    border-radius: 0 4px 4px 0;
    text-decoration: none;
    user-select: none;
}

.next {
    cursor: pointer;
    position: fixed;
    top: 47%;
    width: auto;
    padding: 20px;
    color: black;
    font-weight: bold;
    font-size: 18px;
    border-radius: 4px 0 0 4px;
    text-decoration: none;
    user-select: none;
}

.next {
    right: 0;
}

.prev {
    left: 0;
}

.prev:hover,
.next:hover {
    background-color: rgba(0, 0, 0, 0.3);
}
</style>
  