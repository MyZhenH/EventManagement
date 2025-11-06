CREATE TABLE roles (
    role_id INTEGER PRIMARY KEY AUTOINCREMENT,
    role_name TEXT UNIQUE NOT NULL
);

CREATE TABLE categories (
    category_id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_name TEXT UNIQUE NOT NULL
);

CREATE TABLE event_statuses (
    event_status_id INTEGER PRIMARY KEY AUTOINCREMENT,
    status_name TEXT UNIQUE NOT NULL
);

CREATE TABLE participant_statuses (
    p_status_id INTEGER PRIMARY KEY AUTOINCREMENT,
    status_name TEXT UNIQUE NOT NULL
);

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    phone TEXT UNIQUE,
    password TEXT NOT NULL,
    registration_date DATETIME,
    role_id INTEGER,
    enabled BOOLEAN CHECK (enabled IN (0, 1)),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

CREATE TABLE cities (
    city_id INTEGER PRIMARY KEY AUTOINCREMENT,
    city_name TEXT NOT NULL,
    state TEXT,
    country TEXT
);

CREATE TABLE events (
    event_id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    location TEXT NOT NULL,
    address TEXT,
    city_id INTEGER,
    start_date DATETIME,
    end_date DATETIME,
    created_at DATETIME,
    updated_at DATETIME,
    created_by INTEGER,
    updated_by INTEGER,
    category_id INTEGER,
    event_status_id INTEGER,
    FOREIGN KEY (created_by) REFERENCES users (user_id),
    FOREIGN KEY (updated_by) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (event_status_id) REFERENCES event_statuses (event_status_id),
    FOREIGN KEY (city_id) REFERENCES cities (city_id)
);

CREATE TABLE event_participants (
    ep_id INTEGER PRIMARY KEY AUTOINCREMENT,
    event_id INTEGER,
    user_id INTEGER,
    p_status_id INTEGER,
    FOREIGN KEY (event_id) REFERENCES events (event_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (p_status_id) REFERENCES participant_statuses (p_status_id)
);

CREATE TABLE reviews (
    review_id INTEGER PRIMARY KEY AUTOINCREMENT,
    event_id INTEGER,
    user_id INTEGER,
    rating INTEGER CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at DATETIME,
    FOREIGN KEY (event_id) REFERENCES events (event_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);
