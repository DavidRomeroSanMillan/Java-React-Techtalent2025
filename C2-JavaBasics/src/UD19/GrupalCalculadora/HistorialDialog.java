
package UD19.GrupalCalculadora;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistorialDialog extends JDialog {
	public HistorialDialog(JFrame parent, List<String> historial) {
		super(parent, "Historial", true);
		setSize(300, 400);
		setLocationRelativeTo(parent);

		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = historial.size() - 1; i >= 0; i--) {
			listModel.addElement(historial.get(i));
		}

		JList<String> list = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);

		add(scrollPane, BorderLayout.CENTER);
	}
}
