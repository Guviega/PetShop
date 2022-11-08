--Eduarda Reichow, Gustavo Viega e João Vitor Pioner
--Turma 301 Info

--Base de Dados

CREATE DOMAIN genero AS char(1)
    DEFAULT 'F'
    CHECK (VALUE='F' OR VALUE= 'M');

CREATE TABLE cliente (
	id  serial,
	nome varchar(100) NOT NULL, 
    cpf char(11) UNIQUE NOT NULL,
    celular char(11) UNIQUE NOT NULL,
    genero genero,
    datanascimento date,
    endereco varchar(100) NOT NULL,
    CONSTRAINT "ClientePK" PRIMARY KEY(id));
	
CREATE TABLE funcionario (
    id serial,
    nome varchar(100) NOT NULL,
    cpf char(11) UNIQUE NOT NULL,
    celular char(11) UNIQUE NOT NULL,
	genero genero,
	dataNascimento date,
    endereco varchar(100) NOT NULL,
    email varchar(100) UNIQUE, 
    salario numeric(7,2) NOT NULL,
    CONSTRAINT "FuncionarioPK" PRIMARY KEY (id));
	
    
CREATE TABLE pet (
    id serial, 
    nome varchar(100) NOT NULL,
    tipo varchar(100) NOT NULL,
    raca varchar(20),
    cor varchar(20),
    dataNascimento date,
    iddono int NOT NULL,
    CONSTRAINT "PetPK" PRIMARY KEY (id),
    CONSTRAINT "DonoFK" FOREIGN KEY (iddono)
        REFERENCES cliente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE);
        
CREATE TABLE atendimento(
    id serial,
    descricao varchar(100) NOT NULL,
    valor numeric(7,2) NOT NULL,
	data date NOT NULL,
    idPet int NOT NULL,
    idFuncionario int NOT NULL,
    CONSTRAINT "AtendimentoPK" PRIMARY KEY (id),
    CONSTRAINT "PetFK" FOREIGN KEY (idPet)
        REFERENCES pet(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
     CONSTRAINT "FuncionarioFK" FOREIGN KEY (idFuncionario)
        REFERENCES funcionario(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE);

--VIEW

CREATE VIEW "FuncionarioAtendimentos" AS
(SELECT f.nome AS "Nome do funcionário", count(a.idFuncionario) AS "Numero de atendimentos", coalesce(sum(a.valor),0.00) AS "Valor total"
FROM funcionario f LEFT OUTER JOIN atendimento a
ON f.id = a.idFuncionario
GROUP BY f.nome
ORDER BY count(a.idFuncionario) desc);

--INDEX

--Criado index em pessoa utilizado a coluna nome para agilizar a busca dos clientes pelo nome;

CREATE INDEX "NomeClientes" ON CLIENTE(NOME);
