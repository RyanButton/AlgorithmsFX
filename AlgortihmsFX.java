/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algortihmsfx;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ryan
 */
public class AlgortihmsFX extends Application {
    
    Stage window;
    Scene menuScene, selectSortScene, mergeSortScene, bubbleSortScene,
            recursiveBubbleSortScene, heapSortScene, timSortScene, binarySearchScene,
            linearSearchScene, jumpSearchScene, interSearchScene, exponentialSearchScene,
            sublistSearchScene, fiboSearchScene;
    final int WIDTH = 500, HEIGHT = 400;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = { 1,4,6,8,10,12,16,18,20,33 };
        int result = Algorithms.interpolationSearch(arr,12);
        System.out.println(result);
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        /* Main screen layouts */
        
        /* 
            Sorting algorithms layout 
        */
        Label sortingLabel = new Label("Sorting");
        Button selectSortBtn = new Button("Selection sort");
        Button mergeSortBtn = new Button("Merge sort");
        Button bubbleSortBtn = new Button("Bubble sort");
        Button recursiveBubbleSortBtn = new Button("Recursive bubble sort");
        //Button heapSortBtn = new Button("Heap sort");
        //Button timSortBtn = new Button("Tim sort");
        selectSortBtn.setOnAction( e -> window.setScene(selectSortScene) );
        mergeSortBtn.setOnAction( e -> window.setScene(mergeSortScene) );
        bubbleSortBtn.setOnAction( e -> window.setScene(bubbleSortScene) );
        recursiveBubbleSortBtn.setOnAction( e -> window.setScene(recursiveBubbleSortScene) );
        //heapSortBtn.setOnAction( e -> window.setScene(heapSortScene) );
        //timSortBtn.setOnAction( e -> window.setScene(timSortScene) );
        
        VBox sortingLayout = new VBox(10);
        sortingLayout.getChildren().addAll(sortingLabel, selectSortBtn, mergeSortBtn,
            bubbleSortBtn, recursiveBubbleSortBtn);
        
        /*
            Searching algorithms layout
        */
        // Buttons and labels
        Label searchingLabel = new Label("Searching");
        Button linearSearchBtn = new Button("Linear search");
        Button binarySearchBtn = new Button("Binary search");
        Button jumpSearchBtn = new Button("Jump search");
        Button interSearchBtn = new Button("Interpolation search");
        //Button sublistSearchBtn = new Button("Sublist search");
        //Button fiboSearchBtn = new Button("Fibonacci search");
        linearSearchBtn.setOnAction( e -> window.setScene(linearSearchScene) );
        binarySearchBtn.setOnAction( e -> window.setScene(binarySearchScene) );
        jumpSearchBtn.setOnAction( e -> window.setScene(jumpSearchScene) );
        interSearchBtn.setOnAction( e -> window.setScene(interSearchScene) );
        //sublistSearchBtn.setOnAction( e -> window.setScene(sublistSearchScene) );
        //fiboSearchBtn.setOnAction( e -> window.setScene(fiboSearchScene) );
        
        
        VBox searchingLayout = new VBox(10);
        searchingLayout.getChildren().addAll(searchingLabel, linearSearchBtn, 
                binarySearchBtn, jumpSearchBtn, interSearchBtn);
        
        // Main screen Layout
        HBox layout = new HBox(40);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(sortingLayout, searchingLayout);
        
        /*
            Internal layouts
        */
        
        // ---- Sorting Algorithms ----
        
        // Select sort layout
        Label selectSortLabel = new Label("Select sort");
        Label output = new Label();
        
        Text inputPrompt = new Text("Enter a list of integers seperated by spaces:");
        TextField inputText = new TextField();
        Button submitBtn = new Button("Submit");
        Button backBtnSelect = new Button("Back");
        backBtnSelect.setOnAction( e -> window.setScene(menuScene) );
        
        submitBtn.setOnAction(e -> {
            if( validateArray(inputText.getText()) ) {
                int[] arr = parseArray(inputText.getText());
                
                double startTime = System.nanoTime();
                int[] sortedArr = Algorithms.selectionSort(arr);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                output.setText("Sorted Array: " + Arrays.toString(sortedArr) + 
                        "\nExecuted in " + elapsedTime + " microseconds. ");
                
            } else {
                output.setText("Invalid input. Please try again");
            }
        });
        
