function openNav() {
    document.getElementById("myNav").style.width = "25%";

    document.getElementById("myNav").classList.remove("d-none");
}

/* Close when someone clicks on the "x" symbol inside the overlay */
function closeNav() {
    document.getElementById("myNav").style.width = "0%";

    document.getElementById("myNav").classList.add("d-none");
}

