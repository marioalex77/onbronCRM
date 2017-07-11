DROP DATABASE IF EXISTS `onbrondb`;
CREATE DATABASE `onbrondb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `onbrondb`;
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `genero` varchar(1) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  CHECK(`genero` IN ("M","F") AND `estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rolusuario`;
CREATE TABLE `rolusuario` (
  `idRolUsuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`idRolUsuario`),
  CHECK(`tipo` IN ("USUARIO","ADMIN","SUPER"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usuariorolusuario`;
CREATE TABLE `usuariorolusuario` (
  `idUsuario` int(11) unsigned NOT NULL,
  `idRolUsuario` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idUsuario`,`idRolUsuario`),
  KEY `FK_RolUsuario_idx` (`idRolUsuario`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON UPDATE CASCADE,
  CONSTRAINT `FK_RolUsuario` FOREIGN KEY (`idRolUsuario`) REFERENCES `rolusuario` (`idRolUsuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Populate USER_PROFILE Table */
INSERT INTO rolusuario(tipo)
VALUES ('USUARIO');
INSERT INTO rolusuario(tipo)
VALUES ('ADMIN');
INSERT INTO rolusuario(tipo)
VALUES ('SUPER');
COMMIT;

DROP TABLE IF EXISTS `persistentlogins`;
CREATE TABLE `persistentlogins` (
  `correo` varchar(255) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `ultimoIngreso` TIMESTAMP NOT NULL,
  PRIMARY KEY (series)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `nrc` varchar(15) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `nrc_UNIQUE` (`nrc`),
  UNIQUE KEY `nit_UNIQUE` (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipoimpuesto`;
CREATE TABLE `tipoimpuesto` (
  `idTipoImpuesto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoImpuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipoimpuesto(descripcion)
VALUES ('PORCENTAJE');
INSERT INTO tipoimpuesto(descripcion)
VALUES ('VALOR');
COMMIT;


DROP TABLE IF EXISTS `impuesto`;
CREATE TABLE `impuesto` (
  `idImpuesto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `valor` decimal(25,6) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(30) NOT NULL,
  `idTipoImpuesto` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idImpuesto`),
  KEY `FKImpuestoTipoImpuesto_idx` (`idTipoImpuesto`),
  CONSTRAINT `FKImpuestoTipoImpuesto` FOREIGN KEY (`idTipoImpuesto`) REFERENCES `tipoimpuesto` (`idTipoImpuesto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `idDocumento` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` varchar(100) NOT NULL,
  `documento` longblob NOT NULL,
  PRIMARY KEY (`idDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipoproducto`;
CREATE TABLE `tipoproducto` (
  `idTipoProducto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`idTipoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipoproducto(descripcion)
VALUES ('TERMINADO');
INSERT INTO tipoproducto(descripcion)
VALUES ('MATERIA PRIMA');
INSERT INTO tipoproducto(descripcion)
VALUES ('INTERMEDIO');
COMMIT;

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `idCategoria` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `idTipoProducto` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idCategoria`),
  KEY `FKCategoriaTipoProducto_idx` (`idTipoProducto`),
  CONSTRAINT `FKCategoriaTipoProducto` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idProducto` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `idCategoria` int(10) unsigned NOT NULL,
  `idImpuesto` int(10) unsigned NOT NULL,
  `idProveedor` int(11) unsigned NOT NULL,
  `idTipoProducto` int(11) unsigned NOT NULL,
  `precioUnitario` decimal(25,6) NOT NULL,
  `orden` int(11) NOT NULL,
  `descripcion` text,
  `estado` varchar(30) NOT NULL,
  `visible` varchar(1) NOT NULL,
  `idDocumento` int(11) unsigned DEFAULT NULL,
  `fechaDesde` datetime NOT NULL,
  `fechaHasta` datetime DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idDocumento_UNIQUE` (`idDocumento`),
  KEY `FKProductoImpuesto_idx` (`idImpuesto`),
  KEY `FKProductoProveedor_idx` (`idProveedor`),
  KEY `FKProductoImagen_idx` (`idDocumento`),
  KEY `FKProductoCategoria_idx` (`idCategoria`),
  KEY `FKProductoTipoProducto_idx` (`idTipoProducto`),
  CONSTRAINT `FKProductoCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON UPDATE CASCADE,
  CONSTRAINT `FKProductoDocuemnto` FOREIGN KEY (`idDocumento`) REFERENCES `documento` (`idDocumento`) ON UPDATE CASCADE,
  CONSTRAINT `FKProductoImpuesto` FOREIGN KEY (`idImpuesto`) REFERENCES `impuesto` (`idImpuesto`) ON UPDATE CASCADE,
  CONSTRAINT `FKProductoProveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON UPDATE CASCADE,
  CONSTRAINT `FKProductoTipoProducto` FOREIGN KEY (`idTipoProducto`) REFERENCES `tipoproducto` (`idTipoProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `genero` varchar(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `pin` varchar(6) NOT NULL DEFAULT '000000',
  `estado` varchar(30) DEFAULT NULL,
  `verificador` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tipodireccion` (
  `idtipodireccion` int(11) unsigned NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipodireccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipodireccion(descripcion)
VALUES ('RESIDENCIA');
INSERT INTO tipodireccion(descripcion)
VALUES ('TRABAJO');
INSERT INTO tipodireccion(descripcion)
VALUES ('OTRO');
COMMIT;

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion` (
  `idDireccion` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) unsigned NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `departamento` int(11) NOT NULL,
  `municipio` int(11) DEFAULT NULL,
  `telefono` varchar(10) NOT NULL,
  `longitud` decimal(25,6) NOT NULL,
  `latitud` decimal(25,6) NOT NULL,
  `idTipoDireccion` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `FKDireccionesCliente_idx` (`idCliente`),
  KEY `FKDireccionTipoDireccion_idx` (`idTipoDireccion`),
  CONSTRAINT `FKDireccionTipoDireccion` FOREIGN KEY (`idTipoDireccion`) REFERENCES `tipodireccion` (`idtipodireccion`) ON UPDATE CASCADE,
  CONSTRAINT `FKDireccionesCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipolealtad`;
CREATE TABLE `tipolealtad` (
  `idTipoLealtad` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoLealtad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipolealtad(descripcion)
VALUES ('PUNTOS');
INSERT INTO tipolealtad(descripcion)
VALUES ('CUPON');
COMMIT;

DROP TABLE IF EXISTS `lealtad`;
CREATE TABLE `lealtad` (
  `idLealtad` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) unsigned NOT NULL,
  `idTipoLealtad` int(11) unsigned NOT NULL,
  `valor` decimal(25,6) NOT NULL,
  PRIMARY KEY (`idLealtad`),
  KEY `FKLealtadCliente_idx` (`idCliente`),
  KEY `FKLealtadTipoLealtad_idx` (`idTipoLealtad`),
  CONSTRAINT `FKLealtadCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON UPDATE CASCADE,
  CONSTRAINT `FKLealtadTipoLealtad` FOREIGN KEY (`idTipoLealtad`) REFERENCES `tipolealtad` (`idTipoLealtad`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipopago`;
CREATE TABLE `tipopago` (
  `idTipoPago` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`idTipoPago`),
  CHECK(`estado` IN ("ACTIVO","INACTIVO","BORRADO","BLOQUEADO"))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipopago(descripcion)
VALUES ('EFECTIVO');
INSERT INTO tipopago(descripcion)
VALUES ('LEALTAD');
INSERT INTO tipopago(descripcion)
VALUES ('CREDITO');
INSERT INTO tipopago(descripcion)
VALUES ('PREPAGO');
COMMIT;

DROP TABLE IF EXISTS `tipofactura`;
CREATE TABLE `tipofactura` (
  `idTipoFactura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripción` varchar(255) NOT NULL,
  PRIMARY KEY (`idTipoFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipofactura(descripcion)
VALUES ('PRESUPUESTO COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('PROFORMA COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('PEDIDO COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('NOTA ENTREGA COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('CONSUMIDOR FINAL COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('CREDITO FISCAL COMPRA');
INSERT INTO tipofactura(descripcion)
VALUES ('PRESUPUESTO VENTA');
INSERT INTO tipofactura(descripcion)
VALUES ('PROFORMA VENTA');
INSERT INTO tipofactura(descripcion)
VALUES ('PEDIDO VENTA');
INSERT INTO tipofactura(descripcion)
VALUES ('NOTA ENTREGA VENTA');
INSERT INTO tipofactura(descripcion)
VALUES ('CONSUMIDOR FINAL VENTA');
INSERT INTO tipofactura(descripcion)
VALUES ('CREDITO FISCAL VENTA');
COMMIT;


DROP TABLE IF EXISTS `estadotipofactura`;
CREATE TABLE `estadotipofactura` (
  `idEstadoTipoFactura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idTipoFactura` int(11) unsigned NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`idEstadoTipoFactura`),
  KEY `FKTipoFacturaEstado_idx` (`idTipoFactura`),
  CONSTRAINT `FKTipoFacturaEstado` FOREIGN KEY (`idTipoFactura`) REFERENCES `tipofactura` (`idTipoFactura`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `formato`;
CREATE TABLE `formato` (
  `idFormato` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  `signoMoneda` varchar(50) DEFAULT NULL,
  `encabezado` varchar(50) DEFAULT NULL,
  `subtitulo` varchar(50) DEFAULT NULL,
  `encabezadoDetalle` varchar(50) DEFAULT NULL,
  `leyendaDetalle` text,
  `tipodePago` varchar(50) DEFAULT NULL,
  `nombreEmpresa` varchar(50) DEFAULT NULL,
  `nit` varchar(50) DEFAULT NULL,
  `lenguaje` varchar(50) DEFAULT NULL,
  `codigoMoneda` varchar(25) DEFAULT NULL,
  `posicionMoneda` varchar(25) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idFormato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `factura`;
CREATE TABLE `factura` (
  `idFactura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) unsigned NOT NULL,
  `idTipoFactura` int(11) unsigned NOT NULL,
  `idFormato` int(11) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  `comentarios` text,
  `totalGrabado` decimal(25,6) NOT NULL,
  `totalExento` decimal(25,6) NOT NULL,
  `total` decimal(25,6) NOT NULL,
  `numero` int(11) unsigned NOT NULL,
  `idDireccion` int(11) unsigned NOT NULL,
  `resumenDetalle` tinytext,
  `idEstadoTipoFactura` int(11) unsigned NOT NULL,
  `idFactRelacionada` int(11) unsigned DEFAULT NULL,
  `idFactRectificada` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `FKCliente_idx` (`idCliente`),
  KEY `FKTipoFactura_idx` (`idTipoFactura`),
  KEY `FKFormato_idx` (`idFormato`),
  KEY `FKDireccionFactura_idx` (`idCliente`,`idDireccion`),
  KEY `FKEstadoFactura_idx` (`idTipoFactura`,`idEstadoTipoFactura`),
  CONSTRAINT `FKCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON UPDATE CASCADE,
  CONSTRAINT `FKDireccionFactura` FOREIGN KEY (`idCliente`, `idDireccion`) REFERENCES `direccion` (`idCliente`, `idDireccion`) ON UPDATE CASCADE,
  CONSTRAINT `FKEstadoFactura` FOREIGN KEY (`idTipoFactura`, `idEstadoTipoFactura`) REFERENCES `estadotipofactura` (`idTipoFactura`, `idEstadoTipoFactura`) ON UPDATE CASCADE,
  CONSTRAINT `FKFormato` FOREIGN KEY (`idFormato`) REFERENCES `formato` (`idFormato`) ON UPDATE CASCADE,
  CONSTRAINT `FKTipoFactura` FOREIGN KEY (`idTipoFactura`) REFERENCES `tipofactura` (`idTipoFactura`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `facturaitem`;
CREATE TABLE `facturaitem` (
  `idFacturaItem` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) unsigned NOT NULL,
  `cantidad` int(10) NOT NULL,
  `idProducto` int(11) unsigned NOT NULL,
  `precioUnitario` decimal(25,6) NOT NULL,
  `idImpuesto` int(11) unsigned NOT NULL,
  `impuesto` decimal(25,6) NOT NULL,
  `subTotal` decimal(25,6) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`idFacturaItem`),
  KEY `FKFactura_idx` (`idFactura`),
  KEY `FKProducto_idx` (`idProducto`),
  KEY `FKImpuesto_idx` (`idImpuesto`),
  CONSTRAINT `FKFactura` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON UPDATE CASCADE,
  CONSTRAINT `FKImpuesto` FOREIGN KEY (`idImpuesto`) REFERENCES `impuesto` (`idImpuesto`) ON UPDATE CASCADE,
  CONSTRAINT `FKProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `inventario`;
CREATE TABLE `inventario` (
  `idInventario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) unsigned NOT NULL,
  `cantidad` int(11) unsigned NOT NULL,
  `costo` decimal(25,6) NOT NULL,
  `fechaProduccion` datetime NOT NULL,
  `fechaVencimiento` datetime NOT NULL,
  `comentario` text,
  PRIMARY KEY (`idInventario`),
  KEY `FKProductos_idx` (`idProducto`),
  CONSTRAINT `FKProductos` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `inventariodetalle`;
CREATE TABLE `inventariodetalle` (
  `idInventarioDetalle` int(11) unsigned NOT NULL,
  `idInventario` int(11) unsigned NOT NULL,
  `IdFacturaItem` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idInventarioDetalle`),
  KEY `FKDetalleInvenario_idx` (`idInventario`),
  KEY `FKDetalleInventarioFacturaItem_idx` (`IdFacturaItem`),
  CONSTRAINT `FKDetalleInvenario` FOREIGN KEY (`idInventario`) REFERENCES `inventario` (`idInventario`) ON UPDATE CASCADE,
  CONSTRAINT `FKDetalleInventarioFacturaItem` FOREIGN KEY (`IdFacturaItem`) REFERENCES `facturaitem` (`idFacturaItem`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `pago`;
CREATE TABLE `pago` (
  `idpago` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idFactura` int(11) unsigned NOT NULL,
  `idTipoPago` int(11) unsigned NOT NULL,
  `monto` decimal(25,6) NOT NULL,
  `fecha` datetime NOT NULL,
  `referenciaExterna` varchar(255) DEFAULT NULL,
  `comentario` text,
  `signo` varchar(1) NOT NULL,
  `cuenta` varchar(12) NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `FKPagoFactura_idx` (`idFactura`),
  KEY `FKPagoTipoPago_idx` (`idTipoPago`),
  CONSTRAINT `FKPagoFactura` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`) ON UPDATE CASCADE,
  CONSTRAINT `FKPagoTipoPago` FOREIGN KEY (`idTipoPago`) REFERENCES `tipopago` (`idTipoPago`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `zonacobertura`;
CREATE TABLE `zonacobertura` (
  `idZonaCobertura` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `LatitudIni` decimal(25,6) NOT NULL,
  `LongitudIni` decimal(25,6) NOT NULL,
  `LatitudFin` decimal(25,6) NOT NULL,
  `LongitudFin` decimal(25,6) NOT NULL,
  PRIMARY KEY (`idZonaCobertura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
