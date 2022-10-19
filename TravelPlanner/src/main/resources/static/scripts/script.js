
function viewList(){
	document.getElementById("item-list").classList.remove("hidden")
	document.getElementById("view-button").classList.add("hidden")
	document.getElementById("hide-button").classList.remove("hidden")
}

function hideList(){
	document.getElementById("item-list").classList.add("hidden")
	document.getElementById("hide-button").classList.add("hidden")
	document.getElementById("view-button").classList.remove("hidden")
}
