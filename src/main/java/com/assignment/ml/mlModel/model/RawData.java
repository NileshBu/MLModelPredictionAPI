package com.assignment.ml.mlModel.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawData {
    private int Id;
    private int Age;
    private String Job;
    private String Marital;
    private String Education;
    private int Default;
    private int Balance;
    private int HHInsurance;
    private int CarLoan;
    private String Communication;
    private int LastContactDay;
    private String LastContactMonth;
    private int NoOfContacts;
    private int DaysPassed;
    private int PrevAttempts;
    private String Outcome;
    private String CallStart;
    private String CallEnd;

}
