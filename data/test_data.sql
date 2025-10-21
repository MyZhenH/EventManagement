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

INSERT INTO events (title, description, start_date, end_date, location, created_at, updated_at, created_by, updated_by, category_id, event_status_id) VALUES
('Tech Conference', 'A conference about latest tech trends.', '2025-10-26T09:00:00', '2025-10-26T17:00:00', 'Stockholm', '2025-09-30T14:45:42', '2025-10-01T14:45:42', 1, 1, 1, 1),
('Python Workshop', 'Learn Python programming.', '2025-11-24T10:00:00', '2025-11-24T15:00:00', 'Gothenburg', '2025-09-29T14:45:42', '2025-10-01T14:45:42', 2, 2, 2, 2),
('Monthly Meetup', 'Networking event for professionals.', '2025-11-25T18:00:00', '2025-11-25T21:00:00', 'Malmo', '2025-10-01T14:45:42', '2025-10-03T14:45:42', 3, 3, 3, 3),
('AI Webinar', 'Webinar on artificial intelligence.', '2025-11-30T13:00:00', '2025-11-30T15:00:00', 'Uppsala', '2025-10-06T14:45:42', '2025-10-06T14:45:42', 4, 4, 4, 1),
('Data Science Conference', 'Focus on data science and analytics.', '2025-10-28T09:00:00', '2025-10-29T17:00:00', 'Vaxjo', '2025-10-03T14:45:42', '2025-10-03T14:45:42', 5, 5, 1, 2),
('Cloud Computing Workshop', 'Hands-on cloud computing workshop.', '2025-11-11T10:00:00', '2025-11-11T16:00:00', 'Linkoping', '2025-10-05T14:45:42', '2025-10-08T14:45:42', 6, 6, 2, 3),
('Blockchain Meetup', 'Meetup to discuss blockchain tech.', '2025-11-29T17:00:00', '2025-11-29T20:00:00', 'Halmstad', '2025-10-07T14:45:42', '2025-10-09T14:45:42', 7, 7, 3, 1),
('Cybersecurity Webinar', 'Webinar focused on cybersecurity.', '2025-11-23T14:00:00', '2025-11-23T16:00:00', 'Lund', '2025-10-03T14:45:42', '2025-10-08T14:45:42', 8, 8, 4, 2),
('DevOps Summit', 'Summit on DevOps best practices.', '2025-12-01T09:00:00', '2025-12-01T18:00:00', 'Orebro', '2025-10-04T14:45:42', '2025-10-06T14:45:42', 9, 9, 1, 3),
('Mobile Dev Workshop', 'Workshop on mobile app development.', '2025-11-20T10:00:00', '2025-11-20T16:00:00', 'Karlstad', '2025-10-03T14:45:42', '2025-10-05T14:45:42', 10, 10, 2, 1),
('Startup Meetup', 'Networking startup event.', '2025-11-20T18:00:00', '2025-11-20T21:00:00', 'Sundsvall', '2025-10-05T14:45:42', '2025-10-05T14:45:42', 11, 11, 3, 2),
('Machine Learning Conference', 'Conference on machine learning.', '2025-12-06T09:00:00', '2025-12-06T17:00:00', 'Umea', '2025-10-05T14:45:42', '2025-10-08T14:45:42', 12, 12, 4, 3),
('Big Data Workshop', 'Big data analytics workshop.', '2025-11-17T08:00:00', '2025-11-17T15:00:00', 'Vasteras', '2025-10-03T14:45:42', '2025-10-06T14:45:42', 13, 13, 1, 1),
('UX/UI Meetup', 'User experience and design meetup.', '2025-10-13T17:00:00', '2025-10-13T20:00:00', 'Norrkoping', '2025-10-01T14:45:42', '2025-10-06T14:45:42', 14, 14, 2, 2),
('Product Management Webinar', 'Webinar on product management.', '2025-11-23T12:00:00', '2025-11-23T14:00:00', 'Eskilstuna', '2025-09-29T14:45:42', '2025-09-30T14:45:42', 15, 15, 3, 3);

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
