//The total price of the order
var totalPrice = 0;

// Add to cart button
// It button will multiply the price of the item by the quantity and add it to the total price.
$().ready(function () {
    $(".add-to-cart-btn").click(function () {
        var quantity = $(this).closest('tr').find('input.qty').val();
        var price = $(this).closest('tr').find('.row-price').text();
        totalPrice += (parseInt(quantity) * parseFloat(price));
    });
});

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

// "=" button
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