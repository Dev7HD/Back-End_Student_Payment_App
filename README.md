### README.md

# 📚 Student Payment Application

Welcome to the Student Payment Application! This application enables efficient management of students and their payments.

## 🌟 Features Overview
- View list of students and their payments
- Import student and payment lists
- Retrieve student info by code
- Filter students by study program
- Filter payments by status or type
- Retrieve payment by ID
- Update payment status
- Add new student payments

## 🛠️ Backend Documentation

### Endpoints
Accessible via Swagger-UI:
- **Students**
  - `GET /students/all`: Retrieve all students
  - `GET /students/{programId}`: Retrieve students by program
  - `GET /students/{code}`: Retrieve student by code
- **Payments**
  - `GET /payments/all`: Retrieve all payments
  - `GET /payments/status/{status}`: Retrieve payments by status
  - `GET /payments/type/{type}`: Retrieve payments by type
  - `GET /payment/{id}`: Retrieve payment by ID
  - `GET /payments/student/{code}`: Retrieve payments by student code
  - `PUT /payments/{id}`: Update payment status
  - `POST /payments/new`: Add new payment

### Entities
- **Student**: Attributes include ID, first name, last name, email, code, program ID
- **Payment**: Attributes include ID, date, amount, type, status, receipt

### Repositories
- **StudentRepository**: Access student data
- **PaymentRepository**: Access payment data

### Services
- **StudentService**: Business logic for students
- **PaymentService**: Business logic for payments

### Web Controllers
- **StudentRestController**: Handles student-related requests
- **PaymentRestController**: Handles payment-related requests

## 💻 Frontend Documentation

### Components
- **Admin Template Component**: Provides the main layout for the admin panel.
- **Login Component**: Allows users to log in to the application.
- **Dashboard Component**: Displays dashboard.
- **Home Component**: Displays home page.
- **Loading Students Component**: Allows admin to import students list.
- **Loading Payments Component**: Allows admin to import payments list.
- **Loading Toast Component**: Provides a popup loading toast.
- **Payments Component**: Displays a list of payments.
- **Students Component**: Displays a list of students.
- **Profile Component**: User profile.
- **Student List Component**: Display list of students.
- **Student Payments Component**: Display student payments.
- **Student Details Component**: Displays student information and all his payments.
- **Student Payment Details Component**: Display payment details.
- **Payment List Component**: Display list of payments with pagination.
- **Payment Details Component**: Display details of a single payment.
- **New Payment Component**: Add new payment made by a student.
- **Payment Recipt Component**: Allows user to view the payment receipt.
- **Update Payment Status Component**: Form to update payment status.
- **New Payment Dialog Component**: Popup appears when new payment successfully saved.
- **Update Status Dialog Component**: Popup appears when payment status successfully updated.

### Guards
- **Auth Guard**: Protects routes from unauthorized access
- **Authorization Guard**: Restricts access based on roles

### Services
- **Authentication Service**: Manages user authentication
- **Toast Service**: Displays notifications
- **Student Service**: Manages student data
- **Payment Service**: Manages payment data

### Interceptors
- **App Interceptor**: Intercepts HTTP requests/responses

### Routing
Defines application routes and applies guards.

### Dependencies
- **Angular Material**: UI components
- **RxJS**: Reactive programming
- **Angular Forms**: Form handling
- **HttpClientModule**: HTTP client

## 🚀 Getting Started
### Backend
1. Clone the repository:
   ```bash
   git clone https://github.com/Dev7HD/student-spring-ng-app.git
   ```
2. Navigate to the backend directory:
   ```bash
   cd student-spring-ng-app/backend
   ```
3. Build the project with Maven:
   ```bash
   mvn clean install
   ```
4. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend
1. Navigate to the frontend directory:
   ```bash
   cd student-spring-ng-app/frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the Angular development server:
   ```bash
   ng serve
   ```

## 📈 Usage
1. Log in using your credentials.
2. Navigate through the sections to manage students and payments.
3. Import student and payment lists.
4. Retrieve student details by code.
5. Update payment statuses.
6. Add new payments.

## 🤝 Contribution
Contributions are welcome! Please submit a pull request or open an issue to discuss your changes.

## 📄 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## ℹ️ About
Developed by [Dev7HD](https://github.com/Dev7HD).
