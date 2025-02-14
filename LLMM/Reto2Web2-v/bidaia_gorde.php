<?php
session_start();

$servername = "localhost:3306";
$username = "root";        
$password = "";         
$dbname = "agenciaPruebas";    

$conn = new mysqli($servername, $username, $password, $dbname);

//include 'erregistroa.php'; // Asegurar que la conexión a la BD está incluida

// Verificar que la solicitud es POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtener los datos del formulario
    $nom_viaje  = trim($_POST['nom_viaje'] ?? '');
    $fec_ini    = trim($_POST['fec_ini'] ?? '');
    $fec_fin    = trim($_POST['fec_fin'] ?? '');
    $duracion   = trim($_POST['duracion'] ?? '');
    $pais       = trim($_POST['pais'] ?? '');
    $desc_viaje = trim($_POST['desc_viaje'] ?? '');
    $serv_no_inc = trim($_POST['serv_no_inc'] ?? '');
    $id_agencia = $_SESSION['id_agencia'] ?? die("Error: La agencia no está en la sesión.");
    $id_tipo_viaje = trim($_POST['tipo_viaje'] ?? '');

   /*echo "nom_viaje: " . htmlspecialchars($nom_viaje) . "<br>";
   echo "fec_ini: " . htmlspecialchars($fec_ini) . "<br>";
   echo "fec_fin: " . htmlspecialchars($fec_fin) . "<br>";
   echo "duracion: " . htmlspecialchars($duracion) . "<br>";
   echo "pais: " . htmlspecialchars($pais) . "<br>";
   echo "desc_viaje: " . htmlspecialchars($desc_viaje) . "<br>";
   echo "serv_no_inc: " . htmlspecialchars($serv_no_inc) . "<br>";
   echo "id_tipo_viaje: " . htmlspecialchars($id_tipo_viaje) . "<br>";
   echo "id_agencia: " . htmlspecialchars($id_agencia) . "<br>";
   
   exit(); // Esto detiene la ejecución para ver los valores antes de insertar.*/
   
   $sql_check_tipo_viaje = "SELECT COUNT(*) FROM tipo_viaje WHERE id_tipo_viaje = ?";
    $stmt_check = $conn->prepare($sql_check_tipo_viaje);
    $stmt_check->bind_param("i", $id_tipo_viaje);
    $stmt_check->execute();
    $stmt_check->bind_result($count);
    $stmt_check->fetch();
    $stmt_check->close();

    if ($count == 0) {
        die("Error: El tipo de viaje no existe en la base de datos.");
    }

    // Validaciones
    if (empty($nom_viaje) || empty($fec_ini) || empty($fec_fin) || empty($duracion) || empty($pais) || empty($desc_viaje) || empty($serv_no_inc) || empty($id_tipo_viaje) || empty($id_agencia)) {
        die("Error: Todos los campos son obligatorios.");
    }

    // Validar formato de fechas
    if (!DateTime::createFromFormat('Y-m-d', $fec_ini) || !DateTime::createFromFormat('Y-m-d', $fec_fin)) {
        die("Error: Formato de fecha inválido.");
    }

    // Validar duración (debe ser un número entero positivo)
    if (!ctype_digit($duracion) || $duracion <= 0) {
        die("Error: La duración debe ser un número entero positivo.");
    }

    // Conexión a la base de datos
    $conn = new mysqli($servername, $username, $password, $dbname);
    
    if ($conn->connect_error) {
        die("Error de conexión: " . $conn->connect_error);
    }

    // Conectar a la base de datos
$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

    // Preparar la consulta SQL con valores correctos
    $stmt = $conn->prepare("INSERT INTO viaje (nom_viaje, fec_ini, fec_fin, duracion, pais, desc_viaje, serv_no_inc, id_agencia, id_tipo_viaje) 
                            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    
    if (!$stmt) {
        die("Error al preparar la consulta: " . $conn->error);
    }

    // Enlazar parámetros
    $stmt->bind_param("sssisssis", $nom_viaje, $fec_ini, $fec_fin, $duracion, $pais, $desc_viaje, $serv_no_inc, $id_agencia, $id_tipo_viaje);

    // Ejecutar la consulta
    if ($stmt->execute()) {
        echo "Viaje guardado correctamente.";
    } else {
        echo "Error al guardar el viaje: " . $stmt->error;
    }

    // Cerrar conexiones
    $stmt->close();
    $conn->close();

    header("Location: menu.php");
    exit();
} else {
    echo "Método de solicitud no permitido.";
}
