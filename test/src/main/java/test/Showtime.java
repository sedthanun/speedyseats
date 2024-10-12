package test;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.themes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;

public class Showtime extends JFrame {
    private class Showtimedetails {
        int showtimeID;
        DateFormat showtimeDateTime;
        // movie movie;   // Uncomment when Movie class is defined
        // theatre Theatre; // Uncomment when Theatre class is defined
        // seats seat;     // Uncomment when Seats class is defined
    }

    private JPanel seatsPanel;

    public Showtime() {
        setTitle("ShowtimeDemo");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel ที่แบ่งเป็น 2 ส่วน
        JPanel mainPanel = new JPanel(new GridLayout(1,2));

        // Left panel - โปสเตอ กับ คำอธิบาย
        JPanel leftPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Title: Sample Movie");
        JLabel genreLabel = new JLabel("Genre: Action");
        JLabel showtimeLabel = new JLabel("Showtime: None Selected");
        JPanel bord = new JPanel();
        JPanel bord2 = new JPanel();
        JPanel bord3 = new JPanel();
        bord.setPreferredSize(new Dimension(100,40));

        // Movie poster
        JLabel posterLabel = new JLabel("Movie Poster Here", SwingConstants.CENTER);
        posterLabel.setPreferredSize(new Dimension(10, 20));  // Set a fixed size
        posterLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Load image for poster
        ImageIcon posterImage = new ImageIcon("/C://Users//pleum/OneDrive//เดสก์ท็อป//IMG_2420.png"); // poster path
        posterLabel.setIcon(posterImage);  // Set the image as the poster
        leftPanel.add(posterLabel, BorderLayout.CENTER);

        // Movie details panel (title, genre, showtime)
        JPanel posterDescription = new JPanel(new GridLayout(3, 1));
        posterDescription.add(titleLabel);
        posterDescription.add(genreLabel);
        posterDescription.add(showtimeLabel);
        leftPanel.add(posterDescription, BorderLayout.SOUTH);
        leftPanel.add(bord,BorderLayout.WEST);
        leftPanel.add(bord2,BorderLayout.NORTH);


        // Right panel - for additional information
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // Middle panel - Showtime buttons
        JPanel middlePanel = new JPanel();
        ArrayList<JButton> showtimeButtons = createShowtimeButtons(showtimeLabel);

        for (JButton button : showtimeButtons) {
            middlePanel.add(button);
        }

        // Add panels to main panel

        mainPanel.add(leftPanel);
        mainPanel.add(middlePanel);


        // Adding main panel to the frame
        add(mainPanel);
    }

    private ArrayList<JButton> createShowtimeButtons(JLabel showtimeLabel) {
        ArrayList<JButton> buttons = new ArrayList<>();
        String[] showtimes = {"10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "10:00 PM"};

        for (String time : showtimes) {
            JButton button = new JButton(time);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showtimeLabel.setText("Showtime: " + time);
                }
            });
            buttons.add(button);
        }
        return buttons;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new Showtime().setVisible(true);
        });
    }
}
