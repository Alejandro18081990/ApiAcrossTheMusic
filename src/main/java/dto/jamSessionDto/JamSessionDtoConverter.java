package dto.jamSessionDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.musicoDto.CreateMusicoDto;
import dto.musicoDto.MusicoDto;
import lombok.RequiredArgsConstructor;
import modelo.Musico;

@Component
@RequiredArgsConstructor
public class JamSessionDtoConverter {

	@Autowired
	private ModelMapper modelMapper;

	public MusicoDto convertirDto(Musico musico) {
		return modelMapper.map(musico, MusicoDto.class);
	}

	public Musico convertirAMusico(CreateMusicoDto createMusicoDto) {
		return modelMapper.map(createMusicoDto, Musico.class);
	}
}
