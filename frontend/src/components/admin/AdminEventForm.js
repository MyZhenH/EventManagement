import React, { useState, useEffect } from "react";
import { eventService } from "../../services/eventService";
import "./AdminDashboard.css";

const AdminEventForm = ({ eventToEdit, onSave, onCancel }) => {
  const [formData, setFormData] = useState({
    title: "",
    description: "",
    startDate: "",
    endDate: "",
    location: "",
    categoryId: "",
    eventStatusId: "",
  });

  // Pre fill form when editing
  useEffect(() => {
    if (eventToEdit) {
      setFormData({
        title: eventToEdit.title || "",
        description: eventToEdit.description || "",
        startDate: eventToEdit.startDate
          ? eventToEdit.startDate.slice(0, 16)
          : "",
        endDate: eventToEdit.endDate ? eventToEdit.endDate.slice(0, 16) : "",
        location: eventToEdit.location || "",
        categoryId: eventToEdit.categoryId || "",
        eventStatusId: eventToEdit.eventStatusId || "",
      });
    }
  }, [eventToEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const payload = {
        ...formData,
        categoryId: Number(formData.categoryId),
        eventStatusId: Number(formData.eventStatusId),
      };

      if (eventToEdit && eventToEdit.eventId !== undefined) {
        await eventService.updateEvent(eventToEdit.eventId, payload);
        alert("Event updated successfully!");
      } else if (!eventToEdit) {
        await eventService.createEvent(payload);
        alert("Event created successfully!");
      } else {
        throw new Error("Missing eventId for update");
      }

      onSave();
    } catch (err) {
      console.error("Failed to save event:", err);
      alert("Failed to save event: " + err.message);
    }
  };

  return (
    <div className="admin-event-form-container">
      <h3>{eventToEdit ? "Edit Event" : "Create New Event"}</h3>
      <form onSubmit={handleSubmit}>
        <label>Title</label>
        <input
          type="text"
          name="title"
          value={formData.title}
          onChange={handleChange}
          required
        />

        <label>Description</label>
        <textarea
          name="description"
          value={formData.description}
          onChange={handleChange}
        />

        <label>Start Date</label>
        <input
          type="datetime-local"
          name="startDate"
          value={formData.startDate}
          onChange={handleChange}
          required
        />

        <label>End Date</label>
        <input
          type="datetime-local"
          name="endDate"
          value={formData.endDate}
          onChange={handleChange}
          required
        />

        <label>Location</label>
        <input
          type="text"
          name="location"
          value={formData.location}
          onChange={handleChange}
        />

        <label>Category ID</label>
        <input
          type="number"
          name="categoryId"
          value={formData.categoryId}
          onChange={handleChange}
          required
        />

        <label>Status ID</label>
        <input
          type="number"
          name="eventStatusId"
          value={formData.eventStatusId}
          onChange={handleChange}
          required
        />

        <div className="admin-event-form-buttons">
          <button type="submit" className="admin-event-form-submit">
            {eventToEdit ? "Update" : "Create"}
          </button>
          <button
            type="button"
            className="admin-event-form-cancel"
            onClick={onCancel}
          >
            Cancel
          </button>
        </div>
      </form>
    </div>
  );
};

export default AdminEventForm;