        VBox selectSortLayout = new VBox(10);
        selectSortLayout.setPadding(new Insets(20,20,20,20));
        selectSortLayout.getChildren().addAll(selectSortLabel, inputPrompt, inputText,
                submitBtn, output, backBtnSelect);
        
        /* 
            Merge sort layout
        */
        Label mergeSortLabel = new Label("Merge sort");
        Button backBtnMerge = new Button("Back");
        Label outputMerge = new Label();
        Text inputPromptMerge = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextMerge = new TextField();
        backBtnMerge.setOnAction( e -> window.setScene(menuScene) );
        
        Button submitBtnMerge = new Button("Submit");
        submitBtnMerge.setOnAction(e -> {
            if( validateArray(inputTextMerge.getText()) ) {
                int[] arr = parseArray(inputTextMerge.getText());
                
                double startTime = System.nanoTime();
                int[] sortedArr = Algorithms.mergeSort(arr, 0, arr.length-1);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                outputMerge.setText("Sorted Array: " + Arrays.toString(sortedArr) + 
                        "\nExecuted in " + elapsedTime + " microseconds. ");
                
            } else {
                outputMerge.setText("Invalid input. Please try again");
            }
        });
        
        // Layout
        VBox mergeSortLayout = new VBox(10);
        mergeSortLayout.setPadding(new Insets(20,20,20,20));
        mergeSortLayout.getChildren().addAll(mergeSortLabel, inputPromptMerge, 
                inputTextMerge, submitBtnMerge, outputMerge, backBtnMerge);
        
        /*
            Bubble sort layout
        */
        Label bubbleSortLabel = new Label("Bubble sort");
        Label outputBubble = new Label();
        Text inputPromptBubble = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextBubble = new TextField();
        Button backBtnBubble = new Button("Back");
        backBtnBubble.setOnAction( e -> window.setScene(menuScene) );
        
        Button submitBtnBubble = new Button("Submit");
        submitBtnBubble.setOnAction(e -> {
            if( validateArray(inputTextBubble.getText()) ) {
                int[] arr = parseArray(inputTextBubble.getText());
                
                double startTime = System.nanoTime();
                int[] sortedArr = Algorithms.bubbleSort(arr);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                outputBubble.setText("Sorted Array: " + Arrays.toString(sortedArr) + 
                        "\nExecuted in " + elapsedTime + " microseconds. ");
                
            } else {
                outputBubble.setText("Invalid input. Please try again");
            }
        });
        
        // Layout
        VBox bubbleSortLayout = new VBox(10);
        bubbleSortLayout.setPadding(new Insets(20,20,20,20));
        bubbleSortLayout.getChildren().addAll(bubbleSortLabel, inputPromptBubble, 
                inputTextBubble, submitBtnBubble, outputBubble, backBtnBubble);
        
        /* 
            Recursive bubble sort 
        */
        Label recurBubbleSortLabel = new Label("Recursive bubble sort");
        Label outputRecurBubble = new Label();
        Text inputPromptRecurBubble = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextRecurBubble = new TextField();
        Button backBtnRecurBubble = new Button("Back");
        backBtnRecurBubble.setOnAction( e -> window.setScene(menuScene) );
        
        Button submitBtnRecurBubble = new Button("Submit");
        submitBtnRecurBubble.setOnAction(e -> {
            if( validateArray(inputTextRecurBubble.getText()) ) {
                int[] arr = parseArray(inputTextRecurBubble.getText());
                
                double startTime = System.nanoTime();
                int[] sortedArr = Algorithms.recursiveBubbleSort(arr, arr.length);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                outputRecurBubble.setText("Sorted Array: " + Arrays.toString(sortedArr) + 
                        "\nExecuted in " + elapsedTime + " microseconds. ");
                
            } else {
                outputRecurBubble.setText("Invalid input. Please try again");
            }
        });
        
        // Layout
        VBox recurBubbleSortLayout = new VBox(10);
        recurBubbleSortLayout.setPadding(new Insets(20,20,20,20));
        recurBubbleSortLayout.getChildren().addAll(recurBubbleSortLabel, inputPromptRecurBubble, 
                inputTextRecurBubble, submitBtnRecurBubble, outputRecurBubble, backBtnRecurBubble);
        
