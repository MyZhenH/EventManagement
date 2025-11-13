
import React from 'react';
import { eventService } from '../../services/eventService';
import './AdminDashboard.css';

const AdminEventCard = ({ event, onUpdate, onEdit }) => {
  if (!event) return null; // safety check

  const handleDelete = async () => {
    if (window.confirm('Are you sure you want to delete this event?')) {
      try {
        await eventService.deleteEvent(event.eventId);
        onUpdate();
      } catch (err) {
        console.error('Delete failed', err);
      }
    }
  };

  const handleUpdateStatus = async () => {
    const newStatus = prompt('Enter new status (e.g., ACTIVE, CANCELLED):', event.eventStatus || '');
    if (newStatus) {
      try {
        await eventService.updateEventStatus(event.eventId, newStatus);
        onUpdate();
      } catch (err) {
        console.error('Update status failed', err);
      }
    }
  };

  return (
    <div className="admin-event-card">
      <h3>{event.title || 'No Title'}</h3>

      <p><strong>Location:</strong> {event.location || 'N/A'}</p>

      <p><strong>Start:</strong> {event.startDate ? new Date(event.startDate).toLocaleString() : 'N/A'}</p>
      <p><strong>End:</strong> {event.endDate ? new Date(event.endDate).toLocaleString() : 'N/A'}</p>

      <div className="card-buttons">
        <button className="btn btn-primary" onClick={() => onEdit(event)}>Edit</button>
        <button className="btn btn-danger" onClick={handleDelete}>Delete</button>
        <button className="btn btn-secondary" onClick={handleUpdateStatus}>Update Status</button>
      </div>
    </div>
  );
};

export default AdminEventCard;
