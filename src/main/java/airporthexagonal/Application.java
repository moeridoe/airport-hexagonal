package airporthexagonal;

import java.time.LocalDate;

import airporthexagonal.adapters.dataaccess.inmemory.AirplaneInMemoryRepository;
import airporthexagonal.adapters.dataaccess.inmemory.AirportInMemoryRepository;
import airporthexagonal.adapters.dataaccess.inmemory.FlightInMemoryRepository;
import airporthexagonal.adapters.dataaccess.inmemory.LaneInMemoryRepository;
import airporthexagonal.adapters.presentation.FlightView;
import airporthexagonal.adapters.presentation.MainView;
import airporthexagonal.core.ports.in.FindAirportUc;
import airporthexagonal.core.ports.in.FindFlightUc;
import airporthexagonal.core.ports.out.AirplaneRepository;
import airporthexagonal.core.ports.out.AirportRepository;
import airporthexagonal.core.ports.out.FlightRepository;
import airporthexagonal.core.ports.out.LaneRepository;
import airporthexagonal.core.usecases.FindAirportUcImpl;
import airporthexagonal.core.usecases.FindFlightUcImpl;
import airporthexagonal.domain.Airplane;
import airporthexagonal.domain.Airport;
import airporthexagonal.domain.Flight;
import airporthexagonal.domain.Lane;

public class Application {
	private final static AirplaneRepository airplaneRepo = new AirplaneInMemoryRepository();
	private final static AirportRepository airportRepo = new AirportInMemoryRepository();
	private final static LaneRepository laneRepo = new LaneInMemoryRepository();
	private final static FlightRepository flightRepo = new FlightInMemoryRepository();
	
	private final static FindFlightUc findFlightUc = new FindFlightUcImpl(flightRepo);
	private final static FindAirportUc findAirportUc = new FindAirportUcImpl(airportRepo);

	public static void main(String[] args) {
		createMasterData();
		createFlightData();
		
		new MainView().setActiveView(new FlightView(findFlightUc, findAirportUc));
	}
	
	private static void createMasterData() {
		airplaneRepo.save(new Airplane("Boeing-737", "B101"));
		airplaneRepo.save(new Airplane("Boeing-787", "B201"));
		airplaneRepo.save(new Airplane("Airbus-A320", "A101"));
		airplaneRepo.save(new Airplane("Airbus-A330neo", "A201"));
		
		airportRepo.save(new Airport("DEDUS", "Düsseldorf"));
		airportRepo.save(new Airport("DEFRA", "Frankfurt"));
		airportRepo.save(new Airport("DEHAM", "Hamburg"));
		airportRepo.save(new Airport("DELUB", "Lübeck"));
		airportRepo.save(new Airport("DEMUC", "München"));
	}
	
	private static void createFlightData() {
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("B101"), airportRepo.getByCode("DELUB"), airportRepo.getByCode("DEHAM")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("B101"), airportRepo.getByCode("DEHAM"), airportRepo.getByCode("DELUB")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("B201"), airportRepo.getByCode("DEMUC"), airportRepo.getByCode("DEHAM")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("B201"), airportRepo.getByCode("DEHAM"), airportRepo.getByCode("DEMUC")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("A101"), airportRepo.getByCode("DEMUC"), airportRepo.getByCode("DEFRA")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("A101"), airportRepo.getByCode("DEFRA"), airportRepo.getByCode("DEMUC")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("A201"), airportRepo.getByCode("DEDUS"), airportRepo.getByCode("DEHAM")));
		laneRepo.save(new Lane(airplaneRepo.getByPlaneNumber("A201"), airportRepo.getByCode("DEHAM"), airportRepo.getByCode("DEDUS")));
		
		createFlightsForNextSevenDays("DELUBDEHAM", 0, 13.37);
		createFlightsForNextSevenDays("DEHAMDELUB", 0, 13.37);
		createFlightsForNextSevenDays("DEMUCDEHAM", 0, 420.0);
		createFlightsForNextSevenDays("DEHAMDEMUC", 0, 420.0);
		createFlightsForNextSevenDays("DEMUCDEFRA", 0, 42.0);
		createFlightsForNextSevenDays("DEFRADEMUC", 0, 42.0);
		createFlightsForNextSevenDays("DEHAMDEDUS", 0, 69.0);
		createFlightsForNextSevenDays("DEDUSDEHAM", 0, 69.0);
	}
	
	private static void createFlightsForNextSevenDays(String laneBk, int transitTime, Double price) {
		for (int i = 0; i < 7; i++) {
			flightRepo.save(new Flight(laneRepo.getByBK(laneBk), LocalDate.now().plusDays(i), LocalDate.now().plusDays(i + transitTime), price));
		}
	}
}
