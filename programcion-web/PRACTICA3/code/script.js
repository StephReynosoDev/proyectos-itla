let btnTema = document.getElementById("btn-tema");
let body = document.querySelector("body");

let btnLike = document.getElementById("btn-like");
let contadorLikes = document.getElementById("contador-likes");
let cantidadLikes = 0;

let btnLeer = document.getElementById("btn-leer");
let textoExtra = document.getElementById("texto-extra");

let btnGaleria = document.getElementById("btn-galeria");
let descripciones = document.querySelectorAll(".desc-galeria");


function cambiarTema() {
    body.classList.toggle("modo-claro");
    
    if (body.classList.contains("modo-claro")) {
        btnTema.textContent = "Modo Oscuro";
    } else {
        btnTema.textContent = "Modo Claro";
    }
}

btnTema.addEventListener("click", cambiarTema);


btnLike.addEventListener("click", function() {
    cantidadLikes = cantidadLikes + 1;
    contadorLikes.textContent = cantidadLikes;
});


btnLeer.addEventListener("click", function() {
    textoExtra.classList.toggle("oculto");
    
    if (textoExtra.classList.contains("oculto")) {
        btnLeer.textContent = "Leer mas";
    } else {
        btnLeer.textContent = "Leer menos";
    }
});


btnGaleria.addEventListener("click", function() {
    for (let i = 0; i < descripciones.length; i++) {
        descripciones[i].classList.toggle("oculto");
    }
    
    if (descripciones[0].classList.contains("oculto")) {
        btnGaleria.textContent = "Ver mas";
    } else {
        btnGaleria.textContent = "Ver menos";
    }
});