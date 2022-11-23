package com.tma.bookmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "persistent_logins")
public class Persistent_Logins {
    private String username;
    @Id
    private String series;
    private String token;
    private Timestamp last_used;
}
