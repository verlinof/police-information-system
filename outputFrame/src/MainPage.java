import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainPage extends JFrame {

    private JButton inputbtn;
    private JButton updatebtn;
    private JButton sortbtn;
    private JPanel MainPage;

    public MainPage(JFrame parent) {
        setTitle("Main Page");
        setContentPane(MainPage);
        setMinimumSize(new Dimension(500, 400));
        setResizable(false);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        //halaman update
        updatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new outputForm();

            }
        });
        //halaman sorting kasus
        sortbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new outputSortingForm();

            }
        });
        //halaman input kasus
        inputbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputGUI(null);

            }
        });
    }

}
