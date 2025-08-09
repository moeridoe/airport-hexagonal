package airporthexagonal.adapters.presentation;

import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import airporthexagonal.core.ports.in.FindAirportUc;
import airporthexagonal.domain.Airport;
import airporthexagonal.domain.FlightSearchCriteria;

public class FlightSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final FindAirportUc findAirportUc;
	
	private List<Airport> airportSearchResults = new ArrayList<>();
	private JTextField fromAirport = new JTextField();
	private JTextField toAirport = new JTextField();
	private JTextField earliestDeparture = new JTextField();
	
	public FlightSearchPanel(FindAirportUc findAirportUc, JButton submitButton) {
		this.findAirportUc = findAirportUc;
		setBackground(ViewConstants.BACKGROUND);
		
		JPanel vBox = new JPanel();
		vBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		vBox.setLayout(new BoxLayout(vBox, BoxLayout.Y_AXIS));
		vBox.setBackground(ViewConstants.CONTAINER_BACKGROUND);
		
		JPanel hBox1 = new JPanel();
		hBox1.setLayout(new BoxLayout(hBox1, BoxLayout.X_AXIS));
		hBox1.setBackground(ViewConstants.CONTAINER_BACKGROUND);
		fromAirport.setPreferredSize(new Dimension(200, 30));
		hBox1.add(new JLabel("from"));
		hBox1.add(fromAirport);

		toAirport.setPreferredSize(new Dimension(200, 30));
		hBox1.add(new JLabel("to"));
		hBox1.add(toAirport);
		vBox.add(hBox1);
		
		JPanel hBox2 = new JPanel();
		hBox2.setLayout(new BoxLayout(hBox2, BoxLayout.X_AXIS));
		hBox2.setBackground(ViewConstants.CONTAINER_BACKGROUND);
		hBox2.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		earliestDeparture.setPreferredSize(new Dimension(200, 30));
		hBox2.add(new JLabel("departure"));
		hBox2.add(earliestDeparture);
		vBox.add(hBox2);
		
		JPanel hBox3 = new JPanel();
		hBox3.setLayout(new BoxLayout(hBox3, BoxLayout.X_AXIS));
		hBox3.setBackground(ViewConstants.CONTAINER_BACKGROUND);
		hBox3.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		hBox3.add(submitButton);
		vBox.add(hBox3);
		
		add(vBox);
	}

	public List<Airport> findAirportsByInput(String input) {
		airportSearchResults = new ArrayList<>();
		if(input.length() > 1) {
			airportSearchResults = findAirportUc.findAirportsByCodeOrName(input);
		}
		return airportSearchResults;
	}
	
	public FlightSearchCriteria getFormValue() {
		Airport from = null;
		Airport to = null;
		LocalDate earliestDeparture = null;
		findAirportsByInput(this.fromAirport.getText());
		if (airportSearchResults.size() > 0) from = airportSearchResults.getFirst();
		findAirportsByInput(this.toAirport.getText());
		if (airportSearchResults.size() > 0) to = airportSearchResults.getFirst();
		if (this.earliestDeparture.getText().length() == 10) earliestDeparture = LocalDate.parse(this.earliestDeparture.getText());
		return FlightSearchCriteria
				.builder()
				.fromAirport(from)
				.toAirport(to)
				.earliestDeparture(earliestDeparture)
				.build();
	}
}
