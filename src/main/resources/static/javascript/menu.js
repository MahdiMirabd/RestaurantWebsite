function filterOptions() {
    let divs = document.getElementsByClassName('menu-item');

    for (let x = 0; x < divs.length; x++) {
        let div = divs[x];
        //let content = div.innerHTML.trim();
        let content = document.getElementById('allergen-list').innerText;
        if (content.includes("Celery")) {
            div.style.display = 'none';
        }
    }
}