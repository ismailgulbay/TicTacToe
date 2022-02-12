package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel buttons_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    JLabel text = new JLabel();
    boolean player1turn;



    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());

        text.setText("Tic-Tac-Toe");
        text.setFont(new Font("Ink Free",Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setBackground(new Color(25,25,25));
        text.setForeground(new Color(25,255,0));
        text.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(25,25,25));
        panel.setBounds(0,0,800,100);

        buttons_panel.setLayout(new GridLayout(3,3));
        buttons_panel.setBackground(new Color(150,150,150));

        for(int i = 0 ; i < 9 ; i++){
            buttons[i] = new JButton();
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }



        panel.add(text);
        frame.add(panel,BorderLayout.NORTH);
        frame.add(buttons_panel,BorderLayout.CENTER);

        firstTurn();



        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<9 ; i++){
            if(e.getSource() == buttons[i]){
                if(player1turn){
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1turn = !player1turn;
                        text.setText("O turn");
                        checkWon();
                    }
                }else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1turn = !player1turn;
                        text.setText("X turn");
                        checkWon();
                    }

                }
            }




        }
    }

    public void firstTurn(){
        player1turn = random.nextBoolean();
        if (player1turn) text.setText("X turn");
        else text.setText("O turn");



    }

    public void checkWon(){
        if(buttons[0].getText()==buttons[1].getText() && buttons[1].getText()==buttons[2].getText() && buttons[0].getText() !=""){
            if(buttons[0].getText() == "X") xWins(0,1,2);
            else oWins(0,1,2);
        }if(buttons[3].getText()==buttons[4].getText() && buttons[4].getText()==buttons[5].getText() && buttons[3].getText() !=""){
            if(buttons[3].getText() == "X") xWins(3,4,5);
            else oWins(3,4,5);
        }if(buttons[6].getText()==buttons[7].getText() && buttons[7].getText()==buttons[8].getText() && buttons[8].getText() !=""){
            if(buttons[6].getText() == "X") xWins(6,7,8);
            else oWins(6,7,8);
        }if(buttons[0].getText()==buttons[3].getText() && buttons[3].getText()==buttons[6].getText() && buttons[6].getText() !=""){
            if(buttons[0].getText() == "X") xWins(0,3,6);
            else oWins(0,3,6);
        }if(buttons[1].getText()==buttons[4].getText() && buttons[4].getText()==buttons[7].getText() && buttons[7].getText() !=""){
            if(buttons[1].getText() == "X") xWins(1,4,7);
            else oWins(1,4,7);
        }if(buttons[2].getText()==buttons[5].getText() && buttons[5].getText()==buttons[8].getText() && buttons[8].getText() !=""){
            if(buttons[2].getText() == "X") xWins(2,5,8);
            else oWins(2,5,8);
        }if(buttons[0].getText()==buttons[4].getText() && buttons[4].getText()==buttons[8].getText() && buttons[8].getText() !=""){
            if(buttons[0].getText() == "X") xWins(0,4,8);
            else oWins(0,4,8);
        }if(buttons[2].getText()==buttons[4].getText() && buttons[4].getText()==buttons[6].getText() && buttons[6].getText() !=""){
            if(buttons[2].getText() == "X") xWins(2,4,6);
            else oWins(2,4,6);
        }



    }
    public void xWins(int a,int b, int c){
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X won!");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    }

    public void oWins(int a,int b, int c){
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O won!");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    }
}
