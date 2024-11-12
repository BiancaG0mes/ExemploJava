package com.enem.analyze.exemplojavafx;

import javafx.application.Application;  // Importa a classe base para uma aplicação JavaFX
import javafx.scene.Scene;             // Importa a classe que define a cena da aplicação
import javafx.scene.control.*;         // Importa classes de controles (Menu, MenuItem, ContextMenu, etc.)
import javafx.scene.input.MouseEvent;  // Importa a classe para capturar eventos do mouse
import javafx.scene.layout.StackPane;  // Importa o layout StackPane para empilhar elementos
import javafx.scene.paint.Color;       // Importa a classe de cores
import javafx.scene.text.Font;         // Importa a classe para manipular fontes
import javafx.stage.Stage;             // Importa a classe Stage que representa a janela da aplicação

public class MenuExample extends Application {  // Define a classe principal que estende Application (classe base do JavaFX)

    @Override
    public void start(Stage primaryStage) {  // Método principal onde a interface gráfica é configurada
        StackPane root = new StackPane();  // Cria um StackPane que irá conter todos os componentes

        Label textLabel = new Label("Texto Exemplo");  // Cria um rótulo (label) com um texto inicial
        textLabel.setFont(Font.font("Serif", 30));  // Define a fonte do texto do rótulo como Serif com tamanho 30

        // Criando a barra de menus
        MenuBar menuBar = new MenuBar();  // Cria a barra de menus
        Menu menu = new Menu("Arquivo");  // Cria o menu "Arquivo"
        MenuItem itemNovo = new MenuItem("Novo");  // Cria o item de menu "Novo"
        MenuItem itemSair = new MenuItem("Sair");  // Cria o item de menu "Sair"
        menu.getItems().addAll(itemNovo, itemSair);  // Adiciona os itens "Novo" e "Sair" ao menu
        menuBar.getMenus().add(menu);  // Adiciona o menu à barra de menus

        // Criando um ContextMenu (menu de contexto) para o clique direito do mouse
        ContextMenu contextMenu = new ContextMenu();  // Cria um novo ContextMenu
        MenuItem colorRed = new MenuItem("Red");  // Cria o item "Red" para mudar a cor de fundo para vermelho
        MenuItem colorGreen = new MenuItem("Green");  // Cria o item "Green" para mudar a cor de fundo para verde
        MenuItem colorBlue = new MenuItem("Blue");  // Cria o item "Blue" para mudar a cor de fundo para azul
        contextMenu.getItems().addAll(colorRed, colorGreen, colorBlue);  // Adiciona os itens de cor ao ContextMenu

        // Definindo ações para cada item de cor no menu de contexto
        colorRed.setOnAction(e -> root.setStyle("-fx-background-color: red"));  // Ao selecionar "Red", a cor de fundo será vermelha
        colorGreen.setOnAction(e -> root.setStyle("-fx-background-color: green"));  // Ao selecionar "Green", a cor de fundo será verde
        colorBlue.setOnAction(e -> root.setStyle("-fx-background-color: blue"));  // Ao selecionar "Blue", a cor de fundo será azul

        // Ação para o item "Novo" no menu
        itemNovo.setOnAction(e -> textLabel.setTextFill(Color.RED));  // Quando "Novo" for clicado, a cor do texto do label será vermelha

        // Exibindo o ContextMenu ao clicar com o botão direito do mouse (botão secundário)
        root.setOnMousePressed((MouseEvent event) -> {  // Evento para pressionar o mouse
            if (event.isSecondaryButtonDown()) {  // Verifica se o botão direito foi pressionado
                contextMenu.show(root, event.getScreenX(), event.getScreenY());  // Exibe o ContextMenu na posição do cursor
            }
        });

        // Criando um TabPane (com abas)
        TabPane tabPane = new TabPane();  // Cria um TabPane para exibir abas
        Tab tab1 = new Tab("Tab 1", new Label("Conteúdo da Tab 1"));  // Cria a primeira aba "Tab 1" com um conteúdo simples
        Tab tab2 = new Tab("Tab 2", new Label("Conteúdo da Tab 2"));  // Cria a segunda aba "Tab 2" com um conteúdo simples
        tabPane.getTabs().addAll(tab1, tab2);  // Adiciona as duas abas ao TabPane

        // Adicionando todos os componentes ao StackPane
        root.getChildren().addAll(menuBar, tabPane, textLabel);  // Adiciona a barra de menus, as abas e o rótulo ao layout

        // Criando a cena e associando o layout root a ela
        Scene scene = new Scene(root, 400, 300);  // Cria uma nova cena com o layout root e define o tamanho da cena
        primaryStage.setTitle("Exemplo de Menus e TabPane");  // Define o título da janela principal
        primaryStage.setScene(scene);  // Define a cena para a janela principal
        primaryStage.show();  // Exibe a janela
    }

    public static void main(String[] args) {  // Método main para iniciar a aplicação
        launch(args);  // Chama o método launch() para iniciar a aplicação JavaFX
    }
}
