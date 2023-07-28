CREATE TABLE medicos(
		id bigint not null AUTO_INCREMENT,
		nombre VARCHAR(100) not null,
		email VARCHAR(100) not null UNIQUE,
		documento VARCHAR(6) NOT NULL UNIQUE,
		especialidad VARCHAR(100) NOT NULL,
		calle VARCHAR(180) NOT NULL,
		distrito VARCHAR(100) NOT NULL,
		complemento VARCHAR(100),
		numero VARCHAR(20),
		ciudad VARCHAR(100) NOT NULL,

		PRIMARY KEY(id)
);