
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JavaGUI extends JFrame {

    JButton tombol;
    ButtonGroup G = new ButtonGroup();
    JLabel judul = new JLabel();
    final JTextArea[] input = new JTextArea[2];

    public JavaGUI() {
        this.setTitle("Program Nge-ALAY");
        this.setSize(600, 800);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

        this.add(judul);
        judul.setFont(new Font("Calibri", Font.BOLD, 25));
        judul.setText(": : ALAY&RAHASIA2AN Yuk : :");
        judul.setBounds(100, 10, 500, 50);

        for (int i = 0; i < 2; i++) {
            input[i] = new JTextArea();
            this.add(input[i]);
            input[i].setBounds(75, (i * 220) + 80, 450, 200);
        }

        input[1].setEditable(false);

        final JRadioButton alay;
        alay = new JRadioButton();
        this.add(alay);
        alay.setFont(new Font("Calibri", Font.BOLD, 20));
        alay.setBounds(350, 575, 75, 20);
        alay.setText("Alay");

        final JRadioButton cecar;
        cecar = new JRadioButton();
        this.add(cecar);
        cecar.setFont(new Font("Calibri", Font.BOLD, 20));
        cecar.setBounds(450, 575, 75, 20);
        cecar.setText("Cecar");

        JRadioButton normal;
        normal = new JRadioButton();
        this.add(normal);
        normal.setFont(new Font("Calibri", Font.BOLD, 20));
        normal.setBounds(400, 625, 100, 20);
        normal.setText("Normal");

        G.add(alay);
        G.add(cecar);
        G.add(normal);

        tombol = new JButton();
        this.add(tombol);
        tombol.setBounds(350, 680, 150, 60);
        tombol.setFont(new Font("Calibri", Font.BOLD, 25));
        tombol.setText("PROSES");
        tombol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (alay.isSelected()) {//fix
                    String line = input[0].getText();
                    int vowels = 0, baru = 0;
                    for (int i = 0; i < line.length(); i++) {
                        char ch = line.charAt(i);
                        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o'
                                || ch == 'A' || ch == 'I' || ch == 'E' || ch == 'O' || ch == 'U' || ch == 'u') {
                            ++vowels;
                        }
                    }

                    String[][] alay
                            = {{"a", "4"}, {"b", "8"}, {"e", "3"}, {"i", "!"}, {"k", "ʞ"}, {"l", "£"},
                            {"o", "0"}, {"s", "$"}, {"y", "¥"}, {"A", "4"}, {"B", "8"}, {"E", "3"},
                            {"I", "!"}, {"K", "ʞ"}, {"L", "£"}, {"O", "0"}, {"S", "$"}, {"Y", "¥"}};
                    for (String[] replacement : alay) {
                        line = line.replace(replacement[0], replacement[1]);
                    }

                    for (int i = 0; i < line.length(); i++) {
                        char ch = line.charAt(i);
                        if (ch == 'U' || ch == 'u') {
                            ++baru;
                        }
                    }

                    input[1].setText(
                            "" + line + "\n\n"
                            + "Jumlah Karakter Kalimat Asli ada " + input[0].getText().length() + "\n"
                            + "Jumlah Huruf Vokal Kalimat Asli ada " + vowels + "\n\n"
                            + "Jumlah Karakter Setelah dienkripsi ada " + input[0].getText().length() + "\n"
                            + "Jumlah Huruf Vokal setelah dienkripsi ada " + baru
                    );

                } else if (cecar.isSelected()) {
                    String line = input[0].getText(), newcecar = "";
                    int vowels = 0, baru = 0,num=0;
                    for (int i = 0; i < line.length(); i++) {
                        char abc = line.charAt(i);
                        if (abc >= 'a' && abc <= 'z') {
                            if(abc=='x'){
                                abc='a';
                                newcecar=newcecar+abc;
                            }
                            else if (abc=='y'){
                                abc='b';
                                newcecar = newcecar + abc;                               
                            }
                            else if (abc=='z'){
                                abc='c';
                                newcecar = newcecar + abc;                               
                            }
                            else{
                                abc = (char) (abc + 3);
                                newcecar = newcecar + abc;                               
                            }
                        } else if (abc >= 'A' && abc <= 'Z') {
                            if(abc=='X'){
                                abc='A';
                                newcecar=newcecar+abc;
                            }
                            else if (abc=='Y'){
                                abc='B';
                                newcecar = newcecar + abc;                               
                            }
                            else if (abc=='Z'){
                                abc='C';
                                newcecar = newcecar + abc;                               
                            }
                            else{
                                abc = (char) (abc + 3);
                                newcecar = newcecar + abc;                               
                            }
                        } else if (abc == ' ') {
                            newcecar = newcecar + abc;
                        } else if(abc == '\n'){
                            num++;
                        } else {
                            num++;
                            newcecar = newcecar.replaceAll("^[A-Za-z0-9]\\s", "");
                        }
                    }

                    for (int i = 0; i < line.length(); i++) {
                        char ch = line.charAt(i);
                        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u'
                                || ch == 'A' || ch == 'I' || ch == 'E' || ch == 'O' || ch == 'U') {
                            ++vowels;
                        }
                    }
                    for (int i = 0; i < newcecar.length(); i++) {
                        char ch = newcecar.charAt(i);
                        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u'
                                || ch == 'A' || ch == 'I' || ch == 'E' || ch == 'O' || ch == 'U') {
                            ++baru;
                        }
                    }

                    input[1].setText(
                            "" + newcecar + "\n\n"
                            + "Jumlah Karakter Kalimat Asli ada " + input[0].getText().length() + "\n"
                            + "Jumlah Huruf Vokal Kalimat Asli ada " + vowels + "\n\n"
                            + "Jumlah Karakter Setelah dienkripsi ada " + (input[0].getText().length()-num) + "\n"
                            + "Jumlah Huruf Vokal setelah dienkripsi ada " + baru
                    );
                } else {
                    input[1].setText(input[0].getText());
                }
            }
        });

        tombol = new JButton();
        this.add(tombol);
        tombol.setBounds(180, 620, 120, 60);
        tombol.setFont(new Font("Calibri", Font.BOLD, 25));
        tombol.setText("CLEAR");
        tombol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                input[0].setText("");
                input[1].setText("");
                G.clearSelection();
            }
        });

        tombol = new JButton();
        this.add(tombol);
        tombol.setBounds(180, 550, 120, 60);
        tombol.setFont(new Font("Calibri", Font.BOLD, 25));
        tombol.setText("SAVE");
        tombol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String line = input[1].getText();
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("/home/me/Documents"));
                int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileWriter save = new FileWriter(chooser.getSelectedFile() + ".txt");
                        save.write(line);
                        save.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        tombol = new JButton();
        this.add(tombol);
        tombol.setBounds(50, 550, 120, 60);
        tombol.setFont(new Font("Calibri", Font.BOLD, 25));
        tombol.setText("OPEN");
        tombol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("/home/me/Documents"));
                int retrival = chooser.showOpenDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    input[0].setText("");
                    try {
                        File selectedFile = chooser.getSelectedFile();
                        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                        String line;
                        while ((line = br.readLine()) != null) {
                            input[0].append(line);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        tombol = new JButton();
        this.add(tombol);
        tombol.setBounds(50, 620, 120, 60);
        tombol.setFont(new Font("Calibri", Font.BOLD, 25));
        tombol.setText("WRAP");
    }
}
