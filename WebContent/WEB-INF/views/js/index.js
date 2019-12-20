function floutter() {
	document.querySelector('#overall').style.filter='blur(12px)';
	document.querySelector('footer').style.filter='blur(12px)';
}

function defloutter() {
	document.querySelector('#overall').style.filter='';
	document.querySelector('footer').style.filter='';
}

window.addEventListener('load', () => {
	poweroff = document.querySelector("#quit");
	poweroff.addEventListener('mouseover', floutter);
	poweroff.addEventListener('mouseout', defloutter);
});