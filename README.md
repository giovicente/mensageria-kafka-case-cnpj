# mensageria-kafka-case-cnpj
Implementa um sistema no domínio de cadastro de empresas por CNPJ, que recebe a solicitação de cadastro em um MS, depois valida se o CNPJ possui capital o suficiente para abertura (por regra de negócio, só serão aceitos cadastros de empresas cujo capital é acima de R$1.000.000,00) mediante chamado a uma API externa e por fim salva os resultados da consulta em um arquivo csv. 

Toda a mensageria foi implementada utilizando Apache Kafka.
