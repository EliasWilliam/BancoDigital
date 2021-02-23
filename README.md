# BancoDigital

Projeto - Banco Digital

Setup do projeto
Usando a ferramenta que você considera mais adequada, crie seu projeto.

start.spring.io para Spring Boot
própria IDE com algum plugin facilitador

#1 - Proposta de Nova Conta
Contexto
Todo cliente precisa solicitar uma proposta de criação de nova conta de pessoa física antes de qualquer outra coisa e este é justamente o processo que precisamos implementar. Só que tal processo precisa ser dividido em várias etapas, caso o contrário o cliente seria obrigado a passar um grande número de informações e poderíamos perder tudo por conta de uma falha de internet, falta de bateria no celular etc. A ideia aqui é minimizar isso.
Necessidade
No primeiro passo precisamos de algumas informações básicas.
nome do cliente
sobrenome do cliente
email
data de nascimento
cpf

Restrições
nome do cliente é obrigatório
sobrenome do cliente é obrigatório
email é obrigatório e precisa ter formato de email
cpf é obrigatório e precisa respeitar o formato
data de nascimento obrigatório, no passado e tem que ter mais de 18 anos
email não pode ser duplicado
cpf não pode ser duplicado



Resultado esperado
status 201 e header location preenchido para o próximo passo do cadastro
status 400 em caso de falha de qualquer validação e JSON de retorno com as informações.

#2 - Proposta de Nova Conta
Contexto
Todo cliente precisa solicitar uma proposta de criação de nova conta de pessoa física antes de qualquer outra coisa e este é justamente o processo que precisamos implementar. Só que tal processo precisa ser dividido em várias etapas, caso o contrário o cliente seria obrigado a passar um grande número de informações e poderíamos perder tudo por conta de uma falha de internet, falta de bateria no celular etc.
Agora vamos para o segundo passo do processo. A pessoa precisa colocar os dados do endereço

Necessidade
cep
rua
bairro
complemento
cidade(pode ser campo aberto)
estado(pode ser campo aberto)

Restrições
cep obrigatório e no formato adequado
rua obrigatório
bairro obrigatório
complemento obrigatório
cidade obrigatória
estado obrigatório
tudo que é obrigatório do passo 1 precisa estar correto

Resultado esperado
status 201 e header location preenchido para o próximo passo do cadastro
status 400 em caso de falha de qualquer validação e JSON de retorno com as informações.




#3 - Proposta de Nova Conta
Contexto
Todo cliente precisa solicitar uma proposta de criação de nova conta de pessoa física antes de qualquer outra coisa e este é justamente o processo que precisamos implementar. Só que tal processo precisa ser dividido em várias etapas, caso o contrário o cliente seria obrigado a passar um grande número de informações e poderíamos perder tudo por conta de uma falha de internet, falta de bateria no celular etc.
Agora vamos para o terceiro passo do processo. A pessoa precisa enviar a foto de frente do cpf.

Necessidade
arquivo que representa a frente do cpf

Restrições
o arquivo é obrigatório

Questionamento...
Será que existe algum jeito melhor de tratar esses uploads do que fazer o arquivo chegar pela aplicação?

Resultado esperado
status 201 e header location preenchido para o próximo passo do cadastro
status 400 em caso de falha de qualquer validação e JSON de retorno com as informações.
status 404 caso a proposta que supostamente deveria estar associada com esse passo não exista.
Se os passos anteriores não estiverem completos, retorne 422

#4 - Proposta de Nova Conta
Contexto
Todo cliente precisa solicitar uma proposta de criação de nova conta de pessoa física antes de qualquer outra coisa e este é justamente o processo que precisamos implementar. Só que tal processo precisa ser dividido em várias etapas, caso o contrário o cliente seria obrigado a passar um grande número de informações e poderíamos perder tudo por conta de uma falha de internet, falta de bateria no celular etc.
Agora precisamos mostrar tudo que foi enviado para o cliente do aceite.
Necessidade
Retornar um json com todas as informações da proposta para que a aplicação cliente exiba e a pessoa possa confirmar tudo!

Restrição
Todos os passos anteriores precisam ter sido completados
Resultado esperado
Em caso de aceite, informamos que vamos criar a conta dela e um e-mail será enviado(próxima funcionalidade)
Em caso de não aceite o sistema registra aquela proposta e vai mandar um email implorando para ela aceitar(próxima funcionalidade)
Se os passos anteriores não estiverem completos, retorne o código 422
#5 - Proposta de Nova Conta
Contexto
Agora precisamos lidar com o aceite da proposta.

