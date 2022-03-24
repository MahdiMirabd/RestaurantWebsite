/* The total price of the order */
let totalPrice = 0;
/* The table number for an order */
let tableNumber = 0;

/* Tracks the quantity selected for a menu item */
let itemCount = 0;

/**
 * Adds  the product of the item price and quantity to the total price.
 */
$().ready(function () {
    $(".add-to-cart-btn").click(function (event) {
        buttonClicked = event.target;
        const image = $(this).closest('tr').find('.row-img').find('.item-img').attr('src');
        const name = $(this).closest('tr').find('.row-name').text();
        let quantity = $(this).closest('tr').find('input.qty').val();
        const price = $(this).closest('tr').find('.row-price').text();
        if (quantity != 0) {
            addItemToCart(image,name,quantity,price);
            updateCartTotal();

            // Changing the styling
            $(this).closest('tr').find('.add-to-cart-btn').html("Added");
            $(this).closest('tr').find('.add-to-cart-btn').css("color", "white");
            $(this).closest('tr').find('.add-to-cart-btn').css("background-color", "rgb(23, 194, 63)");
        } 
    });
});

/**
 * Adds a new menu item to the shopping cart
 *
 * @param image the item image
 * @param name the menu item name
 * @param quantity the quantity selected for the item
 * @param price the unit price of the item
 */
function addItemToCart(image,name, quantity, price) {
    let cartRow = document.createElement('div');
    cartRow.classList.add('cart-row');
    let cartItems = document.getElementsByClassName('cart-items')[0];
    let cartItemNames = cartItems.getElementsByClassName('cart-item-title');
    for (let i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == name) {
            alert('This item has already been added, change the quantity in the cart.');
            return;
        }
    }
    let cartRowContents = `
        <div class="cart-item-box">
        <img class="cart-item cart-column" src="${image}" id="cart-item-img" alt="The image of the item." name="image" />
        <div class="cart-item-info">
        <form action="order/addOrder" class="cart-item-cart-column" method="POST" th:action="@{/order/addOrder}"  >
         <div>
            <p class="cart-item-title"><input type="hidden" value="${name}" name="name"/>${name}</p> 
         </div>
         <p class="cart-item-price"><input type="hidden" value="${price}" th:field="*{price}" name="price"/>${price} </p>
         <p class="cart-price cart-column"><input type="hidden" value="${tableNumber}" th:field="*{tableNo}" name="tableNo"/></p>
         <p class="cart-price cart-column"><input type="hidden" value="pending" th:field="*{status}" name="status"/></p>
        <div class="cart-quantity">
            <input class="cart-quantity-input" type="number" value="${quantity}" name="quantity"/>
        </div>
        <input class="order-time" type="hidden" value="TBD" th:field="*{orderTime}" name="orderTime"/>
        </div>
        <button class="btn btn-remove"><i class='fas fa-trash-alt'></i></button>
        <button class="order-submit-button" type="submit" value="submit"/></button>
    </form>
    </div>`
        cartRow.innerHTML = cartRowContents;
    cartItems.append(cartRow);
    cartRow.getElementsByClassName('btn-remove')[0].addEventListener('click', removeItemFromCart);
    cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', quantityChanged);
}

/**
 * Submits an order to the backend.
 */
$(function() {
    $("#submit-all").click(function(){
        // all the orders in the shopping cart will have the same order time
        let today = new Date();
        let time = today.getHours() + ":" + today.getMinutes();
        let cartItemContainer = document.getElementsByClassName('cart-items')[0];
        let cartRows = cartItemContainer.getElementsByClassName('cart-row');
        for (let i = 0; i < cartRows.length; i++) {
            let cartRow = cartRows[i];
            let orderTimeElement = cartRow.getElementsByClassName('order-time')[0];
            orderTimeElement.value = time;
        }
        // all the hidden submit buttons for each item in the shopping card, will be clicked at the same time
        $('.cart-item-cart-column').each(function(){
            valuesToSend = $(this).serialize();
            $.ajax($(this).attr('action'),
                {
                method: $(this).attr('method'),
                data: valuesToSend
                }
            )
        });
        $(".btn-remove").click();
        $('.cart-popup').hide();
        alert("Your order has been placed.");
    });
});

/**
 * "-" button,
 * It decrements the quantity of the item in that row ONLY if the integer value of quantity
 * is bigger than 0, if not then the button does nothing and the quantity value remains unchanged (0).
 */
