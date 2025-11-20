import { useState, useEffect } from 'react';
import './HeroSlider.css';

const events = [
  { id: 1, title: 'Tech Conference', image: 'https://images.unsplash.com/photo-1587825140708-dfaf72ae4b04?auto=format&fit=crop&w=1920&h=1080&q=80' },
  { id: 2, title: 'Holi Music Festival', image: 'https://images.unsplash.com/photo-1582711012124-a56cf82307a0?auto=format&fit=crop&w=1920&h=1080&q=80' },
  { id: 3, title: 'National Swimming Championships 2026', image: 'https://images.unsplash.com/photo-1530549387789-4c1017266635?auto=format&fit=crop&w=1920&h=1080&q=80'},
  { id: 4, title: 'Princess Cruises alaska', image: 'https://images.unsplash.com/photo-1576724196706-3f23f51ea351?auto=format&fit=crop&w=1920&h=1080&q=80'},
  { id: 5, title: 'Way Out West', image: 'https://images.unsplash.com/photo-1506157786151-b8491531f063?auto=format&fit=crop&w=1920&h=1080&q=80'},
];



const HeroSlider = () => {
  const [currentIndex, setCurrentIndex] = useState(0);

  const prevSlide = () => {
    setCurrentIndex((prev) => (prev === 0 ? events.length - 1 : prev - 1));
  };

  const nextSlide = () => {
    setCurrentIndex((prev) => (prev === events.length - 1 ? 0 : prev + 1));
  };

  useEffect(() => {
      const interval = setInterval(nextSlide, 8000);
      return () => clearInterval(interval);
    }, []);



  return (
    <section className="hero-slider">
      <div className="slide-track"
       style={{ transform: `translateX(-${currentIndex * 100}%)` }}
        >
       {events.map((event) => (
           <div
           key={event.id}
           className="hero-slide"
           style={{ backgroundImage: `url(${event.image})` }}
           >

        <div className="hero-content">
          <h1>{event.title}</h1>
          <button className="btn btn-hero">See More</button>
         </div>
        </div>
       ))}
   </div>

        <button className="prev" onClick={prevSlide} aria-label="Previous Slide">
          &#10094;
        </button>
        <button className="next" onClick={nextSlide} aria-label="Next Slide">
          &#10095;
        </button>
    </section>
  );
};

export default HeroSlider;
