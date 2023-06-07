import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javafx.application.Application;
import javafx.css.Style;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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



public class login  {
    private Employee username;
    private String password;
    private static int noOfUsers=0;
    private boolean check;

    public login(){
         this.noOfUsers++;
    }

    public login(String name) throws IOException{
        this.username = new Employee( name);
        this.noOfUsers++;
        PasswordManager manpass = new PasswordManager();
        manpass.setPassword();
    }
     
    public login(String name, String password){
        this.username.setEmployeeFristName(name);
        this.password = password;
        this.noOfUsers++;
        // Employee  = new Employee(name);
    }

    
    
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Employee getUsername() {
        return username;
    }

    public void setUsername(Employee username) {
        this.username = username;
    }

    public boolean validateUser(String name) throws IOException{
        
        // Scanner scanPass =  new Scanner(System.in);
        // System.out.println("Enter username...");
        // String name = scanPass.next();
        byte[] username = new byte[name.length()];
        RandomAccessFile loginRAF = new RandomAccessFile(new File("src\\Credentials\\loginCredentials.dat"), "rw");
        boolean found = false;
        try {
            while (loginRAF.getFilePointer() < loginRAF.length()) {
                loginRAF.read(username);
                String readData = new String(username, StandardCharsets.UTF_8);
                if (readData.equals(name)) {
                    
                    found=true; 
                    break;
                }else{
                    continue;
                }
            }
        } finally {
        //     if(found == true){
        //    System.out.println("User validated!");
          
        //     }else{
        //         System.out.println("User not Found!");
        //     }
            // loginRAF.setLength(0);
            loginRAF.close();
            
        }
        return found;
    }
    

    private class PasswordManager extends login{

        private void setPassword() throws IOException{
            Scanner reader = new Scanner(System.in);
                System.out.println("Enter Username: ");
                String username = reader.next();
           
           
            
            System.out.println("Setting Password for "+username+" Type password...");
            char[] passEntered = System.console().readPassword();
            String pass = new String(passEntered);
            System.out.println("Confirm Password by retyping...");
            String confirmPass= new String(System.console().readPassword());
            if( pass.equals(confirmPass) ){
                password =  confirmPass; 
                System.out.println("password set successfully! \n New User Registered");
                File loginFile = new File("src\\Credentials\\loginCredentials.dat");
                RandomAccessFile loginRAF = new RandomAccessFile(loginFile,"rw");
                long pos = loginRAF.length();
                loginRAF.seek(pos);
                // loginRAF.writeInt(login.noOfUsers);
                byte[] name = username.getBytes(StandardCharsets.UTF_8);
                byte[] passcode = password.getBytes(StandardCharsets.UTF_8);
               
                loginRAF.write(name);
                loginRAF.write(passcode);
                loginRAF.writeBytes("\n");
                loginRAF.close(); 
                
            }else{
                System.out.println("passwords Dont match!");
            }

    
        }

        


     }

     public void showPassword(){
            
            Scanner scanPass = new Scanner(System.in);
            System.out.println("to Display Password, Type correct Password below for "+this.username);
            String enteredpass = new String(System.console().readPassword());
            if (this.password.equals(enteredpass)){
               System.out.println("PassWord for "+this.username+" : "+this.password); 
            }else{
                System.out.println("password is not a match");
            }
         
        }

        public boolean validatePassword(String enteredpass){
            boolean checkpass=false;
            // System.out.println("to Display Password, Type correct Password below for "+this.username);
            // String enteredpass = new String(System.console().readPassword());
            if (this.password.equals(enteredpass)){
              checkpass = true; 
            }else{
                checkpass = false;
            }
            return checkpass;
         
        }

    public static void main(String[] args) throws IOException {
        login manager = new login("Aman");
        
        // login crew = new login("Roop");
        // crew.setPassword();
        // manager.showPassword();
       
       
       
        // launch( args);

        
    }

    // @Override
    // public void start(Stage primaryStage) throws Exception {

    //     Font font = Font.font("Georgia", FontWeight.BLACK, 22);
    //    Label lblusername = new Label("Username");
    //    TextField tfusername = new TextField();
         
    //    lblusername.setFont(font);

    //    Label lblpassword = new Label("Password"); 
    //    PasswordField tfpassword = new PasswordField();

    //    lblpassword.setFont(font);

    //    Button btnLogin = new Button("Log-in");

    //    Button btnSignin = new Button("Sign-in");

    //    GridPane grid = new GridPane();
    //    grid.add(lblusername, 0, 0);
    //    grid.add(tfusername,1,0);
       
    //    grid.add(lblpassword,0,1);
    //    grid.add(tfpassword,1,1);

    //    grid.add(btnSignin, 0, 2);
    //    grid.add(btnLogin, 1, 2);


    //    grid.setAlignment(Pos.CENTER);
    //    grid.setVgap(15);
    //    grid.setHgap(15);
     
    //    Text title0 =  new Text("   ");
    //    Text title = new Text("The Cafe Checkout System");
    
    //    VBox vpane =  new VBox();
    //    vpane.getChildren().add(grid);
    //    vpane.getChildren().add(title0);
    //    vpane.getChildren().add(title);
    //    vpane.getStylesheets().add("styles.css");
    //    vpane.getStyleClass().add("layout");
    //    vpane.setAlignment(Pos.CENTER);
       
    //    Scene scene = new Scene(vpane,500,400);
    //    primaryStage.setTitle("Employee Login");
    //    primaryStage.setScene(scene);
    //    primaryStage.show();

    //     String UserName = tfusername.getText();
    //     String PassWord = tfpassword.getText();
    //    btnLogin.setOnAction(e -> {
    //      try {
    //         if(validateUser(UserName) && validatePassword(PassWord)){
    //             primaryStage.close();
    //          }
    //     } catch (IOException e1) {
    //         // TODO Auto-generated catch block
    //         e1.printStackTrace();
    //     }
    //    });
       
    //   }

      
}
