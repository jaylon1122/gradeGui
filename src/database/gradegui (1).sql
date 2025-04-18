-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2025 at 02:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gradegui`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_enrollment`
--

CREATE TABLE `tbl_enrollment` (
  `enrollmentID` int(50) NOT NULL,
  `studentID` int(50) NOT NULL,
  `year_level` varchar(50) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `program` varchar(50) NOT NULL,
  `section` varchar(50) NOT NULL,
  `course` varchar(50) NOT NULL,
  `course_description` varchar(50) NOT NULL,
  `date_enrolled` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_grade`
--

CREATE TABLE `tbl_grade` (
  `id` int(50) NOT NULL,
  `student_id` int(50) NOT NULL,
  `course` varchar(100) NOT NULL,
  `prelim` double NOT NULL,
  `midterm` double NOT NULL,
  `prefinal` double NOT NULL,
  `final` double NOT NULL,
  `average` double NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_grade`
--

INSERT INTO `tbl_grade` (`id`, `student_id`, `course`, `prelim`, `midterm`, `prefinal`, `final`, `average`, `status`) VALUES
(1, 1, 'IM207', 1.3, 1.2, 1.6, 1.2, 1.325, 'Passed');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `logID` int(50) NOT NULL,
  `user_id` int(50) NOT NULL,
  `activity_description` varchar(250) NOT NULL,
  `timestamp` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`logID`, `user_id`, `activity_description`, `timestamp`) VALUES
(2, 7, 'User Approved: 7', '2025-03-30 22:45:15'),
(3, 7, 'User Approved: 7', '2025-03-31 06:43:56'),
(4, 5, 'User Approved: 5', '2025-03-31 06:45:08'),
(5, 7, 'User Approved: 7', '2025-03-31 06:45:31'),
(6, 5, 'User Approved: 5', '2025-03-31 06:50:27'),
(7, 5, 'Password Changed: 5', '2025-03-31 06:57:49'),
(8, 5, 'Password Changed: 5', '2025-03-31 06:58:51'),
(9, 5, 'Password Changed: 5', '2025-03-31 07:00:27'),
(10, 8, 'User Approved: 8', '2025-04-04 19:33:16'),
(11, 9, 'User Approved: 9', '2025-04-16 23:46:50');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `student_id` int(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`student_id`, `fname`, `lname`, `email`, `contact`) VALUES
(1, 'jaylon', 'mantillas', 'jaylonmantillas@gmail.com', '09497828037'),
(7, 'jaylon', 'mantillas', 'jaylon2@gmail.com', '88888888888');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `type` varchar(50) NOT NULL,
  `pass` varchar(150) NOT NULL,
  `status` varchar(50) NOT NULL,
  `security_question` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `username`, `fname`, `lname`, `email`, `contact`, `type`, `pass`, `status`, `security_question`, `answer`) VALUES
(5, 'admin', 'Jaylon', 'Mantillas', 'admin123@gmail.com', '09497828037', 'Admin', 'JAvlGPq9JyTdtvBO6x2llnRI1+gxwIyPqCKAn3THIKk=', 'Active', '', ''),
(7, 'instructor', 'instructor', 'instructor', 'instructor@gmail.com', '09090909099', 'User', 'wUN6VfbpO3BJxAZK8bCSCXTjg6Q1KD9dCwSW7kqKR7U=', 'Active', '', ''),
(8, 'krisjaylon', 'krisjaylon', 'mantillas', 'jaylon@gmail.com', '09655418172', 'User', '5WpeJD3wUXNW5h7+FyZqW+KJvW/kBTQWayQ7lum5SQ4=', 'Active', '', ''),
(9, 'jaylonn9', 'jaylonn', 'mantillass', 'jaylonn@gmail.com', '99999999999', 'Admin', 'v4hr0VNY4kbx1YPR1A/abx+ZcPtDERbXKfXBIn5yiGI=', 'Active', 'What is your favorite food?', 'pMGO4K2lnjQ2ke9N3A5QK4Znny6qalV2oOw8nqBljjY=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_enrollment`
--
ALTER TABLE `tbl_enrollment`
  ADD PRIMARY KEY (`enrollmentID`);

--
-- Indexes for table `tbl_grade`
--
ALTER TABLE `tbl_grade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`logID`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_enrollment`
--
ALTER TABLE `tbl_enrollment`
  MODIFY `enrollmentID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_grade`
--
ALTER TABLE `tbl_grade`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `logID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `student_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_enrollment`
--
ALTER TABLE `tbl_enrollment`
  ADD CONSTRAINT `id` FOREIGN KEY (`enrollmentID`) REFERENCES `tbl_student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_grade`
--
ALTER TABLE `tbl_grade`
  ADD CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `tbl_student` (`student_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
