import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui 
{
    //all of our swing objects
    JFrame window;
    JTextField inputTextField;
    JLabel outputLabel;
    JLabel imageLabel;
    JButton runButton;
    JButton imageButton;
    JButton leftMove;
    JButton rightMove;
    JButton upMove;
    JButton downMove;

    //Icon Construction
    Icon image1 = new ImageIcon(this.getClass().getResource("images/02-1.gif"));
    Icon image2 = new ImageIcon(this.getClass().getResource("images/02-1.gif"));
    int xPos; 
    int yPos;

    //constructor
    gui()
    {
        xPos = 500;
        yPos = 500;
        Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\CJ\\Pictures\\2017-07\\IMG_0085.JPG");
        
        //JFrame Construction
            window = new JFrame("Swinging Around");
            window.setSize(1000, 1000);
            window.setVisible(true);
            window.setIconImage(img);
        
        //JTextField Construction
            inputTextField = new JTextField();
            inputTextField.setBounds(50, 50, 150, 20);
            inputTextField.setVisible(true);

        //JLabel Construction
            outputLabel = new JLabel("Label");
            outputLabel.setBounds(50, 100, 250, 20);
            outputLabel.setVisible(true);

            //image label to display our image on the screen
            imageLabel = new JLabel(image1);
            imageLabel.setBounds(xPos, yPos, 250, 250);
            imageLabel.setVisible(true);
            

            
        //JButton Construction
            runButton = new JButton("Find IP");
            runButton.setBounds(50, 150, 95, 30);
            runButton.setMnemonic('c');
            runButton.setVisible(true);
            simpleListener ourListener = new simpleListener();
            runButton.addActionListener(ourListener);
           
            
            //image Button things
            imageButton = new JButton("Images");
            imageButton.setBounds(150, 150, 95, 30);
            imageButton.setVisible(true);
            imageButton.addActionListener(ourListener);
             
            //right move button
            rightMove = new JButton(">");
            rightMove.setBounds(140,55,50,50);
            rightMove.setVisible(true);
            rightMove.addActionListener(ourListener);
            rightMove.setMnemonic(KeyEvent.VK_RIGHT);

            //left move button
            leftMove = new JButton("<");
            leftMove.setBounds(30,55,50,50);
            leftMove.setVisible(true);
            leftMove.addActionListener(ourListener);
            leftMove.setMnemonic(KeyEvent.VK_LEFT);

            //up move button
            upMove = new JButton("^");
            upMove.setBounds(85,5,50,50);
            upMove.setVisible(true);
            upMove.addActionListener(ourListener);
            upMove.setMnemonic(KeyEvent.VK_UP);

            //down move button
            downMove = new JButton("V");
            downMove.setBounds(85,105,50,50);
            downMove.setVisible(true);
            downMove.addActionListener(ourListener);
            downMove.setMnemonic(KeyEvent.VK_DOWN);


        //Adding children to the JFrame

        //window.add(inputTextField);
        //window.add(outputLabel);
        window.add(imageLabel);
        //window.add(runButton);   
        //window.add(imageButton);
        window.add(rightMove);
        window.add(leftMove);
        window.add(upMove);
        window.add(downMove);

        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

    //Our ActionEvent
    private class simpleListener implements ActionListener
    {
        //boolean visibleIcon = true;
        public void actionPerformed(ActionEvent e)
        {
            /*
            if(e.getSource() == runButton)
            {
                try
                {
                    String host = inputTextField.getText();
                    String ip = java.net.InetAddress.getByName(host).getHostAddress();
                    outputLabel.setText("IP of " + host + " is: " + ip);
                }
                catch(Exception error) 
                {
                    System.out.print(error);
                }
            }
            else
            {
                if(visibleIcon)
                {
                    visibleIcon = false;
                    imageLabel.setVisible(visibleIcon);
                }
                else
                {
                    visibleIcon = true;
                    imageLabel.setVisible(visibleIcon);
                }
            }
            */
            //checks button input and moves the image accordingly
            if(e.getSource() == rightMove)
            {
                xPos = xPos + 10;
            }
            else if(e.getSource() == leftMove)
            {
                xPos = xPos - 10;
            }
            else if(e.getSource() == upMove)
            {
                yPos = yPos - 10;
            }
            else if(e.getSource() == downMove)
            {
                yPos = yPos + 10;
            }
            imageLabel.setBounds(xPos, yPos, 250, 250);
        }
    }
}