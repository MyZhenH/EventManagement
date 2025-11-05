import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { eventService } from '../../services/eventService';

const EventList = () => {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchEvents();
  }, []);

  const fetchEvents = async () => {
    try {
      const data = await eventService.getAllEvents();
      console.log('Fetched events:', data); // Debug log
      setEvents(data);
    } catch (err) {
      setError('Could not load events');
      console.error('Error fetching events:', err);
    } finally {
      setLoading(false);
    }
  };

  const formatEventDate = (startDate, endDate) => {
    if (!startDate) return 'Date not specified';

    try {
      const start = new Date(startDate);

      const dateOptions = {
        year: 'numeric',
        month: 'long',
        day: 'numeric'
      };

      const timeOptions = {
        hour: '2-digit',
        minute: '2-digit'
      };

      // If there isnt an end date, show only start date
      if (!endDate) {
        return start.toLocaleDateString('sv-SE', { ...dateOptions, ...timeOptions });
      }

      const end = new Date(endDate);

      // Check if start and end date is the same day
      const sameDay = start.toDateString() === end.toDateString();

      if (sameDay) {
        // Formating for dates and time when an event is the same day
        const dateStr = start.toLocaleDateString('sv-SE', dateOptions);
        const startTime = start.toLocaleTimeString('sv-SE', timeOptions);
        const endTime = end.toLocaleTimeString('sv-SE', timeOptions);
        return `${dateStr}, ${startTime} - ${endTime}`;
      } else {
        // Different formating on dates and time when an event is more than one day
        const startStr = start.toLocaleDateString('sv-SE', { ...dateOptions, ...timeOptions });
        const endStr = end.toLocaleDateString('sv-SE', { ...dateOptions, ...timeOptions });
        return `${startStr} - ${endStr}`;
      }
    } catch (e) {
      console.error('Error formatting date:', e);
      return 'Invalid date';
    }
  };

  if (loading) {
    return (
      <div className="container page-container">
        <div className="loading">Loading events...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="container page-container">
        <div className="alert alert-error">{error}</div>
      </div>
    );
  }

  return (
    <div className="container page-container">
      <div className="mb-6">
        <h1 className="page-title">All events</h1>
        <p className="page-subtitle">
          Explore and register for coming events
        </p>
      </div>

      {events.length === 0 ? (
        <div className="alert alert-info">
          No events available right now.
        </div>
      ) : (
        <div className="grid grid-cols-3">
          {events.map((event) => (
            <div key={event.eventId} className="card">
              <div className="card-body">
                <h2 className="event-card-title">
                  {event.title}
                </h2>

                <div className="space-y-2 mb-4">
                  <div className="event-info">
                    <svg
                      className="event-icon"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      />
                    </svg>
                    {formatEventDate(event.startDate, event.endDate)}
                  </div>

                  <div className="event-info">
                    <svg
                      className="event-icon"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"
                      />
                      <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        strokeWidth={2}
                        d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"
                      />
                    </svg>
                    {event.location || 'Location not specified'}
                  </div>
                </div>

                <Link
                  to={`/events/${event.eventId}`}
                  className="btn btn-primary btn-full"
                >
                  Show details
                </Link>
              </div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default EventList;