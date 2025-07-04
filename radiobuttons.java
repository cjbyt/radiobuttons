package radiobutton;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public  class radiobuttons extends JFrame implements ActionListener {

    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;
    JRadioButton radioButton4;
    JRadioButton radioButton5;
    JLabel imageLabel;

    radiobuttons() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Demo");
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        this.setLayout(new BorderLayout());

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());



        radioButton1 = new JRadioButton("bird");
        radioButton2 = new JRadioButton("cat");
        radioButton3 = new JRadioButton("dog");
        radioButton4 = new JRadioButton("rabbit");
        radioButton5 = new JRadioButton("pig");

        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton3.addActionListener(this);
        radioButton4.addActionListener(this);
        radioButton5.addActionListener(this);

        ButtonGroup radioButton_group = new ButtonGroup();
        radioButton_group.add(radioButton1);
        radioButton_group.add(radioButton2);
        radioButton_group.add(radioButton3);
        radioButton_group.add(radioButton4);
        radioButton_group.add(radioButton5);

        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(radioButton4);
        this.add(radioButton5);

        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);
        radioPanel.add(radioButton4);
        radioPanel.add(radioButton5);

        this.add(radioPanel, BorderLayout.NORTH);
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(1,1));
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.add(imageLabel, BorderLayout.CENTER);

        this.setVisible(true);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });





    }


    // implementing ActionListener interface method




    public static void main(String[] args) {
    new radiobuttons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = "";
        String label = "";
        if (e.getSource() == radioButton1) {
             path ="src/photo-1555169062-013..._imresizer.jpg";
             label = "BIRDIMAGE";
            System.out.println("bird selected");
            //select first then resize the frame to see the image
            //close and rerun to select and see the next image

        } else if (e.getSource() == radioButton2) {
         path ="src/photo-1573865526739-..._imresizer.jpg";

         label = "CATIMAGE";
            System.out.println("cat selected");
            //select first then resize the frame to see the image
            //close and rerun to select and see the next image

        } else if (e.getSource() == radioButton3) {
          path ="src/photo-1530281700549-..._imresizer.jpg";

           label ="DOGIMAGE";
            System.out.println("dog selected");
            //select first then resize the frame to see the image
            //close and rerun to select and see the next image

        } else if (e.getSource() == radioButton4) {
          path = "src/photo-1535241749838-..._imresizer.jpg";

            label = "RABBITIMAGE";
            System.out.println("rabbit selected");
            //select first then resize the frame to see the image
            //close and rerun to select and see the next image


        } else if (e.getSource() == radioButton5) {
            path = "src/photo-1587213128862-..._imresizer.jpg";

           label ="PIGIMAGE";
            System.out.println("pig selected");
            //select first then resize the frame to see the image
            //close and rerun to select and see the next image

        }
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(
                imageLabel.getWidth() > 0 ? imageLabel.getWidth() : 4,
                imageLabel.getHeight() > 0 ? imageLabel.getHeight() : 3,
                Image.SCALE_SMOOTH
        );

        ImageIcon scaledIcon   = new ImageIcon( path);
        imageLabel.setIcon(scaledIcon  );
        imageLabel.setText("");
        // Force GUI to update
        this.revalidate();
        this.repaint();
    }

}





