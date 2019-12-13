function floutter() {
	document.querySelector('overall').style.filter='blur(3px)';
	document.getElementsByTagName('footer').style.filter='blur(3px)';
}

function defloutter() {
	document.querySelector('overall').style.filter='none';
	document.getElementsByTagName('footer').style.filter='none';
}

window.onload(document.querySelector(".fa-power-off").addEventListener()) 