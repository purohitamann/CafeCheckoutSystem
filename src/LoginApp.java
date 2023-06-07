import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class LoginApp extends Application  {

   public static void main(String[] args) {
   launch(args);
   }

@Override
public void start(Stage primaryStage) throws Exception {
        LoginFx loginCheck = new LoginFx();
        loginCheck.start(primaryStage);
        
        if(loginCheck.check == true){
                App app = new App();
                loginCheck.stop();
                app.start(new Stage());
        }
      
        

}



}