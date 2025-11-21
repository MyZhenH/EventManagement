import React, { useState } from "react";
import EventFilters from "../components/eventFilters/EventFilters";
import EventList from "../components/events/EventList";
import HeroSlider from "../components/heroSlider/HeroSlider";
import EventSection from "../components/eventSection/EventSection";

const HomePage = () => {
  const [filteredEvents, setFilteredEvents] = useState([]);

  const handleFilterChange = (filters) => {
    console.log("Filters:", filters);
  };

  return (
    <div>
      <EventFilters onFilterChange={handleFilterChange} />
      <HeroSlider />
      <EventSection />
    </div>
  );
};

export default HomePage;
