INSERT INTO roles (role_name) VALUES ('Admin');
INSERT INTO roles (role_name) VALUES ('Organizer');
INSERT INTO roles (role_name) VALUES ('Participant');

INSERT INTO categories (category_name) VALUES ('Conference');
INSERT INTO categories (category_name) VALUES ('Workshop');
INSERT INTO categories (category_name) VALUES ('Meetup');
INSERT INTO categories (category_name) VALUES ('Webinar');
INSERT INTO categories (category_name) VALUES ('Music');
INSERT INTO categories (category_name) VALUES ('Health & Wellness');
INSERT INTO categories (category_name) VALUES ('Food & Drink');

INSERT INTO event_statuses (status_name) VALUES ('Scheduled');
INSERT INTO event_statuses (status_name) VALUES ('Cancelled');
INSERT INTO event_statuses (status_name) VALUES ('Completed');

INSERT INTO participant_statuses (status_name) VALUES ('Confirmed');
INSERT INTO participant_statuses (status_name) VALUES ('Pending');
INSERT INTO participant_statuses (status_name) VALUES ('Cancelled');

.read insert_users.sql

.read insert_cities.sql

.read insert_events.sql

.read insert_event_participants.sql

.read insert_reviews.sql
