import React, { useState, useEffect } from "react";
import { eventService } from "../../services/eventService";

const AdminEventForm = ({ eventToEdit, onSave, onCancel }) => {
  const [formData, setFormData] = useState({
    title: "",
    description: "",
    startDate: "",
    endDate: "",
    location: "",
    address: "",
    categoryId: "",
    eventStatusId: "",
    cityId: "",
  });

  const categories = [
    { categoryId: 1, categoryName: "Conference" },
    { categoryId: 2, categoryName: "Workshop" },
    { categoryId: 3, categoryName: "Meetup" },
    { categoryId: 4, categoryName: "Webinar" },
    { categoryId: 5, categoryName: "Music" },
    { categoryId: 6, categoryName: "Health & Wellness" },
    { categoryId: 7, categoryName: "Food & Drink" },
  ];

  const statuses = [
    { eventStatusId: 1, statusName: "Scheduled" },
    { eventStatusId: 2, statusName: "Cancelled" },
    { eventStatusId: 3, statusName: "Completed" },
  ];

  const cities = [
    { cityId: 1, cityName: "Stockholm" },
    { cityId: 2, cityName: "Gothenburg" },
    { cityId: 3, cityName: "Malmö" },
    { cityId: 4, cityName: "Uppsala" },
    { cityId: 5, cityName: "Helsingborg" },
    { cityId: 6, cityName: "Linköping" },
  ];

  useEffect(() => {
    if (eventToEdit) {
      setFormData({
        title: eventToEdit.title || "",
        description: eventToEdit.description || "",
        startDate: eventToEdit.startDate
          ? eventToEdit.startDate.slice(0, 16)
          : "",
        endDate: eventToEdit.endDate
          ? eventToEdit.endDate.slice(0, 16)
          : "",
        location: eventToEdit.location || "",
        address: eventToEdit.address || "",
        categoryId: eventToEdit.categoryId?.toString() || "",
        eventStatusId: eventToEdit.eventStatusId?.toString() || "",
        cityId: eventToEdit.cityId?.toString() || "",
      });
    }
  }, [eventToEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = {
      title: formData.title,
      description: formData.description,
      startDate: formData.startDate,
      endDate: formData.endDate,
      location: formData.location,
      address: formData.address,
      categoryId: Number(formData.categoryId),
      eventStatusId: Number(formData.eventStatusId),
      cityId: Number(formData.cityId),
    };

    try {
      if (eventToEdit && eventToEdit.eventId) {
        await eventService.updateEvent(eventToEdit.eventId, payload);
        alert("Event updated successfully!");
      } else {
        await eventService.createEvent(payload);
        alert("Event created successfully!");
      }
      onSave();
    } catch (err) {
      console.error("Error saving event:", err);
      alert("Error saving event");
    }
  };

  return (
    <div className="admin-event-form-container">
      <h3>{eventToEdit ? "Edit Event" : "Create New Event"}</h3>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title</label>
          <input
            name="title"
            value={formData.title}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label>Description</label>
          <textarea
            name="description"
            value={formData.description}
            onChange={handleChange}
          />
        </div>

        <div>
          <label>Start Date</label>
          <input
            type="datetime-local"
            name="startDate"
            value={formData.startDate}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label>End Date</label>
          <input
            type="datetime-local"
            name="endDate"
            value={formData.endDate}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label>Location</label>
          <input
            name="location"
            value={formData.location}
            onChange={handleChange}
            required
          />
        </div>

        <div>
          <label>Address</label>
          <input
            name="address"
            value={formData.address}
            onChange={handleChange}
          />
        </div>

        <div>
          <label>Category</label>
          <select
            name="categoryId"
            value={formData.categoryId}
            onChange={handleChange}
            required
          >
            <option value="">-- Select Category --</option>
            {categories.map((cat) => (
              <option key={cat.categoryId} value={cat.categoryId}>
                {cat.categoryName}
              </option>
            ))}
          </select>
        </div>

        <div>
          <label>Status</label>
          <select
            name="eventStatusId"
            value={formData.eventStatusId}
            onChange={handleChange}
            required
          >
            <option value="">-- Select Status --</option>
            {statuses.map((st) => (
              <option key={st.eventStatusId} value={st.eventStatusId}>
                {st.statusName}
              </option>
            ))}
          </select>
        </div>

        <div>
          <label>City</label>
          <select
            name="cityId"
            value={formData.cityId}
            onChange={handleChange}
            required
          >
            <option value="">-- Select City --</option>
            {cities.map((city) => (
              <option key={city.cityId} value={city.cityId}>
                {city.cityName}
              </option>
            ))}
          </select>
        </div>

        <div className="form-buttons">
          <button type="submit" className="btn btn-primary">
            {eventToEdit ? "Update" : "Create"}
          </button>
          <button type="button" className="admin-event-form-cancel" onClick={onCancel}>
            Cancel
                 </button>

        </div>
      </form>
    </div>
  );
};

export default AdminEventForm;
