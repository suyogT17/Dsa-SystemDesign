package com.systemdesign.lowleveldesignexamples.hotelmanagement.account;

import java.time.LocalDateTime;

public abstract class Account {
    private int id;
    private String username;
    private String password;
    private Contact contact;
    private LocalDateTime lastAccessedAt;
}
