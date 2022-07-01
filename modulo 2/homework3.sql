SELECT p.NOME, c.NUMERO 
  FROM PESSOA p 
  RIGHT JOIN CONTATO c ON c.ID_PESSOA = p.ID_PESSOA;
  
SELECT p.NOME, pxpe.ID_PESSOA, ep.LOGRADOURO  
  FROM PESSOA p 
  RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA
  RIGHT JOIN ENDERECO_PESSOA ep ON ep.ID_ENDERECO = pxpe.ID_ENDERECO;
  
SELECT p.NOME, c.NUMERO, pxpe.ID_PESSOA, ep.LOGRADOURO  
  FROM PESSOA p 
  RIGHT JOIN CONTATO c ON c.ID_PESSOA = p.ID_PESSOA 
  RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA
  RIGHT JOIN ENDERECO_PESSOA ep ON ep.ID_ENDERECO = pxpe.ID_ENDERECO;
 
SELECT p.NOME, c.NUMERO 
  FROM PESSOA p 
  FULL JOIN CONTATO c ON c.ID_PESSOA = p.ID_PESSOA;
 
SELECT p.NOME, pxpe.ID_PESSOA, ep.LOGRADOURO  
  FROM PESSOA p 
  FULL JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA
  FULL JOIN ENDERECO_PESSOA ep ON ep.ID_ENDERECO = pxpe.ID_ENDERECO;
 
SELECT p.NOME, c.NUMERO, pxpe.ID_PESSOA, ep.LOGRADOURO  
  FROM PESSOA p 
  FULL JOIN CONTATO c ON c.ID_PESSOA = p.ID_PESSOA 
  FULL JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA
  FULL JOIN ENDERECO_PESSOA ep ON ep.ID_ENDERECO = pxpe.ID_ENDERECO;
  
 SELECT p.NOME  
   FROM PESSOA p 
  WHERE EXISTS (SELECT pxpe.ID_PESSOA 
  				  FROM PESSOA_X_PESSOA_ENDERECO pxpe  
  				 WHERE pxpe.ID_PESSOA = p.ID_PESSOA);
  				 
SELECT p.ID_PESSOA, p.NOME, ep.LOGRADOURO  
  FROM PESSOA p, ENDERECO_PESSOA ep  
 WHERE EXISTS (SELECT pxpe.ID_PESSOA 
 				  FROM PESSOA_X_PESSOA_ENDERECO pxpe
 				  WHERE pxpe.ID_PESSOA = p.ID_PESSOA);
 				  