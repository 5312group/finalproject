package texteditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.io.*;

public class project1 extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu fontMenu;
	private JMenu editMenu;
	private JList menuList;
	private String[] fontChoice = {"Monospaced", "Serif","SansSerif"};
	private JRadioButtonMenuItem itaButton;
	private JRadioButtonMenuItem bolButton;
	JTextArea theArea = new JTextArea();

	File fnameContainer;
	
	public project1(){
		
		
		Container con= getContentPane();
		JMenuBar menuBar = new JMenuBar();
		JPanel panel1 = new JPanel();
		
		JMenu file = new JMenu("File");
		JMenu font = new JMenu("Font");
		JMenu edit = new JMenu("Edit");
		
		con.setLayout(new BorderLayout());
		JScrollPane jspText = new JScrollPane(theArea);
		jspText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspText.setVisible(true);
		Font fnt=new Font("Arial",Font.PLAIN,15);
		theArea.setFont(fnt);
		theArea.setLineWrap(true);
		theArea.setWrapStyleWord(true);
		
		con.add(jspText);
		
		createMenuItem(file,"New");
		createMenuItem(file,"Open");
		createMenuItem(file,"Save");
		createMenuItem(file,"Save As");
		createMenuItem(file,"Exit");
		createMenuItem(edit,"Cut");
		createMenuItem(edit,"Copy");
		createMenuItem(edit,"Paste");
		
		menuBar.add(file);
		menuBar.add(buildFontMenu());
		menuBar.add(edit);
	
		
		setJMenuBar(menuBar);
		
		
		setSize(300,400);
		setTitle("Text Editor for project IS5312");
		setVisible(true);
		
		
		
	}
	public void createMenuItem(JMenu jm,String txt){
		JMenuItem jmi=new JMenuItem(txt);
		jmi.addActionListener(this);
		jm.add(jmi);
	}
	
	public JMenu buildFontMenu(){
			
			
			
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
			return fontMenu;
		}
		
		

public void actionPerformed(ActionEvent e){
		JFileChooser jfc = new JFileChooser();
		if (e.getActionCommand().equals("New"))
		{
			this.setTitle("Untitled.txt");
			theArea.setText(null);
			fnameContainer = null;
	}else if(e.getActionCommand().equals("Open")){
				//open
				int ret=jfc.showDialog(null,"Open");
				
				if(ret == JFileChooser.APPROVE_OPTION)
				{
					try{
						File fyl=jfc.getSelectedFile();
						OpenFile(fyl.getAbsolutePath());
						this.setTitle(fyl.getName()+ " - Notepad");
						fnameContainer=fyl;
					}catch(IOException ers){}
				} 
				 
			}else if(e.getActionCommand().equals("save")) {
				if (fnameContainer !=null) {
					jfc.setCurrentDirectory(fnameContainer);
					jfc.setSelectedFile(fnameContainer);
					
				}else {
					
					jfc.setSelectedFile(new File("untitled.txt"));
				}
				int ret=jfc.showSaveDialog(null);
				if(ret==JFileChooser.APPROVE_OPTION) {
					
					try {
						File fyl = jfc.getSelectedFile();
						SaveFile(fyl.getAbsolutePath());
						this.setTitle(fyl.getName()+"-notepad");
						fnameContainer=fyl;
						
					}catch (Exception ers2) {}
				}
			} else if(e.getActionCommand().equals("Exit")) {
				Exiting();
				
			} else if(e.getActionCommand().equals("Cut")) {
				theArea.cut();
				
			} else if(e.getActionCommand().equals("Copy")) {
				theArea.copy();
				
			}else if(e.getActionCommand().equals("Paste")) {
				theArea.paste();
				
			}
	
	
	
	
	
	}
	
	public void OpenFile(String fname) throws IOException {	
			//open file code here
			BufferedReader d=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
			String l;
			//clear the textbox
			theArea.setText("");
		
			setCursor(new Cursor(Cursor.WAIT_CURSOR));
				
			while((l=d.readLine())!= null) {
				theArea.setText(theArea.getText()+l+"\r\n");
			}
			
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			d.close();
		}
	
	public void SaveFile(String fname) throws IOException {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		DataOutputStream o=new DataOutputStream(new FileOutputStream(fname));
		o.writeBytes(theArea.getText());
		o.close();		
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void Exiting() {
		
		System.exit(0);
	}
	public static void main(String[] args) {
		 new project1();
		
	}
}