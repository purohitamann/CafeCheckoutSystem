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
        App app = new App();
        if(loginCheck.check == false){
                loginCheck.stop();
                app.start(new Stage());
        }
      
        

}



}