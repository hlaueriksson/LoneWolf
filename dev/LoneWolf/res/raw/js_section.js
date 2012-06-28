function disableAll() {
    console.log("disableAll");
    disableAllChoices();
    disableAllRandomNumbers();
    disableAllCombats();
}
function disableChoice(section) {
    console.log("disableChoice: " + section);
    var choice = document.getElementById(section);
    choice.style.color = "gray";
    var buttons = choice.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "choice") {
            button.disabled = true;
        }
    }
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
function disableAllRandomNumbers() {
    console.log("disableAllRandomNumbers");
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "random-number") {
            button.disabled = true;
        }
    }
}
function disableRandomNumber(index) {
    console.log("disableRandomNumber: " + index);
    var count = 0;
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "random-number") {
            if(index == count) {
                button.disabled = true;
            }
            count++;
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
function displayRandomNumberIndex(value, index) {
    console.log("displayRandomNumber: " + value);
    var count = 0;
    var buttons = document.getElementsByTagName("button");
    for (i in buttons) {
        var button = buttons[i];
        if (button.className == "random-number") {
            if(index == count) {
                button.innerHTML += ": " + value;
            }
            count++;
        }
    }
}
