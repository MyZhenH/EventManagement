INSERT INTO roles (role_name) VALUES ('Admin');
INSERT INTO roles (role_name) VALUES ('Organizer');
INSERT INTO roles (role_name) VALUES ('Participant');

INSERT INTO categories (category_name) VALUES ('Conference');
INSERT INTO categories (category_name) VALUES ('Workshop');
INSERT INTO categories (category_name) VALUES ('Meetup');
INSERT INTO categories (category_name) VALUES ('Webinar');

INSERT INTO event_statuses (status_name) VALUES ('Scheduled');
INSERT INTO event_statuses (status_name) VALUES ('Cancelled');
INSERT INTO event_statuses (status_name) VALUES ('Completed');

INSERT INTO participant_statuses (status_name) VALUES ('Confirmed');
INSERT INTO participant_statuses (status_name) VALUES ('Pending');
INSERT INTO participant_statuses (status_name) VALUES ('Cancelled');

INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Alice', 'Smith', 'alice.smith0@example.com', '+46700000100', '321drowssap_hashed', '2025-09-22T14:45:42', 1, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Bob', 'Johnson', 'bob.johnson1@example.com', '+46700000101', '321drowssap_hashed', '2025-08-12T14:45:42', 2, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Charlie', 'Williams', 'charlie.williams2@example.com', '+46700000102', '321drowssap_hashed', '2025-10-06T14:45:42', 3, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Diana', 'Brown', 'diana.brown3@example.com', '+46700000103', '321drowssap_hashed', '2025-10-04T14:45:42', 1, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Eve', 'Jones', 'eve.jones4@example.com', '+46700000104', '321drowssap_hashed', '2025-08-28T14:45:42', 2, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Frank', 'Taylor', 'frank.taylor5@example.com', '+46700000105', '321drowssap_hashed', '2025-09-23T14:45:42', 3, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Grace', 'Anderson', 'grace.anderson6@example.com', '+46700000106', '321drowssap_hashed', '2025-08-31T14:45:42', 1, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Hannah', 'Thomas', 'hannah.thomas7@example.com', '+46700000107', '321drowssap_hashed', '2025-08-21T14:45:42', 2, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Ivan', 'Jackson', 'ivan.jackson8@example.com', '+46700000108', '321drowssap_hashed', '2025-09-06T14:45:42', 3, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Julia', 'White', 'julia.white9@example.com', '+46700000109', '321drowssap_hashed', '2025-08-19T14:45:42', 1, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Kevin', 'Harris', 'kevin.harris10@example.com', '+46700000110', '321drowssap_hashed', '2025-08-12T14:45:42', 2, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Laura', 'Martin', 'laura.martin11@example.com', '+46700000111', '321drowssap_hashed', '2025-08-30T14:45:42', 3, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Alice', 'Smith', 'alice.smith12@example.com', '+46700000112', '321drowssap_hashed', '2025-08-26T14:45:42', 1, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Bob', 'Johnson', 'bob.johnson13@example.com', '+46700000113', '321drowssap_hashed', '2025-08-11T14:45:42', 2, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Charlie', 'Williams', 'charlie.williams14@example.com', '+46700000114', '321drowssap_hashed', '2025-10-08T14:45:42', 3, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Diana', 'Brown', 'diana.brown15@example.com', '+46700000115', '321drowssap_hashed', '2025-09-18T14:45:42', 1, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Eve', 'Jones', 'eve.jones16@example.com', '+46700000116', '321drowssap_hashed', '2025-09-29T14:45:42', 2, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Frank', 'Taylor', 'frank.taylor17@example.com', '+46700000117', '321drowssap_hashed', '2025-08-18T14:45:42', 3, 0);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Grace', 'Anderson', 'grace.anderson18@example.com', '+46700000118', '321drowssap_hashed', '2025-08-26T14:45:42', 1, 1);
INSERT INTO users (first_name, last_name, email, phone, password, registration_date, role_id, enabled) VALUES ('Hannah', 'Thomas', 'hannah.thomas19@example.com', '+46700000119', '321drowssap_hashed', '2025-08-13T14:45:42', 2, 0);

