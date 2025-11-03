import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { eventService } from '../../services/eventService';
import { useAuth } from '../../context/AuthContext';

const EventDetails = () => {
  const { eventId } = useParams();
  const navigate = useNavigate();
  const { isAuthenticated } = useAuth();

  const [event, setEvent] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [isRegistered, setIsRegistered] = useState(false);
  const [actionLoading, setActionLoading] = useState(false);

  useEffect(() => {
    fetchEventDetails();
    if (isAuthenticated) {
      checkRegistrationStatus();
    }
  }, [eventId, isAuthenticated]);

  const fetchEventDetails = async () => {
    try {
      const data = await eventService.getEventById(eventId);
      console.log('Event details received:', data); // Debug log
      setEvent(data);
      setError('');
    } catch (err) {
      setError('Could not load event details');
      console.error('Error fetching event details:', err);
    } finally {
      setLoading(false);
    }
  };

  const checkRegistrationStatus = async () => {
    try {
      const data = await eventService.checkRegistration(eventId);
      setIsRegistered(data.registered);
    } catch (err) {
      console.error('Could not check registration:', err);
    }
  };

  const handleRegister = async () => {
    if (!isAuthenticated) {
      navigate('/login', {
        state: { from: { pathname: `/events/${eventId}` } }
      });
      return;
    }

    setActionLoading(true);
    try {
      const result = await eventService.registerForEvent(eventId);
      if (result.success) {
        setIsRegistered(true);
        window.alert(result.message);
      } else {
        window.alert(result.message);
      }
    } catch (err) {
      window.alert(err.response?.data?.message || 'Something went wrong with the registration');
    } finally {
      setActionLoading(false);
    }
  };

  const handleUnregister = async () => {
    if (!window.confirm('Are you sure you want to unregister?')) {
      return;
    }

    setActionLoading(true);
    try {
      const result = await eventService.unregisterFromEvent(eventId);
      if (result.success) {
        setIsRegistered(false);
        window.alert(result.message);
      } else {
        window.alert(result.message);
      }
    } catch (err) {
      window.alert(err.response?.data?.message || 'Something went wrong during unregistration');
    } finally {
      setActionLoading(false);
    }
  };

  const formatEventDate = (dateString) => {
    if (!dateString) return 'Date not specified';

    try {
      const date = new Date(dateString);
      return date.toLocaleDateString('sv-SE', {
        year: 'numeric',
        month: 'long',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
      });
    } catch (e) {
      console.error('Error formatting date:', e);
      return 'Invalid date';
    }
  };

  if (loading) {
    return (
      <div className="loading">Loading...</div>
    );
  }

  if (error) {
    return (
      <div className="container page-container">
        <div className="alert alert-error">{error}</div>
        <button
          onClick={() => navigate('/')}
          className="btn btn-secondary mt-4"
        >
          ← Back to events
        </button>
      </div>
    );
  }

  if (!event) {
    return (
      <div className="container page-container">
        <div className="text-center">Event not found</div>
        <button
          onClick={() => navigate('/')}
          className="btn btn-secondary mt-4"
        >
          ← Back to events
        </button>
      </div>
    );
  }

  return (
    <div className="event-details-container">
      <div className="event-details-card">
        <h1 className="event-title">{event.title}</h1>

        <div className="space-y-4 mb-6">
          <div className="event-info">
            <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
            </svg>
            <span>{formatEventDate(event.eventDate || event.startDate)}</span>
          </div>

          <div className="event-info">
            <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
            </svg>
            <span>{event.location || 'Location not specified'}</span>
          </div>

          <div className="event-info">
            <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
            <span><strong>Status: {event.eventStatus || 'Unknown'}</strong></span>
          </div>
        </div>

        <div className="event-section">
          <h2 className="section-title">Description</h2>
          <p className="event-description">{event.description || 'No description available'}</p>
        </div>

        <div className="event-section">
          {isRegistered ? (
            <div className="space-y-3">
              <div className="registered-status">
                <svg className="check-icon" fill="currentColor" viewBox="0 0 20 20">
                  <path fillRule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clipRule="evenodd" />
                </svg>
                You are registered to this event
              </div>
              <button
                onClick={handleUnregister}
                disabled={actionLoading}
                className="btn btn-danger btn-full"
              >
                {actionLoading ? 'Working...' : 'Unregister'}
              </button>
            </div>
          ) : (
            <button
              onClick={handleRegister}
              disabled={actionLoading}
              className="btn btn-primary btn-full"
            >
              {actionLoading ? 'Working...' : isAuthenticated ? 'Register for event' : 'Login to register'}
            </button>
          )}
        </div>

        <div className="mt-6">
          <button
            onClick={() => navigate('/')}
            className="auth-link"
          >
            ← Back to events
          </button>
        </div>
      </div>
    </div>
  );
};

export default EventDetails;