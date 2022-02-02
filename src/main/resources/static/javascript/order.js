//The total price of the order
var totalPrice = 0;

// Add to cart button
// It button will multiply the price of the item by the quantity and add it to the total price.
$().ready(function () {
    $(".add-to-cart-btn").click(function (event) {
        buttonClicked = event.target;
        var name = $(this).closest('tr').find('.row-name').text();
        var quantity = $(this).closest('tr').find('input.qty').val();
        var price = $(this).closest('tr').find('.row-price').text();
        if (quantity != 0) {
            addItemToCart(name,quantity,price);
            updateCartTotal();
        }
    });
});

function addItemToCart(name, quantity, price) {
    var cartRow = document.createElement('div');
    cartRow.classList.add('cart-row');
    var cartItems = document.getElementsByClassName('cart-items')[0];
    var cartItemNames = cartItems.getElementsByClassName('cart-item-title');
    for (var i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == name) {
            alert('This item has already been added, change the quantity in the cart.');
            return;
        }
    }
    var cartRowContents = `
        <div class="cart-item cart-column">
            <span class="cart-item-title">${name}</span>
        </div>
        <span class="cart-price cart-column">${price}</span>
        <div class="cart-quantity">
            <input class="cart-quantity-input" type="number" value="${quantity}">
            <button class="btn btn-remove" type="button">REMOVE</button>
        <div class="submit-button">
            <button class="submit-order"type="button" value="submit">submit order</button></div>
        </div>`
        cartRow.innerHTML = cartRowContents;
    cartItems.append(cartRow);
    cartRow.getElementsByClassName('btn-remove')[0].addEventListener('click', removeItemFromCart);
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', quantityChanged);
}

// "-" button
// It decrements the quantity of the item in that row ONLY if the integer value of quantity is bigger than 0,
// if not then the button does nothing and the quantity value remains unchanged (0).
$().ready(function () {
    $(".decrement-qty-btn").click(function () {
        var quantity = $(this).closest('tr').find('input.qty').val();
        var quantityInt = parseInt(quantity);
        if (0 < quantity)
            quantityInt--;
        quantity = quantityInt.toString();
        $(this).closest('tr').find('input.qty').val(quantity);
    });
});

// "+" button
// It increments the quantity of the item in that row.
$().ready(function () {
    $(".increment-qty-btn").click(function () {
        var quantity = $(this).closest('tr').find('input.qty').val();
        var quantityInt = parseInt(quantity);
        quantityInt++;
        quantity = quantityInt.toString();
        $(this).closest('tr').find('input.qty').val(quantity);
    });
});

// Shopping cart button
// it displays the total price of the items added to the cart.
$().ready(function () {
    $(".shopping-cart-button").click(function () {
        window.alert("Total cost :   " + totalPrice.toString());    });
});

//Waits for a remove button to be clicked
$().ready(function() {
    var removeBtn = document.getElementsByClassName('btn-remove');
    for (var i = 0; i < removeBtn.length; i++) {
        var input = removeBtn[i];
        input.addEventListener('click', removeItemFromCart)
    }
});

//checks if the menu has been updated so the price can then be updated
$().ready(function() {
    var quantityInputs = document.getElementsByClassName('cart-quantity-input');
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i];
        input.addEventListener('change', quantityChanged)
    }
});

//Removes an item from the cart
function removeItemFromCart(event) {
    var buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    updateCartTotal();
}

//updates total price in real time
function quantityChanged(event) {
    var input = event.target;
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    updateCartTotal();
}

//Update cart total after changes have been made
function updateCartTotal() {
    var cartItemContainer = document.getElementsByClassName('cart-items')[0];
    var cartRows = cartItemContainer.getElementsByClassName('cart-row');
    var total = 0;
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i];
        var priceElement = cartRow.getElementsByClassName('cart-price')[0];
        var quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0];
        var price = parseFloat(priceElement.innerText.replace('£', ''));
        var quantity = quantityElement.value;
        console.log(price * quantity);
        total = total + (price*quantity);
    }
    total = Math.round(total*100) / 100;
    totalPrice = total;
    document.getElementsByClassName('cart-total-price')[0].innerText = '£' + total;
}