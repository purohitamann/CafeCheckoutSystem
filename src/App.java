/*Name: Aman Purohit -991669656
Purpose: Java Project: Cafe Checkout System
Created on: 04/10/2023
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.management.OperationsException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application  {
    public static void main(String[] args) throws Exception {
        
       
        launch(args);
      

    }



    @Override
    public void start(Stage primaryStage) throws Exception {

          MenuList menu = new MenuList();
          
         
        
        

        // MenuList Obj
        Font font = Font.font("Georgia", FontWeight.BLACK, 22);

        Text title = new Text("Cafe Checkout System");
        title.setFont(font);

        Button btnBeverage = new Button("Beverage");
        Button btnSnacks = new Button("Snacks");
        Button btnGoodies = new Button("Goodies");

        ListView checkoutWindow = new ListView<>();

        ListView list = new ListView<>();
        list.getItems().add(0, "Item Count: " + menu.size());
        getItemCount(menu, list);
        Button btnPay = new Button("Pay");
        Button btnAddItem = new Button("+");
        Button btnRemoveItem = new Button("-");
        HBox btnLastOrder = new HBox(10, btnAddItem, btnRemoveItem);
        Button btnPastOrder = new Button("Past Transactions");

        Button btnNewOrder = new Button("New Order");
        Button btnExit = new Button("Exit");

        GridPane grid = new GridPane();

        grid.add(title, 1, 0);
        grid.setAlignment(Pos.CENTER);

        GridPane gridOne = new GridPane();

        gridOne.add(btnSnacks, 0, 1);
        gridOne.add(btnBeverage, 1, 1);
        gridOne.add(btnGoodies, 2, 1);
        gridOne.setAlignment(Pos.CENTER);
        gridOne.setMargin(btnBeverage, new Insets(20));
        GridPane gridSecond = new GridPane();
        gridSecond.add(btnPay, 0, 0);
        gridSecond.add(btnLastOrder, 1, 0);
        gridSecond.add(btnPastOrder, 2, 0);
        gridSecond.setAlignment(Pos.CENTER);

        gridSecond.setMargin(btnLastOrder, new Insets(20));

        Text textEmpty = new Text("   ");
        GridPane gridForth = new GridPane();
        gridForth.add(btnNewOrder, 0, 0);
        gridForth.add(textEmpty, 1, 0);
        gridForth.add(btnExit, 2, 0);
        gridForth.setAlignment(Pos.CENTER);

        FlowPane pane = new FlowPane(Orientation.VERTICAL);

        pane.getChildren().add(grid);
        pane.getChildren().add(gridOne);
        pane.getStylesheets().add("styles.css");
        pane.getStyleClass().add("layout");

        Button btnBack = new Button("Back");

        Text snackText = new Text("Select item:");
        snackText.setFont(font);
        Button btnitem01 = new Button("Sandwich");
        Text priceItem01 = new Text("2.99");
        MenuItem sandwich = new MenuItem("Sandwich", 2.99);

        Button btnitem02 = new Button("Wrap");
        Text priceItem02 = new Text("3.29");
        MenuItem wrap = new MenuItem("Wrap", 3.29);

        Button btnitem03 = new Button("Pastry");
        Text priceItem03 = new Text("1.90");
        MenuItem pastry = new MenuItem("pastry", 1.90);

        Button btnitem04 = new Button("Doughnut");
        Text priceItem04 = new Text("1.99");
        MenuItem doughnut = new MenuItem("Doughnut", 1.99);

        Button btnitem05 = new Button("Crossiant");
        Text priceItem05 = new Text("2.70");
        MenuItem crossiant = new MenuItem("Crossiant", 2.70);

        Button btnSnackBack = new Button("Back");
        // Beverage
        Text beverageText = new Text("Select item:");
        beverageText.setFont(font);
        Button btnitem06 = new Button("Americano");
        Text priceItem06 = new Text("2.70");
        MenuItem americano = new MenuItem("Americano", 2.70);

        Button btnitem08 = new Button("591ml Drink");
        Text priceItem08 = new Text("2.25");
        MenuItem smallDrink = new MenuItem("591 Drink", 2.25);

        Button btnitem07 = new Button("Black Coffee");
        Text priceItem07 = new Text("1.70");
        MenuItem blackCoffee = new MenuItem("Black Coffee", 1.70);

        Button btnitem09 = new Button("Tea");
        Text priceItem09 = new Text("2.19");
        MenuItem tea = new MenuItem("Tea", 2.19);

        Button btnitem10 = new Button("Smoothie");
        Text priceItem10 = new Text("4.50");
        MenuItem smoothie = new MenuItem("Smoothie", 4.50);

        Button btnBevrageBack = new Button("Back");

        // tTitle.setFont(Font.font("Inter", FontWeight.BLACK, 18));

        // Goodies
        Text goodiesText = new Text("Select item:");
        goodiesText.setFont(font);
        Button btnitem11 = new Button("Granola Bar");
        Text priceItem11 = new Text("3.99");
        MenuItem granolBar = new MenuItem("Granola Bar", 3.99);

        Button btnitem12 = new Button("Chocolate Bar");
        Text priceItem12 = new Text("3.00");
        MenuItem chocolateBar = new MenuItem("Chocolate Bar", 3.00);

        Button btnitem13 = new Button("Corn-Flakes");
        Text priceItem13 = new Text("1.99");
        MenuItem cornFlakes = new MenuItem("CornFlakes", 1.99);

        Button btnitem14 = new Button("Gum");
        Text priceItem14 = new Text("1.50");
        MenuItem Gum = new MenuItem("Gum", 1.50);

        Button btnitem15 = new Button("Dairy Milk");
        Text priceItem15 = new Text("3.00");
        MenuItem dairyMilk = new MenuItem("Dairy milk", 3.00);

        Button btnitem16 = new Button("M&M");
        Text priceItem16 = new Text("1.99");
        MenuItem mnm = new MenuItem("M&M", 1.99);

        Button btnGoodiesBack = new Button("Back");

        // Snacks

        GridPane snackMenu = new GridPane();

        snackMenu.add(btnitem01, 0, 0);
        snackMenu.add(priceItem01, 1, 0);
        snackMenu.add(btnitem02, 2, 0);
        snackMenu.add(priceItem02, 3, 0);
        snackMenu.add(btnitem03, 4, 0);
        snackMenu.add(priceItem03, 5, 0);
        snackMenu.add(btnitem04, 0, 1);
        snackMenu.add(priceItem04, 1, 1);
        snackMenu.add(btnitem05, 2, 1);
        snackMenu.add(priceItem05, 3, 1);
        snackMenu.add(btnSnackBack, 2, 2);
        snackMenu.setHgap(25);
        snackMenu.setVgap(20);

        snackMenu.setAlignment(Pos.CENTER);
        VBox snackVBox = new VBox(25, snackText, snackMenu);
        snackVBox.getStylesheets().add("styles.css");
        snackVBox.getStyleClass().add("layout");
        snackVBox.setAlignment(Pos.CENTER);

        Scene snackOptions = new Scene(snackVBox, 800, 600);
        Stage snackStage = new Stage();
        snackStage.setTitle("Snack Menu");
        snackStage.setScene(snackOptions);
        // --------------------------------------------------
        // Beverage options

        GridPane beverageMenu = new GridPane();

        beverageMenu.add(btnitem06, 0, 0);
        beverageMenu.add(priceItem06, 1, 0);
        beverageMenu.add(btnitem07, 2, 0);
        beverageMenu.add(priceItem07, 3, 0);
        beverageMenu.add(btnitem08, 4, 0);
        beverageMenu.add(priceItem08, 5, 0);
        beverageMenu.add(btnitem09, 0, 1);
        beverageMenu.add(priceItem09, 1, 1);
        beverageMenu.add(btnitem10, 2, 1);
        beverageMenu.add(priceItem10, 3, 1);
        beverageMenu.add(btnBevrageBack, 2, 2);
        beverageMenu.setHgap(25);
        beverageMenu.setVgap(20);
        beverageMenu.setAlignment(Pos.CENTER);
        VBox beverageVBox = new VBox(25, beverageText, beverageMenu);
        beverageVBox.getStylesheets().add("styles.css");
        beverageVBox.getStyleClass().add("layout");
        beverageVBox.setAlignment(Pos.CENTER);
        Scene beverageOptions = new Scene(beverageVBox, 800, 600);
        Stage beverageStage = new Stage();
        beverageStage.setTitle("Beverage Menu");
        beverageStage.setScene(beverageOptions);

        GridPane goodiesMenu = new GridPane();

        goodiesMenu.add(btnitem11, 0, 0);
        goodiesMenu.add(priceItem11, 1, 0);
        goodiesMenu.add(btnitem12, 2, 0);
        goodiesMenu.add(priceItem12, 3, 0);
        goodiesMenu.add(btnitem13, 4, 0);
        goodiesMenu.add(priceItem13, 5, 0);
        goodiesMenu.add(btnitem14, 0, 1);
        goodiesMenu.add(priceItem14, 1, 1);
        goodiesMenu.add(btnitem15, 2, 1);
        goodiesMenu.add(priceItem15, 3, 1);
        goodiesMenu.add(btnitem16, 4, 1);
        goodiesMenu.add(priceItem16, 5, 1);
        goodiesMenu.add(btnGoodiesBack, 2, 2);
        goodiesMenu.setHgap(25);
        goodiesMenu.setVgap(20);
        goodiesMenu.setAlignment(Pos.CENTER);

        VBox goodiesVBox = new VBox(25, goodiesText, goodiesMenu);
        goodiesVBox.getStylesheets().add("styles.css");
        goodiesVBox.getStyleClass().add("layout");
        goodiesVBox.setAlignment(Pos.CENTER);

        Scene goodiesOptions = new Scene(goodiesVBox, 800, 600);
        Stage goodiesStage = new Stage();
        goodiesStage.setTitle("Goodies Menu");
        goodiesStage.setScene(goodiesOptions);

        // -------------------------
        // pay new order
        Button waitForNew = new Button("Wait for New Order");

        FlowPane payFlow = new FlowPane(Orientation.VERTICAL);

        payFlow.getChildren().add(waitForNew);
        payFlow.setAlignment(Pos.CENTER);
        payFlow.getChildren().add(checkoutWindow);
        payFlow.getStylesheets().add("styles.css");
        payFlow.getStyleClass().add("layout");
        Scene payScene = new Scene(payFlow, 300, 200);

        Stage payWindow = new Stage();
        payWindow.setTitle("Order Checkout");
        payWindow.setScene(payScene);

        SplitPane splitView = new SplitPane();
        splitView.getItems().addAll(list, checkoutWindow);
        splitView.setPrefSize(600, 300);
        pane.getChildren().addAll(splitView);
        pane.getChildren().add(gridSecond);

        pane.getChildren().add(gridForth);
        pane.setAlignment(Pos.CENTER);
        pane.getStylesheets().add("styles.css");
        pane.getStyleClass().add("layout");

        TabPane Tabs = new TabPane();
        ListView record = new ListView<>();
        record.getStylesheets().add("styles.css");
        record.getStyleClass().add("layout");
        Tab allTransactions = new Tab("All Transactions", record);
        Tab home = new Tab("Home", pane);

        Tabs.getTabs().add(home);
        Tabs.getTabs().add(allTransactions);

        Scene checkoutScene = new Scene(Tabs, 800, 600);
        Tabs.getStylesheets().add("styles.css");
        home.getStyleClass().add("layoutmain");
        allTransactions.getStyleClass().add("layoutmain");
       
        primaryStage.setScene(checkoutScene);
        primaryStage.setTitle("Cafe Checkout System");
       
        // menu.setEmployee(loginCheck.currentUser);
       
         
         primaryStage.show();

        

   
       
       
        record.setOnMouseClicked(e -> {

            String selectedItem = (String) record.getItems().get(record.getSelectionModel().getSelectedIndex());
            String orderNo;
            if (selectedItem.contains("Order No : ")) {
                TextArea datadisplay = new TextArea();
                datadisplay.getStylesheets().add("styles.css");
                datadisplay.getStyleClass().add("layout");

                orderNo = selectedItem.substring((selectedItem.indexOf(": ") + 2), (selectedItem.indexOf(": ") + 5))
                        .trim();

                try {
                    datadisplay.appendText(menu.getorderdetail(Integer.parseInt(orderNo)));
                } catch (NumberFormatException | IOException e1) {

                    System.out.println("Error in getting details!");
                }
                Scene dtatScene = new Scene(datadisplay);
                Stage dataStage = new Stage();
                dataStage.setScene(dtatScene);
                dataStage.setTitle("Retrieving Order No-" + orderNo);
                dataStage.show();

            }

        });

        // // Events
        btnBevrageBack.setOnAction(a -> {
            beverageStage.close();
        });

        btnGoodiesBack.setOnAction(a -> {
            goodiesStage.close();
        });

        btnSnackBack.setOnAction(a -> {
            snackStage.close();
        });
        btnAddItem.setOnAction(a -> {
            String selectedItem = (String) list.getItems().get(list.getSelectionModel().getSelectedIndex());
            list.getItems().add((selectedItem));
            menu.get(Integer.parseInt(selectedItem)).addQuantity();

            getItemCount(menu, list);

            updatePayWindow(menu, checkoutWindow);
        });

        btnRemoveItem.setOnAction(a -> {
            String selectedItem = (String) list.getItems().get(list.getSelectionModel().getSelectedIndex());
            list.getItems().remove(selectedItem);
        });
        btnPastOrder.setOnAction(w -> {
            Tabs.getSelectionModel().select(allTransactions);

        });

        btnSnacks.setOnAction(event -> {

            snackStage.show();
        });

        btnBeverage.setOnAction(event -> {

            beverageStage.show();
        });

        btnGoodies.setOnAction(event -> {

            goodiesStage.show();
        });

        btnExit.setOnAction(e -> {
            primaryStage.close();
        });

        btnBack.setOnAction(b -> {

            // beverStage.close();
            // goodiesStage.close();
            // snackStage.close();

        });

        // Snacks

        btnitem01.setOnAction(a -> {
            menu.add(sandwich);

            getItemCount(menu, list);
            list.getItems().add(" " + sandwich.getItemName() + "   " + sandwich.getItemPrice());

            snackStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        btnitem02.setOnAction(a -> {
            menu.add(wrap);
            getItemCount(menu, list);
            list.getItems().add(" " + wrap.getItemName() + "   " + wrap.getItemPrice());

            snackStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        btnitem03.setOnAction(a -> {
            menu.add(pastry);
            getItemCount(menu, list);
            list.getItems().add(" " + pastry.getItemName() + "   " + pastry.getItemPrice());

            snackStage.close();
            updatePayWindow(menu, checkoutWindow);
        });
        btnitem04.setOnAction(a -> {
            menu.add(doughnut);

            getItemCount(menu, list);
            list.getItems().add(" " + doughnut.getItemName() + "   " + doughnut.getItemPrice());

            snackStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem05.setOnAction(a -> {
            menu.add(crossiant);

            getItemCount(menu, list);
            list.getItems().add(" " + crossiant.getItemName() + "   " + crossiant.getItemPrice());

            snackStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        // beverage

        btnitem06.setOnAction(a -> {
            menu.add(americano);

            getItemCount(menu, list);
            list.getItems().add(" " + americano.getItemName() + "   " + americano.getItemPrice());

            beverageStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        btnitem08.setOnAction(a -> {
            menu.add(smallDrink);

            getItemCount(menu, list);
            list.getItems().add(" " + smallDrink.getItemName() + "   " + smallDrink.getItemPrice());

            beverageStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem07.setOnAction(a -> {
            menu.add(blackCoffee);

            getItemCount(menu, list);
            list.getItems().add(" " + blackCoffee.getItemName() + "   " + blackCoffee.getItemPrice());

            beverageStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem09.setOnAction(a -> {
            menu.add(tea);

            getItemCount(menu, list);
            list.getItems().add(" " + tea.getItemName() + "   " + tea.getItemPrice());

            beverageStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem10.setOnAction(a -> {
            menu.add(smoothie);

            getItemCount(menu, list);
            list.getItems().add(" " + smoothie.getItemName() + "   " + smoothie.getItemPrice());

            beverageStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        // goodies
        btnitem11.setOnAction(a -> {
            menu.add(granolBar);

            getItemCount(menu, list);
            list.getItems().add(" " + granolBar.getItemName() + "   " + granolBar.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });

        btnitem12.setOnAction(a -> {
            menu.add(chocolateBar);

            getItemCount(menu, list);
            list.getItems().add(" " + chocolateBar.getItemName() + "   " + chocolateBar.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem13.setOnAction(a -> {
            menu.add(cornFlakes);

            getItemCount(menu, list);
            list.getItems().add(" " + cornFlakes.getItemName() + "   " + cornFlakes.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem14.setOnAction(a -> {
            menu.add(Gum);

            getItemCount(menu, list);
            list.getItems().add(" " + Gum.getItemName() + "   " + Gum.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem15.setOnAction(a -> {
            menu.add(dairyMilk);

            getItemCount(menu, list);
            list.getItems().add(" " + dairyMilk.getItemName() + "   " + dairyMilk.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnitem16.setOnAction(a -> {
            menu.add(mnm);

            getItemCount(menu, list);
            list.getItems().add(" " + mnm.getItemName() + "   " + mnm.getItemPrice());

            goodiesStage.close();
            updatePayWindow(menu, checkoutWindow);

        });
        btnPay.setOnAction(e -> {
            if (menu.empty()) {
                Text error = new Text("Select Item First");
                HBox errorBox = new HBox(error);

                Scene errorScene = new Scene(errorBox, 200, 100);
                errorBox.getStylesheets().add("styles.css");
                errorBox.getStyleClass().add("layout");
                Stage errorStage = new Stage();
                errorStage.setTitle("System Error");
                errorStage.setScene(errorScene);
                errorStage.show();

            } else {
                payWindow.show();
                try {
                    menu.generateReceipt();
                    menu.generateReceiptraf();
                } catch (IOException e1) {
                    checkoutWindow.getItems().add(menu.generateSubtotal() + "   " + menu.getTotal());
                }

            }

        });

        waitForNew.setOnAction(e -> {
            updateRegistry(menu, record);
            checkoutWindow.getItems().clear();
            list.getItems().clear();
            menu.clear();
            list.getItems().add("Item Count: " + menu.size());
            payWindow.close();
            updatePayWindow(menu, checkoutWindow);
         });

        btnNewOrder.setOnAction(e -> {
            updatePayWindow(menu, record);
            menu.clear();
            checkoutWindow.getItems().clear();
            list.getItems().clear();
            list.getItems().add("Item Count: " + menu.size());
            updatePayWindow(menu, checkoutWindow);

        });

    }

    private void updatePayWindow(MenuList menu, ListView checkoutWindow) {
        checkoutWindow.getItems().clear();
        checkoutWindow.getItems()
                .add("Subtotal is: $" + menu.generateSubtotal() + " \n" + "Total is $" + menu.getTotal() + "\n");
    }

    private void updateRegistry(MenuList menu, ListView checkoutWindow) {

        String order = "Order No : " + menu.getOrderNo() + "      Order Item Count: " + menu.size()
                + "      Order Subtotal: $" + menu.generateSubtotal() + "      Taxable Total: $" + menu.getTotal();
        checkoutWindow.getItems()
                .add(order);

    }

    private void getItemCount(MenuList menu, ListView view) {
        view.getItems().remove(view.getItems().get(0));
        view.getItems().add(0, "Item Count: " + menu.size());

    }

}