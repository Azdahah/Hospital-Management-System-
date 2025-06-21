Create table login(
	ID VARCHAR(26),
	PW VARCHAR(20)


);
/*Chnage your login*/
insert into login values('YourID','YourPassword');

CREATE TABLE Patient (
    P_ID INT PRIMARY KEY IDENTITY(1,1),
    P_Name VARCHAR(50),
    Age INT,
	DOB DATE,
    Gender VARCHAR(10),
    Phone VARCHAR(15)
);
CREATE TABLE Department(
	DEP_ID INT PRIMARY KEY NOT NULL,
	DEP_Name VARCHAR(50),
	Location VARCHAR(60)
);
create table Doctor(
	D_ID INT PRIMARY KEY NOT NULL,
	D_Name VARCHAR(50),
	Specialty VARCHAR(50),
	DEP_ID INT,
	FOREIGN KEY(DEP_ID) REFERENCES Department(DEP_ID)


);
CREATE TABLE Employee(
	E_ID INT PRIMARY KEY NOT NULL,
	E_Name VARCHAR(50),
	Role VARCHAR(50),
	Phone VARCHAR(50),
	DEP_ID INT,
	FOREIGN KEY(DEP_ID) REFERENCES Department(DEP_ID)
);
CREATE TABLE Appointments(
	APP_ID INT PRIMARY KEY NOT NULL identity(1,1),
	APP_Date Date,
	APP_Time VARCHAR(100),
	P_ID INT,
	D_ID INT,
	FOREIGN KEY(P_ID) REFERENCES Patient(P_ID),
	FOREIGN KEY(D_ID) REFERENCES Doctor(D_ID)
);
CREATE TABLE Bills(
	B_ID INT PRIMARY KEY NOT NULL identity(1,1),
	TotalAmount INT,
	B_Date DATE,
	P_ID INT,
	FOREIGN KEY(P_ID) REFERENCES Patient(P_ID)
);

INSERT INTO Department (DEP_ID, DEP_Name, Location)
VALUES
(1, 'Cardiology', 'East Wing'),
(2, 'Neurology', 'West Wing'),
(3, 'Pediatrics', 'North Wing'),
(4, 'Orthopedics', 'South Wing'),
(5, 'Radiology', 'First Floor - Block A'),
(6, 'Dermatology', 'Ground Floor - Block B'),
(7, 'Oncology', 'First Floor - Block A');

INSERT INTO Doctor (D_ID, D_Name, Specialty, DEP_ID)
VALUES
(1, 'Dr. Ahsan Khan', 'Cardiologist', 1),
(2, 'Dr. Saira Malik', 'Neurologist', 2),
(3, 'Dr. Bilal Ahmed', 'Pediatrician', 3),
(4, 'Dr. Farah Shah', 'Orthopedic Surgeon', 4),
(5, 'Dr. Kamran Raza', 'Radiologist', 5),
(6, 'Dr. Sana Javed', 'Dermatologist', 6),
(7, 'Dr. Imran Qureshi', 'Oncologist', 7),
(8, 'Dr. Hira Sohail', 'Cardiac Surgeon', 1),
(9, 'Dr. Yasir Mahmood', 'Neurosurgeon', 2),
(10, 'Dr. Mehwish Tariq', 'General Pediatrician', 3);
INSERT INTO Patient (P_Name, Age, DOB, Gender, Phone)
VALUES 
('Ali Khan', 30, '1995-03-15', 'Male', '03001234567'),
('Fatima Ahmed', 25, '2000-07-22', 'Female', '03111234567'),
('Usman Iqbal', 40, '1985-11-05', 'Male', '03211234567'),
('Ali Raza', 32, '1993-05-12', 'Male', '03001234567'),
('Fatima Noor', 28, '1997-08-21', 'Female', '03019876543'),
('Ahmed Khan', 45, '1979-03-30', 'Male', '03211234567'),
('Sara Iqbal', 22, '2003-11-15', 'Female', '03151234567'),
('Usman Javed', 39, '1985-01-09', 'Male', '03331234567'),
('Ayesha Bukhari', 31, '1993-06-22', 'Female', '03041234567'),
('Zain Ali', 26, '1998-09-05', 'Male', '03461234567'),
('Hira Munir', 35, '1989-02-17', 'Female', '03051234567'),
('Bilal Haider', 41, '1983-12-03', 'Male', '03221234567'),
('Nimra Shahid', 24, '2000-04-27', 'Female', '03131234567'),
('Fahad Mehmood', 29, '1995-07-19', 'Male', '03451234567'),
('Mehwish Tariq', 36, '1988-10-10', 'Female', '03091234567'),
('Hamza Sheikh', 33, '1991-03-01', 'Male', '03011234567'),
('Laiba Hassan', 27, '1997-01-18', 'Female', '03031234567'),
('Taha Zubair', 30, '1994-08-25', 'Male', '03431234567'),
('Maham Riaz', 21, '2003-02-14', 'Female', '03251234567'),
('Rehan Siddiqui', 38, '1986-06-11', 'Male', '03321234567'),
('Sana Haroon', 34, '1990-09-23', 'Female', '03141234567'),
('Imran Qureshi', 42, '1982-11-07', 'Male', '03081234567'),
('Areeba Zulfiqar', 25, '1999-12-29', 'Female', '03231234567');