INSERT INTO cities (city_name) VALUES ('Stockholm');
INSERT INTO cities (city_name) VALUES ('Gothenburg');
INSERT INTO cities (city_name) VALUES ('Malmö');
INSERT INTO cities (city_name) VALUES ('Uppsala');
INSERT INTO cities (city_name) VALUES ('Helsingborg');
INSERT INTO cities (city_name) VALUES ('Linköping');
INSERT INTO cities (city_name) VALUES ('Örebro');
INSERT INTO cities (city_name) VALUES ('Västerås');
INSERT INTO cities (city_name) VALUES ('Jönköping');
INSERT INTO cities (city_name) VALUES ('Norrköping');
INSERT INTO cities (city_name) VALUES ('Lund');
INSERT INTO cities (city_name) VALUES ('Umeå');
INSERT INTO cities (city_name) VALUES ('Gävle');
INSERT INTO cities (city_name) VALUES ('Borås');
INSERT INTO cities (city_name) VALUES ('Södertälje');
INSERT INTO cities (city_name) VALUES ('Eskilstuna');
INSERT INTO cities (city_name) VALUES ('Halmstad');
INSERT INTO cities (city_name) VALUES ('Växjö');
INSERT INTO cities (city_name) VALUES ('Karlstad');
INSERT INTO cities (city_name) VALUES ('Täby');
INSERT INTO cities (city_name) VALUES ('Östersund');
INSERT INTO cities (city_name) VALUES ('Sundsvall');
INSERT INTO cities (city_name) VALUES ('Luleå');
INSERT INTO cities (city_name) VALUES ('Trollhättan');
INSERT INTO cities (city_name) VALUES ('Borlänge');
INSERT INTO cities (city_name) VALUES ('Falun');
INSERT INTO cities (city_name) VALUES ('Kalmar');
INSERT INTO cities (city_name) VALUES ('Skövde');
INSERT INTO cities (city_name) VALUES ('Kristianstad');
INSERT INTO cities (city_name) VALUES ('Katrineholm');
INSERT INTO cities (city_name) VALUES ('Söderhamn');
INSERT INTO cities (city_name) VALUES ('Nyköping');
INSERT INTO cities (city_name) VALUES ('Västervik');
INSERT INTO cities (city_name) VALUES ('Landskrona');
INSERT INTO cities (city_name) VALUES ('Motala');
INSERT INTO cities (city_name) VALUES ('Alingsås');
INSERT INTO cities (city_name) VALUES ('Trelleborg');
INSERT INTO cities (city_name) VALUES ('Ystad');
INSERT INTO cities (city_name) VALUES ('Mölndal');
INSERT INTO cities (city_name) VALUES ('Huddinge');
INSERT INTO cities (city_name) VALUES ('Kungsbacka');
INSERT INTO cities (city_name) VALUES ('Tyresö');
INSERT INTO cities (city_name) VALUES ('Lidingö');
INSERT INTO cities (city_name) VALUES ('Sollentuna');
INSERT INTO cities (city_name) VALUES ('Sundbyberg');
INSERT INTO cities (city_name) VALUES ('Solna');
INSERT INTO cities (city_name) VALUES ('Örnsköldsvik');
INSERT INTO cities (city_name) VALUES ('Eslöv');
INSERT INTO cities (city_name) VALUES ('Haninge');

