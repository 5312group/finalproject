import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project2 extends JFrame{
	private JLabel messageLabel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu fontMenu;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveasItem;
	private JMenuItem exitItem;
	private JList menuList;
	private String[] fontChoice = {"Monospaced", "Serif","SansSerif"};
	private JRadioButtonMenuItem itaButton;
	private JRadioButtonMenuItem bolButton;
	private JTextArea theArea;
	public project2(){
		setTitle("Text Editor");
		pack();
		setVisible(true);
		//JScrollPane scroll =new JScrollPane(theArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//add(scroll,BorderLayout.CENTER);
		//theArea = new JTextArea();
		//theArea.setEditable(false);
		//getContentPane().add(new JScrollPane(theArea));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildMenuBar();
		
	}
	private void buildMenuBar(){
		//create the menu bar
		menuBar = new JMenuBar();
		//create two menus
		buildFileMenu();
		buildFontMenu();
		//add files to main menubar
		menuBar.add(fileMenu);
		menuBar.add(fontMenu);
		setJMenuBar(menuBar);
	
		
	}
	
	private void buildFileMenu(){
		fileMenu = new JMenu("File");
		newItem = new JMenuItem("new");
		openItem = new JMenuItem("open");
		saveItem = new JMenuItem("save");
		saveasItem = new JMenuItem("save as");
		exitItem = new JMenuItem("exit");
	
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveasItem);
		fileMenu.add(exitItem);
		//fileMenu.getAccessibleContext().setAccessibleDescription("the first menu in this program");
	}
	
	private void buildFontMenu(){
			
			//fileMenu.add(newItem)
			
			itaButton = new JRadioButtonMenuItem("Italic",true);
			bolButton = new JRadioButtonMenuItem("Bold",true);
			ButtonGroup group = new ButtonGroup();
			group.add(itaButton);
			group.add(bolButton);
			fontMenu = new JMenu("Font");
			menuList = new JList(fontChoice);
			fontMenu.add(menuList);
			menuList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			fontMenu.addSeparator();
			fontMenu.add(itaButton);
			fontMenu.add(bolButton);
			
		}
		
	public static void main(String[] args) {
		new project2();
		//made change in 12.48 am --test
	}
}