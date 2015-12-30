SET sql_safe_updates=0; 

SELECT * FROM DISTRITO;

SELECT * FROM ELEITOR;
SELECT * FROM ELEICAO;
SELECT * FROM participantes;
SELECT * FROM lista;
SELECT * FROM RESULTADOS;

Select count(votos) from resultados;


UPDATE eleicao SET Estado = "Terminado" where nEleicao>=1 AND nEleicao<5000;
UPDATE eleicao SET Estado = "Decorrer" where nEleicao=9999;
UPDATE lista SET validacao ="Válido";
UPDATE RESULTADOS SET votos = '700' where idResultados='34'  ;
UPDATE RESULTADOS SET TipoEleicao = 'Assembleia' where idResultados='18'  ;
UPDATE resultados SET deputados = votos/'230';

delete FROM participantes;
Delete FROM lista;


DELETE FROM eleitor WHERE numEleitor = '43';
DELETE FROM lista WHERE idLista = '21';

SELECT * FROM ELEICAO WHERE tipo = 'Assembleia'

DELETE FROM resultados WHERE idResultados = '21';
delete from eleicao where nEleicao = '9001';


SELECT * FROM Resultados TipoEleicao = 'Presidêncial' ;