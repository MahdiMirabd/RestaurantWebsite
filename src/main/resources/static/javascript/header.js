class Header extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.innerHTML =
             '<ul>' +
                '<li><a href="/">Home</a></li>' +
                '<li><a href="/menu">Menu</a></li>' +
                '<li><a href="/order">Order</a></li>' +
                '<li><a href="/login">Login</a></li>' +
            '</ul>';
    }
}
customElements.define('header-component', Header);