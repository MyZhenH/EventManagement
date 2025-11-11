// components/footer/AboutSection.jsx
import { useNavigate } from "react-router-dom";

const AboutSection = () => {
  const navigate = useNavigate();

  return (
    <div className="footer_section pages_about">
      <h3>About us</h3>
      <p>We create memorable events <br />from meetup to festival.</p>
      <button onClick={() => navigate("/about")} className="footer_button">
        Learn More ➔
      </button>
      <address className="footer_address">
        <p>Kalkstensvägen 3, Lund, Sweden</p>
        <p>Phone: +46 70 123 45 67</p>
        <p>Email: info@eventmanagement.com</p>
      </address>
    </div>
  );
};

export default AboutSection;
