package Random_C;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttn_save;

    @FXML
    private ImageView img_monkey;

    @FXML
    private TextArea txt_field;

    @FXML
    private Label lbl_instructions2;

    @FXML
    private Button bttn_reset;

    @FXML
    private Button bttn_generate;

    @FXML
    private Label lbl_title;

    @FXML
    private Label lbl_instructions1;

    @FXML
    private Separator separator;

    @FXML
    private Label lbl_preview;

    private String random_code;

    @FXML
    void generateCode(ActionEvent event) {
        //bttn_generate.setDisable(true);
        bttn_save.setDisable(false);
        bttn_reset.setDisable(false);
        img_monkey.setVisible(true);

        random_code = prog();

        // System.out.println(random_code); // for testing purposes

        txt_field.setText(random_code);

    }

    @FXML
    void save(ActionEvent event) {

        try(  PrintWriter out = new PrintWriter( "random_C.txt" )  ){
            out.println(txt_field.getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void reset(ActionEvent event) {
        bttn_generate.setDisable(false);
        bttn_save.setDisable(true);
        bttn_reset.setDisable(true);

        txt_field.setText("Introduction to Programming Languages\n" +
                "\n" +
                "HOMEWORK #1\n" +
                "\n" +
                "Author: Mauro J. Pappaterra\n" +
                "Net id: ew3525\n" +
                "Area: Computer Science\n" +
                "Course Code: CS 3120\n" +
                "Quarter: Winter 2017\n" +
                "\n" +
                "California State University East Bay");

    }

    @FXML
    void initialize() {
        assert bttn_save != null : "fx:id=\"bttn_save\" was not injected: check your FXML file 'GUI.fxml'.";
        assert img_monkey != null : "fx:id=\"img_monkey\" was not injected: check your FXML file 'GUI.fxml'.";
        assert txt_field != null : "fx:id=\"txt_field\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lbl_instructions2 != null : "fx:id=\"lbl_instructions2\" was not injected: check your FXML file 'GUI.fxml'.";
        assert bttn_reset != null : "fx:id=\"bttn_reset\" was not injected: check your FXML file 'GUI.fxml'.";
        assert bttn_generate != null : "fx:id=\"bttn_generate\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lbl_title != null : "fx:id=\"lbl_title\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lbl_instructions1 != null : "fx:id=\"lbl_instructions1\" was not injected: check your FXML file 'GUI.fxml'.";
        assert separator != null : "fx:id=\"separator\" was not injected: check your FXML file 'GUI.fxml'.";
        assert lbl_preview != null : "fx:id=\"lbl_preview\" was not injected: check your FXML file 'GUI.fxml'.";

    }

    // EVERY METHOD RELATED TO THE STRING GENERATIONS
    // I used methods and random number generation
    // For convenience sake every method is named after its production name

    static Random randomize = new Random(); // keeping things random

    private static String prog (){
        return "int main() {" + stat_list() + "return 0;\n}";
    }

    private static String stat_list (){
        int choose = randomize.nextInt(2);
        String code = "";

        switch (choose){
            case 0:
                code = "\n\t" + stat() +"\n";
                break;
            case 1:
                code = "\n\t" + stat() + "\n" + stat_list();
                break;
        }

        return code;
    }

    private static String stat() {
        int choose = randomize.nextInt(5);
        String code = "";

        switch (choose){
            case 0:
                code = cmpd_stat();
                break;
            case 1:
                code = if_stat();
                break;
            case 2:
                code = iter_stat();
                break;
            case 3:
                code = assgn_stat();
                break;
            case 4:
                code = decl_stat();
                break;
        }

        return code;
    }

    public static String cmpd_stat() {
    return "{\n\t" + stat_list() + "\n\t}";
    }

    public static String if_stat() {
        int choose = randomize.nextInt(6);
        String code = "";

        switch (choose){
            case 0:
                code = "if (" + exp() + ")\t" +  stat();
                break;
            case 1:
                code = "if (" + exp() + ")\t" +  cmpd_stat();
                break;
            case 2:
                code = "if (" + exp() + ")\t" +  stat() + "\t\n else " + stat();
                break;
            case 3:
                code = "if (" + exp() + ")\t" +  cmpd_stat() + "\t\n else " + stat();
                break;
            case 4:
                code = "if (" + exp() + ")\t" +  stat() + "\t\n else " + cmpd_stat();
                break;
            case 5:
                code = "if (" + exp() + ")\t" +  cmpd_stat() + "\t\n else " + cmpd_stat();
                break;
        }

        return code;
    }

    public static String iter_stat() {
        int choose = randomize.nextInt(2);
        String code = "";
        switch (choose){
            case 0:
                code = "\twhile (" + exp() +")\n\t"+ stat();
                break;
            case 1:
                code = "\twhile (" + exp() +")\n\t"+ cmpd_stat();
                break;
        }
        return code;
    }

    public static String assgn_stat() {
        return id() + " = " + exp() + ";";
    }

    public static String decl_stat() {
        int choose = randomize.nextInt(2);
        String code = "";
        switch (choose){
            case 0:
                code = type() + id() + ";";
                break;
            case 1:
                code = type() + assgn_stat();
                break;
        }
        return code;
    }

    public static String exp() {
        int choose = randomize.nextInt(3);
        String code = "";
        switch (choose){
            case 0:
                code = exp() + op() + exp();
                break;
            case 1:
                code = id();
                break;
            case 2:
                code = c_onst(); // const is a reserved work on Java
                break;
        }
        return code;
    }

    public static String op() {
        int choose = randomize.nextInt(4);
        String code = "";

        switch (choose){
            case 0:
                code = " + ";
                break;
            case 1:
                code = " - ";
                break;
            case 2:
                code = " * ";
                break;
            case 3:
                code = " / ";
                break;
        }

        return code;
    }

    public static String type() {
        int choose = randomize.nextInt(2);
        String code = "";
        switch (choose){
            case 0:
                code = "int ";
                break;
            case 1:
                code = "double ";
                break;
        }
        return code;
    }

    public static String id() {
        return c_har() + chardigit_seq();
    }

    public static String c_onst() {
        return digit() + digit_seq();
    }

    public static String chardigit_seq() {
        int choose = randomize.nextInt(3);
        String code = "";
        switch (choose){
            case 0:
                code = "";
                break;
            case 1:
                code = c_har() + chardigit_seq();
                break;
            case 2:
                code = digit() + chardigit_seq();
                break;
        }
        return code;
    }

    public static String digit_seq() {
        int choose = randomize.nextInt(2);
        String code = "";
        switch (choose){
            case 0:
                code = "";
                break;
            case 1:
                code = digit()+digit_seq();
                break;
        }
        return code;
    }

    public static String c_har() {
        int choose = randomize.nextInt(2);
        char [] uppercase = {'_','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char [] lowercase = {'_','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        String code = "";
        switch (choose){
            case 0:
                code = uppercase[randomize.nextInt(27)] + "";
                break;
            case 1:
                code = lowercase[randomize.nextInt(27)] + "";;
                break;
            }
        return code;
    }

    public static String digit() {
        return randomize.nextInt(10) + "";
    }

}
