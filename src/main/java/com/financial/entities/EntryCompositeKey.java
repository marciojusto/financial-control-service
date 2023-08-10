package com.financial.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

public class EntryCompositeKey implements Serializable {
    public UUID id;
    public String description;
    public Date entryDate;
}
