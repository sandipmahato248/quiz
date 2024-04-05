package edu.miu.cs.cs489appsd.contactCLI.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailAddress {
	private String number;
    private String label;

}
