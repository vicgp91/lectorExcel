package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelos.CarneInfo;
import utils.LectorExcel;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel("Selecciona documento:");
	JTextField textfield = new JTextField("", 20);
	JButton btnEjecutar = new JButton("Generar");
	JButton btnOpenFile = new JButton("Abrir documento");
	JFileChooser archivo = new JFileChooser();
	JPanel contentPaneMain, contentPaneFileExplorer;
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
	List<CarneInfo> listaCar = new ArrayList<CarneInfo>();
	File URIEXCEL;

	public Formulario() {
		super("Generador de Carné");
		contentPaneMain = new JPanel();
		setBounds(350, 50, 600, 600);
		contentPaneMain.setBackground(Color.LIGHT_GRAY);
		contentPaneMain.add(label);
		contentPaneMain.add(textfield);
		contentPaneMain.add(btnOpenFile);
		contentPaneMain.add(btnEjecutar);

		setContentPane(contentPaneMain);
		setVisible(true);
		contentPaneMain.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileFilter(filter);
				file.showOpenDialog(contentPaneMain);
				if (file.getSelectedFile() != null) {
					JOptionPane.showMessageDialog(contentPaneMain, file.getSelectedFile().getAbsolutePath());
					URIEXCEL = new File(file.getSelectedFile().getAbsolutePath());
					textfield.setText(file.getSelectedFile().getAbsolutePath());
					//label.setText("");
					
				}
			}
		});

		
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LectorExcel lector = new LectorExcel();
				lector.covertExcel(URIEXCEL);
			}
		});

	}

}
