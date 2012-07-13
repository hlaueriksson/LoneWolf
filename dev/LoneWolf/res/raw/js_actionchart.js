function init() {
    console.log("init");

    var weapons = document.getElementById("weapons");
    var ul = weapons.getElementsByTagName("ul")[0];
    for (i in inventory.weapons) {
        var weapon = inventory.weapons[i];
        var li = document.createElement("li");
        li.innerHTML = weapon.name;
        ul.appendChild(li);
    }

    var goldCrowns = document.getElementById("gold-crowns");
    var div = goldCrowns.getElementsByTagName("div")[0];
    div.innerHTML = inventory.goldCrowns.quantity;

    var backpackItems = document.getElementById("backpack-items");
    ul = backpackItems.getElementsByTagName("ul")[0];
    for (i in inventory.backpackItems) {
        var item = inventory.backpackItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.discard(item.name); };
        ul.appendChild(li);
    }

    var specialItems = document.getElementById("special-items");
    ul = specialItems.getElementsByTagName("ul")[0];
    for (i in inventory.specialItems) {
        var item = inventory.specialItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.discard(item.name); };
        ul.appendChild(li);
    }

    var loot = document.getElementById("loot");
    ul = loot.getElementsByTagName("ul")[0];
    for (i in items) {
        var item = items[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.take(item.name); };
        ul.appendChild(li);
    }
}
