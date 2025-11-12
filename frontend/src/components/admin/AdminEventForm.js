import React from 'react';
import { eventService } from '../../services/eventService';
import './AdminDashboard.css';

const AdminEventCard = ({ event, onUpdate, onEdit }) => {

  const handleDelete = async () => {
    if (window.confirm('Are you sure you want to delete this event?')) {
      await eventService.deleteEvent(event.eventId);
      onUpdate();
    }
  };

  const handleUpdateStatus = async () => {
    const newStatus = prompt('Enter new status (e.g., ACTIVE, CANCELLED):', event.eventStatus || '');
    if (newStatus) {
      await eventService.updateEventStatus(event.eventId, newStatus);
      onUpdate();
    }
  };

  return (
    <div className="admin-event-card">
      <h3>{event.title}</h3>

      <p><strong>Description:</strong> {event.description || 'N/A'}</p>
      <p><strong>Location:</strong> {event.location}</p>
      <p><strong>Category ID:</strong> {event.categoryId || 'N/A'}</p>
      <p><strong>Status ID:</strong> {event.eventStatusId || 'N/A'}</p>
      <p><strong>Start:</strong> {new Date(event.startDate).toLocaleString()}</p>
      <p><strong>End:</strong> {new Date(event.endDate).toLocaleString()}</p>
      <p><strong>Created At:</strong> {event.createdAt ? new Date(event.createdAt).toLocaleString() : 'N/A'}</p>
      <p><strong>Updated At:</strong> {event.updatedAt ? new Date(event.updatedAt).toLocaleString() : 'N/A'}</p>
      <p><strong>Created By:</strong> {event.createdBy || 'N/A'}</p>
      <p><strong>Updated By:</strong> {event.updatedBy || 'N/A'}</p>

      <div className="card-buttons">
        <button className="btn btn-primary" onClick={() => onEdit(event)}>Edit</button>
        <button className="btn btn-danger" onClick={handleDelete}>Delete</button>
        <button className="btn btn-secondary" onClick={handleUpdateStatus}>Update Status</button>
      </div>
    </div>
  );
};

export default AdminEventCard;


