import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class project1 extends JFrame{
	private JTextArea theArea = null;
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
	final JFileChooser fc = new JFileChooser();
	private Component aComponent;
    final int returnVal = fc.showOpenDialog(aComponent);
	public project1(){
		super("Text Editor");
		//setTitle("Text Editor");
		setSize(300,400);
		
		setVisible(true);
		theArea = new JTextArea();
		theArea.setEditable(false);
		getContentPane().add(new JScrollPane(theArea));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.setOpaque(false);
		JMenuBar mfile = buildMenuBar();
		menuBar.add(mfile);
		setJMenuBar(menuBar);
	}
	private JMenuBar buildMenuBar(){
		//create the menu bar
		menuBar = new JMenuBar();
		
		//menuBar.setOpaque(true);
		//create two menus
		buildFileMenu();
		buildFontMenu();
		//add files to main menubar
		menuBar.add(fileMenu);
		menuBar.add(fontMenu);
		return menuBar;

	}
	
	public void buildFileMenu(){
		
		fileMenu = new JMenu("File");
		newItem = new JMenuItem("new");
		openItem = new JMenuItem("open");
		saveItem = new JMenuItem("save");
		saveasItem = new JMenuItem("save as");
		exitItem = new JMenuItem("exit");
	
		
		fileMenu.add(newItem);
		
		fileMenu.add(openItem);
		
		openItem.addActionListener(new ActionListener(){
	
					public void actionPerformed(ActionEvent e)
					{
						theArea.append("- MenuItem New Performed -\n");
					}
		});
		fileMenu.add(saveItem);
		fileMenu.add(saveasItem);
		fileMenu.add(exitItem);
		
	}
	
	public void buildFontMenu(){
			
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
			
			new project1();
			
			//made change in 12.48 am --test
		}
}