Necessidade
Caso a proposta seja aceita pelo cliente, uma nova conta deve ser criada em função daquela proposta. Essa nova conta tem as seguintes informações:
Agência (4 dígitos e pode ser gerado aleatório)
Conta (8 dígitos e pode ser gerado aleatório)
Código do banco (3 dígitos e pode ser fixo)
A partir da conta, precisamos chegar na proposta que a originou.
Saldo igual a zero.
Com a conta criada, um email deve ser enviado para a dona da proposta informando a criação da nova conta e os respectivos dados.

detalhes adicionais
O email não precisa ser real. Vai ser legal se o sistema ficar preparado para lidar com emails fake em dev e reais em produção.
O processo de criação de conta só acontece depois que um sistema externo aceita as informações do documento daquela pessoa. Como toda chamada remota, algo de errado pode acontecer. Precisamos tentar pelo menos 2x antes de desistir.
Caso o sistema externo de aceite de documentos não tenha liberado, precisamos deixar um status na proposta indicando que ela ainda não foi liberada.
Caso o sistema externo de aceite tenha liberado, além de criamos a conta deixamos um status na proposta informando que ela foi liberada.

Restrições
O processo de criação deve ser disparado de forma a não bloquear o retorno relativo ao aceite do usuário. A pessoa aceita e depois a conta é criada e o email informativo é enviado. Isso é muito importante!

Resultado esperado
status 200(conta vai ser criada)

Primeiro Acesso Após Aprovação de Conta
Contexto
No primeiro acesso após aprovação, precisamos passar pelo processo de confirmação de identidade e criação de nova senha.

Necessidade
Aqui vamos precisar de alguns passos para realizar o processo de aprovação:
Primeiro colocamos de novo nosso email e cpf
Recebemos um email com um token de 6 dígitos aleatório associado com aquela conta que deve ser passado para a criação da nova senha.
Agora precisamos criar uma senha de 8 dígitos que seja forte.
Finalmente a senha é criada e associada com a conta.
Depois que a senha for criada é importante que um email seja enviado para o(a) dono(a) da conta informando que a senha foi modificada.

Restrições
O token tem tempo de expiração configurável no sistema
O token só pode ser usado uma vez
A senha é obrigatória, tem 8 dígitos e é forte
A senha precisa ser gravada encodada com algum algoritmo de hash

Resultado Esperado
Caso o token tenha expirado, retorne 400
Caso o token já tenha sido usado retorne 400
Caso tudo dê certo, retorne 200.

O status de falha aqui poderia ser 422, que significa unprocessable entity... Mas confesso que não vejo muita utilidade nesse circo de status para apis convencionais.
Receber Dinheiro via Transferência
Contexto
Clientes podem receber dinheiro via transferência bancária. Aqui vamos simular a integração com um endpoint externo onde você checar se determinado CPF tem uma nova transferência para aquele banco, agência e conta.
Aqui existe um detalhe extra: O primeiro passo da proposta, originalmente pedia a CNH. Mas achamos melhor manter o cpf mesmo, caso você tenha implementado com CNH, pode usar o mesmo número agora.

Necessidade
Vamos imaginar que temos um endpoint chamado por um entidade externa que nos informa, a qualquer momento, sobre novas transferências. O seu endpoint deve receber uma lista em json, com as seguintes informações:

valor da transferência
data da realização
documento identificador da origem da transferência recebida
banco de origem
conta de origem
agência de origem
código único da transferência para aquele determinado banco de origem
conta de destino
agência de destino

Agora que já temos um lugar para saber das novas transferências recebidas, precisamos atualizar o saldo da conta que está recebendo o dinheiro.
Então, a necessidade básica é atualizar o saldo da conta em questão com o valor que chegou. Todas as informações relativas a origem precisam ser armazenadas.

Ponto de atenção
A sua aplicação não tem controle sobre as chamadas informando novas transferências. Se duas requisições chegarem ao mesmo tempo com novas transferências para uma mesma conta, você pode ter um problema de concorrência. Como você vai resolver?
Este processamento não precisa acontecer de forma síncrona.

Restrições
Todas as informações relativas à transferência são obrigatórias.
Caso uma transferência com código para único para um determinado banco já tenha sido processada, simplesmente ignore e gere um log.

Resultado esperado
Caso tenha problema de validação básico retorne 400 e um json com os problemas.
Caso tudo dê certo, retorne 200.
