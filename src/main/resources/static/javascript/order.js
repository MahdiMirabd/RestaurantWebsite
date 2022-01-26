function decrementQuantity(){

	document.getElementById("item-quantity").value --;
}

function incrementQuantity(){

	document.getElementById("item-quantity").value ++;
}

function addToCart() {
    //Just to test if it reads the correct value.
    window.alert(document.getElementById("item-quantity").value);
}