<?php
session_start();

$servername = "localhost:3306";
$username = "root";        
$password = "";         
$dbname = "agenciaPruebas";    

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} else {
    echo "Conexión establecida con éxito.";
}

if (isset($_SESSION['agencia'])) {
    $idAgencia = $_SESSION['agencia'];
    echo "El ID de la agencia logueada es: " . $idAgencia;
} else {
    echo "No hay ninguna agencia logueada.";
}

error_log("Datos recibidos: " . print_r($_POST, true));

// Recojo los datos de registro (viaje)
$nom_viaje      = $conn->real_escape_string($_POST['nom_viaje']);
$fec_ini        = $conn->real_escape_string($_POST['fec_ini']);
$fec_fin        = $conn->real_escape_string($_POST['fec_fin']);
$duracion       = $conn->real_escape_string($_POST['duracion']);
$pais           = $conn->real_escape_string($_POST['pais']);
$desc_viaje    = $conn->real_escape_string($_POST['desc_viaje']);
$serv_no_inc   = $conn->real_escape_string($_POST['serv_no_inc']);
$idAgencia      = $conn->real_escape_string($_SESSION['agencia']);
$tipo_viaje  = $conn->real_escape_string($_POST['tipo_viaje']);

// Obtener el id_tipo_viaje
$sql_get_id = "SELECT id_tipo_viaje FROM tipo_viaje WHERE desc_tipo_viaje = ?";
$stmt_get_id = $conn->prepare($sql_get_id);
$stmt_get_id->bind_param("s", $tipo_viaje);
$stmt_get_id->execute();
$result = $stmt_get_id->get_result();

if ($row = $result->fetch_assoc()) {
    $id_tipo_viaje = $row['id_tipo_viaje'];

    // Insertamos los datos a la tabla Viaje
    $sql_viaje = "INSERT INTO viaje (nom_viaje, fec_ini, fec_fin, duracion, pais, desc_viaje, serv_no_inc, id_agencia, id_tipo_viaje)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    $stmt = $conn->prepare($sql_viaje);
    $stmt->bind_param("sssisssii", $nom_viaje, $fec_ini, $fec_fin, $duracion, $pais, $desc_viaje, $serv_no_inc, $idAgencia, $id_tipo_viaje);
    if ($stmt->execute()) {
        $_SESSION['mensaje'] = "El viaje se ha registrado correctamente.";
    } else {
        $_SESSION['mensaje'] = "Error al registrar el viaje: " . $stmt->error;
    }

    $stmt->close();
} else {
    $_SESSION['mensaje'] = "No se encontró el tipo de viaje seleccionado.";
}

$stmt_get_id->close();



/*// Recojo los datos del formulario de tipo viajes
$todos_viajes   = $_POST['todos_viajes'];
$vuelo          = $_POST['vuelo'];
$hotel          = $_POST['hotel'];
$hotel          = $_POST['otros_servicios'];

// Recojo los datos del formulario vuelo (ida)
$ae_origen      = $_POST['ae_origen'];
$ae_destino     = $_POST['ae_destino'];
$cod_vuelo      = $_POST['cod_vuelo'];
$aerolinea      = $_POST['aerolinea'];
$precio         = $_POST['precio'];
$fecha_salida   = $_POST['fecha_salida'];
$hora_salida    = $_POST['hora_salida'];
$duracion_vuelo = $_POST['duracion_vuelo'];

// Recojo los datos del Formulario Vuelo (ida/vuelta) se añade lo de ida
$fecha_vuelta       = $_POST['fecha_vuelta'];
$hora_vuelta        = $_POST['hora_vuelta'];
$duracion_vuelta    = $_POST['duracion_vuelta'];
$cod_vuelta         = $_POST['cod_vuelta'];
$aerolinea_vuelta   = $_POST['aerolinea_vuelta'];

//Recojo los datos del formulario de hotel
$nombre_hotel       = $_POST['nombre_hotel'];
$ciudad             = $_POST['ciudad'];
$precio             = $_POST['precio'];
$fec_entrada        = $_POST['fec_entrada'];
$fec_salida         = $_POST['fec_salida'];
$tipo_habi          = $_POST['tipo_habi'];

//Recojo los datos del formulario de otros servicios
$nombre_otros       = $_POST['nombre_otros'];
$fecha_otros        = $_POST['fecha_otros'];
$desc_otros         = $_POST['desc_otros'];
$precio_otros       = $_POST['precio_otros'];



// Insertamos los datos a la tabla de hotel a evento
$sql = "INSERT INTO evento
        VALUES ("$nombre_hotel, $ciudad, $precio, $fec_entrada, $fec_salida, $tipo_habitacion")";


// Kontsulta exekutatu
if ($conn->query($sql) === TRUE) {
    // Mezua baldin eta ondo erregistratu den datu basean
    $_SESSION['mensaje'] = "El viaje se ha registrado correctamente.";
} else {
    // Mezua baldin eta txarto erregistratu den datu basean
    $_SESSION['mensaje'] = "Error al registrar el viaje: " . $conn->error;
}
*/
// KOnexioa itxi
$conn->close();

// Menua.php-ra itzuli (bai ondo ala txarto egin den erregistroa.. edo agian txarto egiten bada mantentzen gara orri berean?)
header("Location: menu.php");
exit();
?>
?>0