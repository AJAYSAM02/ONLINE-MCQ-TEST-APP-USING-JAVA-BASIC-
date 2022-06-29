package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("NEXT");
		btnBookmark = new JButton("BOOKMARK");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 120, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("RESULT");
			}
		}
		if (e.getActionCommand().equals("BOOKMARK")) {
			JButton bk = new JButton("BOOKMARK" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("RESULT");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("BOOKMARK" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("RESULT")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Number of right answers = " + count);
			System.exit(0);
		}
	}
// Questions
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Q1: What is the full form of “AI”?");
			radioButton[0].setText("Artificially Intelligent");
			radioButton[1].setText("Artificial Intelligence");
			radioButton[2].setText("Artificially Intelligence");
			radioButton[3].setText("Advanced Intelligence");
		}
		if (current == 1) {
			label.setText("Q2: Who is the inventor of Artificial Intelligence?");
			radioButton[0].setText("Geoffrey Hinton");
			radioButton[1].setText("Andrew Ng");
			radioButton[2].setText("John McCarthy");
			radioButton[3].setText("Jürgen Schmidhuber");
		}
		if (current == 2) {
			label.setText("Q3: Which of the following is the branch of Artificial Intelligence?");
			radioButton[0].setText("Machine Learning");
			radioButton[1].setText("Cyber forensics");
			radioButton[2].setText("Full-Stack Developer");
			radioButton[3].setText("Network Design");
		}
		if (current == 3) {
			label.setText("Q4: Which of the following are the 5 big ideas of AI?");
			radioButton[0].setText("Perception");
			radioButton[1].setText("Human-AI Interaction");
			radioButton[2].setText("Societal Impact");
			radioButton[3].setText("All of the above");
		}
		if (current == 4) {
			label.setText("Q5: What does the Bayesian network provide?");
			radioButton[0].setText("Partial description of the domain");
			radioButton[1].setText("Complete description of the problem");
			radioButton[2].setText("Complete description of the domain");
			radioButton[3].setText("None of the mentioned");
		}
		if (current == 5) {
			label.setText("Q6: _________ number of informed search method are there in Artificial Intelligence.");
			radioButton[0].setText("4");
			radioButton[1].setText("3");
			radioButton[2].setText("2");
			radioButton[3].setText("1");
		}
		if (current == 6) {
			label.setText("Q7: Face Recognition system is based on which type of approach?");
			radioButton[0].setText("Weak AI approach");
			radioButton[1].setText("Applied AI approach");
			radioButton[2].setText("Cognitive AI approach");
			radioButton[3].setText("Strong AI approach");
		}
		if (current == 7) {
			label.setText("Q8: Artificial Intelligence has evolved extremely in all the fields except for _________");
			radioButton[0].setText("Web mining");
			radioButton[1].setText("Construction of plans in real time dynamic systems");
			radioButton[2].setText("Understanding natural language robustly");
			radioButton[3].setText("All of the mentioned");
		}
		if (current == 8) {
			label.setText("Q9: What is an AI ‘agent’?");
			radioButton[0].setText("Takes input from the surroundings and uses its intelligence and performs the desired operations");
			radioButton[1].setText("An embedded program controlling line following robot");
			radioButton[2].setText("Perceives its environment through sensors and acting upon that environment through actuators");
			radioButton[3].setText("All of the mentioned");
		}
		if (current == 9) {
			label.setText("Q10: Which of the following produces hypotheses that are easy to read for humans?");
			radioButton[0].setText("Machine Learning");
			radioButton[1].setText("ILP");
			radioButton[2].setText("First-order logic");
			radioButton[3].setText("Propositional logic");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}
// correct answers
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}
// now we will run and see the working. we can even bookmark our answers and check our results. Here we go
// i gave wrong answers randomly. now we will check with the correct answers
// hence the app is working correctly. The page has features like next finish and bookmark. the no of correct responses si also shown at the end 
// THANK YOU