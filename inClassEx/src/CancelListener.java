import java.awt.event.*;
class CancelListener implements ActionListener {
    private MyFrame frame;
    // constructor
//    public CancelListener(MyFrame jf) {
//        frame = jf;
//    }
    // performs an action in response to the event
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Do Something Else");
    }
}