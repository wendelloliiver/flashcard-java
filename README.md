# 📚 Aplicativo de Flashcards em Java

Este é um aplicativo simples de Flashcards desenvolvido em Java com interface gráfica Swing. Ele permite que você crie seus próprios conjuntos de flashcards (perguntas e respostas) e depois os revise. O aplicativo é dividido em duas partes principais: um **Construtor de Flashcards** para criar e salvar seus cards, e um **Leitor de Flashcards** para estudá-los.

---

## ✨ Funcionalidades

* **Criação de Flashcards:** Crie flashcards com perguntas e respostas personalizadas.
* **Salvamento de Conjuntos:** Salve seus conjuntos de flashcards em um arquivo (`.txt` ou qualquer extensão que preferir).
* **Carregamento de Conjuntos:** Carregue conjuntos de flashcards salvos para revisão.
* **Revisão Interativa:** Navegue pelos flashcards, revele as respostas e passe para o próximo card.

---

## 🛠️ Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Swing:** Toolkit para criação da interface gráfica (GUI).

---

## 🚀 Como Usar

O aplicativo consiste em dois módulos principais: `FlashcardBuilder` e `FlashcardPlayer`.

### **1. Criando seus Flashcards (FlashcardBuilder)**

1.  Compile e execute a classe `FlashcardBuilder.java`.
2.  Uma janela com campos para "Question" (Pergunta) e "Answer" (Resposta) aparecerá.
3.  Digite sua pergunta no campo superior e a resposta no campo inferior.
4.  Clique no botão **"Next Card"** para adicionar o flashcard à sua lista e limpar os campos para o próximo card.
5.  Quando terminar de criar todos os seus cards, vá em **"File" > "Save"** no menu superior.
6.  Escolha um nome e local para salvar seu arquivo de flashcards (por exemplo, `meus_estudos.txt`).

### **2. Revisando seus Flashcards (FlashcardPlayer)**

1.  Compile e execute a classe `FlashcardPlayer.java`.
2.  Uma janela de revisão aparecerá. Vá em **"File" > "Load card set"** no menu superior.
3.  Selecione o arquivo de flashcards que você salvou anteriormente usando o `FlashcardBuilder`.
4.  A primeira pergunta do seu conjunto de cards será exibida.
5.  Clique em **"Show Answer"** para revelar a resposta do card atual.
6.  Clique em **"Next card"** para ir para o próximo flashcard.
7.  Quando todos os cards tiverem sido revisados, o aplicativo indicará que foi o "último card".

---

## 🏗️ Estrutura do Projeto

* `Flashcard.java`: Define a estrutura de um flashcard, contendo uma pergunta e uma resposta.
* `FlashcardBuilder.java`: A interface para criar e salvar novos conjuntos de flashcards.
* `FlashcardPlayer.java`: A interface para carregar e revisar conjuntos de flashcards.

---

## 👨‍💻 Autor

* **Wendell Oliveira**

---
