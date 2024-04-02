package dto.jamSessionDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import entities.JamSession;

public class CreateJamSessionDto {
	@Autowired
	private ModelMapper modelMapper;

	public JamSessionDto convertirADTO(JamSession jamSession) {
		return modelMapper.map(jamSession, JamSessionDto.class);
	}

	public JamSession convertirACentroSalud(CreateJamSessionDto createJamSessionDto) {
		return modelMapper.map(createJamSessionDto, JamSession.class);
	}

}