INSERT INTO Employee VALUES
(1, 'Sara Ahmed', 'Nurse', '03001234501', 1),
(2, 'Bilal Khan', 'Technician', '03001234502', 2),
(3, 'Amina Tariq', 'Receptionist', '03001234503', 3),
(4, 'Zeeshan Malik', 'Nurse', '03001234504', 4),
(5, 'Fatima Rauf', 'Administrator', '03001234505', 5),
(6, 'Rizwan Ali', 'Lab Assistant', '03001234506', 6),
(7, 'Hina Shah', 'Pharmacist', '03001234507', 7),
(8, 'Kashif Nawaz', 'Ward Boy', '03001234508', 1),
(9, 'Nadia Hussain', 'Accountant', '03001234509', 2),
(10, 'Shahbaz Qureshi', 'Nurse', '03001234510', 3),
(11, 'Mehwish Javed', 'Receptionist', '03001234511', 4),
(12, 'Tariq Mahmood', 'Technician', '03001234512', 5),
(13, 'Lubna Iqbal', 'Clerk', '03001234513', 6),
(14, 'Yasir Mehmood', 'Cleaner', '03001234514', 7),
(15, 'Sana Imran', 'Nurse', '03001234515', 1),
(16, 'Omar Farooq', 'IT Support', '03001234516', 2),
(17, 'Asma Khalid', 'HR Officer', '03001234517', 3),
(18, 'Waleed Hassan', 'Storekeeper', '03001234518', 4),
(19, 'Iqra Nadeem', 'Cashier', '03001234519', 5),
(20, 'Hamza Rafiq', 'Security Guard', '03001234520', 6),
(21, 'Iqbal Hussain', 'Security Guard', '03011234521', 1),
(22, 'Sadia Imran', 'Receptionist', '03011234522', 2),
(23, 'Mohsin Rafiq', 'Lab Assistant', '03011234523', 3),
(24, 'Rabia Shahid', 'Nurse', '03011234524', 4),
(25, 'Ali Nawaz', 'Technician', '03011234525', 5),
(26, 'Hina Waheed', 'Pharmacist', '03011234526', 6),
(27, 'Noman Aftab', 'Cleaner', '03011234527', 7),
(28, 'Zara Maqbool', 'Cashier', '03011234528', 1),
(29, 'Owais Nadeem', 'Administrator', '03011234529', 2),
(30, 'Neha Tariq', 'Nurse', '03011234530', 3),
(31, 'Talha Riaz', 'IT Support', '03011234531', 4),
(32, 'Kiran Javed', 'HR Officer', '03011234532', 5),
(33, 'Rehan Aslam', 'Storekeeper', '03011234533', 6),
(34, 'Zulekha Nasir', 'Receptionist', '03011234534', 7),
(35, 'Faraz Shah', 'Technician', '03011234535', 1),
(36, 'Bushra Qamar', 'Ward Nurse', '03011234536', 2),
(37, 'Haris Latif', 'Clerk', '03011234537', 3),
(38, 'Mahnoor Aziz', 'Accountant', '03011234538', 4),
(39, 'Areeb Khan', 'Electrician', '03011234539', 5),
(40, 'Nashit Ali', 'Sanitation Worker', '03011234540', 6);

INSERT INTO Appointments (APP_Date, APP_Time, P_ID, D_ID) VALUES
('2025-06-01', '09:00 AM', 2, 1),
('2025-06-02', '10:30 AM', 1, 4),
('2025-06-03', '11:00 AM', 3, 2),
('2025-06-04', '12:30 PM', 2, 5),
('2025-06-05', '02:00 PM', 1, 8),
('2025-06-06', '03:15 PM', 3, 7),
('2025-06-07', '04:45 PM', 2, 9),
('2025-06-08', '08:30 AM', 1, 10),
('2025-06-09', '01:15 PM', 3, 3),
('2025-06-10', '05:00 PM', 2, 6);

INSERT INTO Bills (TotalAmount, B_Date, P_ID) VALUES
(5000, '2024-05-01', 1),
(4500, '2024-05-02', 1),
(6200, '2024-05-03', 2),
(7000, '2024-05-04', 5),
(4300, '2024-05-05', 6),
(3200, '2024-05-06', 6),
(6700, '2024-05-07', 7),
(3900, '2024-05-08', 8),
(4100, '2024-05-09', 8),
(7200, '2024-05-10', 10),
(5600, '2024-05-11', 11),
(4800, '2024-05-12', 11),
(5900, '2024-05-13', 13),
(5300, '2024-05-14', 14),
(6000, '2024-05-15', 15),
(6100, '2024-05-16', 15),
(4700, '2024-05-17', 17),
(5400, '2024-05-18', 17),
(6300, '2024-05-19', 20),
(5800, '2024-05-20', 21),
(4900, '2024-05-21', 21),
(5100, '2024-05-22', 23),
(5500, '2024-05-23', 24),
(5000, '2024-05-24', 24),
(6900, '2024-05-25', 25),
(6400, '2024-05-26', 27),
(4200, '2024-05-27', 27),
(5700, '2024-05-28', 5),
(6100, '2024-05-29', 6),
(5300, '2024-05-30', 13);
