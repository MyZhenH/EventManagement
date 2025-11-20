import React, { useState } from "react";
import EventCard from "../events/EventCard";
import "./EventSlider.css";

const EventSlider = ({ events }) => {
  const [index, setIndex] = useState(0);
  const cardsToShow = 3;

  const next = () => {
      if (index < events.length - cardsToShow) {
        setIndex(index + 1);
      }
    };

    const prev = () => {
      if (index > 0) {
        setIndex(index - 1);
      }
    };

return (
    <div className="slider-container">

      <button
        className="slider-arrow left"
        onClick={prev}
        disabled={index === 0}
      >
        &#10094;
      </button>

      {/* WRAPPER */}
      <div className="slider-window">
        <div
          className="slider-track"
          style={{
            transform: `translateX(-${index * (100 / cardsToShow)}%)`,
          }}
        >
          {events.map((event) => (
            <div className="slider-card" key={event.eventId}>
              <EventCard event={event} />
            </div>
          ))}
        </div>
      </div>

      <button
        className="slider-arrow right"
        onClick={next}
        disabled={index >= events.length - cardsToShow}
      >
        &#10095;
      </button>

    </div>
  );
};

export default EventSlider;