INSERT INTO events (
  title, description, location, address, city_id, start_date, end_date,
  created_at, updated_at, created_by, updated_by, category_id, event_status_id
) VALUES
('Tech Conference', 'A conference about latest tech trends.', 'Main Hall', NULL, 1, '2025-10-10T09:00:00', '2025-10-10T17:00:00', '2025-09-01T08:00:00', '2025-09-02T08:00:00', 1, 1, 1, 1),
('Python Workshop', 'Learn Python programming.', 'Room 202', NULL, 2, '2025-10-12T10:00:00', '2025-10-12T15:00:00', '2025-09-03T08:00:00', '2025-09-03T08:00:00', 2, 2, 2, 2),
('Monthly Meetup', 'Networking event for professionals.', 'Community Center', NULL, 3, '2025-10-14T18:00:00', '2025-10-14T21:00:00', '2025-09-04T08:00:00', '2025-09-04T08:00:00', 3, 3, 3, 3),
('AI Webinar', 'Webinar on artificial intelligence.', 'Online', NULL, NULL, '2025-10-15T13:00:00', '2025-10-15T15:00:00', '2025-09-05T08:00:00', '2025-09-05T08:00:00', 4, 4, 4, 1),
('Data Science Conference', 'Focus on data science and analytics.', 'Expo Center', NULL, 4, '2025-10-16T09:00:00', '2025-10-17T17:00:00', '2025-09-06T08:00:00', '2025-09-06T08:00:00', 5, 5, 1, 2),
('Cloud Computing Workshop', 'Hands-on cloud computing workshop.', 'Tech Lab', NULL, 5, '2025-10-18T10:00:00', '2025-10-18T16:00:00', '2025-09-07T08:00:00', '2025-09-07T08:00:00', 6, 6, 2, 3),
('Blockchain Meetup', 'Meetup to discuss blockchain tech.', 'Startup Hub', NULL, 6, '2025-10-20T17:00:00', '2025-10-20T20:00:00', '2025-09-08T08:00:00', '2025-09-08T08:00:00', 7, 7, 3, 1),
('Cybersecurity Webinar', 'Webinar focused on cybersecurity.', 'Online', NULL, NULL, '2025-10-21T14:00:00', '2025-10-21T16:00:00', '2025-09-09T08:00:00', '2025-09-09T08:00:00', 8, 8, 4, 2),
('DevOps Summit', 'Summit on DevOps best practices.', 'Conference Hall A', NULL, 7, '2025-10-22T09:00:00', '2025-10-22T18:00:00', '2025-09-10T08:00:00', '2025-09-10T08:00:00', 9, 9, 1, 3),
('Mobile Dev Workshop', 'Workshop on mobile app development.', 'Room 101', NULL, 8, '2025-10-24T10:00:00', '2025-10-24T16:00:00', '2025-09-11T08:00:00', '2025-09-11T08:00:00', 10, 10, 2, 1),
('Startup Meetup', 'Networking startup event.', 'Innovation Center', NULL, 9, '2025-10-25T18:00:00', '2025-10-25T21:00:00', '2025-09-12T08:00:00', '2025-09-12T08:00:00', 11, 11, 3, 2),
('Machine Learning Conference', 'Conference on machine learning.', 'Grand Ballroom', NULL, 10, '2025-10-26T09:00:00', '2025-10-26T17:00:00', '2025-09-13T08:00:00', '2025-09-13T08:00:00', 12, 12, 4, 3),
('Big Data Workshop', 'Big data analytics workshop.', 'Tech Hub', NULL, 11, '2025-10-27T08:00:00', '2025-10-27T15:00:00', '2025-09-14T08:00:00', '2025-09-14T08:00:00', 13, 13, 1, 1),
('UX/UI Meetup', 'User experience and design meetup.', 'Design Studio', NULL, 12, '2025-10-28T17:00:00', '2025-10-28T20:00:00', '2025-09-15T08:00:00', '2025-09-15T08:00:00', 14, 14, 2, 2),
('Product Management Webinar', 'Webinar on product management.', 'Online', NULL, NULL, '2025-10-29T12:00:00', '2025-10-29T14:00:00', '2025-09-16T08:00:00', '2025-09-16T08:00:00', 15, 15, 3, 3),
('Data Analytics Symposium', 'Symposium on data analytics trends.', 'Conference Room B', NULL, 13, '2025-10-30T10:00:00', '2025-10-30T16:00:00', '2025-09-17T08:00:00', '2025-09-17T08:00:00', 1, 1, 1, 2),
('Quantum Computing Workshop', 'Workshop on quantum computing basics.', 'Lab 3', NULL, 14, '2025-11-01T09:00:00', '2025-11-01T15:00:00', '2025-09-18T08:00:00', '2025-09-18T08:00:00', 2, 2, 2, 3),
('AI for Healthcare', 'Conference on AI applications in healthcare.', 'Auditorium', NULL, 15, '2025-11-02T10:00:00', '2025-11-02T18:00:00', '2025-09-19T08:00:00', '2025-09-19T08:00:00', 3, 3, 3, 1),
('Virtual Reality Expo', 'Expo showcasing VR technologies.', 'Online', NULL, NULL, '2025-11-03T09:00:00', '2025-11-03T17:00:00', '2025-09-20T08:00:00', '2025-09-20T08:00:00', 4, 4, 4, 2),
('Blockchain Innovations', 'Seminar on blockchain innovations.', 'Tech Park', NULL, 16, '2025-11-04T11:00:00', '2025-11-04T15:00:00', '2025-09-21T08:00:00', '2025-09-21T08:00:00', 5, 5, 1, 3),
('Cloud Migration Bootcamp', 'Hands-on bootcamp on cloud migration.', 'Room 15', NULL, 17, '2025-11-06T08:00:00', '2025-11-06T16:00:00', '2025-09-22T08:00:00', '2025-09-22T08:00:00', 6, 6, 2, 1),
('Cyber Threats Forum', 'Forum discussing latest cyber threats.', 'Online', NULL, NULL, '2025-11-07T13:00:00', '2025-11-07T16:00:00', '2025-09-23T08:00:00', '2025-09-23T08:00:00', 7, 7, 3, 2),
('IoT Summit', 'Summit on Internet of Things advancements.', 'Convention Center', NULL, 18, '2025-11-08T09:00:00', '2025-11-08T19:00:00', '2025-09-24T08:00:00', '2025-09-24T08:00:00', 8, 8, 4, 3),
('Software Architecture Meetup', 'Meetup on modern software architecture.', 'Room 101', NULL, 19, '2025-11-09T17:00:00', '2025-11-09T20:00:00', '2025-09-25T08:00:00', '2025-09-25T08:00:00', 9, 9, 1, 1),
('DevSecOps Workshop', 'Workshop integrating security into DevOps.', 'Lab 9', NULL, 20, '2025-11-10T09:00:00', '2025-11-10T16:00:00', '2025-09-26T08:00:00', '2025-09-26T08:00:00', 10, 10, 2, 2),
('Remote Work Strategies', 'Strategies for effective remote work.', 'Online', NULL, NULL, '2025-11-11T12:00:00', '2025-11-11T14:00:00', '2025-09-27T08:00:00', '2025-09-27T08:00:00', 11, 11, 3, 3),
('Augmented Reality Conference', 'Conference on AR technologies.', 'Main Hall', NULL, 21, '2025-11-13T09:00:00', '2025-11-13T18:00:00', '2025-09-28T08:00:00', '2025-09-28T08:00:00', 12, 12, 4, 1),
('Big Data Analytics Forum', 'Forum on big data analytics trends.', 'Room 4', NULL, 22, '2025-11-14T09:00:00', '2025-11-14T17:00:00', '2025-09-29T08:00:00', '2025-09-29T08:00:00', 13, 13, 1, 2),
('UI/UX Design Workshop', 'Workshop on user interface and experience design.', 'Design Studio', NULL, 23, '2025-11-15T14:00:00', '2025-11-15T18:00:00', '2025-09-30T08:00:00', '2025-09-30T08:00:00', 14, 14, 2, 3),
('Product Launch Webinar', 'Webinar on effective product launching.', 'Online', NULL, NULL, '2025-11-16T11:00:00', '2025-11-16T13:00:00', '2025-10-01T08:00:00', '2025-10-01T08:00:00', 15, 15, 3, 1),
('City 24 Conference', 'Conference for city 24', 'Venue 24', NULL, 24, '2025-11-17T09:00:00', '2025-11-17T17:00:00', '2025-10-02T08:00:00', '2025-10-02T08:00:00', 1, 1, 1, 2),
('City 25 Workshop', 'Workshop for city 25', 'Venue 25', NULL, 25, '2025-11-18T09:00:00', '2025-11-18T15:00:00', '2025-10-03T08:00:00', '2025-10-03T08:00:00', 2, 2, 2, 3),
('City 26 Meetup', 'Meetup for city 26', 'Venue 26', NULL, 26, '2025-11-19T18:00:00', '2025-11-19T21:00:00', '2025-10-04T08:00:00', '2025-10-04T08:00:00', 3, 3, 3, 1),
('City 27 Webinar', 'Webinar for city 27', 'Online', NULL, NULL, '2025-11-20T13:00:00', '2025-11-20T15:00:00', '2025-10-05T08:00:00', '2025-10-05T08:00:00', 4, 4, 4, 2),
('City 28 Conference', 'Conference for city 28', 'Venue 28', NULL, 27, '2025-11-21T09:00:00', '2025-11-21T17:00:00', '2025-10-06T08:00:00', '2025-10-06T08:00:00', 5, 5, 1, 3),
('City 29 Workshop', 'Workshop for city 29', 'Venue 29', NULL, 28, '2025-11-22T10:00:00', '2025-11-22T16:00:00', '2025-10-07T08:00:00', '2025-10-07T08:00:00', 6, 6, 2, 1),
('City 30 Meetup', 'Meetup for city 30', 'Community Hall', NULL, 29, '2025-11-23T17:00:00', '2025-11-23T20:00:00', '2025-10-08T08:00:00', '2025-10-08T08:00:00', 7, 7, 3, 2),
('City 31 Webinar', 'Webinar for city 31', 'Online', NULL, NULL, '2025-11-24T13:00:00', '2025-11-24T15:00:00', '2025-10-09T08:00:00', '2025-10-09T08:00:00', 8, 8, 4, 3),
('City 32 Conference', 'Conference for city 32', 'Venue 32', NULL, 30, '2025-11-25T08:00:00', '2025-11-25T16:00:00', '2025-10-10T08:00:00', '2025-10-10T08:00:00', 9, 9, 1, 1),
('City 33 Workshop', 'Workshop for city 33', 'Venue 33', NULL, 31, '2025-11-26T09:00:00', '2025-11-26T15:00:00', '2025-10-11T08:00:00', '2025-10-11T08:00:00', 10, 10, 2, 2),
('City 34 Meetup', 'Meetup for city 34', 'Venue 34', NULL, 32, '2025-11-27T18:00:00', '2025-11-27T21:00:00', '2025-10-12T08:00:00', '2025-10-12T08:00:00', 11, 11, 3, 3),
('City 35 Seminar', 'Seminar for city 35', 'Venue 35', NULL, 33, '2025-11-28T09:00:00', '2025-11-28T16:00:00', '2025-10-13T08:00:00', '2025-10-13T08:00:00', 12, 12, 4, 1),
('City 36 Workshop', 'Workshop for city 36', 'Venue 36', NULL, 34, '2025-11-29T10:00:00', '2025-11-29T15:00:00', '2025-10-14T08:00:00', '2025-10-14T08:00:00', 13, 13, 1, 2),
('City 37 Conference', 'Conference for city 37', 'Venue 37', NULL, 35, '2025-11-30T09:00:00', '2025-11-30T17:00:00', '2025-10-15T08:00:00', '2025-10-15T08:00:00', 14, 14, 2, 3),
('City 38 Webinar', 'Webinar for city 38', 'Online', NULL, NULL, '2025-12-01T13:00:00', '2025-12-01T15:00:00', '2025-10-16T08:00:00', '2025-10-16T08:00:00', 15, 15, 3, 1),
('City 39 Meetup', 'Meetup for city 39', 'Venue 39', NULL, 36, '2025-12-02T18:00:00', '2025-12-02T21:00:00', '2025-10-17T08:00:00', '2025-10-17T08:00:00', 1, 1, 1, 2),
('City 40 Seminar', 'Seminar for city 40', 'Venue 40', NULL, 37, '2025-12-03T09:00:00', '2025-12-03T16:00:00', '2025-10-18T08:00:00', '2025-10-18T08:00:00', 2, 2, 2, 3),
('City 41 Workshop', 'Workshop for city 41', 'Venue 41', NULL, 38, '2025-12-04T10:00:00', '2025-12-04T15:00:00', '2025-10-19T08:00:00', '2025-10-19T08:00:00', 3, 3, 3, 1),
('City 42 Conference', 'Conference for city 42', 'Venue 42', NULL, 39, '2025-12-05T09:00:00', '2025-12-05T17:00:00', '2025-10-20T08:00:00', '2025-10-20T08:00:00', 4, 4, 4, 2),
('City 43 Webinar', 'Webinar for city 43', 'Online', NULL, NULL, '2025-12-06T13:00:00', '2025-12-06T15:00:00', '2025-10-21T08:00:00', '2025-10-21T08:00:00', 5, 5, 1, 3),
('City 44 Meetup', 'Meetup for city 44', 'Venue 44', NULL, 40, '2025-12-07T18:00:00', '2025-12-07T21:00:00', '2025-10-22T08:00:00', '2025-10-22T08:00:00', 6, 6, 2, 1),
('City 45 Seminar', 'Seminar for city 45', 'Venue 45', NULL, 41, '2025-12-08T09:00:00', '2025-12-08T16:00:00', '2025-10-23T08:00:00', '2025-10-23T08:00:00', 7, 7, 3, 2),
('City 46 Workshop', 'Workshop for city 46', 'Venue 46', NULL, 42, '2025-12-09T10:00:00', '2025-12-09T15:00:00', '2025-10-24T08:00:00', '2025-10-24T08:00:00', 8, 8, 4, 3),
('City 47 Conference', 'Conference for city 47', 'Venue 47', NULL, 43, '2025-12-10T09:00:00', '2025-12-10T17:00:00', '2025-10-25T08:00:00', '2025-10-25T08:00:00', 9, 9, 1, 1),
('City 48 Webinar', 'Webinar for city 48', 'Online', NULL, NULL, '2025-12-11T13:00:00', '2025-12-11T15:00:00', '2025-10-26T08:00:00', '2025-10-26T08:00:00', 10, 10, 2, 2),
('City 49 Meetup', 'Meetup for city 49', 'Venue 49', NULL, 44, '2025-12-12T18:00:00', '2025-12-12T21:00:00', '2025-10-27T08:00:00', '2025-10-27T08:00:00', 11, 11, 3, 3),
('City 50 Seminar', 'Seminar for city 50', 'Venue 50', NULL, 45, '2025-12-13T09:00:00', '2025-12-13T16:00:00', '2025-10-28T08:00:00', '2025-10-28T08:00:00', 12, 12, 4, 1),
('Global Tech Summit', 'Worldwide virtual tech summit.', 'Online', NULL, NULL, '2025-12-14T09:00:00', '2025-12-14T17:00:00', '2025-10-29T08:00:00', '2025-10-29T08:00:00', 13, 13, 1, 2),
('AI & Robotics Conference', 'Virtual conference on AI and robotics.', 'Online', NULL, NULL, '2025-12-15T10:00:00', '2025-12-15T18:00:00', '2025-10-30T08:00:00', '2025-10-30T08:00:00', 14, 14, 2, 3),
('Cloud Innovation Webinar', 'Exploring cloud innovations online.', 'Online', NULL, NULL, '2025-12-16T11:00:00', '2025-12-16T13:00:00', '2025-10-31T08:00:00', '2025-10-31T08:00:00', 15, 15, 3, 1),
('Cybersecurity Awareness Event', 'Raising awareness of cybersecurity.', 'Online', NULL, NULL, '2025-12-17T12:00:00', '2025-12-17T14:00:00', '2025-11-01T08:00:00', '2025-11-01T08:00:00', 1, 1, 4, 2),
('Data Privacy Workshop', 'Workshop on data privacy best practices.', 'Online', NULL, NULL, '2025-12-18T13:00:00', '2025-12-18T16:00:00', '2025-11-02T08:00:00', '2025-11-02T08:00:00', 2, 2, 1, 3);

INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (1, 1, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (1, 14, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (1, 4, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (2, 10, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (2, 19, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (2, 3, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (2, 2, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (3, 19, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (3, 20, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (3, 4, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (4, 18, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (4, 13, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (4, 2, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (5, 1, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (5, 12, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (5, 18, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (6, 12, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (6, 19, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (6, 2, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (6, 11, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (6, 10, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (7, 12, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (7, 4, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (7, 13, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (7, 2, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (8, 15, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (8, 1, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (8, 8, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (8, 17, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (8, 14, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (9, 7, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (9, 13, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (9, 6, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (9, 15, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (10, 5, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (10, 10, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (10, 14, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (10, 8, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (11, 2, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (11, 17, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (12, 13, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (12, 6, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (12, 3, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (12, 12, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (13, 8, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (13, 16, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (13, 9, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (13, 7, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (13, 20, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (14, 10, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (14, 3, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (15, 11, 2);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (15, 6, 3);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (15, 14, 1);
INSERT INTO event_participants (event_id, user_id, p_status_id) VALUES (15, 13, 2);

INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (2, 9, 5, 'Great event!', '2025-10-03T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (9, 5, 3, 'Learned a lot.', '2025-09-12T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (2, 5, 1, 'Will attend again.', '2025-09-30T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (7, 15, 4, 'Could be better.', '2025-09-03T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (4, 8, 4, 'Excellent organization.', '2025-09-19T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (14, 3, 2, 'Well organized and informative.', '2025-09-16T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (1, 2, 5, 'Could use more hands-on sessions.', '2025-09-14T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (15, 12, 4, 'Good networking opportunity.', '2025-09-02T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (6, 17, 2, 'Loved the speakers.', '2025-09-16T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (3, 20, 5, 'Interesting topics covered.', '2025-08-23T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (4, 8, 2, 'Great event!', '2025-08-20T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (5, 3, 2, 'Learned a lot.', '2025-08-20T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (8, 18, 5, 'Will attend again.', '2025-10-02T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (7, 18, 3, 'Could be better.', '2025-09-29T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (6, 18, 5, 'Excellent organization.', '2025-10-08T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (13, 16, 2, 'Well organized and informative.', '2025-10-07T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (13, 6, 3, 'Could use more hands-on sessions.', '2025-09-21T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (2, 17, 2, 'Good networking opportunity.', '2025-08-24T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (9, 10, 5, 'Loved the speakers.', '2025-08-28T14:45:42');
INSERT INTO reviews (event_id, user_id, rating, comment, created_at) VALUES (5, 4, 4, 'Interesting topics covered.', '2025-09-23T14:45:42');
