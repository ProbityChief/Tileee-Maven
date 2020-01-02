var p = document.querySelector("tabletag")

p.removeChild("leLien");

let creationtr = document.createElement("tr");
//2.affectation d'un ID à cette balise div nouvellement créée
creationDiv.setAttribute("id", "leLien");
//3.Création puis ajout des paragraphes dans la div
let leLien = 
`<div style="width: 600px;  padding-top:10px; padding-bottom:10px;
border: 3px solid #A0A0A0; text-align: center;background: #C0C0C0;"> 
http://localhost:8080/tileee/Invitation?action=3&rand=${lol.rand}</div>`;

creationDiv.innerHTML = leLien;
p.appendChild("leLien");
