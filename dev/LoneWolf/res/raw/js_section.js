function disableAll() {
    console.log("disableAll");
    disableAllChoices();
    disableRandomNumber();
    disableAllCombats();
}
function disableChoice(section) {
    console.log("disableChoice: " + section);
    var choice = document.getElementById(section);
    choice.style.color = "gray";
    var button = choice.getElementsByTagName("button")[0];
    button.disabled = true;
}
function disableAllChoices() {
    console.log("disableAllChoices");
    var paragraphs = document.getElementsByTagName("p");
    for (i in paragraphs) {
        var paragraph = paragraphs[i];
        if (paragraph.className == "choice") {
            paragraph.style.color = "gray";
            var button = paragraph.getElementsByTagName("button")[0];
            button.disabled = true;
        }
    }
}
function disableRandomNumber() {
    console.log("disableRandomNumber");
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "random-number") {
            button.disabled = true;
        }
    }
}
function disableAllCombats() {
    console.log("disableAllCombats");
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "combat") {
            button.disabled = true;
        }
    }
}
function disableCombat(index) {
    console.log("disableCombat: " + index);
    var count = 0;
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "combat") {
            if(index == count) {
                button.disabled = true;
            }
            count++;
        }
    }
}
function displayRandomNumber(value) {
    console.log("displayRandomNumber: " + value);
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "random-number") {
            button.innerHTML += ": " + value;
        }
    }
}
