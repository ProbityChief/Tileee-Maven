function floutter() {
	document.querySelector('overall').style.filter='blur(3px)';
	document.querySelector('footer').style.filter='blur(3px)';
    return;
}

function defloutter() {
	document.querySelector('overall').style.filter='none';
	document.querySelector('footer').style.filter='none';
    return;
}

window.onload(document.querySelector(".fa-power-off").addEventListener()) 