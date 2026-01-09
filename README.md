# EmployeeManagement
A spring boot application that allows for basic employee management features.

## **How to run the project:**
### 1. Prerequisites:
- Java OpenJDK version 25.0.1
- Gradle 9.2.1
- Git
### 2. Steps:
   Clone the repository with
   ```
   git clone https://github.com/kar993/employeeManagement.git
   cd employeeManagement
```
  Build the project
  ```
  ./gradlew build
```
  Run the Application
  ```
  ./gradlew bootRun
```
  The application will start at <code>http://localhost:8080</code>
  H2-console:
  URL: <code>http://localhost:8080/h2-console</code>
  JDBC URL: <code>jdbc:h2:mem:testDB</code>
  Username: <code>sa</code>
  Password:

## **API Endpoints**

### Employee:

```
| Method | Endpoint        |     Description         |
|--------|-----------------|-------------------------|
| POST   |  /employees     |  Create employee        |
| GET    | /employees      | Get all employees       |
| GET    | /employees/{id} | Get employee by ID      |
| PUT    | /employees/{id} | Update employee         |
| DELETE | /employees/{id} | Delete employee         |
```
Sample Request Body for create employee:

```
JSON

{ "employeeName": "Name", "employeeEmailAddress": "Name@gmail.com", "employeeDepartment": "department", "employeeSalary": 1000000 }
```

## **Assumptions**

### Validation Rules:
1. Unique Email Constraint: No two employees can share the same email. This is enforced at the service layer (via <code>EmployeeAlreadyExistsException</code>).
2. Name must be at least 3 characters, alphabetic only.
3. Email must be valid format.
4. Department cannot be blank.
5. Salary must be positive (> 0).

### Database:
Uses H2 in‑memory DB <code>(jdbc:h2:mem:testDB)</code>, so data resets on every restart.

### Error Handling:
Custom exceptions (<code>EmployeeNotFoundException, EmptyDatabaseException, EmployeeAlreadyExistsException</code>) are globally handled to return consistent JSON responses.

