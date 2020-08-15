
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

public class calc {

	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Calculator");
		frame.getContentPane().setBackground(new Color(110, 124, 145));
		
		JTextField textField = new JTextField();
		textField.setBounds(100,100, 100, 100);
		frame.setSize(450,410);
		
		frame.setLocation(100, 150);
		
		//exit button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		Font font=new Font("SansSerif Plain", Font.BOLD,45);
		
		//upper text field
		JTextField TextF = new JTextField();
		TextF.setHorizontalAlignment(SwingConstants.RIGHT);
		TextF.setBounds(5,0,440,100);
		TextF.setFont(font);
		TextF.setEditable(true);
		
		frame.add(TextF);
		frame.setLayout(null);
		frame.setVisible(true);
	
		
		StringBuilder s=new StringBuilder("");
		
		
			//indiv. buttons
		
			JButton sev = new JButton(String.valueOf(7));
			sev.setBounds(10, 110, 100, 60);
			addActionListener(frame,TextF,sev,s);
			
			JButton eight = new JButton(String.valueOf(8));
			eight.setBounds(120, 110, 100, 60);
			addActionListener(frame,TextF,eight,s);
				
			JButton nine = new JButton(String.valueOf(9));
			nine.setBounds(230, 110, 100, 60);
			addActionListener(frame,TextF,nine,s);;
					
			JButton four = new JButton(String.valueOf(4));
			four.setBounds(10, 180, 100, 60);
			addActionListener(frame,TextF,four,s);
				
			JButton five = new JButton(String.valueOf(5));
			five.setBounds(120, 180, 100, 60);
			addActionListener(frame,TextF,five,s);
				
			JButton six = new JButton(String.valueOf(6));
			six.setBounds(230, 180, 100, 60);
			addActionListener(frame,TextF,six,s);
				
			JButton one = new JButton(String.valueOf(1));
			one.setBounds(10, 250, 100, 60);
			addActionListener(frame,TextF,one,s);
				
			JButton two = new JButton(String.valueOf(2));
			two.setBounds(120, 250, 100, 60);
			addActionListener(frame,TextF,two,s);
				
			JButton three = new JButton(String.valueOf(3));
			three.setBounds(230, 250, 100, 60);
			addActionListener(frame,TextF,three,s);

			JButton z = new JButton(String.valueOf(0));
			z.setBounds(10, 320, 100, 60);
			frame.add(z);
			addActionListener(frame,TextF,z,s);					

			JButton add = new JButton(String.valueOf('+'));
			add.setBounds(340, 110, 100, 60);
			addActionListener(frame,TextF,add,s);
			
			JButton sub = new JButton(String.valueOf('-'));
			sub.setBounds(340, 180, 100, 60);
			addActionListener(frame,TextF,sub,s);
						
			JButton mul = new JButton(String.valueOf('*'));
			mul.setBounds(340, 250, 100, 60);
			addActionListener(frame,TextF,mul,s);				

			JButton div = new JButton(String.valueOf('/'));
			div.setBounds(340, 320, 100, 60);
			addActionListener(frame,TextF,div,s);
			
					
					
			JButton eq = new JButton(String.valueOf('='));
			eq.setBounds(230, 320, 100, 60);
			frame.add(eq);
			setButton(eq);
					eq.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//equation(s.toString());
						TextF.setText(equation(s.toString()));
						String st=equation(s.toString());
						s.setLength(0);
						s.append(st);
						
				}
			});
					
			JButton ac = new JButton(String.valueOf('C'));
			ac.setBounds(120, 320, 100, 60);
			frame.add(ac);
			setButton(ac);
					ac.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TextF.setText("");
						s.setLength(0);
					}
			});
			
			//if enter key is pressed rather than = button
			TextF.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st=TextF.getText();
				TextF.setText(equation(st));
				st=equation(s.toString());
				s.setLength(0);
				s.append(st);
			}});
					
	}
	
	//adding actionlistener
	public static void addActionListener(JFrame frame, JTextField TextF, JButton button, StringBuilder s) {
		frame.add(button);
		setButton(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.append(button.getText());
				TextF.setText(s.toString());
				
			}
		});
	}
	
	//calculations
	public static String equation(String s){
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		Object equation = null;
		//String st=s.toString();
		try {
			equation = (engine.eval(s));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		String proper =equation.toString();
		return proper;
		
	}
	
	//color, font, background of buttons
	public static void setButton(JButton button) {
		button.setBackground(new Color(0, 78, 168));
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		
	}

}
