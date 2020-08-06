# company
This project is used for 
  1.Accept the data of employee and manager.
  
  curl --location --request POST 'http://localhost:8080/addManager' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "ab@gmail.com",
    "address": "sector 56",
    "joiningDateTime": "2020-03-31T15:31:00.319-05:00",
    "managerFirstName": "Jag",
    "managerLastName": "Gupta",
    "dept": "IT",
    "managerId": 1,
    "salary": "23.56",
    "reportingEmployees": [
        {
         "firstName":"Lucifer",
         "lastName":"Morningstar",
         "middleName":"Samael",
         "email":"lucifer.morngstr@xyz.com",
         "phoneNumber":"9876543210",
         "address1":"111",
         "city":"Delhi",
         "Dept":"IT",
         "state":"Delhi",
         "postalCode":"110008",
         "Salary":"13.56"
      },
      {
         "firstName":"Sonu",
         "lastName":"Singh",
         "middleName":"",
         "email":"sonu.singh@xyz.com",
         "phoneNumber":"9876545430",
         "address1":"23456",
         "city":"Delhi",
         "Dept":"IT",
         "state":"Delhi",
         "postalCode":"110008",
         "Salary":"11.56"
      }
    ]
}'
  
  
  2.Rest API, which gives the list of all the employees with their respective manager.
   http://localhost:8080/getAllManager
    
  3.Rest API, which gives the manager Data by passing manager id.
   http://localhost:8080/getManager/1
  
  4.Rest API, which gives the All Employee Data
   http://localhost:8080/getAllEmployee
  
  5.Rest API, which gives the Employee Data by passing employee id
    http://localhost:8080/getEmployee/1
  
