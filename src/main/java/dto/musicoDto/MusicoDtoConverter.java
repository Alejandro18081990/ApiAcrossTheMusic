package dto.musicoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entities.Musico;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MusicoDtoConverter {

	@Autowired
	private ModelMapper modelMapper;

	public MusicoDto convertirDto(Musico musico) {
		return modelMapper.map(musico, MusicoDto.class);
	}

	public Musico convertirAMusico(CreateMusicoDto createMusicoDto) {
		return modelMapper.map(createMusicoDto, Musico.class);
	}
}
