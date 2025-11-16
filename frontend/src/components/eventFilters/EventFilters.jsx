import React, { useState} from "react";
import "./EventFilters.css";
import { FaSearch } from "react-icons/fa";

const EventFilters = ({ onFilterChange }) => {
  const [filters, setFilters] = useState({
    date: "",
    city: "",
    category: "",
    search: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    const newFilters = { ...filters, [name]: value };
    setFilters(newFilters);
    if (onFilterChange) onFilterChange(newFilters);
  };


  return (
    <div className="event-filters">
        <input type="date" name="date" value={filters.date} onChange={handleChange} />
            <select name="city" value={filters.city} onChange={handleChange}>
              <option value="">All cities</option>
              <option value="stockholm">Stockholm</option>
              <option value="gothenburg">Gothenburg</option>
              <option value="malmo">Malmö</option>
            </select>
      <select name="category" value={filters.category || ""} onChange={handleChange}>
        <option value="">All categories</option>
        <option value="music">Music</option>
        <option value="sports">Sports</option>
        <option value="theater">Theater</option>
      </select>
      <div className="search-wrapper">
        <FaSearch className="search-icon" />
        <input
          type="text" name="search" value={filters.search}
          onChange={handleChange}
          placeholder="Search events..." />
          <button type="button">Search</button>
      </div>
    </div>
  );
};

export default EventFilters;
