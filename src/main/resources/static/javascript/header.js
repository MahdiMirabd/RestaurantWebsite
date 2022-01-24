class Header extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.innerHTML =
             '<ul>' +
                '<li><a href="index.html">Home</a></li>' +
                '<li><a href="menu.html">Menu</a></li>' +
                '<li><a href="Order.html">Order</a></li>' +
                '<li><a href="Login.html">Login</a></li>' +
            '</ul>';
    }
}

customElements.define('header-component', Header);