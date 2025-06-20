# 🏦 Janta Bank

**Janta Bank** is a web-based banking application built using **Spring MVC**, **Hibernate**, and **MySQL**, simulating core banking functionalities such as account management, transactions, and authentication.

## 📌 Features

* User registration and login
* Secure session management
* Deposit and withdrawal operations
* Transaction history
* Admin dashboard for user/account management
* JSP-based UI with JSTL integration
* RESTful MVC architecture

## 🧰 Tech Stack

| Technology       | Description                       |
| ---------------- | --------------------------------- |
| Java 21          | Backend programming language      |
| Spring MVC       | Web framework                     |
| Hibernate ORM    | ORM for database interactions     |
| MySQL            | Relational database               |
| Apache Tomcat 11 | Application server                |
| JSP & JSTL       | Frontend rendering engine         |
| Maven            | Project build and dependency tool |

## ⚙️ Project Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/MayankJain9910/Janta-Bank.git
   cd Janta-Bank
   ```

2. **Configure Database**

   * Create a MySQL database named `jantabank`.
   * Update DB credentials in `SpringConfig.java`:

     ```java
     ds.setUrl("jdbc:mysql://localhost:3306/jantabank");
     ds.setUsername("your-username");
     ds.setPassword("your-password");
     ```

3. **Build the project**

   * Import the project in **Eclipse/IntelliJ** as a Maven project.
   * Run `mvn clean install` to resolve dependencies and build the WAR file.

4. **Deploy on Tomcat**

   * Copy the WAR file from `target/` to the `webapps/` folder of Apache Tomcat.
   * Start the server and navigate to:

     ```
     http://localhost:8080/Janta-Bank/
     ```

## 📂 Project Structure

```
Janta-Bank/
│
├── src/main/java/com/jantabank
│   ├── config/          # Spring & Hibernate configuration
│   ├── controller/      # MVC Controllers
│   ├── repository/      # Data Access Object interfaces & implementations
|   ├── Entity/          # Entity classes
│   └── service/         # Business logic
│   └── utility/         # Utility Classes
│
├── src/main/webapp/
│   ├── WEB-INF/
│   │   ├── templates/   # JSP views
│
│
├── pom.xml              # Maven configuration
└── README.md            # Project documentation
```

## 🧪 Future Enhancements

* Two-factor authentication
* Mobile-responsive UI with Bootstrap
* REST API support
* Transaction PDFs/email alerts

## 🙇‍♂️ Author

**Mayank Jain**
📧 [mayankjain9910@gmail.com](mailto:mayankjain9910@gmail.com)
🌐 [GitHub - MayankJain9910](https://github.com/MayankJain9910)
