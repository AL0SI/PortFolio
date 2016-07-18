import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by q on 18.07.2016.
 */
public class MainFrame extends JFrame {
    private JPanel panel1;
    private JButton shemeButton;
    private JButton fileCalcButton1;
    private JButton fileRezButton = new JButton();
    private JLabel Sheme;
   static   JTextArea textArea1 = new JTextArea();
    private JButton validateButton;
    JLabel label1 = new JLabel();
    Control control;


    public static void main(String[] args) {
        MainFrame app = new MainFrame();
        app.setVisible(true);
        app.pack();

    }
    static void setrezult(String string){
        textArea1.setText(string);
    }
    MainFrame() {
        super("XmlCalculator");
        iniGUI();
        buttos();
        control = new Control();

    }

    private void buttos() {
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callvalid();


            }
        });
        shemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileopen = new JFileChooser();

                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();

                    control.sheme(file);
                }
            }

        });
        fileCalcButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileopen = new JFileChooser();

                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();

                    control.calc(file);
                }

            }
        });
        fileRezButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (callvalid()) {
                    try {
                        control.calculate();
                    } catch (SAXException e1) {
                        e1.printStackTrace();
                    } catch (TransformerException e1) {
                        e1.printStackTrace();
                    } catch (ParserConfigurationException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
    }

    private boolean callvalid() {
        try {
            String valid = control.valid();
            switch (valid) {
                case "1":
                    textArea1.setText("не хватает данных");return false;

                case "2":
                    label1.setText("InValid");return false;

                case "3":
                    label1.setText("Valid");textArea1.setText("");return true;

            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        }
return false;
    }

    private void iniGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        setLocationRelativeTo(getOwner());
        contentPane.setLayout(new BorderLayout(10, 10));

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(300, 200));
        contentPane.add(panel1);
        panel1.setLayout(new BorderLayout(0, 0));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 1));
        panel1.add(panel2, BorderLayout.EAST);
        shemeButton = new JButton();
        shemeButton.setText("Scheme");
        panel2.add(shemeButton);

        fileCalcButton1 = new JButton();
        fileCalcButton1.setText("FileCalc");
        panel2.add(fileCalcButton1);
        fileRezButton = new JButton();
        fileRezButton.setText("Calc");
        panel2.add(fileRezButton);

        validateButton.setText("Validate");
        panel2.add(validateButton);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        panel1.add(panel3, BorderLayout.CENTER);
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 2));

        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 1));
        panel3.add(panel5);
        JScrollPane scrollPane1 = new JScrollPane();
        panel5.add(scrollPane1);

        textArea1.setEditable(false);
        textArea1.setText("Выберите файл схемы для проверки, кнопка Scheme." +"\r\n"+"Выберите файл с заданием, кнопка FileCalc. "+"\r\n"+ "Можете провести проверку соответствия схеме, кнопка Validate."+"\r\n"+"Или сразу приступить к формированию файла с вычислениями, кнопка Calc.");
        scrollPane1.setViewportView(textArea1);
        panel1.add(panel4, BorderLayout.SOUTH);

        Sheme = new JLabel();
        Sheme.setText("Validate :");
        panel4.add(Sheme);

        label1.setText("");
        panel4.add(label1);


    }


}
