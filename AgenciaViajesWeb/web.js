// Variables principales
var images = document.querySelectorAll('.contenedor_carrusel img'); // Seleccionar imágenes del carrusel
var currentIndex = 0; // Índice actual de la imagen visible

// Función para actualizar la imagen visible
function updateImageDisplay() {
    for (var i = 0; i < images.length; i++) {
        if (i === currentIndex) {
            images[i].classList.add('active'); // Activa la clase solo en la imagen actual
        } else {
            images[i].classList.remove('active'); // Elimina la clase de las otras imágenes
        }
    }
}

// Función para pasar a la siguiente imagen
function showNextImage(event) {
    if (event) event.preventDefault(); // Evita la recarga de página
    currentIndex = (currentIndex + 1) % images.length; // Incrementa el índice con bucle
    updateImageDisplay();
}

// Función para pasar a la imagen anterior
function showPreviousImage(event) {
    if (event) event.preventDefault(); // Evita la recarga de página
    currentIndex = (currentIndex - 1 + images.length) % images.length; // Decrementa el índice con bucle
    updateImageDisplay();
}

// Inicializar mostrando la primera imagen
updateImageDisplay();

// Seleccionar las flechas de navegación
var nextButton = document.querySelector('.flecha.siguiente');
var prevButton = document.querySelector('.flecha.anterior');

// Agregar eventos a las flechas
nextButton.addEventListener('click', showNextImage);
prevButton.addEventListener('click', showPreviousImage);