$().ready(function () {
    $(".decrement-qty-btn").click(function () {
        let quantity = $(this).closest('tr').find('input.qty').val();
        let quantityInt = parseInt(quantity);
        if (0 < quantity)
            quantityInt--;
        quantity = quantityInt.toString();
        $(this).closest('tr').find('input.qty').val(quantity);
    });
});

/**
 * "+" button,
 * It increments the quantity of the item in that row.
 */
$().ready(function () {
    $(".increment-qty-btn").click(function () {
        let quantity = $(this).closest('tr').find('input.qty').val();
        let quantityInt = parseInt(quantity);
        quantityInt++;
        quantity = quantityInt.toString();
        $(this).closest('tr').find('input.qty').val(quantity);
    });
});


/**
 * Shopping cart button,
 * it displays the total price of the items added to the cart.
 */
$().ready(function () {
    $(".shopping-cart-button").click(function(){
        $('.cart-popup').show();
    });
    $('.popupCloseButton').click(function(){
        $('.cart-popup').hide();
    });
});

/**
 * Waits for a remove button to be clicked.
 */
$().ready(function() {
    let removeBtn = document.getElementsByClassName('btn-remove');
    for (let i = 0; i < removeBtn.length; i++) {
        let input = removeBtn[i];
        input.addEventListener('click', removeItemFromCart)
    }
});

/**
 * checks if the menu has been updated so the price can then be updated
 */
$().ready(function() {
    let quantityInputs = document.getElementsByClassName('cart-quantity-input');
    for (let i = 0; i < quantityInputs.length; i++) {
        let input = quantityInputs[i];
        input.addEventListener('change', quantityChanged)
    }
});

/**
 * Removes an item from the cart
 * @param event when the user selects the trash can icon on cart.
 */
function removeItemFromCart(event) {
    let buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    updateCartTotal();
}

/**
 * updates total price in real time.
 *
 * @param event when the user changes the quantity of a cart item
 */
function quantityChanged(event) {
    let input = event.target;
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    updateCartTotal();
}

/**
 * Update cart total after changes have been made
 */
function updateCartTotal() {
    let cartItemContainer = document.getElementsByClassName('cart-items')[0];
    let cartRows = cartItemContainer.getElementsByClassName('cart-row');
    let total = 0;
    var itemCount = 0;
    for (let i = 0; i < cartRows.length; i++) {
        let cartRow = cartRows[i];
        let priceElement = cartRow.getElementsByClassName('cart-item-price')[0];
        let quantityElement = cartRow.getElementsByClassName('cart-quantity-input')[0];
        let price = parseFloat(priceElement.innerText.replace('£', ''));
        const quantity = quantityElement.value;
        console.log(price * quantity);
        total = total + (price * quantity);
        itemCount+=parseInt(quantity);
    }
    total = Math.round(total * 100) / 100;
    totalPrice = total;
    document.getElementsByClassName('cart-total-price')[0].innerText = '£' + total;
    console.log(itemCount);
    $('#lblCartCount').html(itemCount).css('display', 'inline');
}

/**
 * Hides the order form until the user selects a table number
 */
$(document).ready(function () {
    $(".order-section").hide();
});

/**
 * Sets the table number to be applied to an order
 *
 * @param table the table number
 */
function setTable(table) {
    tableNumber = table;
    $(".table-id").text(tableNumber);
    $(".order-heading-with-logo").show();
    $("#table-num").val(tableNumber);
    $(".order-section").show();
    $(".table-selection").hide();
}

/**
 * Changes the test of the "add" to cart button to "added".
 */
$('.add-to-cart-btn').click(function (){
  itemCount ++;
  $('#lblCartCount').html(itemCount).css('display', 'block');
});

/**
 * Displays cart and help screen when the button is clicked.
 */
$(".order-help").click(function(){
    $('.help-hover').show();
});

/**
 * Hides the Help screen when the close button is selected.
 */
$('.help-hover').click(function(){
    $('.help-hover').hide();
});

/**
 * The close button for pop-up boxes on the page which hides them.
 */
$('.popup-close-button').click(function(){
    $('.help-hover').hide();
});
/**
 * Displays the shopping cart on this page.
 */
$(document).ready(function() {
    $("#shop-cart").show();
  });

function enableButton() {
    document.getElementById('register-btn').disabled = false;
}
