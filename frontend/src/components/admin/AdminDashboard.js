
import React, { useState, useEffect } from 'react';
import { eventService } from '../../services/eventService';
import AdminEventCard from './AdminEventCard';
import AdminEventForm from './AdminEventForm';
import './AdminDashboard.css';

const AdminDashboard = () => {
  const [events, setEvents] = useState([]);
  const [editingEvent, setEditingEvent] = useState(null);
  const [showForm, setShowForm] = useState(false);

  const fetchEvents = async () => {
    try {
      const data = await eventService.getAllEvents();
      setEvents(data);
    } catch (error) {
      console.error('Problem fetching events:', error);
    }
  };

  useEffect(() => {
    fetchEvents();
  }, []);

  const handleCreateNew = () => {
    setEditingEvent(null);
    setShowForm(true);
  };

  const handleEdit = (event) => {
    setEditingEvent(event);
    setShowForm(true);

    // Fetch detailed event info
    eventService.getEventById(event.eventId)
      .then(detailedEvent => setEditingEvent(detailedEvent))
      .catch(err => console.warn('Failed to fetch detailed event, using basic info', err));
  };

  const handleSave = () => {
    fetchEvents();
    setEditingEvent(null);
    setShowForm(false);
  };

  return (
    <div className="admin-dashboard">
      <h2>Admin Dashboard</h2>

      <button onClick={handleCreateNew} className="btn btn-primary mb-4">
        Create New Event
      </button>

      {showForm && (
        <AdminEventForm
          eventToEdit={editingEvent}
          onSave={handleSave}
          className="admin-form"
        />
      )}

      <div className="events-grid">
        {events.map(event => (
          <AdminEventCard
            key={event.eventId}
            event={event}
            onUpdate={fetchEvents}
            onEdit={handleEdit}
            className="admin-event-card"
          />
        ))}
      </div>
    </div>
  );
};

export default AdminDashboard;


