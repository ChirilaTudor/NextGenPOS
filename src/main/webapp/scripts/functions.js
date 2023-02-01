function openNav() {
    document.getElementById("myNav").style.width = "20%";
    document.getElementById("products").style.marginLeft = "20%";
}
function closeNav() {
    document.getElementById("myNav").style.width = "0%";
    document.getElementById("products").style.marginLeft = "0rem";
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


function myFunction1() {
    const submit = document.getElementById("submit");
    const done = document.getElementById("done");
    const myPopup = document.getElementById("myPopup");


    if (confirm("Transaction complete!")) {
        myPopup.classList.remove("d-none");
        submit.classList.add("d-none");
        done.classList.remove("d-none");
    }

}