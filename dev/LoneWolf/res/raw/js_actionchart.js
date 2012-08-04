function init() {
    console.log("init");

    initWeapons();

    var goldCrowns = document.getElementById("gold-crowns");
    var div = goldCrowns.getElementsByTagName("div")[0];
    div.innerHTML = inventory.goldCrowns.quantity;

    initBackpackItems();
    initSpecialItems();
    initLoot();
}
function initWeapons() {
    var weapons = document.getElementById("weapons");
    var ul = weapons.getElementsByTagName("ul")[0];
    for (i in inventory.weapons) {
        var weapon = inventory.weapons[i];
        var li = document.createElement("li");
        li.innerHTML = weapon.name;
        li.onclick = function() { ActionChart.discard(this.innerHTML); };
        ul.appendChild(li);
    }
}
function initBackpackItems() {
    var backpackItems = document.getElementById("backpack-items");
    var ul = backpackItems.getElementsByTagName("ul")[0];
    for (i in inventory.backpackItems) {
        var item = inventory.backpackItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.discard(this.innerHTML); };
        ul.appendChild(li);
    }
}
function initSpecialItems() {
    var specialItems = document.getElementById("special-items");
    var ul = specialItems.getElementsByTagName("ul")[0];
    for (i in inventory.specialItems) {
        var item = inventory.specialItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.discard(this.innerHTML); };
        ul.appendChild(li);
    }
}
function initLoot() {
    var loot = document.getElementById("loot");
    var ul = loot.getElementsByTagName("ul")[0];
    for (i in items) {
        var item = items[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        li.onclick = function() { ActionChart.take(this.innerHTML); };
        ul.appendChild(li);
    }
}