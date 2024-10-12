package payment;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RoundedPanel extends JPanel {

    public RoundedPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // กำหนดให้ขอบมน 30px
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); // เปลี่ยนสีขอบให้เป็นสีเดียวกับพื้นหลัง
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RoundedPanel panel = new RoundedPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
