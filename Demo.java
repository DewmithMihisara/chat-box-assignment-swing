import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatBox extends JFrame{
	private JTextArea chtTAr;
	private JTextField msgTxt;
	
	ChatBox(String title){
		initComponents(title);
	}
	public void initComponents(String title) {
		setSize(300,400);
		setTitle(title+"'s Room");
		setDefaultCloseOperation(1);
		setLocationRelativeTo(null);
		
		chtTAr = new JTextArea();
		chtTAr.setBounds(40,75,250,200);
		chtTAr.setLineWrap(true);
		chtTAr.setWrapStyleWord(true);
		
		JScrollPane jscPane=new JScrollPane(chtTAr);
		
		msgTxt = new JTextField(40);
		msgTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cht = msgTxt.getText();
				chtTAr.append("\n"+title+" : "+ cht);
				msgTxt.setText("");
			}
		});
		
		add(jscPane,BorderLayout.CENTER);
		add(msgTxt,BorderLayout.PAGE_END);
	}
}

class Chat extends JFrame implements ActionListener{
	private JTextField txt1;
	private JButton btnJin;
	private JPanel midPnl;
	
	Chat() {
		initComponents();
	}
	public void initComponents() {
		setSize(200,100);
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		midPnl=new JPanel(new BorderLayout());
		
		btnJin=new JButton("Join");
		btnJin.addActionListener(this);
		
		txt1 = new JTextField(15);
		
		midPnl.add(btnJin,BorderLayout.PAGE_END);
		midPnl.add(txt1,BorderLayout.PAGE_START);
		
		add(midPnl,BorderLayout.PAGE_START);
		
		String t1= txt1.getText();
		System.out.println(t1);
		btnJin.setEnabled(false);
		
		txt1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
				if(txt1.getText().equals("")){
					btnJin.setEnabled(false);
				}else{
					btnJin.setEnabled(true);
				}  
            }
        });
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Join")) {
			String title = txt1.getText();
			txt1.setText("");
			//btnJin.setEnabled(false);
			new ChatBox(title).setVisible(true);
		}
	}
}

class Demo{
	public static void main(String args[]){
		Chat c1 = new Chat();
		c1.setVisible(true);
	}
}


