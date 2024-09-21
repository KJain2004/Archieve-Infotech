import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp {
    private static long elapsedTime = 0;
    private static boolean running = true; 
    private static Timer timer;
    private static JLabel timeLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Timer App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new FlowLayout());

            timeLabel = new JLabel("Elapsed Time: 0 seconds");
            JButton runButton = new JButton("Run");
            JButton pauseButton = new JButton("Pause");

            startTimer();

            runButton.addActionListener(e -> {
                if (!running) {
                    running = true;
                    startTimer(); // Resume the timer
                }
            });

            pauseButton.addActionListener(e -> {
                if (running) {
                    running = false;
                    timer.stop(); // Pause the timer
                }
            });

            frame.add(timeLabel);
            frame.add(runButton);
            frame.add(pauseButton);

            frame.setVisible(true);
        });
    }

    private static void startTimer() {
        timer = new Timer(1000, e -> {
            elapsedTime++;
            updateTimerDisplay();
        });
        timer.start();
    }

    private static void updateTimerDisplay() {
        timeLabel.setText("Elapsed Time: " + elapsedTime + " seconds");
    }
}
