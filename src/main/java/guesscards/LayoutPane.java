package java.guesscards;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Daljeet Singh
 * @version 0.1
 */
public class LayoutPane {
    private BorderPane paneForHeader = new BorderPane();
    private BorderPane paneForInnerContent = new BorderPane();
    private StackPane paneForBottom = new StackPane();
    private BorderPane paneForLayout = new BorderPane();

    public BorderPane getPaneForLayout()
    {
        Text heading = new Text();
        heading.setText("Guess the card");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,18));

        Rectangle backgroundForHeading = new Rectangle();
        backgroundForHeading.setWidth(380);
        backgroundForHeading.setHeight(40);
        backgroundForHeading.setArcWidth(10);
        backgroundForHeading.setArcHeight(10);
        backgroundForHeading.setFill(Color.GREEN);

        StackPane paneForHeading = new StackPane();
        paneForHeading.getChildren().addAll(backgroundForHeading,heading);

        Button btnForPlay = new Button();
        btnForPlay.setText("Play");
        Button btnForReset = new Button();
        btnForReset.setText("Reset");

        HBox paneForButtons = new HBox();
        paneForButtons.getChildren().addAll(btnForPlay,btnForReset);
        paneForButtons.setSpacing(20);
        paneForButtons.setAlignment(Pos.CENTER);

        paneForHeader.setTop(paneForHeading);
        paneForHeader.setCenter(paneForButtons);

        Image imgOfCard1 = new Image("images\\PNG\\red_back.png");
        ImageView imgViewOfCard1 = new ImageView(imgOfCard1);
        Image imgOfCard2 = new Image("images\\PNG\\red_back.png");
        ImageView imgViewOfCard2 = new ImageView(imgOfCard2);
        Image imgOfCard3 = new Image("images\\PNG\\red_back.png");
        ImageView imgViewOfCard3 = new ImageView(imgOfCard3);
        Image imgOfCard4 = new Image("images\\PNG\\red_back.png");
        ImageView imgViewOfCard4 = new ImageView(imgOfCard4);

        HBox paneForImages = new HBox();
        paneForImages.getChildren().addAll(imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4);
        paneForImages.setSpacing(8);
        paneForImages.setAlignment(Pos.CENTER);

        RadioButton rdoBtnForOption1 = new RadioButton("Example card 1");
        RadioButton rdoBtnForOption2 = new RadioButton("Example card 2");
        RadioButton rdoBtnForOption3 = new RadioButton("Example card 3");
        RadioButton rdoBtnForOption4 = new RadioButton("Example card 4");

        ToggleGroup group = new ToggleGroup();
        rdoBtnForOption1.setToggleGroup(group);
        rdoBtnForOption2.setToggleGroup(group);
        rdoBtnForOption3.setToggleGroup(group);
        rdoBtnForOption4.setToggleGroup(group);

        VBox paneForRdoOptions = new VBox();
        paneForRdoOptions.getChildren().addAll(rdoBtnForOption1,rdoBtnForOption2,rdoBtnForOption3,rdoBtnForOption4);
        paneForRdoOptions.setSpacing(5);
        paneForRdoOptions.setAlignment(Pos.CENTER);

        paneForInnerContent.setCenter(paneForImages);
        paneForInnerContent.setBottom(paneForRdoOptions);

        TextArea result = new TextArea();
        result.setEditable(false);
        result.setPrefWidth(350);
        result.setPrefHeight(50);
        result.setPadding(new Insets(0,0,10,0));

        paneForBottom.getChildren().add(result);

        paneForLayout.setTop(paneForHeader);
        paneForLayout.setCenter(paneForInnerContent);
        paneForLayout.setBottom(paneForBottom);

        return paneForLayout;
    }
}
