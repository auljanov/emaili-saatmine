package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import application.SentItems;

public class MainPageViewSentItemsListner implements MouseListener {

	// actions on the "View Sent Items" button
	@Override
	public void mouseClicked(final MouseEvent e) {
		final SentItems sentItemsWindow = new SentItems();
		sentItemsWindow.populateTable();
		sentItemsWindow.setVisible(true);
	}

	@Override
	public void mousePressed(final MouseEvent e) {
	}

	@Override
	public void mouseReleased(final MouseEvent e) {
	}

	@Override
	public void mouseEntered(final MouseEvent e) {
	}

	@Override
	public void mouseExited(final MouseEvent e) {
	}
};