package com.tcs.studenthostel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentHostel {
	private int id;
	private String name;
	private int room_number;
}
