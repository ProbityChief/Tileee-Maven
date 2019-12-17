function floutter() {
	document.querySelector('#overall').style.filter='blur(6px)';
	document.querySelector('footer').style.filter='blur(6px)';
}

function defloutter() {
	document.querySelector('#overall').style.filter='';
	document.querySelector('footer').style.filter='';
}

window.addEventListener('load', () => {
	poweroff = document.querySelector(".fa-power-off");
	poweroff.addEventListener('mouseover', floutter);
	poweroff.addEventListener('mouseout', defloutter);
});