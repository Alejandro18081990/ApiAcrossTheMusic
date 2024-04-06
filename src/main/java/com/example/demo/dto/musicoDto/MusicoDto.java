package com.example.demo.dto.musicoDto;

import java.sql.Blob;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class MusicoDto {
	
	private String email;
	private String nombre;
	private int edad;
	private int anios_experiencia;
	private Blob video;
}
