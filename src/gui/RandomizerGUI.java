package gui;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

import javax.swing.border.EmptyBorder;

import randomizer.RandomizerBackend;

public class RandomizerGUI extends JFrame {

	private static final long serialVersionUID = -6955621547749350374L;

	private JPanel contentPane;
	private JTextField textField;

	private List<String> randomList = new ArrayList<>();
	private List<String> randomness = new ArrayList<>();

	private int amount;
	private String item = "";
	private RandomizerBackend rgg = new RandomizerBackend(randomList);
	private JFileChooser jfc;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		RandomizerGUI frame = new RandomizerGUI();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public RandomizerGUI() {
		jfc = new JFileChooser();
		JOptionPane.showMessageDialog(null, "Please choose a file with each entry on separate lines");
		jfc.showDialog(null, "Open");
		jfc.setVisible(true);
		file = jfc.getSelectedFile();
		randomness = rgg.getInfo(file);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Random list Generator");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 114, 363, 158);
		contentPane.add(textArea);

		JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(6, 114, 363, 158);
		contentPane.add(sp);

		textField = new JTextField();
		textField.setBounds(6, 35, 240, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("0");

		JButton btnNewButton = new JButton("Generate random list");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				amount = Integer.parseInt(textField.getText());
				item = rgg.setRandomAmount(amount, randomness);
				textArea.setText(item);

			}
		});
		btnNewButton.setBounds(6, 73, 181, 29);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Enter amount of items you would like");
		lblNewLabel.setBounds(6, 7, 281, 26);
		contentPane.add(lblNewLabel);
	}
}
