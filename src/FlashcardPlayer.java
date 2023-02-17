import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

/*
 * @author: Wendell Oliveira
 */
public class FlashcardPlayer extends JPanel
{
    private JTextArea display;
    private ArrayList<Flashcard> cardList;
    private Flashcard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) throws Exception 
    {
        
        FlashcardPlayer player = new FlashcardPlayer();
        player.go();
    }

    public void go() 
    {
        JFrame frame = new JFrame ("Flashcard - Player");
        Font bigFont = new Font("sanseif", Font.BOLD, 24);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        display = new JTextArea(5, 5);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");

        cardList = new ArrayList<Flashcard>();

        setPreferredSize(new Dimension (350, 480));
        setLayout(null);

        add(display);

        add(qScroller);
        add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        display.setBounds(15, 55, 320, 160);
        nextButton.setBounds(88, 435, 170, 25);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        frame.pack();
    }
    public class NextCardListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            if (isShowAnswer)
            {
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next card");
                isShowAnswer = false;
            }
            else
            {
                if (currentCardIndex < cardList.size())
                {
                    showNextCard();
                }
                else
                {
                    display.setText("Thas was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    public class OpenMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0) 
        {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    private void loadFile(File file)
    {
        cardList = new ArrayList<Flashcard>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                makeCard(line);
            }
            reader.close();
        }
        catch (Exception ex)
        {
            System.out.println("couldn't read the card file ");
            ex.printStackTrace();
        }

        showNextCard();
        nextButton.setEnabled(true);
    }

    private void makeCard(String lineToParse)
    {
        String[] result = lineToParse.split("/");
        Flashcard card = new Flashcard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    private void showNextCard()
    {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
