# C214

![CI-CD](https://github.com/InajahaCosta/C214/actions/workflows/cicd.yml/badge.svg)

## Configuração e Instalação de Bibliotecas

Para configurar e instalar as bibliotecas necessárias, siga os passos abaixo:

1. Inicialize o projeto NodeJS:

Claro! Aqui está o conteúdo formatado para o arquivo README.md:

markdown
Copy code

# C214

Este repositório é dedicado ao conteúdo da disciplina de Engenharia de Software.

## Configuração e Instalação de Bibliotecas

Para configurar e instalar as bibliotecas necessárias, siga os passos abaixo:

1. Inicialize o projeto NodeJS:
   npm init -y

2. Instale o TypeScript, a linguagem de programação que estaremos utilizando durante o curso:
   npm install -D typescript

3. Adicione algumas tipagens:
   npm install -D @types/node

4. Inicialize as configurações de compilação do TypeScript:
   npx tsc --init

5. Instale a biblioteca para execução do código TypeScript:
   npm install -D ts-node-dev

6. Instale o Husky, uma biblioteca para execução de scripts com o git:
   npm install husky
   npx husky init

7. Instale o ESLint e suas dependências:
   npm i -D eslint @typescript-eslint/eslint-plugin @typescript-eslint/parser eslint-config-standard

## Execução de Scripts

Utilize os seguintes scripts para executar diferentes tarefas:

- `npm start`: Executa o código em ambiente de desenvolvimento.
- `npm run start:prod`: Compila e executa o código compilado em JavaScript.
- `npm run build`: Compila o código para JavaScript.

## Testes

Para executar os testes, utilize o seguinte comando:
