import React, { useEffect, useState } from "react";
import EventSlider from "../eventSection/EventSlider";
import { eventService } from "../../services/eventService";
import "./EventSection.css";
import { FaCalendarAlt, FaStar, FaMusic } from "react-icons/fa";

const EventSection = () => {
  const [upcomingEvents, setUpcomingEvents] = useState([]);
  const [dontMissEvents, setDontMissEvents] = useState([]);
  const [categoryMusic, setCategoryMusic] = useState([]);
  const [error, setError] = useState('');

 useEffect(() => {
    const fetchEvents = async () => {
      try {
        const data = await eventService.getAllEvents();
        setUpcomingEvents(data.slice(0, 6));
        setDontMissEvents(data.slice(6, 12));

        const musicEvents = data.filter((event) => Number(event.categoryId) === 5);
        const count = Math.min(7, musicEvents.length);
        const shuffled = [...musicEvents].sort(() => Math.random() - 0.5);
        const randomSeven = shuffled.slice(0, count);

        setCategoryMusic(randomSeven);

      } catch (err) {
        setError('Could not load events');
        console.error('Error fetching events:', err);
      }
  };

    fetchEvents();
  }, []);

  return (
    <div className="event-sections">

      <section className="upcoming-events">
        <h2 className="title">
            <FaCalendarAlt style={{ marginRight: '0.5rem', color: 'black' }} />
            Upcoming Events</h2>
        <p>Discover what’s happening this month</p>
        <EventSlider events={upcomingEvents} />
      </section>

      <section className="dont-miss-events">
        <h2 className="title">
                <FaStar style={{ marginRight: '0.5rem', color: '#ffc107' }} />
            Don't Miss These</h2>
        <p>Check out the hottest upcoming events this month</p>
        <EventSlider events={dontMissEvents} />
      </section>

      <section className="music-events">
        <h2 className="title">
            <FaMusic style={{ marginRight: '0.5rem', color: '#8e44ad' }} />
            Music</h2>
         <p>Check out music events</p>
        <EventSlider events={categoryMusic} />
      </section>

    </div>
  );
};

export default EventSection;
