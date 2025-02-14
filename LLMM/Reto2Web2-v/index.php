<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Viajes Erreka_Mari - Login</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/web.js"></script>
</head>
<body class="login-page">
    <div class="contenedor_login">
        <h1>Login</h1>
        <?php
        // Para trabajar con sesion $_SESSION
        session_start();

        // parámetros de conexión a la base de datos
        $servername = "localhost:3306";
        $username   = "root";
        $password   = "";
        $dbname     = "agenciaPruebas";

        // Haces conexión
        $conn = new mysqli($servername, $username, $password, $dbname);

        // Verficar la conexión
        if ($conn->connect_error) {
            die("Fallo en la conexión: " . $conn->connect_error);
        }

        $error = '';

        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Recuperar los datos del formulario
            $usuario = $_POST['usuario'];
            $password = $_POST['password'];

            // Consulta SQL
            $sql = "SELECT * FROM agencia WHERE nom_agencia = '$usuario' AND PASSWORD = '$password'";

            // Ejecutar la consulta
            $result = $conn->query($sql);

            // verificar si el usuario existe
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    $_SESSION['agencia'] = $row['nom_agencia']; // Guardaremos el nombre de la agencia para mostrarlo luego en la cabecera 
                    $_SESSION['id_agencia'] = $row['id_agencia'];
                }
                // Si hemos encontrado el registro, nos logueamos y seguimos adelante: redirigir a la página menu.php
                header("Location: menu.php");
                exit();
            } else {
                // Si no existe, mensaje de error
                $error = 'Usuario o contraseña incorrectos';
                
            }
        }

        // Cerrar conexión
        $conn->close();
        ?>
    
        <form id="formulario_login" method="POST">
            <div class="grupo_formulario">
                <label for="usuario">Nombre de la Agencia</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>
            <div class="grupo_formulario">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" required>
                <div class="botonLogin">
                    <button type="submit">Iniciar sesión</button>
                </div>
        </form>
    </div>
</body>
</html>
