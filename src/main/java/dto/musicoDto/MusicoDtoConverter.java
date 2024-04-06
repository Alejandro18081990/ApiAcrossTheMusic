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

	public MusicoDto convertirADTO(Musico musico) {
		return modelMapper.map(musico, MusicoDto.class);
	}

	public Musico convertirAMusicoDTO(CreateMusicoDto createMusicoDto) {
		return modelMapper.map(createMusicoDto, Musico.class);
	}
}
