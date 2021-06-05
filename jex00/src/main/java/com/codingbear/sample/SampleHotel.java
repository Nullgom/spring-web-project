package com.codingbear.sample;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Getter
@Setter
//@AllArgsConstructor
@RequiredArgsConstructor
public class SampleHotel {
	@NonNull
	private Chef chef;
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
