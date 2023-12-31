/**
 * Hides and show menu items based on a specified allergen,
 * Hides all menu items that contains an allergen.
 *
 * @param allergy the allergen to be filtered out
 */
function filterOptions(allergy) {
    let divs = document.getElementsByClassName('menu-item');

    for (let x = 0; x < divs.length; x++) {
        let div = divs[x];
        let content = div.innerHTML.trim();
        console.log(content);
        console.log(allergy);
        if (allergy == "no-filters") {
            location.reload();
        }
        if (content.toLowerCase().includes(allergy)) {
            div.style.display = 'none';
        }
    }
}

