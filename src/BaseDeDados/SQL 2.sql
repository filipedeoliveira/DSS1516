SET sql_safe_updates=0; 

SELECT * FROM DISTRITO;

SELECT * FROM ELEITOR;
SELECT * FROM ELEICAO;
SELECT * FROM participantes;
SELECT * FROM lista;
SELECT * FROM RESULTADOS;


UPDATE eleicao SET Estado = "Terminado" where nEleicao>=1 AND nEleicao<5000;
UPDATE eleicao SET Estado = "Terminado" where nEleicao>=5000;
UPDATE lista SET validacao ="Válido";

delete FROM participantes;
Delete FROM lista;


DELETE FROM eleitor WHERE numEleitor = '43';
DELETE FROM lista WHERE idLista = '21';

SELECT * FROM ELEICAO WHERE tipo = 'Assembleia'

DELETE FROM participantes WHERE posicao = '2';