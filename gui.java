import javafx.*;
public class gui  extends application {
Button b1;
public static void main(String[] args){
	launch(args);
}
public void start(Stage primaryStage)
{
	primaryStage.setTitle("Title of the window");
	b1=new Button();
	b1.setText("Press me?");

}
}