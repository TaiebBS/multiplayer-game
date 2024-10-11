import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;


public class Game extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("pair ou impair");
        primaryStage.setScene(createMainScene(primaryStage));
        primaryStage.show();
    }

    private Scene createMainScene(Stage primaryStage) {
        Pane panel = createPanel(primaryStage);
        Scene scene = new Scene(panel, 500, 400);
        scene.setFill(javafx.scene.paint.Color.rgb(37, 150, 190));
        return scene;
    }

    private Pane createPanel(Stage primaryStage) {
        Pane panel = new Pane();

        Button button1 = new Button("CPU VS CPU");
        Button button2 = new Button("1 joueur");
        Button button3 = new Button("2 joueurs");

        String ButtonStyle = 
            "-fx-background-color: white;"
          + "-fx-text-fill: black;"
          + "-fx-font-size: 15px;"
          + "-fx-padding: 5 10;"
          + "-fx-border-radius: 25;"
          + "-fx-background-radius: 25;";

        String hoverStyle = 
            "-fx-background-color: black;"
          + "-fx-text-fill: white;"
          + "-fx-font-size: 15px;"
          + "-fx-padding: 5 10;"
          + "-fx-border-radius: 25;"
          + "-fx-background-radius: 25;";

        button1.setStyle(ButtonStyle);
        button2.setStyle(ButtonStyle);
        button3.setStyle(ButtonStyle);

        button1.setOnMouseEntered(e -> button1.setStyle(hoverStyle));
        button2.setOnMouseEntered(e -> button2.setStyle(hoverStyle));
        button3.setOnMouseEntered(e -> button3.setStyle(hoverStyle));   

        button1.setOnMouseExited(e -> button1.setStyle(ButtonStyle));
        button2.setOnMouseExited(e -> button2.setStyle(ButtonStyle));
        button3.setOnMouseExited(e -> button3.setStyle(ButtonStyle));

        button1.setLayoutX(90);
        button1.setOnAction(e -> showCPUInterface(primaryStage));
        button2.setOnAction(e -> show1PlayerInterface(primaryStage));
        button3.setOnAction(e -> show2PlayersInterface(primaryStage));

        HBox buttonBox = new HBox(30);
        buttonBox.getChildren().addAll(button1, button2, button3);
        
        buttonBox.setLayoutX(90);
        buttonBox.setLayoutY(300);

        panel.getChildren().add(buttonBox);

        String imagePath = "C:\\Users\\lenovo\\Downloads\\image2.jpeg";
        File file = new File(imagePath);
        String uri = file.toURI().toString();

        panel.setStyle("-fx-background-image: url('" + uri + "');"
                      + "-fx-background-size: cover;");

        return panel;
    }

    private void showCPUInterface(Stage primaryStage) {
    Pane mainPanel = new Pane();
    mainPanel.setStyle("-fx-background-color: rgba(31,21,32,255);");

    Label titleLabel = new Label("CPU VS CPU");
    titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");
    titleLabel.setLayoutX(165);
    titleLabel.setLayoutY(20);

    mainPanel.getChildren().add(titleLabel);

    //player 1
    Pane player1Panel = new Pane();
    player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player1Panel.setLayoutX(0);
    player1Panel.setLayoutY(100);
    player1Panel.setPrefSize(180, 200);

    Label player1Label = new Label("CPU 1");
    player1Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
    player1Label.setLayoutX(55);
    player1Label.setLayoutY(10);

    Label choix_parite1 = new Label();
    choix_parite1.setLayoutX(20);
    choix_parite1.setLayoutY(60);
    choix_parite1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_parite1.setText("choix =");

    
    Label choix_nombre1 = new Label();
    choix_nombre1.setLayoutX(20);
    choix_nombre1.setLayoutY(100);
    choix_nombre1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_nombre1.setText("nombre =");

    player1Panel.getChildren().addAll(player1Label, choix_nombre1,choix_parite1);
    mainPanel.getChildren().add(player1Panel);

    //middle panel
    Pane middlePanel = new Pane();
    middlePanel.setStyle("-fx-background-color: rgba(31,21,32,255);");
    middlePanel.setLayoutX(220);
    middlePanel.setLayoutY(80);
    middlePanel.setPrefSize(100, 200);

    Button middleButton = new Button("Lancer");
    middleButton.setLayoutX(10);
    middleButton.setLayoutY(100);

    Button NewGame = new Button("nouvelle partie");
    NewGame.setLayoutX(-15);
    NewGame.setLayoutY(250);
    NewGame.setOnAction(e -> showCPUInterface(primaryStage));

    Button backButton = new Button("Retour");
    backButton.setLayoutX(8);
    backButton.setLayoutY(280);
    backButton.setMaxWidth(70);
    backButton.setOnAction(e -> primaryStage.setScene(createMainScene(primaryStage)));

    middlePanel.getChildren().addAll(middleButton,NewGame ,backButton);
    mainPanel.getChildren().add(middlePanel);

    //player 2
    Pane player2Panel = new Pane();
    player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player2Panel.setLayoutX(320);
    player2Panel.setLayoutY(100);
    player2Panel.setPrefSize(180, 200);

    Label player2Label = new Label("CPU 2");
    player2Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
    player2Label.setLayoutX(55);
    player2Label.setLayoutY(10);

    Label choix_parite2 = new Label();
    choix_parite2.setLayoutX(20);
    choix_parite2.setLayoutY(60);
    choix_parite2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_parite2.setText("choix =");

    Label choix_nombre2 = new Label();
    choix_nombre2.setLayoutX(20);
    choix_nombre2.setLayoutY(100);
    choix_nombre2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_nombre2.setText("nombre =");

    player2Panel.getChildren().addAll(player2Label,choix_parite2, choix_nombre2);
    mainPanel.getChildren().add(player2Panel);

    middleButton.setOnAction(e -> {
        middlePanel.getChildren().remove(middleButton);
        
        Random random = new Random();
        String[] options = {"pair", "impair"};
        int x = random.nextInt(options.length);
        CPU cpu1 = new CPU(choix_parite1,choix_nombre1,options[x]);
        CPU cpu2 = new CPU(choix_parite2,choix_nombre2,options[1-x]);
        cpu1.run();
        cpu2.run();
        int total = cpu1.getNombre() + cpu2.getNombre();
        if ((cpu1.getPrediction().equals("pair") && total % 2 == 0) || 
    (cpu1.getPrediction().equals("impair") && total % 2 != 0)) { 
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
        } else {
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
        }
        Label total_label = new Label();
        total_label.setLayoutX(-5);
        total_label.setLayoutY(100);
        total_label.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        total_label.setText("total = " + total);
        middlePanel.getChildren().add(total_label);
    });

    Scene newScene = new Scene(mainPanel, 500, 400);
    primaryStage.setScene(newScene);
}

    private void show1PlayerInterface(Stage primaryStage) {
    Pane mainPanel = new Pane();
    mainPanel.setStyle("-fx-background-color: rgba(31,21,32,255);");

    Label titleLabel = new Label("CPU VS CPU");
    titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");
    titleLabel.setLayoutX(165);
    titleLabel.setLayoutY(20);

    mainPanel.getChildren().add(titleLabel);

    //player 1
    Pane player1Panel = new Pane();
    player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player1Panel.setLayoutX(0);
    player1Panel.setLayoutY(100);
    player1Panel.setPrefSize(180, 200);

    Label player1Label = new Label("PLAYER");
    player1Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
    player1Label.setLayoutX(50);
    player1Label.setLayoutY(10);

    Label choix_parite1 = new Label();
    choix_parite1.setLayoutX(20);
    choix_parite1.setLayoutY(60);
    choix_parite1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_parite1.setText("choix =");
    
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.getItems().addAll("pair", "impair");
    comboBox.setPromptText("choix");
    comboBox.setLayoutX(90);
    comboBox.setLayoutY(63);
    comboBox.setMaxWidth(80);
    
    Label choix_nombre1 = new Label();
    choix_nombre1.setLayoutX(20);
    choix_nombre1.setLayoutY(100);
    choix_nombre1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_nombre1.setText("nombre =");

    TextField inputField = new TextField();
    inputField.setLayoutX(110);
    inputField.setLayoutY(103);
    inputField.setMaxWidth(50);
    inputField.setPromptText("Input");

    player1Panel.getChildren().addAll(player1Label, choix_nombre1,choix_parite1,comboBox,inputField);
    mainPanel.getChildren().add(player1Panel);

    //middle panel
    Pane middlePanel = new Pane();
    middlePanel.setStyle("-fx-background-color: rgba(31,21,32,255);");
    middlePanel.setLayoutX(220);
    middlePanel.setLayoutY(80);
    middlePanel.setPrefSize(100, 200);

    Button middleButton = new Button("Lancer");
    middleButton.setLayoutX(10);
    middleButton.setLayoutY(100);

    Button NewGame = new Button("nouvelle partie");
    NewGame.setLayoutX(-15);
    NewGame.setLayoutY(250);
    NewGame.setOnAction(e -> show1PlayerInterface(primaryStage));

    Button backButton = new Button("Retour");
    backButton.setLayoutX(10);
    backButton.setLayoutY(280);
    backButton.setMaxWidth(70);
    backButton.setOnAction(e -> primaryStage.setScene(createMainScene(primaryStage)));

    middlePanel.getChildren().addAll(middleButton,NewGame ,backButton);
    mainPanel.getChildren().add(middlePanel);

    //player 2
    Pane player2Panel = new Pane();
    player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player2Panel.setLayoutX(320);
    player2Panel.setLayoutY(100);
    player2Panel.setPrefSize(180, 200);

    Label player2Label = new Label("CPU");
    player2Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
    player2Label.setLayoutX(70);
    player2Label.setLayoutY(10);

    Label choix_parite2 = new Label();
    choix_parite2.setLayoutX(20);
    choix_parite2.setLayoutY(60);
    choix_parite2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_parite2.setText("choix =");

    Label choix_nombre2 = new Label();
    choix_nombre2.setLayoutX(20);
    choix_nombre2.setLayoutY(100);
    choix_nombre2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_nombre2.setText("nombre =");

    player2Panel.getChildren().addAll(player2Label,choix_parite2, choix_nombre2);
    mainPanel.getChildren().add(player2Panel);

    middleButton.setOnAction(e -> {
        if (inputField.getText().length() ==1 && inputField.getText().matches("[0-9]*") && comboBox.getSelectionModel().getSelectedItem() != null && !comboBox.getSelectionModel().getSelectedItem().isEmpty()) 
        {middlePanel.getChildren().remove(middleButton);
        
        String selected = comboBox.getSelectionModel().getSelectedItem();
        String[] options = {"pair", "impair"};
        String otherOption = "";

        for (String option : options) {
            if (!option.equals(selected)) {
                otherOption = option;
                break;
            }
        }
        CPU cpu1 = new CPU(choix_parite1,choix_nombre1,selected,Integer.parseInt(inputField.getText()));
        CPU cpu2 = new CPU(choix_parite2,choix_nombre2,otherOption);
        cpu1.run();
        cpu2.run();
        int total = cpu1.getNombre() + cpu2.getNombre();
        if ((cpu1.getPrediction().equals("pair") && total % 2 == 0) || 
    (cpu1.getPrediction().equals("impair") && total % 2 != 0)) { 
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
        } else {
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
        }
        Label total_label = new Label();
        total_label.setLayoutX(0);
        total_label.setLayoutY(100);
        total_label.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        total_label.setText("total = " + total);
        middlePanel.getChildren().add(total_label);
        
        player1Panel.getChildren().remove(comboBox);
        player1Panel.getChildren().remove(inputField);
    }
    });

    Scene newScene = new Scene(mainPanel, 500, 400);
    primaryStage.setScene(newScene);
    }

    private void show2PlayersInterface(Stage primaryStage) {
    Pane mainPanel = new Pane();
    mainPanel.setStyle("-fx-background-color: rgba(31,21,32,255);");

    Label titleLabel = new Label("CPU VS CPU");
    titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 32px; -fx-font-weight: bold;");
    titleLabel.setLayoutX(165);
    titleLabel.setLayoutY(20);

    mainPanel.getChildren().add(titleLabel);

    //player 1
    Pane player1Panel = new Pane();
    player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player1Panel.setLayoutX(0);
    player1Panel.setLayoutY(100);
    player1Panel.setPrefSize(180, 200);

    Label player1Label = new Label("PLAYER");
    player1Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
    player1Label.setLayoutX(50);
    player1Label.setLayoutY(10);

    Label choix_parite1 = new Label();
    choix_parite1.setLayoutX(20);
    choix_parite1.setLayoutY(60);
    choix_parite1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_parite1.setText("choix =");
    
    ComboBox<String> comboBox1 = new ComboBox<>();
    comboBox1.getItems().addAll("pair", "impair");
    comboBox1.setPromptText("choix");
    comboBox1.setLayoutX(90);
    comboBox1.setLayoutY(63);
    comboBox1.setMaxWidth(80);
    
    Label choix_nombre1 = new Label();
    choix_nombre1.setLayoutX(20);
    choix_nombre1.setLayoutY(100);
    choix_nombre1.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
    choix_nombre1.setText("nombre =");

    PasswordField inputField = new PasswordField();
    inputField.setLayoutX(110);
    inputField.setLayoutY(103);
    inputField.setMaxWidth(50);
    inputField.setPromptText("Input");

    player1Panel.getChildren().addAll(player1Label, choix_nombre1,choix_parite1,comboBox1,inputField);
    mainPanel.getChildren().add(player1Panel);

    //middle panel
    Pane middlePanel = new Pane();
    middlePanel.setStyle("-fx-background-color: rgba(31,21,32,255);");
    middlePanel.setLayoutX(220);
    middlePanel.setLayoutY(80);
    middlePanel.setPrefSize(100, 200);

    Button middleButton = new Button("Lancer");
    middleButton.setLayoutX(10);
    middleButton.setLayoutY(100);

    Button NewGame = new Button("nouvelle partie");
    NewGame.setLayoutX(-15);
    NewGame.setLayoutY(250);
    NewGame.setOnAction(e -> show2PlayersInterface(primaryStage));

    Button backButton = new Button("Retour");
    backButton.setLayoutX(10);
    backButton.setLayoutY(280);
    backButton.setMaxWidth(70);
    backButton.setOnAction(e -> primaryStage.setScene(createMainScene(primaryStage)));

    middlePanel.getChildren().addAll(middleButton,NewGame ,backButton);
    mainPanel.getChildren().add(middlePanel);

    //player 2
    Pane player2Panel = new Pane();
    player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: white;" +
        "-fx-border-radius: 5;");
    player2Panel.setLayoutX(320);
    player2Panel.setLayoutY(100);
    player2Panel.setPrefSize(180, 200);

    Label player2Label = new Label("PLAYER 2");