        // ---- Searching Algorithms ----
        
        /* 
            Linear search layout 
        */
        Label labelLS =  new Label("Linear search");
        Label outputLS = new Label();
        
        Text inputPromptLS = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextLS = new TextField();
        Button submitBtnLS = new Button("Submit");
        AlertBox alertBoxLS = new AlertBox();
        Button backBtnLS = new Button("Back");
        backBtnLS.setOnAction( e -> window.setScene(menuScene) );
        
        submitBtnLS.setOnAction( e -> {
            if( validateArray(inputTextLS.getText()) ) {
                alertBoxLS.display("Algorithms", "Enter a target element");
                TextField targetTextLS = alertBoxLS.getTarget();
                int target = Integer.parseInt(targetTextLS.getText());
                
                int[] arr = parseArray(inputTextLS.getText());
                
                double startTime = System.nanoTime();
                int index = Algorithms.linearSearch(arr, target, 0, arr.length);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                if(index != -1)
                    outputLS.setText("Target '" + targetTextLS.getText() + "' found at index: " + index 
                    + " in " + elapsedTime + " microseconds.");
                else
                    outputLS.setText("Target not found.");
                
            } else {
                outputLS.setText("Invalid input. Please try again");
            }
        });
        
        VBox linearSearchLayout = new VBox(10);
        linearSearchLayout.setPadding(new Insets(20,20,20,20));
        linearSearchLayout.getChildren().addAll(labelLS, inputPromptLS, inputTextLS,
                submitBtnLS, outputLS, backBtnLS);
        
        /* 
            Binary search layout 
        */
        Label labelBS = new Label("Binary search");
        Label outputBS = new Label();
        
        Text inputPromptBS = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextBS = new TextField();
        Button submitBtnBS = new Button("Submit");
        AlertBox alertBoxBS = new AlertBox();
        Button backBtnBS = new Button("Back");
        backBtnBS.setOnAction( e -> window.setScene(menuScene) );
        
        submitBtnBS.setOnAction(e -> {
            if( validateArray(inputTextBS.getText()) ) {
                alertBoxBS.display("Algorithms", "Enter a target element");
                TextField targetTextBS = alertBoxBS.getTarget();
                int target = Integer.parseInt(targetTextBS.getText());
                
                int[] arr = parseArray(inputTextBS.getText());
                arr = Algorithms.selectionSort(arr);
                
                double startTime = System.nanoTime();
                int index = Algorithms.binarySearch(arr, target, 0, arr.length-1);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                if(index != -1)
                    outputBS.setText("Sorted Array: " + Arrays.toString(arr) + "\nTarget '" + targetTextBS.getText() + "' found at index: " + index 
                    + " in " + elapsedTime + " microseconds.");
                else
                    outputBS.setText("Target not found.");
                
            } else {
                outputBS.setText("Invalid input. Please try again");
            }
        });
        
        VBox binarySearchLayout = new VBox(10);
        binarySearchLayout.setPadding(new Insets(20,20,20,20));
        binarySearchLayout.getChildren().addAll(labelBS, inputPromptBS, inputTextBS,
                submitBtnBS, outputBS, backBtnBS);
        
        /* 
            Jump search layout 
        */
        Label labelJump = new Label("Jump search");
        Label outputJump = new Label();
        
        Text inputPromptJump = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextJump = new TextField();
        Button submitBtnJump = new Button("Submit");
        AlertBox alertBoxJump = new AlertBox();
        Button backBtnJump = new Button("Back");
        backBtnJump.setOnAction( e -> window.setScene(menuScene) );
        
        submitBtnJump.setOnAction(e -> {
            if( validateArray(inputTextJump.getText()) ) {
                alertBoxJump.display("Algorithms", "Enter a target element");
                TextField targetTextJump = alertBoxJump.getTarget();
                int target = Integer.parseInt(targetTextJump.getText());
                
                int[] arr = parseArray(inputTextJump.getText());
                arr = Algorithms.mergeSort(arr, 0, arr.length-1);
                
                double startTime = System.nanoTime();
                int index = Algorithms.jumpSearch(arr, target);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                if(index != -1)
                    outputJump.setText("Sorted Array: " + Arrays.toString(arr) + "\nTarget '" + targetTextJump.getText() + "' found at index: " + index 
                    + " in " + elapsedTime + " microseconds.");
                else
                    outputJump.setText("Target not found.");
                
            } else {
                outputJump.setText("Invalid input. Please try again");
            }
        });
        
