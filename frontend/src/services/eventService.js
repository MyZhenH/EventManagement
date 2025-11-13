import api from './api';

export const eventService = {
  // Event endpoints (public)
  getAllEvents: async () => {
    const response = await api.get('/events');
    return response.data;
  },

  getEventById: async (eventId) => {
    const response = await api.get(`/events/${eventId}`);
    return response.data;
  },

  // Participant endpoints (required login)
  registerForEvent: async (eventId) => {
    const response = await api.post(`/participants/register/${eventId}`);
    return response.data;
  },

  unregisterFromEvent: async (eventId) => {
    const response = await api.delete(`/participants/unregister/${eventId}`);
    return response.data;
  },

  checkRegistration: async (eventId) => {
    const response = await api.get(`/participants/check/${eventId}`);
    return response.data;
  },

  getMyEvents: async () => {
    const response = await api.get('/participants/my-events');
    return response.data;
  },
  // Admin
  /*createEvent: async (eventData) => {
    const response = await api.post('/events', eventData);
    return response.data;
  },

  updateEvent: async (eventId, eventData) => {
    const response = await api.patch(`/events/${eventId}`, eventData);
    return response.data;
  },

  deleteEvent: async (eventId) => {
    const response = await api.delete(`/events/${eventId}`);
    return response.data;
  },

  updateEventStatus: async (eventId, statusId) => {
    const response = await api.put(`/events/${eventId}/status`, { eventStatusId: statusId });
    return response.data;
  }*/
  // Admin endpoints
    createEvent: async (eventData) => {
      const response = await api.post('/events', eventData);
      return response.data; // EventResponseDto
    },

    updateEvent: async (eventId, eventData) => {
      const response = await api.patch(`/events/${eventId}`, eventData);
      return response.data; // EventResponseDto
    },

    deleteEvent: async (eventId) => {
      await api.delete(`/events/${eventId}`);
    },

     updateEventStatus: async (eventId, newStatusId) => {
        if (!eventId) throw new Error("Missing eventId for status update");
        const response = await fetch(`/api/events/${eventId}/status`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ eventStatusId: newStatusId }),
        });

        if (!response.ok) throw new Error("Failed to update event status");
        return response.json();
      },



};