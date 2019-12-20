let line = 0;

function floutter() {
	document.querySelector('#overall').style.filter='blur(12px)';
	document.querySelector('footer').style.filter='blur(12px)';
}

function defloutter() {
	document.querySelector('#overall').style.filter='';
	document.querySelector('footer').style.filter='';
}

deleteLine = (thatline) => {
	document.querySelector('.line'+thatline).parentNode.remove();
	if(document.querySelector('#textbox').innerHTML.length === 4)
		document.querySelector('#valid').remove();
}

addInputs = () => {
	let div = document.createElement('div');
	let addspace = document.querySelector('#textbox');
	if(!document.querySelector('#valid'))
		document.querySelector('#buttoncase').innerHTML += '<button id="valid" type="submit" class="fa fa-check-square otherbutton" form="textbox"></button>';
	div.innerHTML = '<div style="display: flex; flex-direction: row;" class="line'+line+'"><input type="text" placeholder="Mot" class="form-control" name="mot" required="required" style="margin: 12px;"  autocomplete="off"/><input type="text" placeholder="Traduction" class="form-control" name="traduction" required="required" style="margin: 12px;"  autocomplete="off"/><button type="button" class="fas fa-times" onclick="deleteLine('+line+')" style="color: #dddddd;"></button></div>';
	addspace.appendChild(div);
	line++;
}

window.addEventListener('load', () => {
	poweroff = document.querySelector("#quit");
	poweroff.addEventListener('mouseover', floutter);
	poweroff.addEventListener('mouseout', defloutter);
});