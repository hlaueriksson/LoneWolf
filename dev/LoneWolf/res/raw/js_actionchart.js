function init() {
    console.log("init");

    initWeapons();

    var goldCrowns = document.getElementById("gold-crowns");
    var div = goldCrowns.getElementsByTagName("div")[0];
    div.innerHTML = inventory.goldCrowns.quantity;

    initBackpackItems();
    initSpecialItems();
    initSectionItems();
}
function initWeapons() {
    var weapons = document.getElementById("weapons");
    var ul = weapons.getElementsByTagName("ul")[0];
    for (i in inventory.weapons) {
        var weapon = inventory.weapons[i];
        var li = document.createElement("li");
        li.innerHTML = weapon.name;
        ul.appendChild(li);

        var button = document.createElement("button");
        button.innerHTML = "Discard";
        button.title = weapon.name;
        button.onclick = function() { ActionChart.discard(this.title); };
        li.appendChild(button);
    }
}
function initBackpackItems() {
    var backpackItems = document.getElementById("backpack-items");
    var ul = backpackItems.getElementsByTagName("ul")[0];
    for (i in inventory.backpackItems) {
        var item = inventory.backpackItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        ul.appendChild(li);

        var button = document.createElement("button");
        button.innerHTML = "Use";
        button.title = item.name;
        button.onclick = function() { ActionChart.use(this.title); };
        li.appendChild(button);

        button = document.createElement("button");
        button.innerHTML = "Discard";
        button.title = item.name;
        button.onclick = function() { ActionChart.discard(this.title); };
        li.appendChild(button);
    }
}
function initSpecialItems() {
    var specialItems = document.getElementById("special-items");
    var ul = specialItems.getElementsByTagName("ul")[0];
    for (i in inventory.specialItems) {
        var item = inventory.specialItems[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        ul.appendChild(li);

        var button = document.createElement("button");
        button.innerHTML = "Use";
        button.title = item.name;
        button.onclick = function() { ActionChart.use(this.title); };
        li.appendChild(button);

        button = document.createElement("button");
        button.innerHTML = "Discard";
        button.title = item.name;
        button.onclick = function() { ActionChart.discard(this.title); };
        li.appendChild(button);
    }
}
function initSectionItems() {
    var loot = document.getElementById("section-items");
    var ul = loot.getElementsByTagName("ul")[0];
    for (i in items) {
        var item = items[i];
        var li = document.createElement("li");
        li.innerHTML = item.name;
        ul.appendChild(li);

        var button = document.createElement("button");
        button.innerHTML = "Take";
        button.title = item.name;
        button.onclick = function() { ActionChart.take(this.title); };
        li.appendChild(button);
    }
}