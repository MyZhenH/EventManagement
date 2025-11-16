// src/components/Footer/Footer.jsx
import React from "react";
import "./Footer.css";
import AboutSection from "./AboutSection"
import HelpSection from "./HelpSection"
import LegalSection from "./LegalSection"
import NewsletterSection from "./NewsletterSection"
import SocialMediaSection from "./SocialMediaSection"

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-top">
      <h2>EVENT MANAGEMENT</h2>
      </div>
        <div className="footer-sections">
            <AboutSection />
            <HelpSection />
            <LegalSection />
            <SocialMediaSection/>
            <NewsletterSection/>
      </div>
      <div className="footer-bottom">
        <p>© 2025 Event Management. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;


