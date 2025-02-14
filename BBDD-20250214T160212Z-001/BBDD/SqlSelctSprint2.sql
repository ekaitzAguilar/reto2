-- SELECT DE PAIS

	SELECT 
    nombre
FROM
    Pais;
	
	
-- SELECT DE AEROPUERTOS

	SELECT 
    cod_aeropuerto, ciudad
FROM
    Aeropuerto;
	
-- SELECT DE AEROLINEAS

	SELECT 
    a.nombre, a.cod_pais
FROM
    Aerolinea a
        JOIN
    Pais p ON a.cod_pais = p.cod_pais
WHERE
    a.COD_PAIS IN (SELECT 
            p.COD_PAIS
        FROM
            Pais p);
	
-- SELECT DE AGENCIA

	SELECT 
    nombre, password, color, logo
FROM
    Agencia;
	
	SELECT 
    id_Agencia
FROM
    Agencia;
    
    SELECT 
    id_agencia, nombre, password, color, logo
FROM
    Agencia;

-- 	select logo, color  from Agencia;

SELECT 
    *
FROM
    actividad;
SELECT 
    *
FROM
    aerolinea;
SELECT 
    *
FROM
    aeropuerto;
SELECT 
    *
FROM
    agencia;
SELECT 
    *
FROM
    agencia_tipo;
SELECT 
    *
FROM
    alojamiento;
SELECT 
    *
FROM
    empleado;
SELECT 
    *
FROM
    pais;
SELECT 
    *
FROM
    tipo_agencia;
SELECT 
    *
FROM
    tipo_viaje;
SELECT 
    *
FROM
    viaje;
SELECT 
    *
FROM
    vuelo;
SELECT 
    *
FROM
    vuelo_aerolinea;

