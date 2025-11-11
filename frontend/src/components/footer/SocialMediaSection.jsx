import React from "react";
import { FaFacebook, FaInstagram, FaYoutube } from 'react-icons/fa';

const SocialMediaSection = () => (
    <div className= "footer_section pages_social-media">
    <h3>Follow us</h3>
    <div className="social-icons">
    <a href="https://facebook.com" target="_blank" rel="noopener noreferrer">
            <FaFacebook className="icon facebook"/>
          </a>
          <a href="https://instagram.com" target="_blank" rel="noopener noreferrer">
            <FaInstagram className="icon instagram"/>
          </a>
          <a href="https://youtube.com" target="_blank" rel="noopener noreferrer">
            <FaYoutube className="icon youtube"/>
          </a>
          </div>
    </div>

    );

 export default SocialMediaSection;



