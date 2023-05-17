### Application Name

This is a RESTful API for managing medical cases, where each case is represented by a label. The application is built using Java and utilizes the Spring Framework.
****
### Installation

Clone the repository: git clone https://github.com/<username>/<repository>.git
Open the project in your preferred IDE.
Build the project using Maven.
Run the project.
****

### Usage

The API provides the following endpoints:

* POST /labels: creates a new label.
* GET /labels/{code}: retrieves a label by its code.
* GET /labels: retrieves all labels.
* PUT /labels/{code}: updates a label by its code.
* DELETE /labels/{code}: deletes a label by its code.

### Request Examples
Create a new label

``` http
POST /labels HTTP/1.1
Content-Type: application/json

{
"name": "Label Name",
"description": "Label Description"
}
```
Retrieve a label by its code

```http
GET /labels/{code} HTTP/1.1
```

Retrieve all labels

``` http
GET /labels HTTP/1.1
```

Update a label by its code
``` http
PUT /labels/{code} HTTP/1.1
Content-Type: application/json

{
"name": "New Label Name",
"description": "New Label Description"
}
```

Delete a label by its code
``` http

DELETE /labels/{code} HTTP/1.1
```

### Dependencies

The application uses the following dependencies:

* Spring Boot
* Spring Data JPA
* Jakarta Bean Validation
* Lombok
