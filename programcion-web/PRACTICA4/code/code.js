let inputProducto = document.getElementById("input-producto");
let btnAgregar = document.getElementById("btn-agregar");
let btnOrdenar = document.getElementById("btn-ordenar");
let listaUI = document.getElementById("lista-productos");

let productos = [];
let ordenAZ = true;

function renderLista() {
    listaUI.innerHTML = "";

    productos.forEach(function(producto, index) {
        let li = document.createElement("li");

        if (producto.completado === true) {
            li.classList.add("completado");
        }

        let checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = producto.completado;
        
        checkbox.addEventListener("change", function() {
            if (producto.completado === true) {
                producto.completado = false;
            } else {
                producto.completado = true;
            }
            renderLista(); 
        });

        let texto = document.createElement("span");
        texto.textContent = producto.nombre;

        let btnEliminar = document.createElement("button");
        btnEliminar.textContent = "Eliminar";
        btnEliminar.classList.add("btn-eliminar");
        
        btnEliminar.addEventListener("click", function() {
            productos = productos.filter(function(prod, i) {
                return i !== index;
            });
            renderLista();
        });

        li.appendChild(checkbox);
        li.appendChild(texto);
        li.appendChild(btnEliminar);
        
        listaUI.appendChild(li);
    });
}

function agregarProducto() {
    let nombreProd = inputProducto.value;

    if (nombreProd.trim() !== "") {
        productos.push({ nombre: nombreProd, completado: false });
        inputProducto.value = ""; 
        renderLista();
    } else {
        alert("El campo esta vacio");
    }
}

btnAgregar.addEventListener("click", agregarProducto);

inputProducto.addEventListener("keypress", function(evento) {
    if (evento.key === "Enter") {
        agregarProducto();
    }
});

btnOrdenar.addEventListener("click", function() {
    if (ordenAZ === true) {
        productos.sort(function(a, b) {
            if (a.nombre > b.nombre) {
                return 1;
            } else if (a.nombre < b.nombre) {
                return -1;
            } else {
                return 0;
            }
        });
        ordenAZ = false;
        btnOrdenar.textContent = "Ordenar Z-A";
    } else {
        productos.sort(function(a, b) {
            if (a.nombre < b.nombre) {
                return 1;
            } else if (a.nombre > b.nombre) {
                return -1;
            } else {
                return 0;
            }
        });
        ordenAZ = true;
        btnOrdenar.textContent = "Ordenar A-Z";
    }

    renderLista();
});