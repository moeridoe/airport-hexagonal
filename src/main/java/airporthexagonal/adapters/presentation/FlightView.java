package airporthexagonal.adapters.presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import airporthexagonal.core.ports.in.FindAirportUc;
import airporthexagonal.core.ports.in.FindFlightUc;
import airporthexagonal.domain.Flight;
import airporthexagonal.domain.FlightSearchCriteria;

public class FlightView extends JPanel {
	private static final long serialVersionUID = 1L;
	private final FindFlightUc findFlightUc;
	
	private static FlightSearchPanel searchPanel;
	private static FlightResultView resultView;
	
	private List<Flight> flightSearchResults = new ArrayList<>();

	public FlightView(FindFlightUc findFlightUc, FindAirportUc findAirportUc) {
		super();

		setBackground(ViewConstants.BACKGROUND);
		
		JButton submitButton = new JButton("Search Flights");
		ActionListener submitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (submitButton.equals(e.getSource())) {
					submitSearch(searchPanel.getFormValue());
				}
			}
		};
		submitButton.addActionListener(submitListener);
		
		searchPanel = new FlightSearchPanel(findAirportUc, submitButton);
		resultView = new FlightResultView();
		
		this.findFlightUc = findFlightUc;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel title = new JLabel("Flights");
		title.setFont(title.getFont().deriveFont(Font.BOLD));
		add(title);
		add(searchPanel);
		add(resultView);
		
		setVisible(true);
	}
	
	public void submitSearch(FlightSearchCriteria flightSearchCriteria) {
		flightSearchResults = findFlightUc.findFlightsByCriteria(flightSearchCriteria);
		resultView.buildFlightResultView(flightSearchResults);
	}
}
