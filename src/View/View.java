package View;

import Controller.Controller;
import Model.Board;
import Model.plr;
import Model.tl;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_BLUEPeer;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static java.lang.Integer.parseInt;

public class View extends JFrame{
    private JLayeredPaneExtension basic_panel,dice1,dice2,logo,jackpot_img,card1,card2;
    private JLayeredPane player1,player2,Info_box;
    private final ClassLoader cldr;
    private JButton Roll1,Roll2,MDC1,MDC2,Get_l1,Get_l2,End1,End2;
    private JLabel jackpot_txt,money1,money2,loan1,loan2,bills1,bills2,head1,head2,headI,months_inf,turn_inf,event;
    private final JLayeredPaneExtension[][] tiles = new JLayeredPaneExtension[5][7];
    private JLabel[][] days = new JLabel[5][7];

    public View(){
        cldr = this.getClass().getClassLoader();
        setSize(1920,1080);
        setResizable(true);
        setTitle("PayDay");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initComp();
    }

    public void updateDie(int player,int d,plr plr){
        URL imageURL = cldr.getResource("Hy252_Project/images/dice-"+d+".jpg");
        Image image = new ImageIcon("src/images/dice-"+d+".jpg").getImage();
        if(plr.getPos()+d>=31){
            plr.setPos(31);
        }else{
            plr.setPos(plr.getPos()+d);
        }
        if(player == 1){
            dice1 = new JLayeredPaneExtension(image);
            player1.add(dice1,0);
            player1.repaint();
        }else{
            dice2 = new JLayeredPaneExtension(image);
            player2.add(dice2,0);
            player2.repaint();
        }

    }
    public void updatePlayer(plr player,int plr){
        if(plr ==1){
            money1.setText("Money: "+player.getMoney()+" Euros");
            loan1.setText("Loan: "+player.getLoans()+" Euros");
            bills1.setText("Bills: "+player.getBills()+" Euros");
            player1.repaint();
        }else{
            money2.setText("Money: "+player.getMoney()+" Euros");
            loan2.setText("Loan: "+player.getLoans()+" Euros");
            bills2.setText("Bills: "+player.getBills()+" Euros");
            player2.repaint();
        }

    }

