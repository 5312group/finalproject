import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project1 extends JFrame{
	private JLabel messageLabel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu fontMenu;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveasItem;
	public project1(){
		setTitle("Text Editor");
		setSize(400,300)
		setVisible(true);
	}
	public static void main(String[] args) {
		new project1();
		//made change in 12.48 am --test
	}
}
