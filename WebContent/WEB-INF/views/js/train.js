let index = 0;
let score = 0;
let mot = ["mot", "voiture"];
let traduction = ["word", "car"];
let toIndex = () => {window.location.replace('/')};
let toTrain = () => {window.location.replace('train.html')};

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
            document.querySelector('.face-back p').innerText = `${mot[index]}`;
        }
        if (elements[i].className == "card-single") {
            elements[i].className += " rotated";
            check.className = "fas fa-arrow-right fa-4x";
        } else {
            check.className = "fas fa-check-square fa-4x";
            elements[i].className = "card-single";
            if (index < traduction.length - 1) {
                index++;
                document.querySelector('.face-front p').innerText = traduction[index];
                input.value = "";
                input.focus();
            } else {
                input.remove();
                check.className = "fas fa-home fa-5x";
                let result = (score / traduction.length) * 100;
                let color = result > 90 ? "rgba(25,150,50,1)" : (result > 50 ? "rgba(25,150,175,1)" : "rgba(175,50,25,1)");
                document.querySelector('.face-front').style = `font-size: 2em; background: ${color};`;
                document.querySelector('.face-front p').innerText = `${result}%`;
                check.addEventListener("click", toIndex);
            }
        }
    }
}

function insert(){
    document.querySelector("#traduction").value = fds;
}

window.onload = function() {
    check = document.querySelector("#flip");
    input = document.querySelector("#input");
    validate = document.querySelector("#add");

    if(check != null && input != null) {
        document.querySelector('.face-front p').innerText = traduction[index];
        check.addEventListener("click", checkResponse);
        input.addEventListener("keypress", searchKeyPress);
        input.focus();
    }
    if(validate != null)
        validate.addEventListener("click", () => {
            toTrain();
        });

};