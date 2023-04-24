
/*Simple Calculator app using Javax-GUI
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;


class MyGUI implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[11]; //to display
    JButton[] functionButtons = new JButton[9];//to add functionalty with ActionListener
    JButton addButton,subButton,mulButton,divButton,negButton;
    
    JButton decButton,equButton,delButton,clrButton;
    
    JPanel panel;
    Font font = new Font("Ink Free",Font.BOLD,20);
    double num1=0,num2=0,res=0;
    char operator;

    MyGUI(){
        setFrame();
        setTextField();
        setPanel();
    }

    public void setFrame(){
        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setBackground(Color.CYAN);
        
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setEditable(false);
    
        frame.setVisible(true);
      }
      
      public void Buttons(){
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        

        //declaring functionality buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        
        


        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);

        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        negButton.setBounds(50,430,100,50);
      }

      public void setTextField(){
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setEditable(false);
        
        Buttons();

        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);

        frame.setVisible(true);
      }
      public void setPanel(){
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.lightGray);

        //1st Row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        //2nd row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        //3rd row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(decButton);

        //bottom row
        panel.add(numberButtons[0]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(equButton);
    

        frame.add(panel);
      }
      
      
      public void actionPerformed(ActionEvent e){
        
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //setting decimal button
        if(e.getSource()==decButton){ 
            textField.setText(textField.getText().concat("."));
        }
        //setting adding button
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        //setting subtraction buton
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        //setting multiply button
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        //setting divide button
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //setting equal button
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator)
            {
                case'+':
                res = num1 + num2;
                break;

                case'-':
                res = num1 - num2;
                break;

                case'*':
                res = num1 * num2;
                break;

                case'/':
                res = num1 / num2;
                break;
            }
            textField.setText(String.valueOf(res));
            num1 = res; //to continue if we want to use same value
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String temp = textField.getText(); 
            textField.setText("");
            for(int i=0;i<temp.length()-1;i++) 
            {
              textField.setText(textField.getText()+temp.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(textField.getText());
            //flip the sing of the number
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        
      }
}


public class Calculator{
    public static void main(String[] args){

       new MyGUI();
    }
}
