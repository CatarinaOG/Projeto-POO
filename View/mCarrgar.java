package View;
import java.util.Scanner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mCarrgar {
    private JPanel cEquipa;
    private JTextField escolheAEquipa;
    private JLabel escolherE, Equipas;
    private Scanner Equipa;


    public mCarrgar() {
        escolheAEquipa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipa = new Scanner(System.in);
                JOptionPane.showMessageDialog(null, "Erro nao existe essa equipa");
            }
        });
    }

    static public void carregarFrame(){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new mCarrgar().cEquipa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
