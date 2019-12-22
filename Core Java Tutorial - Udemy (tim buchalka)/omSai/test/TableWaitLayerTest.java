import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import javax.swing.table.*;

public class TableWaitLayerTest {
  private final String[] columnNames = {"String", "Integer", "Boolean"};
  private final Object[][] data = {
    {"aaa", 12, true}, {"bbb", 5, false}, {"ccc", 9, false},
  };
  private final DefaultTableModel model = new DefaultTableModel(data, columnNames) {
    @Override public Class<?> getColumnClass(int column) {
      return getValueAt(0, column).getClass();
    }
  };
  private final JTable table = new JTable(model);
  private final JButton startButton = new JButton();
  private final WaitLayerUI layerUI = new WaitLayerUI();
  public JComponent makeUI() {
    startButton.setAction(new AbstractAction("start") {
      @Override public void actionPerformed(ActionEvent e) {
        layerUI.start();
       
        
       }
    });
    JPanel p = new JPanel(new BorderLayout());
    //p.add(new JButton("dummy"), BorderLayout.NORTH);
    p.add(new JLayer<JComponent>(new JScrollPane(table), layerUI));
    p.add(startButton, BorderLayout.SOUTH);
    return p;
  }
  public static void main(String[] args) {
   
    createAndShowGUI();
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new TableWaitLayerTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
