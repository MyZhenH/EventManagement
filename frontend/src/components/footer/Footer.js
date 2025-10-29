// src/components/Footer/Footer.jsx
import React from "react";
import "./Footer.css";

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-top">
      <h2>EVENT MANAGEMENT</h2>
        <div className="footer-sections">
        <div className="footer-section about-us">
          <h3>About us</h3>
          <p>We create memorable events from meetup to festival</p>
          <button>Learn More ➔</button>
          <div className="footer-section address">
          <p>Kalkstensvägen 3, Lund, Sweden</p>
          <p>Phone: +46 70 123 45 67</p>
          <p>Email: info@eventmanagement.com</p>
        </div>
       </div>

        <div className="footer-section need-help">
          <h3>Need help?</h3>
          <a href="/faq">FAQ</a>
          <a href="/contact">Contact us</a>
          <a href="/careers">Careers</a>
          <a href="/organizer">For organizers</a>
        </div>

        <div className="footer-section legal">
          <h3>Legal</h3>
          <a href="/privacy-policy">Privacy Policy</a>
          <a href="/terms-of-service">Terms of service</a>
          <a href="/cookie">Cookie Policy</a>
        </div>

        <div className="footer-section follow-us">
          <h3>Follow us</h3>
          <div className="newsletter">
            <p>Sign up for our newsletter</p>
            <input type="email" placeholder="you@example.com" />
            <button>Submit</button>
          </div>
        </div>
      </div>
     </div>

      <div className="footer-bottom">
        <p>© 2025 Event Management. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;


