<?php
session_start();
// Cuando se registra un viaje, independientemente de si se ha creado correctamente o no, lo guardamos en _Session (bidaia_gorde.php)
if (isset($_SESSION['mensaje'])) {
    // Para poder ser usado en Javascript
    $mensaje = $_SESSION['mensaje'];    
    // Al mismo tiempo que la sesión para borrar el mensaje
    unset($_SESSION['mensaje']);
} else {
    $mensaje = '';
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Viajes Erreka-Mari - Menú Principal</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/web.js"></script>
</head>
<body>
    <header>
        <h1>
            <?php echo $_SESSION['agencia']; ?>
        </h1>
        <a href="login.php" class="logout-icono">
    <img src="imagenes/logout.svg" alt="logout"></a>
    </header>
    <main>
        <div class="contenedor_carrusel">
            <!-- Aquí se muestran las imágenes del carrusel -->
            <img src="imagenes/reservar_viaje.svg" alt="Descripcion reservar viaje" class="imagen_carrusel active">
            <img src="imagenes/reservar.svg" alt="Descripcion reservar" class="imagen_carrusel">
            <!-- Flechas para navegar en el carrusel -->
            <a href="#" class="flecha anterior">&lt;</a>
            <a href="#" class="flecha siguiente">&gt;</a>
        </div>
        <section class="opciones_menu">
            <h2>Elige una de las 2 opciones</h2>
            <div class="contenedor_opciones">
                <!-- Enlace para registrar un viaje -->
                <a href="erregistroa.php" class="boton_opcion">
                    <img src="imagenes/icono_avion.png" alt="Icono de avion">
                    <span>Registrar Viaje</span>
                </a>
                <!-- Enlace para registrar un servicio -->
                <a href="zerbitzuak.php" class="boton_opcion">
                    <img src="imagenes/icono_registro.png" alt="Icono de servicio">
                    <span>Registrar Servicio</span>
                </a>
            </div>
        </section>
    </main>
    <footer>
        <p>2025 Viajes Erreka-Mari.</p>
    </footer>
</body>
</html>
