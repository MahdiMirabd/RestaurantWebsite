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
                    //'background-color: #fff;' +
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
                    'border: 2px solid red;' +
                    'border-radius: 10px;'  +
                    'transition: color .3s ease-in-out, box-shadow .3s ease-in-out;'+
                    'box-shadow: inset 0 0 0 0 #45a049;' +
                '} ' +
                'a:hover {' +
                    'padding-bottom: 5px;' +
                   // 'box-shadow: inset 0 -2px 0 0 #0a0a23;' +
                    'box-shadow: inset 100px 0 0 0 #45a049;' +
                    'color: white;' +
                '} ' +
                '.shopping-cart-button {' +
                    'background-color: white;' +
                    'border: 2px solid Dodgerblue;' +
                    'color: DodgerBlue;' +
                    'padding: 12px 16px;' +
                    'font-size: 16px;' +
                    'cursor: pointer;' +
                    'position:absolute;' +
                    'top:10px;' +
                    'right:200px;' +
                    'border-radius: 10px;'  +
                '} ' +
                  '.shopping-cart-button:hover {' +
                    'background-color: DodgerBlue;' +
                    'color: white;' +
                '} ' +
                '.Logo{' +
                    'left:20%; ' +
                    'position: absolute; ' +
                    'border-radius: 5px; ' +
                    'color: green; ' +
                    'display:block;' +
                    'flex-wrap: nowrap;'+
                '}' +
                '@media only screen and (max-width: 1200px) {a{font-size:20px;}}' +
                '@media only screen and (max-width: 1000px) {Logo{left:100%;}}' +
            '</style> ' +
            '<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">' +
            '<header> ' +
                '<nav> ' +
                '<h1 class = "Logo"><a href="/">Oaxaca</a> </h1>' +
                    '<ul>' +
                        '<li><a href="/">Home</a></li>' +
                        '<li><a href="/menu">Menu</a></li>' +
                        '<li><a href="/order">Order</a></li>' +
                        '<li class="log"><a href="/login">Login</a></li>' +
                    '</ul> ' +
                '</nav>' +
                '<button class="shopping-cart-button"><i class="fa fa-shopping-cart"></i></button>' +
            '</header>';
    }
}
customElements.define('header-component', Header);