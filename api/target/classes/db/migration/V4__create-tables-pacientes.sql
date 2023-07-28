CREATE TABLE pacientes(
		id bigint not null AUTO_INCREMENT,
		nombre VARCHAR(100) not null,
		email VARCHAR(100) not null UNIQUE,
		telefono VARCHAR(20) not null, 
		calle VARCHAR(180) NOT NULL,
		distrito VARCHAR(100) NOT NULL,
		complemento VARCHAR(100),
		numero VARCHAR(20),
		ciudad VARCHAR(100) NOT NULL,
		activo TINYINT NOT NULL,

		PRIMARY KEY(id)
);