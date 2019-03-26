import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {
    JButton b1, b2;
//    SubmitListener submitListener;
//    CancelListener cancelListener;

    public MyFrame(String s){
        super(s);
//        submitListener = new SubmitListener();
//        cancelListener = new CancelListener();
        setLayout ( new BorderLayout());
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Do Something");
            }
        });
//        b2.addActionListener(cancelListener);
        add("North",b1);
        add("Center", b2);
    }
    public static void main(String args[])
    {
// Create the frame
        MyFrame frame = new MyFrame("Frame 1");
        frame.pack();
        frame.setVisible(true);
    }
}