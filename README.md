This application provides all Customers Information

Pre Requisites : Java 19 and Gradle 7.6 and mongodb

mongodb installation in docker desktop:
> docker pull mongo:latest
> docker run -d -p 27017:27017 --name mongodb mongo:latest

------------------------------------------------------------------------------------------------------------------------------------------
Used topics:
1.Http all Requests
2.Form Validations
3.PathVariable Validations
4.H2 db by setting up all required info in application.yml
variables
5.Used Global Exception handler

------------------------------------------------------------------------------------------------------------------------------------------
All Services Request URLS & Body

Post:
URL:- http://localhost:1001/customer-register/customer/addCustomer
Body:-
{
"customerId": "12345678",
"customerName": "SonuNigum",
"customerDOB": "2015-01-09",
"phoneNumber": 1234567899,
"email": "s.s@gmail.com",
"password": "12345678",
"addresses": [
{
"addressType": "Permanent",
"flatNumber": "101",
"plotNumber": "102",
"buildingName": "31",
"roadNumber": 124578,
"street": "ss",
"city": "Telangana",
"country": "India",
"pinCode": 500036
}    ]
}

Get:
URL:- http://localhost:1001/customer-register/customer/getCustomer/12345678

Get All:
URL:- http://localhost:1001/customer-register/customer/getAllCustomers

Put:
URL:- http://localhost:1001/customer-register/customer/updateCustomer
Body:-
{
"customerId": "12345678",
"customerName": "Sonu Nigum",
"customerDOB": "2015-01-09",
"phoneNumber": 1234567899,
"email": "s.s@gmail.com",
"password": "87951",
"addresses": [
{
"addressType": "Permanent",
"flatNumber": "101",
"plotNumber": "102",
"buildingName": "31",
"roadNumber": 124578,
"street": "ss",
"city": "Telangana",
"country": "India",
"pinCode": 500036
}    ]
}

Delete:
URL:- http://localhost:1001/customer-register/customer/deleteCustomer/12345678

h2 Database Console:
URL:- http://localhost:1001/customer-register/h2-console

------------------------------------------------------------------------------------------------------------------------------------------