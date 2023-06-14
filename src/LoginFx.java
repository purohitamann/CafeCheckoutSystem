import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginFx extends Application {

   static Employee currentUser = new Employee("Admin");
   static boolean check;

public static void main(String[] args) {
    launch(args);
}



    @Override
    public void start(Stage primaryStage) throws Exception {
        login user = new login();
      
        Font font = Font.font("Georgia", FontWeight.BLACK, 22);
       Label lblusername = new Label("Username");
       TextField tfusername = new TextField();
         
       lblusername.setFont(font);

       Label lblpassword = new Label("Password"); 
       PasswordField tfpassword = new PasswordField();

       lblpassword.setFont(font);

       Button btnLogin = new Button("Log-in");

       Button btnSignin = new Button("Sign-in");

       GridPane grid = new GridPane();
       grid.add(lblusername, 0, 0);
       grid.add(tfusername,1,0);
       
       grid.add(lblpassword,0,1);
       grid.add(tfpassword,1,1);

       grid.add(btnSignin, 0, 2);
       grid.add(btnLogin, 1, 2);


       grid.setAlignment(Pos.CENTER);
       grid.setVgap(15);
       grid.setHgap(15);
     
       Text title0 =  new Text("   ");
       Text title = new Text("The Cafe Checkout System");
    
       VBox vpane =  new VBox();
       vpane.getChildren().add(grid);
       vpane.getChildren().add(title0);
       vpane.getChildren().add(title);
       vpane.getStylesheets().add("styles.css");
       vpane.getStyleClass().add("layout");
       vpane.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(vpane,500,400);
       primaryStage.setTitle("Employee Login");
       primaryStage.setScene(scene);
       primaryStage.show();

        

       btnLogin.setOnAction(e -> {
        String UserName = tfusername.getText();
        String PassWord = tfpassword.getText(); 
        try {
            // System.out.println(UserName);
            // // System.out.println(PassWord);
            // if(user.validateUser(UserName)){ 

            //    if(user.validatePassword(PassWord)){
            //     System.out.println(PassWord);
               
            //     user.setCheck(true);
            //     
            if(user.validateCredentials(UserName, PassWord)){
            this.check = true;
                this.currentUser = user.getUsername();

            //    System.out.println(user.isCheck());
                
                primaryStage.close();
               
                App exe = new App();
                exe.start(new Stage());
            }else{
                user.setCheck(false);
                this.check = false;
               
            }
             
        } catch (IOException e1) {
            this.check = false;
        } catch (Exception e1) {
            this.check = false;
        }

        


       });

 }




}
