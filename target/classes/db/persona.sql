-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2022 a las 14:52:47
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `testjpa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `nombre`, `apellidos`) VALUES
(13, 'Marta', 'Nelson'),
(34, 'Daniel', 'Van'),
(36, 'Lucas ', 'Grijander'),
(37, 'Anastasio', 'Randelmore'),
(45, 'Carmen', 'Esther'),
(46, 'Daniel', 'Lord'),
(47, 'Lucas', 'Martín'),
(48, 'Sas', 'Anderson'),
(49, 'Jander', 'Clander'),
(50, 'Berta', 'Cleotilda'),
(54, 'Anabel', 'Cart'),
(60, 'Flanders', 'McYurtonite'),
(61, 'Rissoto', 'Parmesani Ramnna'),
(65, 'Julio', 'César'),
(67, 'Carmen Esther', 'Pichaco  González'),
(68, 'Felice J.', 'Anderson'),
(70, 'Barman', 'Stranger '),
(92, 'Babasos', 'Ambrosio'),
(93, 'Bingo', 'Chacho'),
(96, 'Noeman', 'Helderwitch'),
(105, 'dede', 'dede');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
