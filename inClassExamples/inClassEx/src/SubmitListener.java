import java.awt.event.*;
class SubmitListener implements ActionListener {
    private MyFrame frame;
    // constructor
//    public SubmitListener(MyFrame jf) {
//        frame = jf;
//    }
    // performs an action in response to the event
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Do Something");
    }
}