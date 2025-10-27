import React from 'react';
import { useNavigate } from 'react-router-dom';
import './EventCard.css';

function EventCard({ event }) {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/events/${event.eventId}`);
  };

  return (
    <div className="event-card" onClick={handleClick}>
      <div className="event-card-header">
        <h3 className="event-card-title">{event.title}</h3>
      </div>

      <div className="event-card-body">
        <div className="event-info">
          <div className="event-info-item">
            <span className="info-icon">📅</span>
            <span>{event.eventDate || 'Date not specified'}</span>
          </div>

          <div className="event-info-item">
            <span className="info-icon">📍</span>
            <span>{event.location}</span>
          </div>
        </div>
      </div>
    </div>
  );
}

export default EventCard;