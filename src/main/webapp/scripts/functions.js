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
function changeName() {
    var name = document.getElementById('product_name');

    var vw1 = document.getElementById('viewer1');
    var vw2 = document.getElementById("viewer2");
    var vw3 = document.getElementById("viewer3");
    var vw4 = document.getElementById("viewer4");

    switch (name) {
        case vw1:
            name.textContent = "Drinks";
            break;
        case vw2:
            name.textContent = "Fruits";
            break;
        case vw3:
            name.textContent = "Meat";
            break;
        case vw4:
            name.textContent = "Bakery";
            break;
    }
}

function validate() {
    const checkBoxes = document.getElementsByClassName("checkbox_class")
    if (!checkBoxes) {
        return;
    }
    let checked = false;
    Array.from(checkBoxes).forEach(checkBox => {
        if (checkBox.checked) {
            checked = true;
            const delete_submit = document.getElementById("deleteSubmit");
            delete_submit.classList.remove('d-none');
            return 0;
        }
    })
    if (!checked) {
        const delete_submit = document.getElementById("deleteSubmit");
        delete_submit.classList.add('d-none');
    }
}



function paymentChange() {
    document.getElementById('payment_change').classList.remove("d-none")
    document.getElementById('complete').classList.add("d-none")
}


function myFunction() {
    const popup = document.getElementById("myPopup");
    const submit = document.getElementById("submit");
    const done = document.getElementById("done");

        popup.classList.toggle("show")
        submit.classList.add("d-none");
        done.classList.remove("d-none");
        
}

function myFunction1() {
    const submit = document.getElementById("submit");
    const done = document.getElementById("done");

    if (confirm("Transaction complete!")) {
        submit.classList.add("d-none");
        done.classList.remove("d-none");
    }
}