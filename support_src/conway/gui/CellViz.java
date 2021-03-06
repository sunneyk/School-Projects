package conway.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import conway.Conway;

public class CellViz extends JLabel {
	private static final long serialVersionUID = 1L;

	public CellViz(final Cell c, int cellWidth, final int row, final int col, final Conway conway) {
		this.setSize(cellWidth, cellWidth);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setOpaque(true);

		c.getPCS().addPropertyChangeListener(
				"live",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						boolean alive = (Boolean) evt.getNewValue();
						displayLiveness(alive);
					}

				});

		this.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean isAlive = conway.isAlive(row, col);
						isAlive = !isAlive;
						conway.setAlive(isAlive, row, col);
						displayLiveness(isAlive);
					}
				});

	}

	public void displayLiveness(boolean isLive) {
		setBackground(isLive ? Color.BLACK : Color.WHITE);
	}

}
