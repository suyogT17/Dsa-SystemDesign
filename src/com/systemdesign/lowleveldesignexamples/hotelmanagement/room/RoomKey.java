package com.systemdesign.lowleveldesignexamples.hotelmanagement.room;

import java.time.LocalDateTime;

public class RoomKey {
    private int id;
    private String barcode;
    private LocalDateTime issuedAt;
    private LocalDateTime expiredAt;
}
