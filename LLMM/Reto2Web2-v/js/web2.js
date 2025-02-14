// Validar que se carga el js en la pagina cargada
console.log("Cargando web.js en:", window.location.pathname);

// Asignar evento al botón de login cuando cargue la página
document.addEventListener("DOMContentLoaded", function () {
  var botonLogin = document.getElementById("btnLogin");
  if (botonLogin) {
      botonLogin.addEventListener("click", iniciarSesion);
      botonLogin.addEventListener("click", mensajePrueba);
  }
});

document.addEventListener('DOMContentLoaded', function () {
  // Verificar en qué página estamos y ejecutar la función correspondiente
  if (window.location.pathname.includes("menu")) {
    inicializarCarrusel();
  }
  document.getElementById('fecha_entrada').addEventListener('change', validarFechaSalida);
  document.getElementById('fecha_salida').addEventListener('change', validarFechaSalida);
  if (window.location.pathname.includes("zerbitzuak")) {
    inicializarSelectorOpciones();
    //inicializarValidacionesFechas();
  }
});

function iniciarSesion() {
  console.log("Iniciando sesión...");

  // Obtener los valores del formulario
  var usuarioIngresado = document.getElementById("usuario").value;
  var contrasenaIngresada = document.getElementById("contrasena").value;

  if (!usuarioIngresado || !contrasenaIngresada) {
      alert("Por favor, ingrese usuario y contraseña.");
      return;
  }

  // Validar usuario y contraseña con los datos cargados desde PHP
  var usuarioValido = false;

  for (var i = 0; i < usuariosDB.length; i++) {
      if (usuariosDB[i].NOMBRE === usuarioIngresado && usuariosDB[i].PASSWORD === contrasenaIngresada) {
          usuarioValido = true;
          break;
      }
  }

  if (usuarioValido) {
      alert("Inicio de sesión exitoso.");
      window.location.href = "menu.php"; // Redirigir a menu.php
  } else {
      alert("Usuario o contraseña incorrectos.");
  }
}
/*function iniciarSesion() {
  console.log("Iniciando sesión...");

  // Obtener los valores del formulario
  var usuarioIngresado = document.getElementById("usuario").value;
  var contrasenaIngresada = document.getElementById("password").value;

  if (!usuarioIngresado || !contrasenaIngresada) {
      alert("Por favor, ingrese usuario y contraseña.");
      return;
  }

  // Validar usuario y contraseña con los datos cargados desde PHP
  var usuarioValido = false;

  for (var i = 0; i < usuariosDB.length; i++) {
      if (usuariosDB[i].NOMBRE === usuarioIngresado && usuariosDB[i].PASSWORD === contrasenaIngresada) {
          usuarioValido = true;
          break;
      }
  }

  if (usuarioValido) {
      alert("Inicio de sesión exitoso.");
      window.location.href = "menu.php"; // Redirigir a menu.php
  } else {
      alert("Usuario o contraseña incorrectos.");
  }
}*/

function mensajePrueba() {
  window.prompt("Mensaje de prueba...");
}

function inicializarCarrusel() {

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
}


function inicializarSelectorOpciones() {
  console.log("Ejecutando inicializarSelectorOpciones...");

  var radiosServicio = document.querySelectorAll('input[name="tipo_servicio"]');
  console.log("Radios de servicio encontrados:", radiosServicio.length);

  var seccionVuelo = document.getElementById("seccion_vuelo");
  var seccionHotel = document.getElementById("seccion_hotel");
  var seccionOtros = document.getElementById("seccion_otros");
  var seccionIda = document.getElementById("seccion_ida");
  var seccionVuelta = document.getElementById("seccion_vuelta");

  radiosServicio.forEach(function (radio) {
      radio.addEventListener("change", function () {
          console.log("Opción seleccionada:", this.value);

          // Verificar que los elementos existen antes de usarlos
          if (seccionVuelo) seccionVuelo.style.display = "none";
          if (seccionHotel) seccionHotel.style.display = "none";
          if (seccionOtros) seccionOtros.style.display = "none";
          if (seccionIda) seccionIda.style.display = "none";
          if (seccionVuelta) seccionVuelta.style.display = "none";

          // Mostrar la sección correspondiente si el elemento existe
          if (this.value === "vuelo" && seccionVuelo) {
              seccionVuelo.style.display = "block";
          } else if (this.value === "hotel" && seccionHotel) {
              seccionHotel.style.display = "block";
          } else if (this.value === "otros" && seccionOtros) {
              seccionOtros.style.display = "block";
          } 
          if (tipoVuelo === 'vuelo_ida' && seccionIda) {
            seccionIda.style.display = 'block';
          } else if (tipoVuelo === 'vuelo_idaVuelta' && seccionIda && seccionVuelta) {
            seccionIda.style.display = 'block';
            seccionVuelta.style.display = 'block';
        }

        // Event listener para el tipo de vuelo (ida/ida-vuelta)
        radiosTipoVuelo.forEach(function (radio) {
          radio.addEventListener("change", function () {
              mostrarSeccionesVuelo(this.value);
          });
        });
      });
  });
}


// Función para comprobar que la fecha de salida del hotel es posterior a la de entrada y que aparezca un error si no es así en el momento de seleccionar la fecha de salida del hotel
function validarFechaSalida() {
  var fechaEntrada = document.getElementById('fecha_entrada');
  var fechaSalida = document.getElementById('fecha_salida');

  if (fechaSalida.value && fechaEntrada.value) {
    var fechaEntradaValue = new Date(fechaEntrada.value);
    var fechaSalidaValue = new Date(fechaSalida.value);

    if (fechaSalidaValue <= fechaEntradaValue) {
      alert("La fecha de salida no puede ser anterior o igual a la fecha de entrada.");
      fechaSalida.value = ""; // Limpiar el campo de fecha de salida
    }
  }
}
















