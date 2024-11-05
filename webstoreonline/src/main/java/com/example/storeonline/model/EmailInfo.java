package com.example.storeonline.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfo {
    String from = "0tringuyen46@gmail.com";
    String to;
    String[] cc;
    String[] bcc;
    String subject;
    String body;
    List<File> files = new ArrayList<>(); 

    public EmailInfo(String to,String subject,String body) {
		this.from = "Chiem Nguyen Tri Nguyen";
		this.to = to;
		this.subject = subject;
		this.body = body;		
	}
}
