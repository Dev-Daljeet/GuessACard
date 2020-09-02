package com.mycompany.guessacard;

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

/** Represents a layout pane which is part of User Interface.
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
public class LayoutPane {
    private BorderPane paneForHeader = new BorderPane();
    private BorderPane paneForInnerContent = new BorderPane();
    private BorderPane paneForBottom = new BorderPane();
    private BorderPane paneForLayout = new BorderPane();

    /** Gets the pane for Layout of User interface.
     * @return A BorderPane representing the pane for layout.
     */
    public BorderPane getPaneForLayout()
    {
        // Make a text object which acts as a heading.
        Text heading = new Text();
        heading.setText("Guess a card");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,25));

        // Make a rectangle object which acts as background for heading.
        Rectangle backgroundForHeading = new Rectangle();
        backgroundForHeading.setWidth(430);
        backgroundForHeading.setHeight(60);
        backgroundForHeading.setArcWidth(10);
        backgroundForHeading.setArcHeight(10);
        backgroundForHeading.setFill(Color.GREEN);

        // Make a StackPane object and add the text object (heading) and rectangle object (backgroundForHeading) in it.
        StackPane paneForHeading = new StackPane();
        paneForHeading.getChildren().addAll(backgroundForHeading,heading);
        paneForHeading.setPadding(new Insets(10,0,0,0));

        // Make two objects of Button for 'Play' and 'Reset'.
        Button btnForPlay = new Button();
        btnForPlay.setText("Play");
        btnForPlay.setPrefWidth(60);
        Button btnForReset = new Button();
        btnForReset.setText("Reset");
        btnForReset.setPrefWidth(60);

        // Make a HBox object and add both Button objects (btnForPlay and btnForReset) in it.
        HBox paneForButtons = new HBox();
        paneForButtons.getChildren().addAll(btnForPlay,btnForReset);
        paneForButtons.setSpacing(40);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setPadding(new Insets(15,0,0,0));

        // Add StackPane object (paneForHeading) and HBox object (paneForButtons) in BorderPane object (paneForHeader).
        paneForHeader.setTop(paneForHeading);
        paneForHeader.setCenter(paneForButtons);

        // Make a image object and four ImageView objects.
        Image imgOfCardBack = new Image("com/myCompany/guessacard/images/CLUBS/green_back.png");
        ImageView imgViewOfCard1 = new ImageView();
        ImageView imgViewOfCard2 = new ImageView();
        ImageView imgViewOfCard3 = new ImageView();
        ImageView imgViewOfCard4 = new ImageView();

        // Make a array of ImageView and set the image, width and height of each ImageView object.
        ImageView[] imgViewOfCards = {imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4};
        for (int i=0; i< imgViewOfCards.length;i++)
        {
            imgViewOfCards[i].setImage(imgOfCardBack);
            imgViewOfCards[i].setFitWidth(100);
            imgViewOfCards[i].setFitHeight(150);
        }

        // Make a HBox object and add all ImageView objects in it.
        HBox paneForImages = new HBox();
        paneForImages.getChildren().addAll(imgViewOfCard1,imgViewOfCard2,imgViewOfCard3,imgViewOfCard4);
        paneForImages.setSpacing(10);
        paneForImages.setAlignment(Pos.CENTER);
        paneForImages.setPadding(new Insets(15,0,0,0));

        // Make a label object which acts as an question in game.
        Label lbForQues = new Label("Guess the fourth card");
        lbForQues.setFont(Font.font("Helvetica",15));

        // Make four RadioButton objects and add them to array of RadioButton.
        RadioButton rdoBtnForOption1 = new RadioButton("Example of card 1");
        RadioButton rdoBtnForOption2 = new RadioButton("Example of card 2");
        RadioButton rdoBtnForOption3 = new RadioButton("Example of card 3");
        RadioButton rdoBtnForOption4 = new RadioButton("Example of card 4");
        RadioButton[] rdoBtnForOptions = {rdoBtnForOption1,rdoBtnForOption2,rdoBtnForOption3,rdoBtnForOption4};

        // Make a ToggleGroup object and set the ToggleGroup to each RadioButton objects.
        ToggleGroup group = new ToggleGroup();
        for (int i=0; i<rdoBtnForOptions.length; i++)
        {
            rdoBtnForOptions[i].setToggleGroup(group);
        }

        // Make a VBox object and add label object (lbForQues) and all RadioButton objects in it.
        VBox paneForLbAndRdoOptions = new VBox();
        paneForLbAndRdoOptions.getChildren().addAll(lbForQues,rdoBtnForOption1,rdoBtnForOption2,rdoBtnForOption3,rdoBtnForOption4);
        paneForLbAndRdoOptions.setSpacing(10);
        paneForLbAndRdoOptions.setAlignment(Pos.CENTER);
        paneForLbAndRdoOptions.setPadding(new Insets(0,0,12,0));

        // Add the HBox object (paneForImages) and Vbox object (paneForLbAndRdoOptions) in BorderPane object(paneForInnerContent).
        paneForInnerContent.setTop(paneForImages);
        paneForInnerContent.setCenter(paneForLbAndRdoOptions);

        // Make a Button object which acts as 'Confirm' button.
        Button btnForConfirm = new Button();
        btnForConfirm.setText("Confirm");

        // Make a StackPane object (paneForBtnConfirm) and add Button object (btnForConfirm) in it.
        StackPane paneForBtnConfirm = new StackPane(btnForConfirm);
        paneForBtnConfirm.setPadding(new Insets(0,0,10,0));

        // Make a TextArea object which will display the result.
        TextArea result = new TextArea();
        result.setEditable(false);
        result.setPrefHeight(70);
        result.setPadding(new Insets(6));
        result.setText("Result:");

        // Add the StackPane object (paneForBtnConfirm) and TextArea object (result) in BorderPane object (paneForBottom).
        paneForBottom.setTop(paneForBtnConfirm);
        paneForBottom.setCenter(result);

        // Add all BorderPane objects (paneForHeader, paneForInnerContent and paneForBottom) in BorderPane object (paneForLayout).
        paneForLayout.setTop(paneForHeader);
        paneForLayout.setCenter(paneForInnerContent);
        paneForLayout.setBottom(paneForBottom);

        Card[] cardHand = new Card[4];
        Random random = new Random();

        /* Make an action event handling/handler for Button object (btnForPlay). When this 'Play' Button is clicked, it will set
         * new cards, new options, change its own text to 'Play again', change its own width to 100 and reset the text of result.
         */
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
            result.setText("Result:");
        });

        /* Make an action event handling/handler for Button object (btnForReset). When this 'Reset' Button is clicked, it will set
         * the text of btnForPlay back to 'Play', change the width of btnForPlay to 60, set every cards to 'back card', reset the options
         * and reset the text of result.
         */
        btnForReset.setOnAction(e ->{
            btnForPlay.setText("Play");
            btnForPlay.setPrefWidth(60);
            result.setText("Result:");
            for (int i=0; i<imgViewOfCards.length;i++)
            {
                imgViewOfCards[i].setImage(imgOfCardBack);
            }
            for (int i=0; i< rdoBtnForOptions.length; i++)
            {
                rdoBtnForOptions[i].setText("Example of card option");
            }
        });

        /* Make an action event handling/handler for Button object (btnForConfirm). When this 'Confirm' Button is clicked,
           it will display the result in text area. */
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
                    result.setText("Result: You win! Your guess is right.");
                }
                else
                {
                    result.setText("Result: You lose! Your guess is wrong.");
                }

                imgViewOfCards[imgViewOfCards.length-1].setImage(new Image("com/myCompany/guessacard/images/" + cardHand[cardHand.length-1].getSuit() + "/" + cardHand[cardHand.length-1].getValue() + ".png"));
            }
            else
            {
                result.setText("Please select any one of above options.");
            }
        });
        return paneForLayout;
    }
}
