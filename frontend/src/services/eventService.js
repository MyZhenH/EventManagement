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
  }
};