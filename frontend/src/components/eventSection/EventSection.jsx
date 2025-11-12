import React, { useEffect, useState } from "react";
import EventCard from "../events/EventCard";
import "./EventSection.css";
import { eventService } from '../../services/eventService';



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


        const count = Math.min(10, musicEvents.length);

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
        <h2 className="title">Upcoming Events</h2>
        <p>Discover what’s happening this month</p>

        <div className="event-grid">
          {upcomingEvents.map((event) => (
            <EventCard key={event.eventId} event={event} />
          ))}
        </div>
      </section>

      <section className="new-events">
        <h2 className="title">Don’t Miss These</h2>
        <p>Check out the hottest upcoming events this month</p>

        <div className="event-grid">
          {dontMissEvents.map((event) => (
            <EventCard key={event.eventId} event={event} />
          ))}
        </div>
      </section>

      <section className="music-events">
              <h2 className="title">Music</h2>
              <p>Check out music events</p>

              <div className="music-grid">
                  {categoryMusic
                    .filter((event) => event.categoryId === 5)
                    .slice(0, 10)
                    .map((event) => (
                      <EventCard key={event.eventId} event={event} />
                    ))}
                </div>

            </section>
    </div>
  );
};

export default EventSection;



