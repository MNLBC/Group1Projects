package com.oocl.mnlbc;

public class Ticket {
  private int remaining;
  
  public Ticket(int remaining) {
     this.remaining = remaining;
  }
  
  public int getRemaining() {
     return remaining;
  }

  public void setRemaining(int remaining) {
     this.remaining = remaining;
  }
}
