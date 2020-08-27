import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MP3Player  extends JFrame implements MouseListener, MouseMotionListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Define all of your variables here
	int windowHeight;
	int windowWidth;

	BufferedImage phoneImage;
	Graphics offscreen;
	JScrollPane scrollpane;
	JList songList;
	int fontSpacing = 25;

	// Define your songs variables
	int numOfSongs = 4; // number of songs in your MP#Player 

	// TO DO: declare an array of Strings called "songs" that will store your song names
	String [] songs = new String [numOfSongs];

	// TO DO: declare an array of MP3 objects called "mp3" that will store your mp3 songs
	MP3 [] mp3 = new MP3 [numOfSongs];

	String path;  // declare path to your mp3 folder

	public static void main(String[] args) {
		MP3Player player = new MP3Player();
		//player.setBounds(200, 100, 500, 1000);   
	}

	// initialize your variables in this method
	public MP3Player () {
		// TO DO: set the number of songs that you have (give numOfSongs a value)
		numOfSongs = 4;

		getContentPane().setLayout(null);
		((JPanel) getContentPane()).setOpaque(false);

		JPanel backPanel = new JPanel();

		// TODO: Place the name of your MP3 Player image here, including the extension.
		//       Remember to use double backslashes inside of quotations
		String imageFile = "xforce.jpg"; 
		
		// TODO: Specify the path to your folder that contains all of mp3 files
		path = "reserve/";

		final ImageIcon m_image = new ImageIcon(path + imageFile);
		windowWidth = m_image.getIconWidth();
		windowHeight = m_image.getIconHeight();

		// TO DO: create an array of songs here (your array is called "songs") and fill 
		//        it with your song names
		
		songs [0] = "Frosty The Snowman";
		songs [1] = "Jingle Bells Rock";
		songs [2] = "Old Toy Trains";
		songs [3] = "Santa Claus Is Coming To Town";

		// TO DO: Now create an array of MP3 objects called "mp3", with a size equal to the 
		//        number of songs that you have and fill it with new MP3 objects.
		//        ex. mp3[0] = new MP3(path + "\filename.mp3");
		
		mp3 [0] = new MP3 (path + "Frosty The Snowman.mp3");
		mp3 [1] = new MP3 (path + "Jingle Bells Rock.mp3");
		mp3 [2] = new MP3 (path + "Old Toy Trains.mp3");
		mp3 [3] = new MP3 (path + "Santa Claus Is Coming To Town.mp3");



		// DO NOT MODIFY THE REST OF THIS METHOD
		songList = new JList(songs);
		songList.setOpaque(false);
		songList.setBackground(new Color(0.6f, 0.9f, 0.4f, 0.9f));
		songList.setForeground(new Color(0.8f, 0.1f, 0.2f, 0.9f));
		songList.setFont(new Font("Comic Sans MS", Font.BOLD, 32));

		songList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return;
				JList list = (JList)evt.getSource();

				// Get all selected items
				Object[] selected = list.getSelectedValues();

				// Iterate all selected items
				for (int i=0; i<selected.length; i++) {
					Object sel = selected[i];
					System.out.println(selected[i]);
					play((String)selected[i]);
				}
			}
		});

		scrollpane = new JScrollPane(songList);
		scrollpane.setSize(windowWidth-1000, windowHeight - 1280);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);
		// This next line sets the location of your list of songs as x, y coordinates
		// from the top left corner of your window.  You may need to change the x, y values. 
		scrollpane.setLocation(0, 0);

		getContentPane().add(scrollpane);

		if (m_image.getIconWidth() > 0 && m_image.getIconHeight() > 0) {
			backPanel = new JPanel(){
				public void paintComponent(Graphics g ){
					super.paintComponent(g);

					int w = getParent().getWidth();
					int h = getParent().getHeight();

					g.drawImage (m_image.getImage(), 0, 0, w, h, this);
				}
			};

		}

		getLayeredPane().add( backPanel, new Integer( Integer.MIN_VALUE ) );
		backPanel.setBounds(0, 0, 0, 0);

		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setSize(windowWidth, windowHeight);
		setVisible(true);
	}

	public void play(String filename)
	{
		// TO DO : this method is called when you click on a mp3 file.
		//         Modify this method to play the song that was clicked.  The
		//         name of the mp3 file is stored in the variable filename
		
		for (int i = 0; i < numOfSongs; i++) {
			if (songs[i].equals(filename)) { 
				mp3[i].play();
			}
		}

	}


	public void mouseClicked(MouseEvent e) {

	}


	public void mouseEntered(MouseEvent arg0) {

	}


	public void mouseExited(MouseEvent arg0) {

	}


	public void mousePressed(MouseEvent arg0) {

	}


	public void mouseReleased(MouseEvent arg0) {

	}


	public void mouseDragged(MouseEvent arg0) {

	}


	public void mouseMoved(MouseEvent arg0) {

	}


	public void windowActivated(WindowEvent arg0) {

	}


	public void windowClosed(WindowEvent arg0) {

	}


	public void windowClosing(WindowEvent arg0) {

	}


	public void windowDeactivated(WindowEvent arg0) {

	}


	public void windowDeiconified(WindowEvent arg0) {

	}


	public void windowIconified(WindowEvent arg0) {

	}


	public void windowOpened(WindowEvent arg0) {

	}

}

