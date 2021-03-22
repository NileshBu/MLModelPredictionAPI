package com.assignment.ml.mlModel.utils;

public interface ConstantTest {

    String JSON1 =" { \"Data\":[{\n" +
            "   \"Id\":2,\n" +
            "   \"Age\":29,\n" +
            "   \"Job\":\"management\",\n" +
            "   \"Marital\":\"single\",\n" +
            "   \"Education\":\"tertiary\",\n" +
            "   \"Default\":0,\n" +
            "   \"Balance\":637,\n" +
            "   \"HHInsurance\":1,\n" +
            "   \"CarLoan\":0,\n" +
            "   \"Communication\":\"cellular\",\n" +
            "   \"LastContactDay\":3,\n" +
            "   \"LastContactMonth\":\"jun\",\n" +
            "   \"NoOfContacts\":1,\n" +
            "   \"DaysPassed\":119,\n" +
            "   \"PrevAttempts\":1,\n" +
            "   \"Outcome\":\"failure\",\n" +
            "   \"CallStart\":\"16:30:24\",\n" +
            "   \"CallEnd\":\"16:36:04\"},\n" +
            "   {\"Id\":3,\n" +
            "   \"Age\":29,\n" +
            "   \"Job\":\"management\",\n" +
            "   \"Marital\":\"single\",\n" +
            "   \"Education\":\"tertiary\",\n" +
            "   \"Default\":0,\n" +
            "   \"Balance\":637,\n" +
            "   \"HHInsurance\":1,\n" +
            "   \"CarLoan\":0,\n" +
            "   \"Communication\":\"cellular\",\n" +
            "   \"LastContactDay\":3,\n" +
            "   \"LastContactMonth\":\"jun\",\n" +
            "   \"NoOfContacts\":1,\n" +
            "   \"DaysPassed\":119,\n" +
            "   \"PrevAttempts\":1,\n" +
            "   \"Outcome\":\"failure\",\n" +
            "   \"CallStart\":\"16:30:24\",\n" +
            "   \"CallEnd\":\"16:36:04\"}\n" +
            "   ]\n" +
            "}\n";

    String INVALID_JSON =" { \"Data\":[{\n" +
            "   \"Id\":2,\n" +
            "   \"Age\":0,\n" +
            "   \"Job\":\"management\",\n" +
            "   \"Marital\":\"single\",\n" +
            "   \"Education\":\"tertiary\",\n" +
            "   \"Default\":0,\n" +
            "   \"Balance\":637,\n" +
            "   \"HHInsurance\":1,\n" +
            "   \"CarLoan\":0,\n" +
            "   \"Communication\":\"cellular\",\n" +
            "   \"LastContactDay\":3,\n" +
            "   \"LastContactMonth\":\"jun\",\n" +
            "   \"NoOfContacts\":1,\n" +
            "   \"DaysPassed\":119,\n" +
            "   \"PrevAttempts\":1,\n" +
            "   \"Outcome\":\"failure\",\n" +
            "   \"CallStart\":\"16:30:24\",\n" +
            "   \"CallEnd\":\"16:36:04\"},\n" +
            "   {\"Id\":3,\n" +
            "   \"Age\":29,\n" +
            "   \"Job\":\"management\",\n" +
            "   \"Marital\":\"single\",\n" +
            "   \"Education\":\"tertiary\",\n" +
            "   \"Default\":0,\n" +
            "   \"Balance\":637,\n" +
            "   \"HHInsurance\":1,\n" +
            "   \"CarLoan\":0,\n" +
            "   \"Communication\":\"cellular\",\n" +
            "   \"LastContactDay\":3,\n" +
            "   \"LastContactMonth\":\"jun\",\n" +
            "   \"NoOfContacts\":1,\n" +
            "   \"DaysPassed\":119,\n" +
            "   \"PrevAttempts\":1,\n" +
            "   \"Outcome\":\"failure\",\n" +
            "   \"CallStart\":\"16:30:24\",\n" +
            "   \"CallEnd\":\"16:36:04\"}\n" +
            "   ]\n" +
            "}\n";

        String RESULT = "\"The Outcome for DataSet with Id : '2' Is Predicted to be : 'FAILURE'\"";
        String OUTCOME_RESULT = "[\"The Outcome for DataSet with Id : '2' Is Predicted to be : 'FAILURE'\"]";

}