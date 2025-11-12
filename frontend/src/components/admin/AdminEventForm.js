import React, { useState, useEffect } from 'react';
import { eventService } from '../../services/eventService';
import './AdminDashboard.css';

const AdminEventForm = ({ eventToEdit, onSave }) => {
  const [formData, setFormData] = useState({
    title: '',
    description: '',
    startDate: '',
    endDate: '',
    location: '',
    categoryId: '',
    eventStatusId: '',
  });

  const [categories, setCategories] = useState([]);
  const [statuses, setStatuses] = useState([]);

  useEffect(() => {
    // Fetch categories and statuses from API
    const fetchData = async () => {
      try {
        const categoriesData = await eventService.getAllCategories();
        const statusesData = await eventService.getAllEventStatuses();
        setCategories(categoriesData);
        setStatuses(statusesData);
      } catch (err) {
        console.error('Failed to load categories/statuses', err);
      }
    };
    fetchData();
  }, []);

  useEffect(() => {
    if (eventToEdit) {
      // Map API response to form
      setFormData({
        title: eventToEdit.title || '',
        description: eventToEdit.description || '',
        startDate: eventToEdit.startDate ? eventToEdit.startDate.slice(0,16) : '', // for datetime-local
        endDate: eventToEdit.endDate ? eventToEdit.endDate.slice(0,16) : '',
        location: eventToEdit.location || '',
        categoryId: eventToEdit.categoryId || '',
        eventStatusId: eventToEdit.eventStatusId || '',
      });
    }
  }, [eventToEdit]);

  const handleChange = (e) => {
    setFormData(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (eventToEdit && eventToEdit.eventId) {
        await eventService.updateEvent(eventToEdit.eventId, formData);
      } else {
        await eventService.createEvent(formData);
      }
      onSave(); // refresh dashboard
    } catch (err) {
      console.error('Failed to save event', err);
    }
  };

  return (
    <form className="admin-form" onSubmit={handleSubmit}>
      <h2>{eventToEdit ? 'Edit Event' : 'Create Event'}</h2>

      <label>Title</label>
      <input type="text" name="title" value={formData.title} onChange={handleChange} required />

      <label>Description</label>
      <textarea name="description" value={formData.description} onChange={handleChange} />

      <label>Start Date</label>
      <input type="datetime-local" name="startDate" value={formData.startDate} onChange={handleChange} required />

      <label>End Date</label>
      <input type="datetime-local" name="endDate" value={formData.endDate} onChange={handleChange} required />

      <label>Location</label>
      <input type="text" name="location" value={formData.location} onChange={handleChange} />

      <label>Category</label>
      <select name="categoryId" value={formData.categoryId} onChange={handleChange} required>
        <option value="">Select Category</option>
        {categories.map(cat => (
          <option key={cat.categoryId} value={cat.categoryId}>{cat.categoryName}</option>
        ))}
      </select>

      <label>Status</label>
      <select name="eventStatusId" value={formData.eventStatusId} onChange={handleChange} required>
        <option value="">Select Status</option>
        {statuses.map(status => (
          <option key={status.eventStatusId} value={status.eventStatusId}>{status.statusName}</option>
        ))}
      </select>

      <button type="submit" className="btn btn-success">{eventToEdit ? 'Update' : 'Create'}</button>
    </form>
  );
};

export default AdminEventForm;
