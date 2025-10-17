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
      setEvent(data);
    } catch (err) {
      setError('Kunde inte ladda eventdetaljer');
      console.error(err);
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
      window.alert(err.response?.data?.message || 'Något gick fel vid anmälan');
    } finally {
      setActionLoading(false);
    }
  };

  const handleUnregister = async () => {
    if (!window.confirm('Är du säker på att du vill avanmäla dig?')) {
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
      window.alert(err.response?.data?.message || 'Något gick fel vid avanmälan');
    } finally {
      setActionLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="loading">Laddar...</div>
    );
  }

  if (error) {
    return (
      <div className="container page-container">
        <div className="alert alert-error">{error}</div>
      </div>
    );
  }

  if (!event) {
    return (
      <div className="container page-container">
        <div className="text-center">Event hittades inte</div>
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
            <span>{event.eventDate}</span>
          </div>

          <div className="event-info">
            <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
            </svg>
            <span>{event.location}</span>
          </div>

          <div className="event-info">
            <svg className="event-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
            <span><strong>Status: {event.eventStatus}</strong></span>
          </div>
        </div>

        <div className="event-section">
          <h2 className="section-title">Beskrivning</h2>
          <p className="event-description">{event.description}</p>
        </div>

        <div className="event-section">
          {isRegistered ? (
            <div className="space-y-3">
              <div className="registered-status">
                <svg className="check-icon" fill="currentColor" viewBox="0 0 20 20">
                  <path fillRule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clipRule="evenodd" />
                </svg>
                Du är anmäld till detta event
              </div>
              <button
                onClick={handleUnregister}
                disabled={actionLoading}
                className="btn btn-danger btn-full"
              >
                {actionLoading ? 'Bearbetar...' : 'Avanmäl mig'}
              </button>
            </div>
          ) : (
            <button
              onClick={handleRegister}
              disabled={actionLoading}
              className="btn btn-primary btn-full"
            >
              {actionLoading ? 'Bearbetar...' : isAuthenticated ? 'Anmäl mig' : 'Logga in för att anmäla dig'}
            </button>
          )}
        </div>

        <div className="mt-6">
          <button
            onClick={() => navigate('/')}
            className="auth-link"
          >
            ← Tillbaka till alla evenemang
          </button>
        </div>
      </div>
    </div>
  );
};

export default EventDetails;