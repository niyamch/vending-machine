# Vending Machine

## Steps to start the project

1. Open terminal in the folder **Vending Machine**
2. Run the command **mvnw spring-boot:run**
3. Open swagger in the following link -> http://localhost:8080/swagger-ui/index.html

You can access the api-docs via the following link -> http://localhost:8080/v3/api-docs



## Services


###HTTP POST /insert-coin

Request Body: String
	The String represents the name of the coin. The coins in the System are as follow:
		TEN_ST, TWENTY_ST, FIFTY_ST, ONE_LEV, TWO_LEV
	example: ONE_LEV
		
Response Body : String
	example: You have an available amount of 1,00lv.


###HTTP PUT /buy-product

Request Body: String
	The String represents the name of the product. The products in the System are as follow:
		cola, croissant, lollypop, waffle, energy drink
	example: lollypop
		
Response Body : String
	example: Enjoy your croissant! You have an available amount of 0,30lv.


###HTTP DELETE /reset

Request Body: NONE

Response Body : ChangeDto
	example:
	{
	  "totalInStotinki": 150,
	  "tenStoninkiQuantity": 0,
	  "twentyStoninkiQuantity": 0,
	  "fiftyStoninkiQuantity": 1,
	  "oneLevQuantity": 1,
	  "twoLevQuantity": 0,
	  "message": "All the change is returned."
	}

