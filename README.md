# 🧩 Sudoku Game - Java

Projeto desenvolvido como parte de um desafio prático de lógica de programação e manipulação de estruturas de dados em Java disponibilizado pela plataforma da DIO.

O objetivo foi construir um jogo de Sudoku funcional no terminal, sem o uso de frameworks, focando puramente na lógica do algoritmo, validação de regras e interação com o usuário.

---

## 📌 Funcionalidades

- **Tabuleiro Dinâmico:** O jogo é inicializado a partir de uma string de configuração passada via argumentos, permitindo carregar diferentes cenários de jogo.
- **Visualização (UI):** Interface no terminal desenhada manualmente com caracteres ASCII, exibindo a grade 9x9.
- **Cores:** Uso de códigos ANSI para diferenciar números fixos (iniciais) dos números inseridos pelo jogador.
- **Regras de Validação:**
  - Impede inserção em posições fixas.
  - **Regra da Linha:** Não permite números repetidos na mesma linha.
  - **Regra da Coluna:** Não permite números repetidos na mesma coluna.
  - **Regra do Quadrante:** Não permite números repetidos no mesmo sub-quadrante 3x3.
- **Condição de Vitória:** Detecta automaticamente quando o tabuleiro está completo e finaliza o jogo.

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Git / GitHub**
- **Lógica:** Manipulação de Matrizes, Listas, Streams e Tratamento de Exceções.

---

## 🚀 Como Executar o Projeto

Para jogar, você precisa passar a configuração do tabuleiro como argumento na execução.

1.  **Clone o repositório:**

    ```bash
    git clone [https://github.com/heitorhidalgo/sudoku-java.git](https://github.com/heitorhidalgo/sudoku-java.git)
    cd sudoku-java
    ```

2.  **Compile o projeto (via terminal):**

    ```bash
    javac -d bin src/com/dio/sudoku/*.java src/com/dio/sudoku/model/*.java
    ```

3.  **Execute com os Argumentos:**
    Copie e cole o comando abaixo (contém o mapa do tabuleiro inicial):

    ```bash
    java -cp bin com.dio.sudoku.Main "0,0;4;false 1,0;7;false 2,0;9;true 3,0;5;false 4,0;8;true 5,0;6;true 6,0;2;true 7,0;3;false 8,0;1;false 0,1;1;false 1,1;3;true 2,1;5;false 3,1;4;false 4,1;7;true 5,1;2;false 6,1;8;false 7,1;9;true 8,1;6;true 0,2;2;false 1,2;6;true 2,2;8;false 3,2;9;false 4,2;1;true 5,2;3;false 6,2;7;false 7,2;4;false 8,2;5;true 0,3;5;true 1,3;1;false 2,3;3;true 3,3;7;false 4,3;6;false 5,3;4;false 6,3;9;false 7,3;8;true 8,3;2;false 0,4;8;false 1,4;9;true 2,4;7;false 3,4;1;true 4,4;2;true 5,4;5;true 6,4;3;false 7,4;6;true 8,4;4;false 0,5;6;false 1,5;4;true 2,5;2;false 3,5;3;false 4,5;9;false 5,5;8;false 6,5;1;true 7,5;5;false 8,5;7;true 0,6;7;true 1,6;5;false 2,6;4;false 3,6;2;false 4,6;3;true 5,6;9;false 6,6;6;false 7,6;1;true 8,6;8;false 0,7;9;true 1,7;8;true 2,7;1;false 3,7;6;false 4,7;4;true 5,7;7;false 6,7;5;false 7,7;2;true 8,7;3;false 0,8;3;false 1,8;2;false 2,8;6;true 3,8;8;true 4,8;5;true 5,8;1;false 6,8;4;true 7,8;7;false 8,8;9;false"
    ```

    _Nota: Se estiver usando Eclipse/STS, configure os argumentos em "Run Configurations > Arguments"._

---

## 🎮 Como Jogar

Após iniciar, o jogo solicitará suas jogadas no formato:
`linha,coluna,valor`

Exemplo:

- Digite `0,1,5` para colocar o número **5** na linha **0**, coluna **1**.
- Digite `sair` para encerrar.

---

## 👤 Autor

**Heitor Hidalgo**

- **GitHub:** [heitorhidalgo](https://github.com/heitorhidalgo)
- **LinkedIn:** [Heitor Hidalgo](https://linkedin.com/in/heitorhidalgo)

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
