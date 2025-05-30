/**
 * 
 */
package hust.soict.hedspi.aims.screen.manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

/**
 * 
 */
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField tfDirector;
    private JTextField tfLength;
    
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }
    
    @Override
    protected JPanel createCenter() {
        JPanel center = super.createCenter();
        
        JPanel directorPanel = new JPanel();
        directorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDirector = new JLabel("Director: ");
        tfDirector = new JTextField(30);
        directorPanel.add(lblDirector);
        directorPanel.add(tfDirector);
        center.add(directorPanel);
        
        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblLength = new JLabel("Length: ");
        tfLength = new JTextField(10);
        lengthPanel.add(lblLength);
        lengthPanel.add(tfLength);
        center.add(lengthPanel);
        
        JPanel btnPanel = new JPanel();
        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore();
            }
        });
        btnPanel.add(addButton);
        center.add(btnPanel);
        
        return center;
    }
    
    @Override
    protected void addItemToStore() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = 0;
            
            if (!tfLength.getText().isEmpty()) {
                length = Integer.parseInt(tfLength.getText());
            }
            
            DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
            
            store.addMedia(newDVD);
            
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            
            tfId.setText("");
            tfTitle.setText("");
            tfCategory.setText("");
            tfCost.setText("");
            tfDirector.setText("");
            tfLength.setText("");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding DVD: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
