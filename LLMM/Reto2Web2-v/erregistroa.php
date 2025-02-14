<?php
session_start();

// parámetros de conexión a la base de datos
$servername = "localhost:3306";
$username   = "root";
$password   = "";
$dbname     = "agenciaPruebas";
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Viajes Erreka_Mari - Registro Viajes</title>
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/web.js"></script>
  </head>
<body>
<header>
        
        <h1>
            <?php echo $_SESSION['agencia']; ?>
        </h1>
        <a href="index.php" class="logout-icono">
    <img src="imagenes/logout.svg" alt="logout"></a>
    </header>
    <main>
        <div id="seccion_hotel">
            <h5>Registro</h5>
        </div>

        <form id="formulario_registro" class="formulario" method="POST" action="bidaia_gorde.php">
            <label for="nombre_viaje">Nombre</label>
            <div id="nombre_viaje"><input type="text"  name="nom_viaje" required></div><br><br>

            <label for="tipo_viaje">Tipo viaje:</label>
            <select id="tipo_viaje" name="tipo_viaje" required>

            <option value="">--Seleccione--</option>
                <!-- DATU BASETIK -->

                <?php
                $conn = new mysqli($servername, $username, $password, $dbname);
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
                $sql = "SELECT id_tipo_viaje, desc_tipo_viaje FROM tipo_viaje";
                $result = $conn->query($sql);
                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        echo "<option value='" . $row['id_tipo_viaje'] . "'>" . $row['desc_tipo_viaje'] . "</option>";
                    }
                }
                $conn->close();
                ?>
            </select>            
            <br><br>
            
            <label for="fecha_inicio">Fecha inicio</label>
            <div id="fecha_entrada">
            <input type="date" id="fecha_entrada" name="fec_ini" />
            </div><br><br>
            
            
            <label for="fecha_fin">Fecha fin</label>
            <div id="fecha_salida">
            <input type="date" id="fecha_salida" name="fec_fin"/>
            </div><br></br>
            
            
            <label for="dias">Días</label>
            <div id="dias">
            <input type="text" id="dias" name="duracion" maxlength="30"/>
            </div><br><br>

            <label for="pais">País:</label>
            <select id="pais" name="pais" required>
                <option value="">--Seleccione--</option>
                <!-- DATU BASETIK -->
               <?php
                $conn = new mysqli($servername, $username, $password, $dbname);
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
                $sql = "SELECT cod_pais, nom_pais FROM pais";
                $result = $conn->query($sql);
                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        echo "<option value='" . $row['cod_pais'] . "'>" . $row['nom_pais'] . "</option>";
                    }
                }
                $conn->close();
                ?>
            </select><br><br>

            <label for="desc_viajes">Descripción:</label>
            <textarea id="desc_viajes" name="desc_viaje" required></textarea><br><br>

            <label for="serv_no_incl">Servicios no incluidos:</label>
            <textarea id="serv_no_incl" name="serv_no_inc" required></textarea><br><br>

            <input type="submit" class="Guardar" value="Guardar" href="menu.php">
        </form>
          
    </main>
    <footer>
        <p>2025 Viajes Erreka-Mari.</p>
    </footer>
</body>
</html>