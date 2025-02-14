-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-02-2025 a las 11:35:30
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `agencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aerolinea`
--

CREATE TABLE `aerolinea` (
  `cod_ae` varchar(3) NOT NULL,
  `nom_ae` varchar(100) NOT NULL,
  `cod_pais` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `aerolinea`
--

INSERT INTO `aerolinea` (`cod_ae`, `nom_ae`, `cod_pais`) VALUES
('2K', 'AVIANCA-Ecuador dba AVIANCA EC', 'EC'),
('3P', 'World 2 Fly PT, S.A.', 'PT'),
('6B', 'TUIfly Nordic AB', 'CN'),
('A.C', 'Air France', 'FR'),
('A0', 'BA Euroflyer Limited dba British Airways', 'GB'),
('AA', 'American Airlines', 'US'),
('AM', 'Aerovias de Mexico SA de CV dba AeroMexico', 'MX'),
('AR', 'Aerolineas Argentinas S.A.', 'AR'),
('AV', 'Aerovias del Continente Americano S.A. AVIANCA', 'CO'),
('AY', 'Finnair', 'FI'),
('AZ', 'Alitalia', 'IT'),
('BA', 'British Airways PLC', 'GB'),
('CL', 'Lufthansa CityLine GmbH', 'DE'),
('DE', 'Condor Flugdienst GmbH', 'DE'),
('DL', 'Delta Air Lines Inc', 'US'),
('DS', 'Easyjet CH S.A.', 'CH'),
('GL', 'Air GRL', 'GL'),
('JJ', 'Tam Linhas Aereas SA dba Latam Airlines Brasil', 'BR'),
('KL', 'KLM', 'NL'),
('KN', 'CN United Airlines', 'CN'),
('LH', 'Lufthansa', 'DE'),
('LX', 'SWISS International Air Lines Ltd', 'CH'),
('M3', 'BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br', 'BR'),
('MS', 'Egyptair', 'EG'),
('MT', 'MT Air Travel Ltd dba MT MedAir', 'MT'),
('N0', 'Norse Atlantic Airways AS', 'NO'),
('OU', 'HR Airlines d.d.', 'HR'),
('PC', 'Pegasus Airlines', 'TR'),
('QR', 'QA Airways Group Q.C.S.C dba QA Airways', 'QA'),
('RJ', 'Alia - The Royal JOn Airlines dba Royal JOn', 'JO'),
('RK', 'RYANAIR', 'GB'),
('S4', 'SATA Internacional - Azores Airlines, S.A.', 'PT'),
('SN', 'Brussels Airlines', 'BE'),
('SP', 'SATA (Air Acores)', 'PT'),
('TK', 'Turkish Airlines Inc', 'TR'),
('TP', 'TAP PT', 'PT'),
('TS', 'Air Transat', 'CA'),
('U2', 'EASYJET UK LIMITED', 'GB'),
('UA', 'United Airlines Inc', 'US'),
('UX', 'Air Europa Lineas Aereas, S.A.', 'ES'),
('VOY', 'Aerolínea Vueling SA', 'ES'),
('VS', 'Virgin Atlantic Airways Ltd', 'GB'),
('WA', 'KLM Cityhopper', 'NL'),
('WFL', 'World2Fly', 'ES'),
('WK', 'Edelweiss Air AG', 'CH'),
('X3', 'TUIfly Gmbh', 'DE'),
('X7', 'Challenge Airlines (BE) S.A.', 'BE'),
('YW', 'Air Nostrum, Lineas aereas del Mediterraneo SA', 'ES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `cod_aeropuerto` char(3) NOT NULL,
  `ciudad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `aeropuerto`
--

INSERT INTO `aeropuerto` (`cod_aeropuerto`, `ciudad`) VALUES
('ACA', 'Acapulco'),
('ACE', 'Lanzarote'),
('AGP', 'Málaga'),
('ALC', 'Alicante'),
('AMM', 'Ammán'),
('AMS', 'Ámsterdam'),
('BCN', 'Barcelona'),
('BER', 'Berlín'),
('BIO', 'Bilbao'),
('BJZ', 'Badajoz'),
('BOG', 'Bogotá'),
('BOS', 'Boston'),
('BRU', 'Bruselas'),
('BSB', 'Brasilia'),
('BUE', 'Buenos Aires'),
('CAI', 'El Cairo'),
('CDG', 'París (Charles de Gaulle)'),
('DTT', 'Detroit'),
('DUS', 'Düsseldorf'),
('EAS', 'San Sebastián'),
('FRA', 'Fráncfort'),
('FUE', 'Fuerteventura'),
('GMZ', 'La Gomera'),
('GRO', 'Gerona'),
('GRX', 'Granada'),
('GVA', 'Ginebra'),
('HAM', 'Hamburgo'),
('HEL', 'Helsinki'),
('HOU', 'Houston'),
('IBZ', 'Ibiza'),
('IST', 'Estambul'),
('JFK', 'Nueva York'),
('LAX', 'Los Ángeles'),
('LBG', 'Le Bourget'),
('LCG', 'La Coruña'),
('LGH', 'Londres Gatwick'),
('LHR', 'Londres Heathrow'),
('LIS', 'Lisboa'),
('LPA', 'Gran Canaria'),
('LYS', 'Lyon'),
('MAD', 'Madrid'),
('MAH', 'Mahón'),
('MEX', 'Ciudad de México'),
('MIA', 'Miami'),
('MIL', 'Milán'),
('MJV', 'Murcia'),
('MRS', 'Marsella'),
('MUC', 'Múnich'),
('ODB', 'Córdoba'),
('ORY', 'Orly'),
('OSL', 'Oslo'),
('OVD', 'Asturias'),
('PHL', 'Filadelfia'),
('PMI', 'Palma de Mallorca'),
('PNA', 'Pamplona'),
('REU', 'Reus'),
('RIO', 'Río de Janeiro'),
('SAO', 'São Paulo'),
('SCQ', 'Santiago de Compostela'),
('SDR', 'Santander'),
('SEA', 'Seattle'),
('SFO', 'San Francisco'),
('SLM', 'Salamanca'),
('SPC', 'Santa Cruz de la Palma'),
('STN', 'Londres Stansted'),
('STR', 'Stuttgart'),
('TFN', 'Tenerife Norte'),
('TFS', 'Tenerife Sur'),
('VDE', 'El Hierro'),
('VGO', 'Vigo'),
('VIT', 'Vitoria'),
('VLC', 'Valencia'),
('WAS', 'Washington'),
('XRY', 'Jerez de la Frontera'),
('YMQ', 'Montreal'),
('YOW', 'Ottawa'),
('YTO', 'Toronto'),
('YVR', 'Vancouver'),
('ZAZ', 'Zaragoza'),
('ZRH', 'Zúrich');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agencia`
--

CREATE TABLE `agencia` (
  `id_agencia` int(11) NOT NULL,
  `nom_agencia` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `color` varchar(12) NOT NULL,
  `logo` varchar(500) NOT NULL,
  `id_tipo_agen` char(2) NOT NULL,
  `cod_emp` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `agencia`
--

INSERT INTO `agencia` (`id_agencia`, `nom_agencia`, `password`, `color`, `logo`, `id_tipo_agen`, `cod_emp`) VALUES
(1, 'agencia1', 'agencia1', '#FDAC9B', 'https://img.freepik.com/foto-gratis/enfoque-selectivo-miniatura-turistica-brujula-sobre-mapa-avion-juguete-plastico-fondo-abstracto-viajar-concepto_1423-180.jpg', 'A3', 'L2'),
(2, 'agencia2', 'agencia2', '#FEFBD3', 'https://www.shutterstock.com/image-photo/travel-world-monument-concept-260nw-2521518873.jpg', 'A1', 'L2'),
(3, 'agencia3', 'agencia3', '#D3FEF2', 'https://previews.123rf.com/images/olegtoka/olegtoka1606/olegtoka160600022/58527149-concepto-de-ilustración-de-los-viajes-alrededor-de-los-puntos-de-referencia-de-fama-mundial-por-aire.jpg', 'A1', 'L1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `cod_emp` char(2) NOT NULL,
  `desc_emp` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`cod_emp`, `desc_emp`) VALUES
('L1', 'Entre 2 y 10 empleados'),
('L2', 'Entre 10 y 100 empleados'),
('L3', 'Entre 100 y 1000 empleados');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `id_evento` int(11) NOT NULL,
  `nom_evento` varchar(100) DEFAULT NULL,
  `tipo` enum('Vuelo','Actividad','Alojamiento') DEFAULT NULL,
  `trayecto` enum('Ida','Ida/Vuelta') DEFAULT NULL,
  `ae_origen` varchar(100) DEFAULT NULL,
  `ae_destino` varchar(100) DEFAULT NULL,
  `fec_ida` date DEFAULT NULL,
  `fec_vuelta` date DEFAULT NULL,
  `cod_vuelo_ida` int(11) DEFAULT NULL,
  `cod_vuelo_vuelta` int(11) DEFAULT NULL,
  `aerolinea_ida` varchar(100) DEFAULT NULL,
  `aerolinea_vuelta` varchar(100) DEFAULT NULL,
  `hora_ida` time DEFAULT NULL,
  `hora_vuelta` time DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `duracion_ida` varchar(50) DEFAULT NULL,
  `duracion_vuelta` int(11) DEFAULT NULL,
  `id_tipo_hab` varchar(3) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `fec_salida` date DEFAULT NULL,
  `desc_act` varchar(100) DEFAULT NULL,
  `id_viaje` int(11) NOT NULL,
  `cod_aeropuerto` char(3) DEFAULT NULL,
  `cod_ae` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`id_evento`, `nom_evento`, `tipo`, `trayecto`, `ae_origen`, `ae_destino`, `fec_ida`, `fec_vuelta`, `cod_vuelo_ida`, `cod_vuelo_vuelta`, `aerolinea_ida`, `aerolinea_vuelta`, `hora_ida`, `hora_vuelta`, `precio`, `duracion_ida`, `duracion_vuelta`, `id_tipo_hab`, `ciudad`, `fec_salida`, `desc_act`, `id_viaje`, `cod_aeropuerto`, `cod_ae`) VALUES
(27, 'paisaje', 'Vuelo', 'Ida', 'ACA  Acapulco', 'ACA  Acapulco', '2025-02-16', NULL, 111111, NULL, 'AVIANCA-Ecuador dba AVIANCA EC', NULL, '12:12:12', NULL, 1200, '1', NULL, NULL, NULL, NULL, NULL, 37, NULL, NULL),
(30, 'bungalo', 'Alojamiento', NULL, NULL, NULL, '2025-02-09', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 200, NULL, NULL, 'DB', 'barcelona', '2025-02-22', NULL, 37, NULL, NULL),
(32, 'cata', 'Actividad', NULL, NULL, NULL, '2025-02-16', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 60, NULL, NULL, NULL, NULL, NULL, 'cata de vinos', 40, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `cod_pais` varchar(3) NOT NULL,
  `nom_pais` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`cod_pais`, `nom_pais`) VALUES
('AR', 'Argentina'),
('AT', 'Austria'),
('AU', 'Australia'),
('BE', 'Bélgica'),
('BR', 'Brasil'),
('CA', 'Canadá'),
('CH', 'Suiza'),
('CN', 'China'),
('CO', 'Colombia'),
('CU', 'Cuba'),
('CY', 'Chipre'),
('CZ', 'República Checa'),
('DE', 'Alemania'),
('DK', 'Dinamarca'),
('DO', 'Republica Dominicana'),
('EC', 'Ecuador'),
('EE', 'Estonia'),
('EG', 'Egipto'),
('ES', 'España'),
('FI', 'Finlandia'),
('FR', 'Francia'),
('GB', 'Reino Unido'),
('GL', 'Groenlandia'),
('GR', 'Grecia'),
('GT', 'Guatemala'),
('HK', 'Hong Kong'),
('HR', 'Croacia'),
('HU', 'Hungría'),
('ID', 'Indonesia'),
('IE', 'Irlanda'),
('IL', 'Israel'),
('IN', 'India'),
('IS', 'Islandia'),
('IT', 'Italia'),
('JM', 'Jamaica'),
('JO', 'Jordania'),
('JP', 'Japón'),
('KE', 'Kenia'),
('LU', 'Luxemburgo'),
('MA', 'Marruecos'),
('MC', 'Mónaco'),
('MT', 'Malta'),
('MV', 'Maldivas'),
('MX', 'México'),
('NL', 'Países Bajos'),
('NO', 'Noruega'),
('PA', 'Panamá'),
('PE', 'Perú'),
('PL', 'Polonia'),
('PR', 'Puerto Rico'),
('PT', 'Portugal'),
('QA', 'Catar'),
('RO', 'Rumania'),
('RU', 'Rusia'),
('SC', 'Seychelles'),
('SE', 'Suecia'),
('SG', 'Singapur'),
('TH', 'Tailandia'),
('TN', 'Túnez'),
('TR', 'Turquía'),
('TZ', 'Tanzania (incluye Zanzíbar)'),
('US', 'Estados Unidos'),
('VE', 'Venezuela'),
('VN', 'Vietnam'),
('ZA', 'Sudáfrica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_agencia`
--

CREATE TABLE `tipo_agencia` (
  `id_tipo_agen` char(2) NOT NULL,
  `desc_tipo_agen` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_agencia`
--

INSERT INTO `tipo_agencia` (`id_tipo_agen`, `desc_tipo_agen`) VALUES
('A1', 'Mayorista'),
('A2', 'minorista'),
('A3', 'Mayorista-minorista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE `tipo_habitacion` (
  `id_tipo_hab` varchar(3) NOT NULL,
  `desc_hab` enum('Doble','Individual-Doble','Individual','Triple') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_habitacion`
--

INSERT INTO `tipo_habitacion` (`id_tipo_hab`, `desc_hab`) VALUES
('DB', 'Doble'),
('DUI', 'Individual-Doble'),
('SIN', 'Individual'),
('TPL', 'Triple');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_viaje`
--

CREATE TABLE `tipo_viaje` (
  `id_tipo_viaje` char(2) NOT NULL,
  `desc_tipo_viaje` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_viaje`
--

INSERT INTO `tipo_viaje` (`id_tipo_viaje`, `desc_tipo_viaje`) VALUES
('B1', 'Luna de Miel'),
('B2', 'Senior'),
('B3', 'Grupos'),
('B4', 'Viajes grandes (destinos exóticos + vuelo + alojamiento)'),
('B5', 'Escapadas'),
('B6', 'Familias (con niños pequeños)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `id_viaje` int(11) NOT NULL,
  `nom_viaje` varchar(100) NOT NULL,
  `fec_ini` date NOT NULL,
  `fec_fin` date NOT NULL,
  `duracion` int(11) DEFAULT NULL CHECK (`duracion` > 0),
  `pais` varchar(50) NOT NULL,
  `desc_viaje` varchar(300) NOT NULL,
  `serv_no_inc` varchar(300) NOT NULL,
  `id_agencia` int(11) NOT NULL,
  `id_tipo_viaje` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `viaje`
--

INSERT INTO `viaje` (`id_viaje`, `nom_viaje`, `fec_ini`, `fec_fin`, `duracion`, `pais`, `desc_viaje`, `serv_no_inc`, `id_agencia`, `id_tipo_viaje`) VALUES
(37, 'fotografico', '2025-02-16', '2025-02-22', 6, 'China', 'paisaje', 'desayuno', 1, 'B1'),
(39, 'excursiones variadas', '2025-02-16', '2025-03-08', 20, 'Argentina', 'excursiones grupales', 'desayuno', 1, 'B3'),
(40, 'fin de semana', '2025-02-14', '2025-02-15', 1, 'Brasil', 'enamorados', 'spa', 1, 'B5');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  ADD PRIMARY KEY (`cod_ae`),
  ADD KEY `fk_aerolinea_cod_pais` (`cod_pais`);

--
-- Indices de la tabla `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`cod_aeropuerto`);

--
-- Indices de la tabla `agencia`
--
ALTER TABLE `agencia`
  ADD PRIMARY KEY (`id_agencia`),
  ADD KEY `fk_agencia_id_tipo_agen` (`id_tipo_agen`),
  ADD KEY `fk_agencia_cod_emp` (`cod_emp`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cod_emp`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `fk_evento_id_viaje` (`id_viaje`),
  ADD KEY `fk_evento_cod_aeropuerto` (`cod_aeropuerto`),
  ADD KEY `fk_evento_cod_ae` (`cod_ae`),
  ADD KEY `fk_evento_id_tipo_hab` (`id_tipo_hab`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`cod_pais`);

--
-- Indices de la tabla `tipo_agencia`
--
ALTER TABLE `tipo_agencia`
  ADD PRIMARY KEY (`id_tipo_agen`);

--
-- Indices de la tabla `tipo_habitacion`
--
ALTER TABLE `tipo_habitacion`
  ADD PRIMARY KEY (`id_tipo_hab`);

--
-- Indices de la tabla `tipo_viaje`
--
ALTER TABLE `tipo_viaje`
  ADD PRIMARY KEY (`id_tipo_viaje`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`id_viaje`),
  ADD KEY `fk_viaje_id_agencia` (`id_agencia`),
  ADD KEY `fk_viaje_id_tipo_viaje` (`id_tipo_viaje`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agencia`
--
ALTER TABLE `agencia`
  MODIFY `id_agencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `evento`
--
ALTER TABLE `evento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `id_viaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aerolinea`
--
ALTER TABLE `aerolinea`
  ADD CONSTRAINT `fk_aerolinea_cod_pais` FOREIGN KEY (`cod_pais`) REFERENCES `pais` (`cod_pais`);

--
-- Filtros para la tabla `agencia`
--
ALTER TABLE `agencia`
  ADD CONSTRAINT `fk_agencia_cod_emp` FOREIGN KEY (`cod_emp`) REFERENCES `empleado` (`cod_emp`),
  ADD CONSTRAINT `fk_agencia_id_tipo_agen` FOREIGN KEY (`id_tipo_agen`) REFERENCES `tipo_agencia` (`id_tipo_agen`);

--
-- Filtros para la tabla `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_evento_cod_ae` FOREIGN KEY (`cod_ae`) REFERENCES `aerolinea` (`cod_ae`),
  ADD CONSTRAINT `fk_evento_cod_aeropuerto` FOREIGN KEY (`cod_aeropuerto`) REFERENCES `aeropuerto` (`cod_aeropuerto`),
  ADD CONSTRAINT `fk_evento_id_tipo_hab` FOREIGN KEY (`id_tipo_hab`) REFERENCES `tipo_habitacion` (`id_tipo_hab`),
  ADD CONSTRAINT `fk_evento_id_viaje` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `fk_tipo_viaje_id_tipo_viaje` FOREIGN KEY (`id_tipo_viaje`) REFERENCES `tipo_viaje` (`id_tipo_viaje`),
  ADD CONSTRAINT `fk_viaje_id_agencia` FOREIGN KEY (`id_agencia`) REFERENCES `agencia` (`id_agencia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
