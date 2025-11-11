// pages/AboutPage.jsx

import React from "react";
import "./AboutPage.css";

const AboutPage = () => {
  return (
    <div className="about-page">
      <section className="about-hero">
        <h1>About Event Management</h1>
        <p>
          Event Management is a digital platform that helps companies plan,
          organize, and promote events — from small meetings to large festivals.
          We create unforgettable experiences and make event planning simple for everyone.
        </p>
      </section>

      <section className="about-story">
        <h2>Our Story</h2>
        <p>
          Founded in <strong>Lund, Sweden in 2025</strong>, we started with a simple idea:
          to make events more accessible to the public and help businesses reach more people.
          We built a solution that brings registrations, communication, and management together in one place.
        </p>
      </section>

      <section className="about-mission">
        <h2>Our Mission</h2>
        <p>
          We believe that events are about people — and we want to make it easier
          for everyone to create meaningful experiences that connect and inspire.
        </p>
      </section>

    </div>
  );
};

export default AboutPage;
