package airporthexagonal.adapters.presentation;

import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import airporthexagonal.domain.Flight;

public class FlightResultView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public FlightResultView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(ViewConstants.BACKGROUND);
	}
	
	public void buildFlightResultView(List<Flight> flightSearchResults) {
		removeAll();
		
		String[] tableHeaders = { "From", "To", "Departure", "Arrival", "Price" };
		String[][] data = new String[flightSearchResults.size()][tableHeaders.length];
		for (int i = 0; i < flightSearchResults.size(); i++) {
			Flight f = flightSearchResults.get(i);
			String[] rowData = {
					f.getLane().getOrigin().getName() + " (" + f.getLane().getOrigin().getCode() + ")",  
					f.getLane().getDestination().getName() + " (" + f.getLane().getDestination().getCode() + ")",
					f.getDeparture().toString(),
					f.getArrival().toString(),
					String.format("%.2f", f.getPrice()) + " €"
			};
			data[i] = rowData;
		}
		JTable table = new JTable(data, tableHeaders);
		table.setBackground(ViewConstants.BLUE_PRIMARY);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(ViewConstants.BLUE_ACCENT);
		table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
		table.setGridColor(ViewConstants.CONTAINER_BACKGROUND);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(ViewConstants.BACKGROUND);
		add(scrollPane);
		
		revalidate();
		repaint();
	}
}
