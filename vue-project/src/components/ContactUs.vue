<script>

</script>

<template>

    <body>
        <div class="row">
            <div class="column" id="aboutUs">
                <div class="field">
                    <div class="aboutUsText">
                        <h3>Contact information: </h3>
                        <ul>
                            <li>Email: PleaseDoNotEmailUs@Yahoo.com</li>
                            <p></p>
                            <li>Phone: +420 603 604 605</li>
                            <p></p>
                            <li>Landline: Never had this</li>
                            <p></p>
                            <li>Socials: They are in the footer, look there!</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="column" id="location">

                <div class="field">
                    <h3>Where you can find us </h3>
                    <div class="mapouter">
                        <div class="gmap_canvas"><iframe class="gmap_iframe" width="100%" frameborder="0" scrolling="no"
                                marginheight="0" marginwidth="0"
                                src="https://maps.google.com/maps?width=&amp;height=450&amp;hl=en&amp;q=T-Mobile Roztyly&amp;t=&amp;z=14&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"></iframe><a
                                href="https://embedmapgenerator.com">google maps code generator</a></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</template>

<style scoped>
body {
    margin: 1%;
}

.row {
    display: flex;
}

.column {
    flex: 100%;
    justify-content: center;
}

#aboutUs {
    background-color: #fbfaf9;
}

.field {
    font-size: 28px;
    margin: 1%;
}

h3 {
    box-shadow: inset;
    color: rgb(125, 170, 70);
}

.mapouter {
    position: relative;
    text-align: right;
    width: 100%;
    height: 450px;
}

.gmap_canvas {
    overflow: hidden;
    background: none !important;
    width: 100%;
    height: 450px;
}

.gmap_iframe {
    height: 450px !important;
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