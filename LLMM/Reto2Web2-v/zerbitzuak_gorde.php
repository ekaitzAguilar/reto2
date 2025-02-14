<?php
session_start();

$servername = "localhost:3306";
$username = "root";        
$password = "";         
$dbname = "agenciaPruebas";    

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id_viajes = trim($_POST['todos_viajes'] ?? '');
    $tipo = trim($_POST['tipo_servicio'] ?? '');
    $fec_ida = trim($_POST['fecha_salida'] ?? ''); 
    $precio = trim($_POST['precio'] ?? '');

    echo "Valores recibidos:<br>";
    echo "ID Viaje: " . htmlspecialchars($id_viajes) . "<br>";
    echo "Tipo: " . htmlspecialchars($tipo) . "<br>";
    echo "Fecha de Ida (sin procesar): " . htmlspecialchars($fec_ida) . "<br>";
    echo "Precio (sin procesar): " . htmlspecialchars($precio) . "<br>";

   // exit(); // Detiene la ejecución para ver los valores antes de validar.

    $errores = [];

     // Validación de fecha y precio
    if (empty($fec_ida) || !DateTime::createFromFormat('Y-m-d', $fec_ida)) {
        echo "Error: La fecha de ida es inválida o está vacía.<br>";
        $errores[] = "La fecha de ida es inválida o está vacía.";
    }

    if (empty($precio) || !is_numeric($precio)) {
        echo "Error: El precio es inválido o está vacío.<br>";
        $errores[] = "El precio es inválido o está vacío.";
    }

    if (!empty($errores)) {
        echo "Por favor, corrige los errores antes de continuar.<br>";
    } else {
        // Procesar la fecha
        $fecha_objeto = DateTime::createFromFormat('Y-m-d', $fec_ida);
        $fec_ida = $fecha_objeto->format('Y-m-d');

        // Convertir el precio a un formato numérico seguro
        $precio = floatval($precio);

        echo "Valores procesados:<br>";
        echo "Fecha de Ida: " . htmlspecialchars($fec_ida) . "<br>";
        echo "Precio: " . htmlspecialchars($precio) . "<br>";

        $sql = null;
        $stmt = null;

    if ($tipo == "vuelo") {
        $trayecto = trim($_POST['tipo_vuelo'] ?? '');
        $ae_origen = trim($_POST['ae_origen'] ?? '');
        $ae_destino = trim($_POST['ae_destino'] ?? '');
        $cod_vuelo_ida = trim($_POST['cod_vuelo'] ?? '');
        $aerolinea_ida = trim($_POST['aerolinea'] ?? '');
        $hora_ida = trim($_POST['hora_salida'] ?? '');
        $duracion_ida = trim($_POST['duracion_vuelo'] ?? '');

        echo "ID Viaje: " . htmlspecialchars($id_viajes) . "<br>";
        echo "Tipo: " . htmlspecialchars($tipo) . "<br>";
        echo "Fecha de Ida: " . htmlspecialchars($fec_ida) . "<br>";
        echo "Precio: " . htmlspecialchars($precio) . "<br>";
        echo "Trayecto: " . htmlspecialchars($trayecto) . "<br>";
        echo "Origen: " . htmlspecialchars($ae_origen) . "<br>";
        echo "Destino: " . htmlspecialchars($ae_destino) . "<br>";
        echo "Código Vuelo Ida: " . htmlspecialchars($cod_vuelo_ida) . "<br>";
        echo "Aerolínea Ida: " . htmlspecialchars($aerolinea_ida) . "<br>";
        echo "Hora Ida: " . htmlspecialchars($hora_ida) . "<br>";
        echo "Duración Ida: " . htmlspecialchars($duracion_ida) . "<br>";

        //exit(); // Detiene la ejecución para ver los valores antes de insertar.

        if (empty($trayecto) || empty($ae_origen) || empty($ae_destino) || empty($cod_vuelo_ida) || empty($aerolinea_ida) || empty($hora_ida) || empty($duracion_ida)) {
            echo "Faltan campos del vuelo.";
            $errores[] = "Faltan campos del vuelo.";
        }

        if ($trayecto == "idaVuelta") {
            $fec_vuelta = trim($_POST['fecha_vuelta'] ?? '');
            $hora_vuelta = trim($_POST['hora_vuelta'] ?? '');
            $duracion_vuelta = trim($_POST['duracion_vuelta'] ?? '');
            $cod_vuelo_vuelta = trim($_POST['cod_vuelta'] ?? '');
            $aerolinea_vuelta = trim($_POST['aerolinea_vuelta'] ?? '');

            echo "Fecha Vuelta: " . htmlspecialchars($fec_vuelta) . "<br>";
            echo "Hora Vuelta: " . htmlspecialchars($hora_vuelta) . "<br>";
            echo "Duración Vuelta: " . htmlspecialchars($duracion_vuelta) . "<br>";
            echo "Código Vuelo Vuelta: " . htmlspecialchars($cod_vuelo_vuelta) . "<br>";
            echo "Aerolínea Vuelta: " . htmlspecialchars($aerolinea_vuelta) . "<br>";
   
            //exit(); // Detiene la ejecución para ver los valores antes de insertar.

            if (empty($fec_vuelta) || empty($hora_vuelta) || empty($duracion_vuelta) || empty($cod_vuelo_vuelta) || empty($aerolinea_vuelta)) {
                echo "Faltan campos de vuelta.";
                $errores[] = "Faltan campos de vuelta.";
            }

            $sql = "INSERT INTO evento (id_viajes, tipo, fec_ida, precio, trayecto, ae_origen, ae_destino, cod_vuelo_ida, aerolinea_ida, hora_ida, duracion_ida, fec_vuelta, hora_vuelta, duracion_vuelta, cod_vuelo_vuelta, aerolinea_vuelta) 
                    VALUES ('$id_viajes', '$tipo', '$fec_ida', '$precio', '$trayecto', '$ae_origen', '$ae_destino', '$cod_vuelo_ida', '$aerolinea_ida', '$hora_ida', '$duracion_ida', '$fec_vuelta', '$hora_vuelta', '$duracion_vuelta', '$cod_vuelo_vuelta', '$aerolinea_vuelta')";

            $stmt = $conn->prepare($sql);
            $stmt->bind_param("sssdssssssssssss", $id_viajes, $tipo, $fec_ida, $precio, $trayecto, $ae_origen, $ae_destino, $cod_vuelo_ida, $aerolinea_ida, $hora_ida, $duracion_ida, $fec_vuelta, $hora_vuelta, $duracion_vuelta, $cod_vuelo_vuelta, $aerolinea_vuelta);

        } else {
            $sql = "INSERT INTO evento (id_viajes, tipo, fec_ida, precio, trayecto, ae_origen, ae_destino, cod_vuelo_ida, aerolinea_ida, hora_ida, duracion_ida) 
                    VALUES ('$id_viajes', '$tipo', '$fec_ida', '$precio', '$trayecto', '$ae_origen', '$ae_destino', '$cod_vuelo_ida', '$aerolinea_ida', '$hora_ida', '$duracion_ida')";

            $stmt = $conn->prepare($sql);
            $stmt->bind_param("sssdsssssss", $id_viajes, $tipo, $fec_ida, $precio, $trayecto, $ae_origen, $ae_destino, $cod_vuelo_ida, $aerolinea_ida, $hora_ida, $duracion_ida);

        }
    } elseif ($tipo == "hotel") {
        $fec_vuelta = trim($_POST['fecha_entrada'] ?? '');
        $ciudad = trim($_POST['ciudad'] ?? '');
        $nom_evento = trim($_POST['nombre_evento'] ?? '');
        $id_tipo_hab = trim($_POST['tipo_habitacion'] ?? '');

        echo "Fecha Vuelta: " . htmlspecialchars($fec_vuelta) . "<br>";
        echo "Ciudad: " . htmlspecialchars($ciudad) . "<br>";
        echo "Nombre Evento: " . htmlspecialchars($nom_evento) . "<br>";
        echo "Tipo Habitación: " . htmlspecialchars($id_tipo_hab) . "<br>";

        //exit(); // Detiene la ejecución para ver los valores antes de insertar.

        if (empty($fec_vuelta) || empty($ciudad) || empty($nom_evento) || empty($id_tipo_hab)) {
            echo "Faltan campos del hotel.";
            $errores[] = "Faltan campos del hotel.";
        }

        $sql = "INSERT INTO evento (id_viajes, tipo, fec_ida, fec_vuelta, precio, ciudad, nom_evento, id_tipo_hab) 
                VALUES ('$id_viajes', '$tipo', '$fec_ida', '$fec_vuelta', '$precio', '$ciudad', '$nom_evento', '$id_tipo_hab')";

        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ssssdssi", $id_viajes, $tipo, $fec_ida, $fec_vuelta, $precio, $ciudad, $nom_evento, $id_tipo_hab);

    } elseif ($tipo == "otros") {

        $nom_evento = trim($_POST['nombre_otros'] ?? '');
        $desc_act = trim($_POST['desc_otros'] ?? '');

        echo "Nombre Evento: " . htmlspecialchars($nom_evento) . "<br>";
        echo "Descripción Actividad: " . htmlspecialchars($desc_act) . "<br>";

        //exit(); // Detiene la ejecución para ver los valores antes de insertar.

        if (empty($nom_evento) || empty($desc_act) || empty($precio)) {
            echo "Faltan campos del evento.";
            $errores[] = "Faltan campos del evento.";
        }

        $sql = "INSERT INTO evento (id_viajes, tipo, fec_ida, precio, nom_evento, desc_act) 
                VALUES ('$id_viajes', '$tipo', '$fec_ida', '$precio', '$nom_evento', '$desc_act')";

        $stmt = $conn->prepare($sql);
        $stmt->bind_param("sssdss", $id_viajes, $tipo, $fec_ida, $precio, $nom_evento, $desc_act);

    }
    
    if (empty($errores)) {
        if ($stmt === null || $sql === null) {
            echo "Error: No se ha definido la consulta SQL.<br>";
        } elseif ($stmt->execute()) {
            echo "Registro guardado exitosamente";
        } else {
            echo "Error: " . $stmt->error;
        }

        if ($stmt !== null) {
            $stmt->close();
        }
    }
}
    $conn->close();

    //header("Location: menu.php");
    exit();
} else {
    echo "Método de solicitud no permitido.";
}
?>