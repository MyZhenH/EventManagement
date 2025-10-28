import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { eventService } from '../../services/eventService';

const MyEvents = () => {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchMyEvents();
  }, []);

  const fetchMyEvents = async () => {
    try {
      const data = await eventService.getMyEvents();
      setEvents(data);
    } catch (err) {
      setError('Could not load your events');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const getStatusClass = (status) => {
    switch(status) {
      case 'Registered':
        return 'badge-success';
      case 'Attended':
        return 'badge-primary';
      case 'Cancelled':
        return 'badge-danger';
      default:
        return 'badge-gray';
    }
  };

  if (loading) {
    return (
      <div className="container page-container">
        <div className="loading">Loading your events...</div>
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
      <h1 className="page-title">My events</h1>

      {events.length === 0 ? (
        <div className="alert alert-info">
          <p>You have not registered for any events yet.</p>
          <Link to="/" className="auth-link mt-2">
            Explore available events →
          </Link>
        </div>
      ) : (
        <div className="grid grid-cols-3">
          {events.map((event) => (
            <div key={event.participantId} className="card">
              <div className="card-body">
                <h3 className="event-card-title">
                  {event.eventTitle}
                </h3>

                <div className="space-y-2 mb-4">
                  <div className="event-info">
                    <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
                    </svg>
                    {new Date(event.eventDate).toLocaleString('sv-SE')}
                  </div>

                  <div className="event-info">
                    <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                    </svg>
                    {event.eventLocation}
                  </div>
                </div>

                <div className="mb-4">
                  <span className={`badge ${getStatusClass(event.participantStatus)}`}>
                    {event.participantStatus}
                  </span>
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

export default MyEvents;