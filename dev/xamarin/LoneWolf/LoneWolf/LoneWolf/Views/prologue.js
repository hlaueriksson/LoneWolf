function disable(element) {

	element.className = "disabled";
}

function toggleKaiDiscipline(element) {

	if (element.className === "selected") {
		element.className = "enabled";
		enableKaiDisciplines();
		return;
	}

	element.className = "selected";

	var selected = document.getElementsByClassName("selected");

	if (selected.length < 5) return;

	disableKaiDisciplines();
}

function disableKaiDisciplines() {
	toggleKaiDisciplines("enabled", "disabled");
}

function enableKaiDisciplines() {
	toggleKaiDisciplines("disabled", "enabled");
}

function toggleKaiDisciplines(from, to) {
	var links = document.getElementsByTagName("a");

	for (var i = 0; i < links.length; i++) {
		if (links[i].className === from && links[i].href.substring(0, 20) === "hybrid:kaidiscipline") {
			links[i].className = to;
		}
	}
}