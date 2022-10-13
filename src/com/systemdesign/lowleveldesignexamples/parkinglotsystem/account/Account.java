package com.systemdesign.lowleveldesignexamples.parkinglotsystem.account;

import java.time.LocalDateTime;

public abstract class Account {
     int id;
     String userName;
     String password;
     Contact contact;
     LocalDateTime lastAccessed;
}
