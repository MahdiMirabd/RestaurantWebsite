function filterOptions() {
    let divs = document.getElementsByClassName('menu-item');

    for (let x = 0; x < divs.length; x++) {
        let div = divs[x];
        //let content = div.innerHTML.trim();
        let content = div.innerHTML.trim();
        console.log(content);
        if (content.toLowerCase().includes("celery")) {
            div.style.display = 'none';
        }
    }
}