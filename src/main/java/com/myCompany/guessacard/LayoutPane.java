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

        Image imgOfCardBack = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard1 = new ImageView(imgOfCardBack);
        ImageView imgViewOfCard2 = new ImageView(imgOfCardBack);
        ImageView imgViewOfCard3 = new ImageView(imgOfCardBack);
        ImageView imgViewOfCard4 = new ImageView(imgOfCardBack);
        ImageView[] imgViewOfCards = {imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4};
        for (int i=0; i< imgViewOfCards.length;i++)
        {
            imgViewOfCards[i].setFitWidth(100);
            imgViewOfCards[i].setFitHeight(150);
        }

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
        for (int i=0; i<rdoBtnForOptions.length; i++)
        {
            rdoBtnForOptions[i].setToggleGroup(group);
        }

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
        Random random = new Random();

        btnForPlay.setOnAction(e ->{
            for(int i=0; i<cardHand.length; i++)
            {
                Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
                Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
                Card card = new Card(value, suit);
                cardHand[i] = card;
                if(i != cardHand.length-1) {
                    imgViewOfCards[i].setImage(new Image("com/myCompany/guessacard/images/" + cardHand[i].getSuit() + "/" + cardHand[i].getValue() + ".png"));
                }
            }
            Collections.shuffle(Arrays.asList(rdoBtnForOptions));
            for(int i=0; i<rdoBtnForOptions.length; i++)
            {
                Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
                Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
                Card card = new Card(value, suit);
                if(i != rdoBtnForOptions.length-1) {
                    rdoBtnForOptions[i].setText(card.getValue()+" of "+card.getSuit());
                }
                else
                {
                    rdoBtnForOptions[i].setText(cardHand[cardHand.length-1].getValue()+" of "+cardHand[cardHand.length-1].getSuit());
                }
            }
            btnForPlay.setText("Play again");
            btnForPlay.setPrefWidth(100);
            imgViewOfCards[imgViewOfCards.length-1].setImage(imgOfCardBack);
        });

        btnForReset.setOnAction(e ->{
            btnForPlay.setText("Play");
            btnForPlay.setPrefWidth(60);
            result.setText("Result:");
            for (int i=0; i<imgViewOfCards.length;i++)
            {
                imgViewOfCards[i].setImage(imgOfCardBack);
                imgViewOfCards[i].setFitWidth(100);
                imgViewOfCards[i].setFitHeight(150);
            }
            for (int i=0; i< rdoBtnForOptions.length; i++)
            {
                rdoBtnForOptions[i].setText("Card example");
            }
        });

        btnForConfirm.setOnAction(e -> {
            boolean checkWin = false;
            if(rdoBtnForOption1.isSelected() || rdoBtnForOption2.isSelected() || rdoBtnForOption3.isSelected() || rdoBtnForOption4.isSelected())
            {
                if (rdoBtnForOption1.isSelected() && rdoBtnForOption1.getText().equals(cardHand[cardHand.length-1].getValue()+" of "+cardHand[cardHand.length-1].getSuit()))
                {
                    checkWin = true;
                }
                else if (rdoBtnForOption2.isSelected() && rdoBtnForOption2.getText().equals(cardHand[cardHand.length-1].getValue()+" of "+cardHand[cardHand.length-1].getSuit()))
                {
                    checkWin = true;
                }
                else if (rdoBtnForOption3.isSelected() && rdoBtnForOption3.getText().equals(cardHand[cardHand.length-1].getValue()+" of "+cardHand[cardHand.length-1].getSuit()))
                {
                    checkWin = true;
                }
                else if (rdoBtnForOption4.isSelected() && rdoBtnForOption4.getText().equals(cardHand[cardHand.length-1].getValue()+" of "+cardHand[cardHand.length-1].getSuit()))
                {
                    checkWin = true;
                }

                if ( checkWin == true)
                {
                    result.setText("Result: You won!");
                    imgViewOfCards[imgViewOfCards.length-1].setImage(new Image("com/myCompany/guessacard/images/" + cardHand[cardHand.length-1].getSuit() + "/" + cardHand[cardHand.length-1].getValue() + ".png"));
                }
                else
                {
                    result.setText("Result: You lose!");
                    imgViewOfCards[imgViewOfCards.length-1].setImage(new Image("com/myCompany/guessacard/images/" + cardHand[cardHand.length-1].getSuit() + "/" + cardHand[cardHand.length-1].getValue() + ".png"));
                }
            }
            else
            {
                result.setText("Please select any one of above choices.");
            }
        });
        return paneForLayout;
    }
}
