import React from 'react';
import { useNavigate } from 'react-router-dom';
import './EventCard.css';
import { formatEventDate } from "../../utils/dateUtils";

function EventCard({ event }) {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/events/${event.eventId}`);
  };

  const displayEvent = {
  image: "https://images.unsplash.com/photo-1517457373958-b7bdd4587205?q=80&w=1169&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
  };


  return (
    <div className="event-card" onClick={handleClick}>
      <div className="event-card-header">
        <h3 className="event-card-title">{event.title}</h3>
      </div>

       <img
          src={displayEvent.image}
          alt={displayEvent.title}
          className="event-card-image"
          />

      <div className="event-card-body">
        <div className="ec-event-info">
          <div className="event-info-item">
            <span className="info-icon">📅</span>
            <span>{formatEventDate(event.startDate, event.endDate)}</span>
          </div>

          <div className="event-info-item">
            <span className="info-icon">📍</span>
            <span>{event.location}</span>
          </div>
        </div>
        <button className="btn event-card-button" onClick={handleClick}>
        Show details
        </button>
      </div>
    </div>
  );
}

export default EventCard;