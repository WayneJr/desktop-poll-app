import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        primaryStage.setTitle("Desktop Polls");
        primaryStage.setScene(new Scene(root, 510, 516));
//        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
//        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        launch(args);
    }
}
