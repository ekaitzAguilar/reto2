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
    <title>Viajes Erreka_Mari - Servicios</title>
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

        <form id="formulario_viajes" class="formulario" method="POST" action="zerbitzuak_gorde.php">
            <label for="eleccion_viaje">Seleccione el viaje</label><br>
            <select id="todos_viajes" name="todos_viajes" required>
                <option value="">--Seleccione--</option>
                    <?php
                    //DATU BASETIK
                    $conn = new mysqli($servername, $username, $password, $dbname);
                    if ($conn->connect_error) {
                        die("Connection failed: " . $conn->connect_error);
                    }
                    $sql = "SELECT id_viaje, nom_viaje FROM viaje";
                    $result = $conn->query($sql);
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            echo "<option value='" . $row['id_viaje'] . "'>" . $row['nom_viaje'] . "</option>";
                        }
                    }
                    $conn->close();
                    ?>
            </select><br>

            <!-- Formulario tipo viaje -->
            <div id="opciones">
                <label for="eleccion_viaje">¿Qué servicio desea registrar?</label><br><br>

                <input type="radio" name="tipo_servicio" value="vuelo" id="tipo_servicio" />
                <label for="tipo_servicio_vuelo">Vuelo</label></br>

                <input type="radio" name="tipo_servicio" value="hotel" id="tipo_servicio" />
                <label for="tipo_servicio_hotel">Hotel</label></br>

                <input type="radio" name="tipo_servicio" value="otros" id="tipo_servicio" />
                <label for="tipo_servicio_otros">Otros Servicios</label>

            </div>
            </br>

            <!-- SECCIONES -->
            <!-- Formulario de vuelo -->
            <div id="seccion_vuelo" class="seccion" style="display:none;">
                <h5>Vuelo</h5>
                <label for="eleccion_vuelo">¿Qué tipo de vuelo es?</label><br>
                <input type="radio" name="tipo_vuelo" value="vuelo_ida" id="tipo_vuelo" />
                <label for="tipo_vuelo_ida">Ida</label><br>
                <input type="radio" name="tipo_vuelo" value="vuelo_idaVuelta" id="tipo_vuelo" />
                <label for="tipo_vuelo_idaVuelta">Ida/Vuelta</label><br><br>
            </div>

            <!--Formulario para el vuelo de ida-->
            <div id="seccion_ida" style="display:none;">
                <h5>Vuelo(ida)</h5>

                <label for="ae_origen">Aeropuerto de origen</label><br>
                <select id="ae_origen" name="ae_origen" required>
                    <option value="ae_origen">--Seleccione--</option>
                    <!--Base de datos???-->
                        <?php
                        //DATU BASETIK
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT cod_aeropuerto, CONCAT(cod_aeropuerto, ' - ', ciudad) AS aeropuerto FROM aeropuerto";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['cod_aeropuerto'] . "'>" . $row['aeropuerto'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                </select><br><br>

                <label for="ae_destino">Aeropuerto de destino</label><br>
                <select id="ae_destino" name="ae_destino" required>
                    <option value="ae_destino">--Seleccione--</option>
                    
                    <!--Base de datos???-->
                        <?php
                        //DATU BASETIK
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT cod_aeropuerto, CONCAT(cod_aeropuerto, ' - ', ciudad) AS aeropuerto FROM aeropuerto";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['cod_aeropuerto'] . "'>" . $row['aeropuerto'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                        
                </select><br><br>

                <label for="cod_vuelo">Código de vuelo</label></br>
                <input type="text" id="cod_vuelo" name="cod_vuelo" maxlength="30" /><br><br>

                <label for="aerolinea">Aerolínea</label><br>
                <select id="aerolinea" name="aerolinea" required>
                    <option value="aerolinea">--Seleccione--</option>
                    <!--Base de datos???-->
                        <?php
                        //DATU BASETIK
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT cod_ae, CONCAT(cod_ae, ' - ', nom_ae) AS aerolinea FROM aerolinea";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['cod_ae'] . "'>" . $row['aerolinea'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                </select><br><br>

                <label for="precio">Precio(€)</label></br>
                <input type="number" id="precio" name="precio" maxlength="30" required/><br><br>

                <label for="fecha_salida">Fecha salida</label></br>
                <input type="date" id="fecha_salida" name="fecha_salida" required/><br><br>

                <label for="hora_salida">Hora salida</label></br>
                <input type="time" id="hora_salida" name="hora_salida" /><br></br>

                <label for="duracion_vuelo">Duración del vuelo (en horas)</label></br>
                <input type="text" id="duracion_vuelo" name="duracion_vuelo" maxlength="30" /><br><br>
            </div>

            <!--Formulario para el vuelo de ida/vuelta-->
            <div id="seccion_vuelta" style="display:none;">
                <h5>Vuelo(vuelta)</h5>

                <label for="fecha_vuelta">Fecha de vuelta</label></br>
                <input type="date" id="fecha_vuelta" name="fecha_vuelta" /><br><br>

                <label for="hora_vuelta">Hora de la vuelta</label></br>
                <input type="time" id="hora_vuelta" name="hora_vuelta" /><br></br>

                <label for="duracion_vuelta">Duración del vuelo de vuelta(en horas)</label></br>
                <input type="text" id="duracion_vuelta" name="duracion_vuelta" maxlength="30" /><br><br>

                <label for="cod_vuelo">Código del vuelo de vuelta</label></br>
                <input type="text" id="cod_vuelta" name="cod_vuelta" maxlength="30" /><br><br>

                <label for="aerolinea_vuelta">Aerolínea de vuelta</label><br>
                <select id="aerolinea_vuelta" name="aerolinea_vuelta" required>
                    <option value="aerolinea_vuelta">--Seleccione--</option>
                    <!--Base de datos???-->
                        <?php
                        //DATU BASETIK
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT cod_ae, CONCAT(cod_ae, ' - ', nom_ae) AS aerolinea FROM aerolinea";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['cod_ae'] . "'>" . $row['aerolinea'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                </select><br><br>
            </div>

            </div>

            <!--Formulario de hotel-->
            <div id="seccion_hotel" style="display:none;">
                <h5>Hotel</h5>

                <label for="nombre_hotel">Nombre del hotel</label><br>
                <input type="text" id="nombre_hotel" name="nombre_hotel" maxlength="30" /><br><br>

                <label for="ciudad">Ciudad</label></br>
                <input type="text" id="ciudad" name="ciudad" maxlength="30" /><br><br>

                <label for="precio">Precio(€)</label></br>
                <input type="number" id="precio" name="precio" maxlength="30" /><br><br>

                <label for="fecha_entrada">Fecha llegada</label></br>
                <input type="date" id="fecha_salida" name="fecha_salida" /><br><br>

                <label for="fecha_salida">Fecha vuelta</label></br>
                <input type="date" id="fecha_vuelta" name="fecha_vuelta" /><br><br>

                <label for="tipo_habitacion">Tipo de habitación</label></br>
                <select id="tipo_habitacion" name="tipo_habitacion" required>
                    <option value="seleccion_habitacion">--Seleccione --</option>
                        <?php
                        // DATU BASETIK
                        $conn = new mysqli($servername, $username, $password, $dbname);
                        if ($conn->connect_error) {
                            die("Connection failed: " . $conn->connect_error);
                        }
                        $sql = "SELECT id_tipo_hab, desc_hab FROM tipo_habitacion"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['id_tipo_hab'] . "'>" . $row['desc_hab'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                </select><br><br>

            </div>

            <!-- Formulario de otros -->
            <div id="seccion_otros" class="seccion" style="display:none;">
                <h5>Otros Servicios</h5>
                <label for="nombre_otros">Nombre</label><br>
                <input type="text" id="nombre_otros" name="nombre_otros" maxlength="100" /><br><br>
                <label for="fecha_otros">Fecha</label><br>
                <input type="date" id="fecha_otros" name="fecha_salida" /><br><br>
                <label for="desc_otros">Descripción</label><br>
                <textarea id="desc_otros" name="desc_otros"></textarea><br><br>
                <label for="precio_otros">Precio(€)</label><br>
                <input type="number" id="precio_otros" name="precio" maxlength="30" /><br><br>
            </div>

            <br><br>
            <input type="submit" class="Guardar" value="Guardar" href="menu.php">
        </form>

    </main>
    <footer>
        <p>2025 Viajes Erreka-Mari.</p>
    </footer>
</body>

</html>