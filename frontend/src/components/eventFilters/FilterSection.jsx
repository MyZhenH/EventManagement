import React from "react";
import EventFilters from "./EventFilters";
import "./FilterSection.css";

const FilterSection = ({ title, subtitle, filterProps }) => {
  return (
    <section className="filter-section">
      <h2>Filter</h2>
      <p></p>
      <EventFilters {...filterProps} />
    </section>
  );
};

export default FilterSection;
