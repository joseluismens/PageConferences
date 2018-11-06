CREATE DATABASE IF NOT EXISTS petclinic;

ALTER DATABASE petclinic
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON petclinic.* TO pc@localhost IDENTIFIED BY 'pc';

USE petclinic;

CREATE TABLE IF NOT EXISTS evento (
  	ID_evento int(10) NOT NULL,
 	name varchar(40) DEFAULT NULL,
	fecha date DEFAULT NULL,
 	PRIMARY KEY (ID_evento) 
	INDEX (name),
)	 ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS expositor (
  ID_expositor int(10) NOT NULL,
 	name varchar(40) DEFAULT NULL,
	 sexo char(1) DEFAULT NULL,
	 correo varchar(40) DEFAULT NULL,
	 fono int(10) DEFAULT NULL,
	 INDEX (name),
	 PRIMARY KEY (ID_expositor)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS invitado (

	 ID_invitado int(11) NOT NULL,
	 name varchar(40) NOT NULL,
	 correo varchar(40) NOT NULL,
	 sexo char(1) NOT NULL,
	 fono int(11) DEFAULT NULL,
	 INDEX(name),
	 PRIMARY KEY (ID_invitado)
) ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS boleto (
 ID_boleto int(10) NOT NULL,
 ID_invitado int(10) NOT NULL,
 ID_evento int(10) NOT NULL,
 nombre varchar(40) NOT NULL,
 fecha date NOT NULL,
 total int(11) NOT NULL,
 PRIMARY KEY (ID_boleto),
 FOREIGN KEY (ID_invitado) REFERENCES invitado (ID_invitado),
 FOREIGN KEY (ID_evento) REFERENCES evento (ID_evento)
) ENGINE=InnoDB;
	
CREATE TABLE IF NOT EXISTS catalogo (
 ID_catalogo int(10) NOT NULL,
 ID_evento int(10) DEFAULT NULL,
 nombreCat varchar(40) NOT NULL,
 cantidad_Productos int(10) DEFAULT NULL,
 PRIMARY KEY (ID_catalogo),
 FOREIGN KEY (ID_evento) REFERENCES evento (ID_evento)
) ENGINE=InnoDB ;

CREATE TABLE IF NOT EXISTS cat_ponencia (
 ID_catPonencia int(10) NOT NULL,
 ID_evento int(10) DEFAULT NULL,
 PRIMARY KEY (ID_catPonencia),
 FOREIGN KEY (ID_evento) REFERENCES evento (ID_evento)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS ponencia(
	ID_ponencia int(10) PRIMARY KEY,
	ID_catPonencia int(10) not null,
	ID_expositor int not null,
    	FOREIGN KEY(ID_catPonencia) REFERENCES cat_ponencia(ID_catPonencia),
    	FOREIGN KEY(ID_expositor) REFERENCES expositor(ID_expositor),
    	nombreCat varchar(40) NOT null,
    	hora_inicio time DEFAULT NULL, 
    	hora_termino time DEFAULT NULL
    	
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS producto (
    	ID_producto int(10) PRIMARY KEY,
		ID_catalogo int(10) not null,
   		FOREIGN KEY(ID_catalogo) REFERENCES catalogo(ID_catalogo),
		nombre varchar(40) NOT null,
		precio_venta int not null,
    		precio_compra int not null	
) ENGINE=InnoDB DEFAULT CHARSET=utf8