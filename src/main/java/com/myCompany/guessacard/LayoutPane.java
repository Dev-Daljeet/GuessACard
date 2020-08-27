package com.myCompany.guessacard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Daljeet Singh
 * @version 0.1
 */
public class LayoutPane {
    private BorderPane paneForHeader = new BorderPane();
    private BorderPane paneForInnerContent = new BorderPane();
    private BorderPane paneForBottom = new BorderPane();
    private BorderPane paneForLayout = new BorderPane();

    public BorderPane getPaneForLayout()
    {
        Text heading = new Text();
        heading.setText("Guess the card");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,25));

        Rectangle backgroundForHeading = new Rectangle();
        backgroundForHeading.setWidth(430);
        backgroundForHeading.setHeight(60);
        backgroundForHeading.setArcWidth(10);
        backgroundForHeading.setArcHeight(10);
        backgroundForHeading.setFill(Color.GREEN);

        StackPane paneForHeading = new StackPane();
        paneForHeading.getChildren().addAll(backgroundForHeading,heading);
        paneForHeading.setPadding(new Insets(10,0,0,0));

        Button btnForPlay = new Button();
        btnForPlay.setText("Play");
        btnForPlay.setPrefWidth(60);
        Button btnForReset = new Button();
        btnForReset.setText("Reset");
        btnForReset.setPrefWidth(60);

        HBox paneForButtons = new HBox();
        paneForButtons.getChildren().addAll(btnForPlay,btnForReset);
        paneForButtons.setSpacing(40);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(15,0,0,0));

        paneForHeader.setTop(paneForHeading);
        paneForHeader.setCenter(paneForButtons);

        Image imgOfCard1 = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard1 = new ImageView(imgOfCard1);
        imgViewOfCard1.setFitWidth(100);
        imgViewOfCard1.setFitHeight(150);
        Image imgOfCard2 = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard2 = new ImageView(imgOfCard2);
        imgViewOfCard2.setFitWidth(100);
        imgViewOfCard2.setFitHeight(150);
        Image imgOfCard3 = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard3 = new ImageView(imgOfCard3);
        imgViewOfCard3.setFitWidth(100);
        imgViewOfCard3.setFitHeight(150);
        Image imgOfCard4 = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard4 = new ImageView(imgOfCard4);
        imgViewOfCard4.setFitWidth(100);
        imgViewOfCard4.setFitHeight(150);
        ImageView[] imgViewOfCards = {imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4};

        HBox paneForImages = new HBox();
        paneForImages.getChildren().addAll(imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4);
        paneForImages.setSpacing(10);
        paneForImages.setAlignment(Pos.CENTER);
        paneForImages.setPadding(new Insets(15,0,0,0));
        
        Label lbForQues = new Label("Guess the forth card");
        lbForQues.setFont(Font.font("Helvetica",15));

        RadioButton rdoBtnForOption1 = new RadioButton("Example card 1");
        RadioButton rdoBtnForOption2 = new RadioButton("Example card 2");
        RadioButton rdoBtnForOption3 = new RadioButton("Example card 3");
        RadioButton rdoBtnForOption4 = new RadioButton("Example card 4");
        RadioButton[] rdoBtnForOptions = {rdoBtnForOption1,rdoBtnForOption2,rdoBtnForOption3,rdoBtnForOption4};

        ToggleGroup group = new ToggleGroup();
        rdoBtnForOption1.setToggleGroup(group);
        rdoBtnForOption2.setToggleGroup(group);
        rdoBtnForOption3.setToggleGroup(group);
        rdoBtnForOption4.setToggleGroup(group);

        VBox paneForLbAndRdoOptions = new VBox();
        paneForLbAndRdoOptions.getChildren().addAll(lbForQues,rdoBtnForOption1,rdoBtnForOption2,rdoBtnForOption3,rdoBtnForOption4);
        paneForLbAndRdoOptions.setSpacing(10);
        paneForLbAndRdoOptions.setAlignment(Pos.CENTER);
        paneForLbAndRdoOptions.setPadding(new Insets(0,0,12,0));

        paneForInnerContent.setTop(paneForImages);
        paneForInnerContent.setCenter(paneForLbAndRdoOptions);

        Button btnForConfirm = new Button();
        btnForConfirm.setText("Confirm");

        Pane paneForBtnConfirm = new StackPane(btnForConfirm);
        paneForBtnConfirm.setPadding(new Insets(0,0,10,0));

        TextArea result = new TextArea();
        result.setEditable(false);
        result.setPrefHeight(70);
        result.setPadding(new Insets(6));
        result.setText("Result:");

        paneForBottom.setTop(paneForBtnConfirm);
        paneForBottom.setCenter(result);

        paneForLayout.setTop(paneForHeader);
        paneForLayout.setCenter(paneForInnerContent);
        paneForLayout.setBottom(paneForBottom);

        Card[] cardHand = new Card[4];
        int[] options = {0,1,2,3};
        Random random = new Random();

        btnForPlay.setOnAction(e ->{
            for(int i=0; i<cardHand.length; i++)
            {
                Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
                Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
                Card card = new Card(value, suit);
                cardHand[i] = card;
                if(i != 3) {
                    imgViewOfCards[i].setImage(new Image("com/myCompany/guessacard/images/" + cardHand[i].getSuit() + "/" + cardHand[i].getValue() + ".png"));
                }
            }
            Collections.shuffle(Arrays.asList(rdoBtnForOptions));
            for(int i=0; i<cardHand.length; i++)
            {
                Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
                Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
                Card card = new Card(value, suit);
                if(i != 3) {
                    rdoBtnForOptions[i].setText(card.getValue()+" of "+card.getSuit());
                }
                else
                {
                    rdoBtnForOptions[i].setText(cardHand[i].getValue()+" of "+cardHand[i].getSuit());
                }
            }
        });



        return paneForLayout;
    }
}
