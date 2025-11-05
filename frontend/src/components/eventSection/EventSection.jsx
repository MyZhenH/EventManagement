import React from "react";
import "./EventSection.css";


const EventSection = () => {
  return (

    <div className="event-sections">
      <section className="upcoming-events">
        <h2>Upcoming Events</h2>
        <p>Discover what’s happening this month</p>
        <div className="event-card" >

        </div>
      </section>

      <section className="new-events">
        <h2>Don’t Miss These</h2>
        <p>Check out the hottest upcoming events this month</p>
        <div className="event-card">
            </div>
      </section>
    </div>
  );
}

export default EventSection;