        VBox jumpSearchLayout = new VBox(10);
        jumpSearchLayout.setPadding(new Insets(20,20,20,20));
        jumpSearchLayout.getChildren().addAll(labelJump, inputPromptJump, inputTextJump,
                submitBtnJump, outputJump, backBtnJump);
        
        /* 
            Interpolation search 
        */
        Label labelIS = new Label("Binary search");
        Label outputIS = new Label();
        
        Text inputPromptIS = new Text("Enter a list of integers seperated by spaces:");
        TextField inputTextIS = new TextField();
        Button submitBtnIS = new Button("Submit");
        AlertBox alertBoxIS = new AlertBox();
        Button backBtnIS = new Button("Back");
        backBtnIS.setOnAction( e -> window.setScene(menuScene) );
        
        submitBtnIS.setOnAction(e -> {
            if( validateArray(inputTextIS.getText()) ) {
                alertBoxIS.display("Algorithms", "Enter a target element");
                TextField targetTextIS = alertBoxIS.getTarget();
                int target = Integer.parseInt(targetTextIS.getText());
                
                int[] arr = parseArray(inputTextIS.getText());
                arr = Algorithms.selectionSort(arr);
                
                double startTime = System.nanoTime();
                int index = Algorithms.interpolationSearch(arr, target);
                double endTime = System.nanoTime();
                double elapsedTime = (endTime - startTime)/1000;
                
                if(index != -1)
                    outputIS.setText("Sorted Array: " + Arrays.toString(arr) + "\nTarget '" + targetTextIS.getText() + "' found at index: " + index 
                    + " in " + elapsedTime + " microseconds.");
                else
                    outputIS.setText("Target not found.");
                
            } else {
                outputIS.setText("Invalid input. Please try again");
            }
        });
        
        VBox interSearchLayout = new VBox(10);
        interSearchLayout.setPadding(new Insets(20,20,20,20));
        interSearchLayout.getChildren().addAll(labelIS, inputPromptIS, inputTextIS,
                submitBtnIS, outputIS, backBtnIS);
        
        // Scenes
        menuScene = new Scene(layout, WIDTH, HEIGHT);
        selectSortScene = new Scene(selectSortLayout, WIDTH, HEIGHT);
        mergeSortScene = new Scene(mergeSortLayout, WIDTH, HEIGHT);
        bubbleSortScene =  new Scene(bubbleSortLayout, WIDTH, HEIGHT);
        linearSearchScene = new Scene(linearSearchLayout, WIDTH, HEIGHT);
        binarySearchScene = new Scene(binarySearchLayout, WIDTH, HEIGHT);
        jumpSearchScene = new Scene(jumpSearchLayout, WIDTH, HEIGHT);
        recursiveBubbleSortScene = new Scene(recurBubbleSortLayout, WIDTH, HEIGHT);
        interSearchScene = new Scene(interSearchLayout, WIDTH, HEIGHT);
                
        window.setTitle("Algorithms");
        window.setScene(menuScene);
        window.show();
    }
    
    private boolean validateArray(String input) {
        boolean errorCaught = false;
        String[] tempArray;
        String delimiter = " ";
        tempArray = input.split(delimiter);
        
        int[] resultArray = new int[tempArray.length];
 
         /* print substrings */
        for (int i = 0; i < tempArray.length; i++) {
            try {
                resultArray[i] = Integer.parseInt(tempArray[i]);
            } catch(NumberFormatException e) {
                errorCaught = true;
            }
            
        }
        
        return !errorCaught;
    }
    private int[] parseArray(String input) {
        String[] tempArray;
        String delimiter = " ";
        tempArray = input.split(delimiter);
        
        int[] resultArray = new int[tempArray.length];
 
         /* print substrings */
        for (int i = 0; i < tempArray.length; i++)
            resultArray[i] = Integer.parseInt(tempArray[i]);
        
        return resultArray;
    }
}
