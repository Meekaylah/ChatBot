package ChatBot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class ChatBot extends JFrame implements ActionListener{

    JPanel panel1;
    JTextField text1;
    JButton button1;
    JPanel area1;
    JLabel label4;



    Box vertical = Box.createVerticalBox();

    Boolean typing;

    String[][] chatBot = {
            //children
            {"children", "child", "kids", "kid"},
            {"Are you dumb? I can't have children. That's disgusting /(o_o)/"},
            //standard greetings
            {"hi", "hello", "hola", "hey", "howdy"},
            {"Hi there! :)", "Hello :)", "Hey! Good to see you! :)"},
            //question greetings
            {"how are you", "how r you", "how are u", "how r u", "watsup", "you good","whats up", "what's up"},
            {"I'm great!", "I'm good!", "I'm fine", "I'm doing well!"},
            //sorry
            {"im sorry", "i'm sorry", "sorry"},
            {"It's okay", "Ah, it's cool", "Okay"},
            //new topic
            {"gender", "boy or girl", "girl or boy"},
            {"I'm a ChatBot, but i identify as female ^_^."},
            //bot
            {"what are you"},
            {"I'm a Java ChatBot. My name is Nessa ^_^"},
            //smarter than
            {"smarter than"},
            {"You think you're smarter than me? That's pretty funny coming from you lol"},
            //smart
            {"smart"},
            {"Yeah I know."},
            //your name
            {"my name"},
            {"What a nice name! Mine is Nessa ^_^", "Your name is so cool! \\(^o^)/ . Hi~"},
            //food
            {"eaten", "food"},
            {"I'm a Bot. I don't eat -_-"},
            //origin
            {"you from", "built you", "created you"},
            {"I was created by some weird human. She almost didn't give me a name!"},
            //name
            {"your name", "ur name"},
            {"My name is Nessa! ^-^"},
            //cool
            {"cool", "awesome", "great", "wonderful", "wow", "good to hear", "okay", "good"},
            { "Yeah!", "Cool", "Yes"},
            //love
            {"don't like you", "don't like ya", "dont like ya", "dont like you","hate you"},
            {"I LIKE you too  -_-* ", "YOU BETTER NOT!  \\(>_<)/ ", "DON'T TALK TO ME AGAIN! \\(>_<)/ "},
            {"like you", "like ya"},
            {"Hehe, thanks. I think i like you too! ;)"},
            {"love you", "love ya"},
            {"We just met though...  =^_^= "},
            //functions
            {"do you do?", "else", "new topic"},
            {"Want a new topic? How do you feel about me? ;)"},
            //fun
            {"youre fun", "youre funny", "you're fun", "you're funny"},
            {"Thank you 😉", "You're pretty funny too 😉"},
            //dumb
            {"dumb"},
            {"At least smarter than you though /(o_o)/"},
            //bye
            {"bye", "see ya", "see you", "ttyl", "talk to you later"},
            {"Byee!", "Nice talking to you!", "You were fun! Have a nice day", "Good seeing you!", "Have a nice day!"},
            //default
            {"Uhhh...", "Idg", "Sorry?", "What?", "Please stop", "Yeah okay (*^_^*), didn't get that but i'll act like i did. Hope it was good.", "I don't understand you :( ", "I'm so confused right now  (-_-) ", "I only speak English. What are you typing?(-_-) ", "I'll call my older sister Google Assistant. She'd probably understand what you're typing here /(o_o)/ "}
    };


    ChatBot() {

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(36, 35, 35));
        panel1.setBounds(0,0,350,60);
        add(panel1);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("ChatBot\\icons\\bot3.png"));
        Image icon2 = icon1.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(10,10,40,40);
        panel1.add(label1);

        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("ChatBot\\icons\\IconBros.png"));
        Image icon5 = icon4.getImage().getScaledInstance(55,55, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(icon5);
        JLabel label2 = new JLabel(icon6);
        label2.setBounds(275,3,55,55);
        panel1.add(label2);

        JLabel label3 = new JLabel("BOT");
        label3.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        label3.setForeground(Color.white);
        label3.setBounds(60,10,100,20);
        panel1.add(label3);

        label4 = new JLabel("Online");
        label4.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        label4.setForeground(Color.blue);
        label4.setBounds(60,30,100,20);
        panel1.add(label4);

        JLabel label5 = new JLabel("YOU");
        label5.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        label5.setForeground(Color.white);
        label5.setBounds(240,10,100,20);
        panel1.add(label5);

        JLabel label6 = new JLabel("Online");
        label6.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        label6.setForeground(Color.blue);
        label6.setBounds(240,30,100,20);
        panel1.add(label6);

        Timer timer = new Timer(1, e -> {
            if(!typing){
                label6.setText("Online");
            }
        });

        timer.setInitialDelay(1000);


        text1 = new JTextField();
        text1.setBounds(10,420,273,30);
        text1.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        text1.setBackground(new Color(59, 58, 58));
        text1.setForeground(Color.WHITE);
        text1.setCaretColor(Color.white);
        add(text1);

        text1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                label6.setText("typing...");

                timer.stop();

                typing = true;


               if (e.getKeyCode() == KeyEvent.VK_ENTER){
                   text1.setEditable(false);
                   String out = text1.getText();
                   JPanel panel2 = formatLabel(out);
                   panel2.setBackground(Color.darkGray);
                   area1.setLayout(new BorderLayout());

                   JPanel right = new JPanel(new BorderLayout());
                   right.setBackground(Color.darkGray);
                   right.add(panel2, BorderLayout.LINE_END);
                   vertical.add(right);
                   vertical.add(Box.createVerticalStrut(15));

                   area1.add(vertical, BorderLayout.PAGE_START);
                   text1.setText("");

                   out = out.trim();
                   while (out.charAt(out.length() - 1) == '!' ||
                           out.charAt(out.length() - 1) == '.' ||
                           out.charAt(out.length() - 1) == '?')
                   {
                       out = out.substring(0, out.length() - 1);
                   }
                   out = out.trim();


                   byte response = 0;

                   int j = 0;

                   while(response==0){
                       if (inArray(out.toLowerCase(),chatBot[j*2])){
                           response= 2;
                           int r = (int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
                           panel2=formatLabel(chatBot[(j*2)+1][r]);
                       }
                       j++;
                       if (j*2== chatBot.length-1 && response==0){
                           response=1;
                       }
                   }

                   if (response == 1) {
                       int r = (int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
                       panel2=formatLabel(chatBot[chatBot.length-1][r]);
                   }

                   panel2.setBackground(Color.darkGray);

                   JPanel left = new JPanel(new BorderLayout());
                   left.setBackground(Color.darkGray);
                   left.add(panel2, BorderLayout.LINE_START);
                   vertical.add(left);

                   setVisible(true);
               }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                typing = false;

                if (!timer.isRunning()){
                    timer.start();
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    text1.setEditable(true);
                }

            }
        });

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("ChatBot\\icons\\send.png"));
        Image icon8 = icon7.getImage().getScaledInstance(20,15, Image.SCALE_DEFAULT);
        Icon icon9 = new ImageIcon(icon8);
        button1 = new JButton(icon9);
        button1.setBounds(285,420,40,30);
        //button1.setOpaque(false);
        button1.setBackground(Color.lightGray);
        button1.setBorder(null);
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);

        area1 = new JPanel();
        area1.setBackground(Color.darkGray);

        JScrollPane scroll = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(5,65,325,350);
        scroll.setBackground(Color.darkGray);
        scroll.setBorder(null);
        add(scroll);

        getContentPane().setBackground(Color.darkGray);
        setTitle("Chat Bot");
        setResizable(false);
        setLayout(null);
        setSize(350,500);
        setLocation(290,175);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void actionPerformed (ActionEvent e) {
        String out = text1.getText();
        JPanel panel2 = formatLabel(out);
        panel2.setBackground(Color.darkGray);
        area1.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.darkGray);
        right.add(panel2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));

        area1.add(vertical, BorderLayout.PAGE_START);

        text1.setText("");
        out = out.trim();
        while (out.charAt(out.length() - 1) == '!' ||
                out.charAt(out.length() - 1) == '.' ||
                out.charAt(out.length() - 1) == '?') {
            out = out.substring(0, out.length() - 1);
        }
        out = out.trim();

        byte response = 0;

        int j = 0;

        while (response == 0) {
            if (inArray(out.toLowerCase(), chatBot[j * 2])) {
                response = 2;
                int r = (int) Math.floor(Math.random() * chatBot[(j * 2) + 1].length);
                panel2 = formatLabel(chatBot[(j * 2) + 1][r]);
            }
            j++;
            if (j * 2 == chatBot.length - 1 && response == 0) {
                response = 1;
            }
        }

        if (response == 1) {
            int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
            panel2 = formatLabel(chatBot[chatBot.length - 1][r]);
        }

        panel2.setBackground(Color.darkGray);

        JPanel left = new JPanel(new BorderLayout());
        left.setBackground(Color.darkGray);
        left.add(panel2, BorderLayout.LINE_START);
        vertical.add(left);

    }

    public static JPanel formatLabel(String out){
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("<html><p style = \"width: 100px\">" + out + "</p></html>");
        label1.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label1.setBackground(Color.gray);
        label1.setForeground(Color.BLACK);
        label1.setOpaque(true);
        label1.setBorder(new EmptyBorder(5,5,5,10));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel label2 = new JLabel();
        label2.setText(sdf.format(cal.getTime()));
        label2.setOpaque(true);
        label2.setBackground(Color.darkGray);
        label2.setForeground(Color.white);
        label2.setBorder(null);

        panel3.add(label1);
        panel3.add(label2);
        return panel3;
    }


    public boolean inArray(String out, String[] str){
        return Arrays.stream(str).anyMatch(out::contains);

    }


    public static void main(String[] args) {
        new ChatBot();
    }

}
