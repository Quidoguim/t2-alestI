# Implementação

Este projeto implementa uma Árvore Binária de Pesquisa (ABP) em Java, com suporte às operações de inserção, remoção, busca com rastreamento e caminhamentos em pré-ordem, pós-ordem, central (in-ordem) e por largura. A classe principal da aplicação (`App.java`) identifica automaticamente o primeiro arquivo `.txt` válido no diretório (ignorando arquivos de saída) e utiliza seu conteúdo para construir a árvore e executar as operações solicitadas. O arquivo de entrada deve conter uma sequência de números inteiros, um por linha, sendo que as N − 1 primeiras linhas representam os valores a serem inseridos na árvore e a última linha indica a chave a ser buscada. Após a execução, o programa gera os seguintes arquivos de saída: `preordem.txt` (caminhamento em pré-ordem), `posordem.txt` (caminhamento em pós-ordem), `central.txt` (caminhamento central), `largura.txt` (caminhamento em largura) e `resultado.txt` (com as chaves visitadas durante a busca, o total de nós visitados e a indicação de sucesso ou fracasso da busca). Esse processo automatizado permite testar diferentes entradas facilmente, sem necessidade de alteração manual no código.

# Trabalho 2 – Alest 1

Este projeto tem como objetivo implementar uma Árvore Binária de Pesquisa (ABP), com métodos completos e uma aplicação (`App.java`) que realiza operações sobre a árvore com base em dados fornecidos por um arquivo `.txt`.

## Objetivos

- Implementar todos os métodos da classe `BinarySearchTree`.
- Utilizar como base o repositório fornecido (clone e continue o desenvolvimento a partir dele).
- A aplicação deve ser capaz de:
  - Ler um arquivo `.txt` contendo uma sequência de inteiros.
  - Construir a árvore com esses valores na ordem em que aparecem.
  - Pesquisar uma chave (última linha do arquivo).
  - Gerar arquivos com os resultados dos caminhamentos e da pesquisa.

## Funcionalidades da Aplicação

- Leitura de um arquivo `.txt` com:
  - N números inteiros (um por linha) a serem inseridos na árvore.
  - Última linha com o número a ser pesquisado na árvore.
- Geração dos seguintes arquivos de saída:
  - `preordem.txt`: caminhamento pré-ordem.
  - `posordem.txt`: caminhamento pós-ordem.
  - `central.txt`: caminhamento central (in-ordem).
  - `largura.txt`: caminhamento em largura.
  - `resultado.txt`: contém as chaves visitadas durante a busca, o total de nós visitados e o resultado da busca (informando se encontrou ou não a chave).

## Entrega

- A entrega deve ser feita por meio de um repositório GitHub.
- Enviar apenas o link do repositório via Moodle.
- Certifique-se de que o professor tem acesso ao repositório.

## Critérios de Avaliação

| Item                                                                 | Pontuação |
|----------------------------------------------------------------------|-----------|
| Leitura correta do arquivo `.txt` com as chaves                     | 1 ponto   |
| Geração do arquivo `preordem.txt`                                   | 1 ponto   |
| Geração do arquivo `posordem.txt`                                   | 1 ponto   |
| Geração do arquivo `central.txt`                                    | 1 ponto   |
| Geração do arquivo `largura.txt`                                    | 1 ponto   |
| Pesquisa correta da chave                                           | 1 ponto   |
| Geração do arquivo `resultado.txt` com as chaves visitadas          | 1 ponto   |
| Indicação correta do resultado da busca no `resultado.txt`          | 1 ponto   |
| Qualidade do código                                                 | 1 ponto   |
| Documentação no `README.md`                                         | 1 ponto   |

## Prazo de Entrega

**Data final: 22/06**  
*Sem possibilidade de prorrogação 😢*
