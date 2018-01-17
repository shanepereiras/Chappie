//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class MainInterface {
//
//    public static JPanel leftPanel;
//    public JPanel middlePanel;
//    public JPanel rightPanel;
//    public JPanel controlPanel;
//    public static Border panelBorder = BorderFactory.createLineBorder(Color.black);;
//
//    public Font chatNameFont = new Font("sansserif", Font.BOLD, 32);
//
//    public String currentChatName = "name";
//
//
//
//    public MainInterface(){
//        JFrame f = new JFrame("Chappie v.0.1");
//        f.add(controlPanel());
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setPreferredSize(new Dimension(1200, 900));
//        f.setMinimumSize(new Dimension(500, 700));
//        f.setResizable(false);
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setBackground(new Color(0,0,0));
//        f.setVisible(true);
//    }
//
//    private JPanel controlPanel(){
//        controlPanel = new JPanel();
//
//        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
//
//        controlPanel.add(leftPanel());
//        controlPanel.add(middlePanel());
//        controlPanel.add(rightPanel());
//        return controlPanel;
//    }
//
//    public JPanel leftPanel(){
//        leftPanel = new JPanel();
//        leftPanel.setPreferredSize(new Dimension(275, 900));
////        leftPanel.setBorder(panelBorder);
//
//        JPanel titlePanel = new JPanel();
//        titlePanel.setPreferredSize(new Dimension(275,50));
//
//        JLabel titleLeft = new JLabel();
//        titleLeft.setText("Chats");
////        titleLeft.setSize(new Dimension(275, 50));
//        titleLeft.setFont(chatNameFont);
//
//        JButton newChat = new JButton("New Chat");
//        newChat.addActionListener(new newChatButton());
//
//        titlePanel.add(titleLeft);
//        titlePanel.add(newChat);
//
//
//        leftPanel.add(titlePanel);
//
//        return leftPanel;
//    }
//
//    public JPanel middlePanel(){
//        middlePanel = new JPanel();
//        middlePanel.setPreferredSize(new Dimension(650, 900));
////        middlePanel.setBorder(panelBorder);
////        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
//
//        JLabel chatName = new JLabel();
//        chatName.setText(currentChatName);
//        chatName.setSize(new Dimension(650, 50));
//        chatName.setFont(chatNameFont);
//
//        JList openchat = new JList();
//        openchat.setSize(new Dimension(500, 700));
//
//        middlePanel.add(chatName);
//        middlePanel.add(openchat);
//
//
//        return middlePanel;
//    }
//
//    public JPanel rightPanel(){
//        rightPanel = new JPanel();
//        rightPanel.setPreferredSize(new Dimension(275, 900));
//        rightPanel.setBorder(panelBorder);
//        return rightPanel;
//    }
//
//    public static void main(String args[]){
//        new MainInterface();
//    }
//}
