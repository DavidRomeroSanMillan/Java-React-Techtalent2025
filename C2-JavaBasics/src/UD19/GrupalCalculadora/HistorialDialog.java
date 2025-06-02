
package UD19.GrupalCalculadora;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistorialDialog extends JDialog {
	public HistorialDialog(JFrame parent, List<String> historial) {
		super(parent, "Historial", true);
		setBounds(150, 150, 261, 425);


		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = historial.size() - 1; i >= 0; i--) {
			listModel.addElement(historial.get(i));
		}

		JList<String> list = new JList<>(listModel);
		list.setFont(new Font("Arial", Font.BOLD, 18));
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(48, 51, 74));
		JScrollPane scrollPane = new JScrollPane(list);

		add(scrollPane, BorderLayout.CENTER);
	}
}
