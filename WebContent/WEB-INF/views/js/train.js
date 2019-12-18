let index = 0;
let score = 0;
let mot = ["voiture", "avion", "train", "bateau", "velo", "moto", "metro"];
let traduction = ["car", "plane", "train", "boat", "bicycle", "motorcycle", "subway"];
let toIndex = () => {window.location.replace('/tileee')};
let toTrain = () => {window.location.replace('/tileee/Demo')};

function searchKeyPress(e) {
    e = e || window.event;
    if (e.keyCode === 13)
    {
        check.click();
    }
}

function checkResponse() {
    var elements = this.parentNode.querySelectorAll("div[class^='card']");
    for (var i = 0; i < elements.length; i++) {
        if (document.querySelector('.face-front input').value.toLowerCase() === mot[index] && elements[i].className == "card-single") {
            elements[i].querySelector(".face-back").style.backgroundColor = "rgba(25,150,175,1)";
            document.querySelector('.face-back p').className = "far fa-smile fa-2x faa-bounce animated";
            document.querySelector('.face-back p').innerHTML = ``;
            score++;
        } else if (document.querySelector('.face-front input').value.toLowerCase() != mot[index]) {
            elements[i].querySelector(".face-back").style.backgroundColor = "rgba(175,50,25,1)";
            document.querySelector('.face-back p').className = "";
            document.querySelector('.face-back p').innerText = mot[index];
        }
        if (elements[i].className == "card-single") {
            elements[i].className += " rotated";
            check.className = "fas fa-arrow-right fa-6x";
        } else {
            check.className = "fas fa-check-square fa-6x";
            elements[i].className = "card-single";
            if (index < traduction.length - 1) {
                index++;
                document.querySelector('.face-front p').innerText = traduction[index];
                input.value = "";
                input.focus();
            } else {
                input.remove();
                let result = (score / traduction.length) * 100;
                let color = result > 90 ? "rgba(25,150,50,1)" : (result > 50 ? "rgba(25,150,175,1)" : "rgba(175,50,25,1)");
                document.querySelector('.face-front').style = "font-size: 2em; background: " + color;
                document.querySelector('.face-front p').innerText = Number.parseFloat(result).toFixed(1)+"%";
                check.remove();
            }
        }
    }
}

function insert(){
    document.querySelector("#traduction").value = ;
}

window.addEventListener("load", () => {
    check = document.querySelector("#flip");
    input = document.querySelector("#input");

    document.querySelector('.face-front p').innerText = traduction[index];
    check.addEventListener("click", checkResponse);
    input.addEventListener("keypress", searchKeyPress);
    input.focus();
});