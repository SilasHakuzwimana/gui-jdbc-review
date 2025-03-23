import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private JTable table;

    public ButtonEditor(JTable table) {
        this.table = table;
        button = new JButton("View");
        button.setBackground(Color.GREEN);
        button.setForeground(Color.WHITE);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int id = (int) table.getValueAt(row, 0);
                    String firstName = (String) table.getValueAt(row, 1);
                    String lastName = (String) table.getValueAt(row, 2);
                    String gender = (String) table.getValueAt(row, 3);
                    
                    JOptionPane.showMessageDialog(null, "Viewing Details:\nID: " + id + "\nName: " + firstName + " " + lastName + "\nGender: " + gender);
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }
}