player2Label.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
player2Label.setLayoutX(50);
player2Label.setLayoutY(10);

Label choix_parite2 = new Label();
choix_parite2.setLayoutX(20);
choix_parite2.setLayoutY(60);
choix_parite2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
choix_parite2.setText("choix =");

ComboBox<String> comboBox2 = new ComboBox<>();
comboBox2.getItems().addAll("pair", "impair");
comboBox2.setPromptText("choix");
comboBox2.setLayoutX(90);
comboBox2.setLayoutY(63);
comboBox2.setMaxWidth(80);

Label choix_nombre2 = new Label();
choix_nombre2.setLayoutX(20);
choix_nombre2.setLayoutY(100);
choix_nombre2.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
choix_nombre2.setText("nombre =");

PasswordField inputField2 = new PasswordField();
inputField2.setLayoutX(110);
inputField2.setLayoutY(103);
inputField2.setMaxWidth(50);
inputField2.setPromptText("Input");

player2Panel.getChildren().addAll(player2Label, choix_nombre2, choix_parite2, comboBox2, inputField2);
mainPanel.getChildren().add(player2Panel);


    middleButton.setOnAction(e -> {
        if ((inputField.getText().length() ==1 && inputField.getText().matches("[0-9]*"))
        && (inputField2.getText().length() ==1 && inputField2.getText().matches("[0-9]*"))
        && (comboBox1.getSelectionModel().getSelectedItem() != null && !comboBox1.getSelectionModel().getSelectedItem().isEmpty())
        && (comboBox2.getSelectionModel().getSelectedItem() != null && !comboBox2.getSelectionModel().getSelectedItem().isEmpty())
        && !(comboBox2.getSelectionModel().getSelectedItem().equals(comboBox1.getSelectionModel().getSelectedItem()))) 
        {middlePanel.getChildren().remove(middleButton);

        CPU cpu1 = new CPU(choix_parite1,choix_nombre1,comboBox1.getSelectionModel().getSelectedItem(),Integer.parseInt(inputField.getText()));
        CPU cpu2 = new CPU(choix_parite2,choix_nombre2,comboBox2.getSelectionModel().getSelectedItem(),Integer.parseInt(inputField2.getText()));
        cpu1.run();
        cpu2.run();
        int total = cpu1.getNombre() + cpu2.getNombre();
        if ((cpu1.getPrediction().equals("pair") && total % 2 == 0) || 
    (cpu1.getPrediction().equals("impair") && total % 2 != 0)) { 
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
        } else {
            player1Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: red;" +
        "-fx-border-radius: 5;");
            player2Panel.setStyle("-fx-background-color: rgba(50,50,50,255);" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-color: green;" +
        "-fx-border-radius: 5;");
        }
        Label total_label = new Label();
        total_label.setLayoutX(0);
        total_label.setLayoutY(100);
        total_label.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        total_label.setText("total = " + total);
        middlePanel.getChildren().add(total_label);
        
        player1Panel.getChildren().remove(comboBox1);
        player1Panel.getChildren().remove(inputField);
        player2Panel.getChildren().remove(comboBox2);
        player2Panel.getChildren().remove(inputField2);
    }
    });

    Scene newScene = new Scene(mainPanel, 500, 400);
    primaryStage.setScene(newScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
