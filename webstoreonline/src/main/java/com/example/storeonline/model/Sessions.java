package com.example.storeonline.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sessions")
public class Sessions {
    @Id
    private String session_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire_time;
    private String session_token;
}
