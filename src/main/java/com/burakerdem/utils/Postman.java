package com.burakerdem.utils;

public class Postman {

    // LIST -->
    // GET --> http://localhost:8080/api/v1/employees

    //------------------------------------------------------------

    // FIND
    // GET --> http://localhost:8080/api/v1/employees/6

    //------------------------------------------------------------

    // DELETE
    // DELETE --> http://localhost:8080/api/v1/employees/6

    //------------------------------------------------------------

    // SAVE
    // POST --> http://localhost:8080/api/v1/employees
    // body -> raw -> JSON
    //    {
    //        "id": 3,
    //            "firstName": "Burak1",
    //            "lastName": "Erdem1",
    //            "email": "burakerdem@gmail.com"
    //    }

    //------------------------------------------------------------

    // UPDATE
    // PUT --> http://localhost:8080/api/v1/employees/3
    // body -> raw -> JSON
    //    {
    //        "id": 3,
    //            "firstName": "Burak1",
    //            "lastName": "Erdem1",
    //            "email": "burakerdem@gmail.com"
    //    }
}
