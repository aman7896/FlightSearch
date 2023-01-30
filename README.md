# FlightSearch

Service usage guide:

	Service: Get all flights
	Path:"/api/flights/getall"
	Request format: Plain text
	Expected Response: All available flights
	Request Method: GET

	Service: Get flight by id
	Path:"/api/flights/getbyid/{id}"
	Request format: Plaintext
	Expected Response: Flight with requested id
	Request Method: GET

	Service: Get flight by flightnumber
	Path:"/api/flights/getbyid/{flightnumber}"
	Request format: Plaintext
	Expected Response: Flight with requested flight number
	Request Method: GET
	
	Service: Get flight by Origin Destination Combination
	Path:"/api/flights/getflightbyorigdest"
	Request format: JSON
	Sample Request:
	{
    "origin": {
            "code": "DEL",
            "id": 1
        },
    "destination": {
            "code": "BLR",
            "id": 2
        }
	}
	Expected Response: Flights with requested origin and destination
	Request Method: POST
	
	Service: Get flight by Origin Destination Combination
	Path:"/api/flights/getflightbyorigdest"
	Request format: JSON
	Sample Request:
	{
    "origin": {
            "code": "DEL",
            "id": 1
        },
    "destination": {
            "code": "BLR",
            "id": 2
        }
	}
	Expected Response: Flights with requested origin and destination
	Request Method: POST
	
	Service: Create flight
	Path:"/api/flights/create"
	Request format: JSON
	Sample Request:
	{"duration": 9000000,
    "origin": {
        "code": "BLR",
        "id": 2
    },
    "destination": {
        "code": "DEL",
        "id": 1
    },"id": 13,
    "flightNumber": "IND1112"}
	Expected Response: Flight created successfully
	Request Method: POST
	
	Service: Update Flight
	Path:"/api/flights/update"
	Request format: JSON
	Sample Request:
	{"duration": 9000000,
    "origin": {
        "code": "BLR",
        "id": 2
    },
    "destination": {
        "code": "DEL",
        "id": 1
    },"id": 2,
    "flightNumber": "IND1112"}
	Expected Response: Flight updated successfully
	Request Method: POST
	
	Service: Delete Flight
	Path:"/api/flights/delete"
	Request format: JSON
	Sample Request:
	{"duration": 9000000,
    "origin": {
        "code": "BLR",
        "id": 2
    },
    "destination": {
        "code": "DEL",
        "id": 1
    },"id": 2,
    "flightNumber": "IND1112"}
	Expected Response: Flight deleted successfully
	Request Method: POST
	
	Service: Get airport by id
	Path:"/api/airport/getall"
	Request format: Plaintext
	Expected Response: List of airports
	Request Method: GET
	
	Service: Get flight by id
	Path:"/api/airport/getbyid/{id}"
	Request format: Plaintext
	Expected Response: Airport with requested id
	Request Method: GET
	
	Service: Create Airport
	Path:"/api/airport/create"
	Request format: JSON
	Sample Request:
	{
        "code": "ABC",
        "id": 30
	}    
	Expected Response: Flight with requested id
	Request Method: POST