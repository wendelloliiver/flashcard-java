import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

/*
 * @author: Wendell Oliveira
 */
public class FlashcardBuilder extends JPanel
{
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<Flashcard> cardList;
    private JFrame frame;
    private JButton nextButton;

    public static void main(String[] args) throws Exception 
    {
        
        FlashcardBuilder builder = new FlashcardBuilder();
        builder.go();
    }

    public void go() 
    {
        JFrame frame = new JFrame ("Flashcard - Builder");
        Font bigFont = new Font("sanseif", Font.BOLD, 24);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuListener());

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveMenuListener());
        
        // JMenuItem exitItem = new JMenuItem("Exit");
        // exitItem.addActionListener(new ExitListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        // fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        JLabel qLabel = new JLabel("Question");
        question = new JTextArea(5, 5);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel aLabel = new JLabel("Answer");
        answer = new JTextArea(5, 5);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane();
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Next Card");

        cardList = new ArrayList<Flashcard>();

        setPreferredSize(new Dimension (350, 480));
        setLayout(null);

        add(qLabel);
        add(qScroller);
        add(question);

        add(aLabel);
        add(aScroller);
        add(answer);

        add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        question.setBounds(15, 55, 320, 160);
        qLabel.setBounds(135, 30, 100, 25);
        answer.setBounds(15, 255, 320, 160);
        aLabel.setBounds(145, 225, 100, 25);
        nextButton.setBounds(105, 435, 130, 25);

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
            Flashcard card = new Flashcard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            Flashcard card = new Flashcard(question.getText(), answer.getText());
            cardList.add(card);

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    public class NewMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ev)
        {
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard()
    {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    private void saveFile(File file)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            for (Flashcard card : cardList)
            {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }

            writer.close();
        }
        catch (IOException ioe)
        {
            System.out.println("couldn't write the cardList out");
            ioe.printStackTrace();
        }
    }
}