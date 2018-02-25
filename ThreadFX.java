//@code contributor: S.Mohammad J. Nourbakhsh
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ThreadFX extends Application {
	private String text = "";
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Label lbl = new Label("Programming is fun");
		pane.getChildren().add(lbl);
		new Thread(new Runnable(){
			public void run(){
				while(true){
					if(lbl.getText().trim().length()==7){
						text = "Goodby";
					
				}else text = "Welcome";
					
					Platform.runLater(new Runnable(){
						public void run(){
							lbl.setText(text);
						}
					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
				
				
				
			}}
				).start();
		
	Scene scene = new Scene(pane,200,50);
	primaryStage.setTitle("Hello");
	primaryStage.setScene(scene);
	primaryStage.show();
	
		}
	public static void main(String[] args){
		Application.launch(args);
	}
	}


