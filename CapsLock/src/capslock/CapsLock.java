package capslock;

import java.io.IOException;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author RISCassembler
 */
public final class CapsLock extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final LogHandler logger = LogHandler.instance;
        logger.info("CapsLock started.");
        launch(args);
        logger.info("CapsLock terminated normally.");
        logger.close();
    }
    
    @Override
    public void start(Stage stage) throws Exception {

        final FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
        
        final Parent root;

        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
            return;
        }
        
        final MainFormController controller = (MainFormController)loader.getController();
        stage.setScene(new Scene(root));
        stage.setOnShown(event -> controller.onLoad(event));
        stage.setTitle("CapsLock");
        stage.setFullScreen(true);
        stage.setAlwaysOnTop(true);
        stage.show();
    }
}
