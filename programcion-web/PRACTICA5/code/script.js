let inputBusqueda = document.getElementById("input-busqueda");
let btnBuscar = document.getElementById("btn-buscar");
let btnAnterior = document.getElementById("btn-anterior");
let btnSiguiente = document.getElementById("btn-siguiente");
let contenedorTarjetas = document.getElementById("contenedor-tarjetas");
let textoMensaje = document.getElementById("mensaje");

let paginaActual = 1;
let busquedaActual = "";

async function cargarDatos() {
    textoMensaje.textContent = "Cargando...";
    contenedorTarjetas.innerHTML = "";
    btnAnterior.disabled = true;
    btnSiguiente.disabled = true;

    let url = "https://rickandmortyapi.com/api/character/?page=" + paginaActual;
    
    // si hay busqueda la agrego a la url
    if (busquedaActual !== "") {
        url = url + "&name=" + busquedaActual;
    }

    try {
        let respuesta = await fetch(url);

        if (respuesta.ok === false) {
            throw new Error("error");
        }

        let datos = await respuesta.json();
        
        textoMensaje.textContent = "";
        dibujarTarjetas(datos.results);

        // activo o desactivo los botones segun lo que devuelva la api
        btnAnterior.disabled = datos.info.prev === null;
        btnSiguiente.disabled = datos.info.next === null;

    } catch (error) {
        textoMensaje.textContent = "No se encontraron personajes";
        contenedorTarjetas.innerHTML = "";
    }
}

function dibujarTarjetas(personajes) {
    contenedorTarjetas.innerHTML = "";
    
    personajes.forEach(function(personaje) {
        let tarjeta = document.createElement("div");
        tarjeta.classList.add("tarjeta");

        let imagen = document.createElement("img");
        imagen.src = personaje.image;

        let nombre = document.createElement("h3");
        nombre.textContent = personaje.name;

        let estado = document.createElement("p");
        estado.textContent = "Estado: " + personaje.status;

        let especie = document.createElement("p");
        especie.textContent = "Especie: " + personaje.species;

        tarjeta.appendChild(imagen);
        tarjeta.appendChild(nombre);
        tarjeta.appendChild(estado);
        tarjeta.appendChild(especie);

        contenedorTarjetas.appendChild(tarjeta);
    });
}

// reseteo la pagina a 1 cada vez que se busca
function hacerBusqueda() {
    busquedaActual = inputBusqueda.value;
    paginaActual = 1;
    cargarDatos();
}

btnBuscar.addEventListener("click", hacerBusqueda);

inputBusqueda.addEventListener("keypress", function(evento) {
    if (evento.key === "Enter") {
        hacerBusqueda();
    }
});

btnAnterior.addEventListener("click", function() {
    paginaActual = paginaActual - 1;
    cargarDatos();
});

btnSiguiente.addEventListener("click", function() {
    paginaActual = paginaActual + 1;
    cargarDatos();
});

cargarDatos();