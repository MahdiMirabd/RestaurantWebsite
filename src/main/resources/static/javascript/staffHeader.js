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
                    'align-items:center;' +  
                    'justify-content: center;' +
                '}' +
                'ul {' +
                    'padding: 0;' +
                '}' +
                'ul li {' +
                    'list-style: none;' +
                    'display: inline; ' +
                '}' +
                'a {' +
                    'font-weight: 900;' +
                    'margin: 0 25px;' +
                    'color: #0a0a23;' +
                    'text-decoration: none;' +
                '} ' +
                'a:hover {' +
                    'padding-bottom: 5px;' +
                    'box-shadow: inset 0 -2px 0 0 #0a0a23;' +
                '} ' +
                'h1.Logo{' +
                    'left:350px; ' +
                    'position: absolute; ' +
                    'border: 2px solid red;' +
                    'border-radius: 5px; ' +
                    'color: green; ' +
                '} ' +
            '</style> ' +
            '<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">' +
            '<header> ' +
                '<nav> ' +
                '<h1 class = "Logo">Oaxaca</h1>' +
                    '<ul>' +
                        '<li><a href="/">Home</a></li>' +
                        '<li><a href="/menu">Menu</a></li>' +
                        '<li><a href="/order">Order</a></li>' +
                        '<li class="login"><a href="/login">Login</a></li>' +
                    '</ul> ' +
                '</nav> ' +
            '</header>';
    }
}
customElements.define('header-component', Header);