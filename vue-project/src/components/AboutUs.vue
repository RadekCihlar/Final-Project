<script>

</script>

<template>

    <body>
        <div class="row">
            <div class="column" id="aboutUs">
                <div class="field">
                    <div class="aboutUsText">
                        <h3>The Gardener (aka cold exposed): </h3>
                        <img class="lukasimg" src="src/components/icons/LukasSeMeje.png" alt="LukásOtužovadlo">
                        <p>Je to on, mého srdce šampion. Pouze on se umí koupat a smát ve studené vodě</p>
                        <p>Zcela jistě je to Lukáš</p>
                    </div>
                </div>
            </div>
            <div class="column" id="location">

                <div class="field">
                    <div class="aboutUsText">
                        <h3>Just Bradek: </h3>
                        <img class="bradekimg" src="src/components/icons/BradekPije.jpeg" alt="bradkopíč">
                        <p>Koukněte na něho. Jak si tam sedí. Buržoust</p>
                        <p>A tak velké brčko, copak asi pil?!?</p>
                        <p>Prostě Bradek SmileyFaceWithCryingEyes</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</template>

<style scoped>
.lukasimg {
    width: 300px;
    height: 350px;
    float: left;
    padding-right: 2%;
}

.bradekimg {
    width: 300px;
    height: 350px;
    float: right;
    padding-left: 2%;
}

body {
    margin: 1%;
    min-height: 40vh;
}

.row {
    display: flex;
}

.column {
    flex: 100%;
    justify-content: center;
}

#aboutUs {
    background-color: whitesmoke;
}

.field {
    font-size: 28px;
    margin: 1%;
}

h3 {
    box-shadow: inset;
    color: rgb(125, 170, 70);
}


ul li {
    list-style: none;
    margin-bottom: 2%;
    padding-left: 1%;
}

ul {
    padding-left: 1%;
}
</style>