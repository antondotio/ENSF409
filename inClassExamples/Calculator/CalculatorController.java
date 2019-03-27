import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView v, CalculatorModel m){
        theView = v;
        theModel = m;
        //the listener is added in the controller
        //the controller connects everything and sits in the middle
        theView.addCalcListen(new CalculateListen());
    }

    class CalculateListen implements ActionListener{

        public void actionPerformed(ActionEvent e){
            int first = 0, sec = 0;
            try{
                first = theView.getFirstNumber();
                sec = theView.getSecondNumber();

                theModel.addTwoNumbers(first, sec);
                theView.setSolution(theModel.getValue());
            }catch (NumberFormatException ex){

            }
        }
    }
}
