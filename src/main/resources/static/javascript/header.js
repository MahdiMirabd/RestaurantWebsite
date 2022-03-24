/**
 * Navigation bar displayed at the top of each screen.
 */
class Header extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.innerHTML ='' +
            '<style> ' +
                'nav {' +
                    'height: 50px;' +
                    'display:flex;' +
                    'flex-wrap: nowrap;'+
                    'align-items:center;' +  
                    'justify-content: center;' +
                    'border-bottom: 2px solid #08090A;' +
                '}' +
                'ul {' +
                    'padding: 0;' +
                '}' +
                'ul li {' +
                    'list-style: none;' +
                    'display: inline; ' +
                '}' +
                'a {' +
                    'font-size: 30px;' +
                    'margin: 0 25px;' +
                    'color: #0a0a23;' +
                    'text-decoration: none;' +
                    'border-radius: 10px;'  +
                    'transition: color .3s ease-in-out, box-shadow .3s ease-in-out;'+
                '} ' +
                'a:hover {' +
                    'padding-bottom: 5px;' +
                    'box-shadow: inset 100px 0 0 0 #45a049;' +
                    'color: white !important;' +
                '} ' +
                '.shopping-cart-button {' +
                    'background-color: white;' +
                    'color: black;' +
                    'padding: 12px 16px;' +
                    'font-size: 16px;' +
                    'cursor: pointer;' +
                    'position:absolute;' +
                    'top:10px;' +
                    'right:200px;' +
                    'border: none;' +
                    ': 10px;'  +
                '} ' +
                  '.shopping-cart-button:hover {' +
                    'background-color: black;' +
                    'color: white;' +
                '} ' +
                '.header-badge { '+
                  '  padding-left: 9px;'+
                  ' padding-right: 9px;'+
                  ' -webkit-border-radius: 9px;'+
                  ' -moz-border-radius: 9px;'+
                  ' border-radius: 9px;'+
                  ' }'+
                  
                  ' .label-warning[href],'+
                  ' .badge-warning[href] {'+
                    '  background-color: #c67605;'+
                    ' }'+
                    '  #lblCartCount {'+
                        '   font-size: 12px;'+
                        ' background: #ff0000;'+
                        ' color: #fff;'+
                        '     padding: 1px 2px;'+
                        '      vertical-align: top;'+
                        '   margin-left: 10px; '+
                        'display :none;'+
                        'position:absolute;'+
                        'top:3px;'+
                        'right:1px;'+
                        ' }' +
                '.Logo{' +
                    'left:20%; ' +
                    'position: absolute; ' +
                    'border-radius: 5px; ' +
                    'color: green ; ' +
                    'display:block;' +
                    'flex-wrap: nowrap;'+
                '}' +

                'Logo:hover{color: white !important;}'+

                '.shop-cart{ border: solid;}'+
                '@media only screen and (max-width: 1450px) {a{font-size:20px;}}' +
                '@media only screen and (max-width: 1450px) {Logo{left:100%;}}' +
            '</style> ' +
            '<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">' +
            '<header> ' +
                '<nav> ' +
                '<h1 class = "Logo"><a style="border: 2px solid red; color: green;" href="/">Oaxaca</a> </h1>' +
                    '<ul>' +
                        '<li><a href="/">Home</a></li>' +
                        '<li><a href="/menu">Menu</a></li>' +
                        '<li><a href="/order">Order</a></li>' +
                        '<li><a href="/ordertrack">Order Track</a></li>' +
                        '<li><a href="/payment">Payment</a></li>'+
                        '<li class="log"><a href="/login">Login</a></li>' +
                    '</ul> ' +
                '</nav>' +
                '<div id= "shop-cart"> ' +
                '<button class="shopping-cart-button id="shopping-cart-button"><i class="fa fa-shopping-cart"></i><span class= "header-badge badge-warning" id="lblCartCount"> 0 </span> </button>' +
                '</div>'+
            '</header>'

    }
}
customElements.define('header-component', Header);
/**
 * Hides the shopping cart.
 */
$(document).ready(function() {
    $("#shop-cart").hide();
  });
