# 🏥 Hospital Management System (Java + JDBC)

A desktop-based Hospital Management System built using **Java Swing** and **JDBC**, designed to manage core hospital operations like patients, appointments, doctors, and billing data.

---

## 📌 Features

- 🔐 **User Login** – Secure login interface for accessing the system  
- 👨‍⚕️ **Patient Management** – Add, update, and discharge patients  
- 🩺 **Doctor Management** – View and manage doctor information and specialties  
- 📅 **Appointment System** – Schedule, update, and view patient appointments  
- 💵 **Billing Viewer** – View bill information linked to appointments  
- 📊 **Dashboard** – Displays counts and summaries of key data

> ⚠️ **Limitations:**  
> - Employee data is view-only (cannot add/update from the UI)  
> - Bills can only be viewed; bill generation is not handled through the UI

---

## 🛠️ Technologies Used

- **Java Swing** – Desktop GUI components  
- **JDBC** – Database operations (SQL Server used in this project)  
- **OOP Principles** – For a modular and maintainable structure  
- **SQL Server** – Backend relational database

---

## 📦 Dependencies / Libraries Used

- **MSSQL JDBC Driver**  
  For connecting the Java application to SQL Server  
  - File: `mssql-jdbc-12.10.0.jre11.jar`  
  - [Download from Microsoft Docs](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server)

- **rs2xml.jar**  
  Used to directly bind SQL `ResultSet` data to `JTable`  
  - [Download from SourceForge](https://sourceforge.net/projects/finalangelsanddemons/)

- **Java Swing (javax.swing)** – GUI framework  
- **Java AWT (java.awt)** – For rendering UI components and layout

---

## 🗂️ Project Structure

HMS/
├── src/
│ └── h/m/s/
│ ├── Login.java
│ ├── home.java
│ ├── Add_Patient.java
│ ├── Update_Patient_Info.java
│ ├── Discharge_Patient.java
│ ├── Doctor_info.java
│ ├── Add_Appointment.java
│ ├── Update_Appointment.java
│ ├── View_Bills.java
│ ├── View_Employees.java
│ ├── DB_Connection.java
│ └── (other class files)
│
├── icon/ # Icons used in the GUI
│ ├── logo.png
│ └── ...
│
└── lib/ # External libraries
├── rs2xml.jar
└── mssql-jdbc-12.10.0.jre11.jar


---

## ⚙️ How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/HospitalManagementSystem.git
   cd HospitalManagementSystem

2. **Set Up the Database**

        Import the database schema (.sql file) into your SQL Server instance

        Open DB_Connection.java and update the database URL, username, and password:

        String url = "jdbc:sqlserver://localhost:1433;databaseName=HospitalDB";
        String username = "yourUsername";
        String password = "yourPassword";

3.**Add Libraries to Classpath**

        Add rs2xml.jar and mssql-jdbc-12.10.0.jre11.jar from the lib/ folder to your project classpath

    Compile and Run

        Open the project in your IDE (Eclipse, IntelliJ, etc.)

        Run Login.java to start the application

📸 Screenshots
![Screenshot 2025-06-16 203851](https://github.com/user-attachments/assets/3e6ab6b1-82a0-4612-ad98-bcb89d4f747f)
![Screenshot 2025-06-16 203824](https://github.com/user-attachments/assets/1b29bd56-6c69-4f5b-852f-5784cd82f402)
![Screenshot 2025-06-16 203758](https://github.com/user-attachments/assets/5e5d0370-9cc2-48cd-8ffb-3c51e1a08d00)
![Screenshot 2025-06-16 203733](https://github.com/user-attachments/assets/d6076566-2e22-4b54-b2ca-142405c7d1d1)
![Screenshot 2025-06-16 203713](https://github.com/user-attachments/assets/b90fe1ba-ad6a-4c20-939d-5e05996820e9)
![Screenshot 2025-06-16 203647](https://github.com/user-attachments/assets/db42610b-5a36-497a-8922-b429132da417)
![Screenshot 2025-06-16 203606](https://github.com/user-attachments/assets/de369772-bc89-4926-9fef-752f97b04423)
![Screenshot 2025-06-16 203430](https://github.com/user-attachments/assets/29ddb1d8-9a52-4280-9faa-1e359a818d5f)
![Screenshot 2025-06-16 203152](https://github.com/user-attachments/assets/86eb7ca9-fd9a-41ed-b0c1-7b565ee5c230)
![Screenshot 2025-06-16 203048](https://github.com/user-attachments/assets/fde155c8-7c45-4976-972c-dafc8928710e)
![Screenshot 2025-06-16 202920](https://github.com/user-attachments/assets/760e73fe-861f-472d-9713-8c4671c25460)
![Screenshot 2025-06-16 202901](https://github.com/user-attachments/assets/073cb383-e7fd-446f-a0fa-0e271f0d2d48)
![Screenshot 2025-06-16 203916](https://github.com/user-attachments/assets/4d090735-fb75-4738-8e79-2574be1ac79c)

📃 License

This project is developed for educational purposes.
Feel free to modify and improve it!