    public void updateTiles(tl[][] Tile){
        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                if(i==4&&j==4){
                    break;
                }
                Image image = new ImageIcon("src/images/"+Tile[i][j].getImage()).getImage();
                image = image.getScaledInstance(185,143,Image.SCALE_SMOOTH);
                tiles[i][j]= new JLayeredPaneExtension(image);

                basic_panel.add(tiles[i][j]);
            }
        }
    }
    public void updateMonth(int months){
        months_inf.setText(months+" Month(s) Left");
        Info_box.repaint();
    }
    public void updateEvent(String ev){
        event.setText("->"+ev);
        Info_box.repaint();
    }
    public void initComp(){
        URL imageURL = cldr.getResource("src/images/bg_green.png");
        assert imageURL != null;
        Image image = new ImageIcon("src/images/bg_green.png").getImage().getScaledInstance(1920,1080,Image.SCALE_SMOOTH);
        basic_panel = new JLayeredPaneExtension(image);
        basic_panel.setBounds(0,0,1920,1080);
        basic_panel.setOpaque(true);

        imageURL = cldr.getResource("src/images/logo.png");
        assert imageURL != null;
        image = new ImageIcon("src/images/logo.png").getImage();
        image = image.getScaledInstance(1300,180,Image.SCALE_SMOOTH);
        logo = new JLayeredPaneExtension(image);
        logo.setBounds(0,0,1300,180);
        logo.setOpaque(true);


        imageURL = cldr.getResource("src/images/jackpot.png");
        image= new ImageIcon("src/images/jackpot.png").getImage();
        image = image.getScaledInstance(350,125, Image.SCALE_SMOOTH);

        jackpot_img = new JLayeredPaneExtension(image);
        jackpot_img.setBounds(840,920,350,125);
        jackpot_img.setOpaque(true);


        jackpot_txt = new JLabel();
        jackpot_txt.setText("Jackpot: 3000 Euros");
        jackpot_txt.setForeground(Color.WHITE);
        jackpot_txt.setBounds(840,1057,350,22);
        jackpot_txt.setOpaque(true);

        player1 = new JLayeredPane();
        player1.setBounds(1350,20,515,360);
        player1.setOpaque(true);
        player1.setBackground(Color.WHITE);

        player2 = new JLayeredPane();
        player2.setBounds(1350,700,515,360);
        player2.setOpaque(true);
        player2.setBackground(Color.WHITE);

        imageURL = cldr.getResource("src/images/dice-1.png");
        image = new ImageIcon("src/images/dice-1.png").getImage();
        image = image.getScaledInstance(105,80,Image.SCALE_SMOOTH);

        dice1= new JLayeredPaneExtension(image);
        dice1.setBounds(1723,235,105,80);
        dice1.setOpaque(true);
        player1.add(dice1,0);

        dice2 = new JLayeredPaneExtension(image);
        dice2.setBounds(1723,920,105,80);
        dice2.setOpaque(true);
        player2.add(dice2,0);

        money1 = new JLabel();
        money1.setText("Money: 3500 Euros");
        money1.setBounds(1372,102,261,22);
        loan1=new JLabel();
        loan1.setText("Loan: 0 Euros");
        loan1.setBounds(1372,147,261,22);
        bills1 = new JLabel();
        bills1.setText("Bills: 0 Euros");
        bills1.setBounds(1372,192,261,22);
        head1 = new JLabel();
        head1.setText("Player 1");
        head1.setBounds(1372,46,261,22);
        Font font = new  Font("Courier",Font.BOLD,22);
        head1.setFont(font);

        player1.add(head1,0);
        player1.add(money1,0);
        player1.add(loan1,0);
        player1.add(bills1,0);

        money2 = new JLabel();
        money2.setText("Money: 3500 Euros");
        money2.setBounds(1372,788,261,22);
        loan2 = new JLabel();
        loan2.setText("Loan: 0 Euros");
        loan2.setBounds(1372,832,261,22);
        bills2 = new JLabel();
        bills2.setText("Bills: 0 Euros");
        bills2.setBounds(1372,878,261,22);
        head2 = new JLabel();
        head2.setText("Player 2");
        head2.setBounds(1372,732,261,22);
        head2.setFont(font);

        player2.add(head2,0);
        player2.add(money2,0);
        player2.add(loan2,0);
        player2.add(bills2,0);

        imageURL = cldr.getResource("Hy252_Project/images/mailCard.png");
        image = new ImageIcon("src/images/mailCard.png").getImage();
        image = image.getScaledInstance(230,87,Image.SCALE_SMOOTH);
        card1 = new JLayeredPaneExtension(image);
        card1.setBounds(1351,569,230,87);
        card1.setOpaque(true);

        imageURL = cldr.getResource("Hy252_Project/images/dealCard.png");
        image = new ImageIcon("src/images/dealCard.png").getImage();
        image = image.getScaledInstance(230,87,Image.SCALE_SMOOTH);
        card2 = new JLayeredPaneExtension(image);
        card2.setBounds(1631,569,230,87);
        card2.setOpaque(true);


        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                if(i==4&&j==4){
                    break;
                }
                days[i][j] = new JLabel();
                if(i==j&&i==0){
                    days[i][j].setText("Start");
                }else{
                    switch(j){
                        case 0:
                            days[i][j].setText("Sunday "+((i*7)+j));
                            break;
                        case 1:
                            days[i][j].setText("Monday "+((i*7)+j));
                            break;
                        case 2:
                            days[i][j].setText("Tuesday "+((i*7)+j));
                            break;
                        case 3:
                            days[i][j].setText("Wednesday "+((i*7)+j));
                            break;
                        case 4:
                            days[i][j].setText("Thursday "+((i*7)+j));
                            break;
                        case 5:
                            days[i][j].setText("Friday "+((i*7)+j));
                            break;
                        case 6:
                            days[i][j].setText("Saturday "+((i*7)+j));
                            break;
                    }
                }
                days[i][j].setBackground(Color.YELLOW);
                days[i][j].setBounds(j*186,((i+1)*180)+2,185,33);
                days[i][j].setOpaque(true);
                basic_panel.add(days[i][j],0);
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                if(i==4&&j==4){
                    break;
                }
                image = new ImageIcon("src/images/start.png").getImage();
                image = image.getScaledInstance(185,143,Image.SCALE_SMOOTH);
                tiles[i][j]= new JLayeredPaneExtension(image);
                tiles[i][j].setBounds(j*186,((i+1)*217),185,143);
                tiles[i][j].setOpaque(true);
                basic_panel.add(tiles[i][j]);
            }
        }


        Info_box = new JLayeredPane();
        Info_box.setBounds(1351,398,511,140);
        Info_box.setOpaque(true);
        Info_box.setBackground(Color.WHITE);

        headI = new JLabel();
        headI.setText("Info Box");
        headI.setBounds(1356,407,103,17);

        months_inf = new JLabel();
        months_inf.setBounds(1361,437,164,18);

        turn_inf = new JLabel();
        turn_inf.setBounds(1361,464,180,19);

        event=new JLabel();
        event.setBounds(1359,493,260,19);

        Info_box.add(event,0);
        Info_box.add(turn_inf,0);
        Info_box.add(months_inf,0);
        Info_box.add(headI,0);

        Roll1 = new JButton("Roll Dice");
        Roll1.setName("Roll1");
        Roll1.setBounds(1374,235,279,35);
        Roll1.addActionListener(new DiceListener());
        Roll1.setOpaque(true);

        Get_l1=new JButton("Get Loan");
        Get_l1.setName("Loan1");
        Get_l1.setBounds(1374,325,221,35);
        Get_l1.addActionListener(new GetLoans());
        Get_l1.setOpaque(true);

        End1 = new JButton("End Turn");
        End1.setName("End1");
        End1.setBounds(1607,325,233,35);
        End1.addActionListener(new EndTurn());
        End1.setOpaque(true);

        player1.add(Roll1,0);
        player1.add(Get_l1,0);
        player1.add(End1);


        Roll2 = new JButton("Roll Dice");
        Roll2.setName("Roll2");
        Roll2.setBounds(1374,920,279,35);
        Roll2.addActionListener(new DiceListener());
        Roll2.setOpaque(true);

        Get_l2=new JButton("Get Loan");
        Get_l2.setName("Loan2");
        Get_l2.setBounds(1374,1010,279,35);
        Get_l2.addActionListener(new GetLoans());
        Get_l2.setOpaque(true);

        End2 = new JButton("End Turn");
        End2.setName("End2");
        End2.setBounds(1602,325,233,35);
        End2.addActionListener(new EndTurn());
        End2.setOpaque(true);

        player2.add(Roll2,0);
        player2.add(Get_l2);
        player2.add(End2);
        player1.setVisible(true);
        player2.setVisible(true);
        basic_panel.add(logo,0);
        basic_panel.add(card1,0);
        basic_panel.add(card2,0);
        basic_panel.add(player2);
        basic_panel.add(player1);
        basic_panel.add(jackpot_txt,0);
        basic_panel.add(jackpot_img,0);
        this.add(basic_panel,0);
        this.pack();
        this.setVisible(true);
    }
    private class DiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getName().equals("Roll1")){
                int d = Controller.dice();
                updateDie(1,d,Controller.getPlayer(1));
            }else if(button.getName().equals("Roll2")){
                int d = Controller.dice();
                updateDie(2,d,Controller.getPlayer(2));
            }
        }
    }
    private class DealCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button =(JButton) e.getSource();
        }
    }
    private class GetLoans implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int amount = parseInt(JOptionPane.showInputDialog("Input loan amount:"));
            if(button.getName().equals("Loan1")){
                Controller.p1.addLoan(amount);
                updatePlayer(Controller.p1,1);
                player1.repaint();
            }else{
                Controller.p2.addLoan(amount);
                updatePlayer(Controller.p2,2);
                player2.repaint();
            }
        }
    }
    private class EndTurn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button =(JButton) e.getSource();
            if (button.getName().equals("end1")) {
                Controller.p1.forbid();
                Controller.p2.allow();
            }else{
                Controller.p2.forbid();
                Controller.p1.allow();
            }
        }
    }
}
