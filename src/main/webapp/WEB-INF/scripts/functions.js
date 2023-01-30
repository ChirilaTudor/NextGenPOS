function openNav() {
    document.getElementById("myNav").style.width = "20%";
    document.getElementById("products").style.marginLeft = "20%";
}
function closeNav() {
    document.getElementById("myNav").style.width = "0%";
    document.getElementById("products").style.marginLeft = "5rem";
}

function search(){
    const searchButton = document.getElementById('search-button');
    const searchInput = document.getElementById('search-input');
    searchButton.addEventListener('click', () => {
        const inputValue = searchInput.value;
        alert(inputValue);
    });
}
function changeName(){
    var name = document.getElementById('product_name');

    var vw1 = document.getElementById('viewer1');
    var vw2 = document.getElementById("viewer2");
    var vw3 = document.getElementById("viewer3");
    var vw4 = document.getElementById("viewer4");

    switch (name){
        case vw1:
            name.textContent="Drinks";
            break;
        case vw2:
            name.textContent="Fruits";
            break;
        case vw3:
            name.textContent="Meat";
            break;
        case vw4:
            name.textContent="Bakery";
            break;
    }


}
