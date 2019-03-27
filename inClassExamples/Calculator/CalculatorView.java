import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame{
	
	
	private JTextField firstNumber = new JTextField(10);
	private JLabel addLabel = new JLabel ("+");
	
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton ("Calculate");
	
	private JTextField solution = new JTextField(10);
    
	CalculatorView(){
		JPanel calcPanel = new JPanel ();
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		calcPanel.add(firstNumber);
		calcPanel.add(addLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(solution);
		
		this.add(calcPanel);
	}
	//to be completed
	public int getFirstNumber(){
		return Integer.parseInt(firstNumber.getText());
	}
	public int getSecondNumber(){
		return Integer.parseInt(secondNumber.getText());
	}
	public void setSolution(int sol){
		solution.setText(Integer.toString(sol));
	}
	//code for action listener
	public void addCalcListen(ActionListener listenForCalcButton){
		calculateButton.addActionListener(listenForCalcButton);//connecting view to controller
	}
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
