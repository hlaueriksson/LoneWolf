function toggleKaiDiscipline(element) {

	if (element.className === "selected") {
		element.className = "enabled";
		return;
	}

	var selected = document.getElementsByClassName("selected");

	if (selected.length >= 5) return;

	element.className = "selected";
}