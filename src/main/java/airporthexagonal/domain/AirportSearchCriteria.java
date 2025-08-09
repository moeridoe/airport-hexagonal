package airporthexagonal.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AirportSearchCriteria {
	private String code;
	private String name;
}
