//Run srver first because your server should be in the running state
package chatting.application;
import javax.swing.*;
import javax.swing.border.*;//48.Contain Empty Border
import java.awt.*;
import java.awt.event.*;//20.Contain ActionListener and action listener will give error because it contain an abstract method so we need to override it
import java.util.*;//49. Contain calender
import java.text.*;//50.Contain Simple Date format and set text
import java.net.*;//52. To make a server and it contain serversocket class(for your server) and socket class(For your client)
import java.io.*;//53.For your inputoutput stream
public class Server implements ActionListener//3.Jframe class in swing that contain methods to make frames
{
     JTextField text;//37. we need to display whatever is in our textbox so it has to get displayed gloably
     JPanel a1;//40.We have to append our text over this jpanel so it has to global as well
     static Box vertical = Box.createVerticalBox();//43. Will set your messages vertically
     static JFrame f = new JFrame();
     static DataOutputStream dout;
    Server()//2.constructor will be called as soon as object is made
    {
     f.setLayout(null);//9.Set default layout to null because we are making our own
     JPanel p1 = new JPanel();//10. use to make a new panel on the top
     p1.setBackground(new Color(7,94,84));//11.Setting color for your panel
     p1.setBounds(0,0,450,70);//13. Will tell where to set p1
     p1.setLayout(null);//17. it is set null because it will not accept setcons of your image i1
     f.add(p1);//12.Add function is used to set the function on the top but here ot will not display because we had set the layout to null and we have to tell where to set this
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));//14.Use to apply image from the directory and classloader.getsystemresource will get icon from directory
     Image i2  = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);//18.Use to scale the image
     ImageIcon i3 = new ImageIcon(i2);//19.we cant add the image i2 directly into the JLabel so we have to again pass it in the image icon
//     JLabel back = new JLabel(i1); //15.Explanation later
     JLabel back = new JLabel(i3);
     back.setBounds(5,20,25,25);
     p1.add(back);//16.add() will add the image behind the panel so use p1.add() which will place it over image
     
      back.addMouseListener(new MouseAdapter()//22.Will close the main menu when clicked the back icon
        {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
      
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));//23.For profile picture , everything 
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));//24.to get video icon
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));//25.to get phonr icon
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));//26.to get more icon
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);
        
        JLabel name = new JLabel("Gaitonde");//27.JLabel is used to add name on your frame
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);//28.This will change the color of the name
        name.setFont(new Font("SAN_SERIF"/* contain font family*/, Font.BOLD, 18));//29.this help to change the font 
        p1.add(name);
        
        JLabel status = new JLabel("Active Now");//30.To add status ,if user is online or offline
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
//        JPanel a1 = new JPanel();//31.Making boundary marking for our text area 
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);
        
        //JTextField text = new JTextField();//33.JTextField is a class that will make a texbox for user where he can type anything
        text = new JTextField();//38.Now it has been declared gloabaly
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));//34. For enlarging the text you are writing
        f.add(text);
        
        JButton send = new JButton("Send");//35. This will make a button and what is written in "" will get displayed over your button
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);//36. Now we need to add some event over the button click and what event will be performed will be written in actionperfformed function
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
    
     f.setSize(450,700);//4.This function is used to set the size of the frame
     f.setLocation(200,50);//6.by default the frane open at origin but this helps to open it at particular location
     f.setUndecorated(true);//32.This will remove the headder of your frame
     f.getContentPane().setBackground(Color.WHITE);//8.getcontentpane() is use to get your frame and then we can set background using setBackgroound function,now to set color color class is used that is present in your awt package
     
     
     
     //7.Set visible should alwas be the last statement ecause you want it visible to user after all the changes have been done
     f.setVisible(true);//5.By default your frame is hidden so to make it visible this function is used
    }
    public void actionPerformed(ActionEvent ae)//21
    {
        try{
        String out = text.getText();//39.Now anything you write in text box will get stored in out
        
//        JLabel output = new JLabel(out);
//        
//        JPanel p2 = new JPanel();
        JPanel p2 = formatLabel(out);
//        p2.add(output);
        
        a1.setLayout(new BorderLayout());//41. Place your elements around the border and also in center
        JPanel right = new JPanel(new BorderLayout());//42. To display your message on right
        right.add(p2, BorderLayout.LINE_END);//44.This do not take the string so you have to take another label
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        
        a1.add(vertical, BorderLayout.PAGE_START);//45. Message will still not be displayed you have to repqint the textareaor you can say frame has to be reloaded 
        
        dout.writeUTF(out);
        
        text.setText("");//52. When you send the text it will empt your textbox
        
        f.repaint();
        f.invalidate();
        f.validate(); //46. These three will repaint the page,the message will just get visible int the frame now you have to make it display it in the box
        }catch(Exception e)
        {
          e.printStackTrace();
        }
     }
     public static JPanel formatLabel(String out)//47.To display the text in your box 
     {
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      
//      JLabel output = new JLabel( out );
      JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
      output.setFont(new Font("Tahoma", Font.PLAIN, 16));
      output.setBackground(new Color(37, 211, 102));
      output.setOpaque(true);
      output.setBorder(new EmptyBorder(15, 15, 15, 50));
      
      panel.add(output);
      
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
      JLabel time = new JLabel();
      time.setText(sdf.format(cal.getTime()));//51.Use to dynamically add time
        
      panel.add(time);
      
      return panel;
     }
    public static void main(String[] args)
    {
    new Server();//1.annonymous object
    try {
            ServerSocket skt = new ServerSocket(6001);
            while(true) {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                
                while(true) {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
