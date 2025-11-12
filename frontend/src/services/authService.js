import api from './api';

export const authService = {
  // Check if user is authenticated
  checkAuth: async () => {
    const response = await api.get('/auth/check');
    return response.data;
  },

  // Logout user
  logout: async () => {
    const response = await api.post('/auth/logout');
    return response.data;
  }
};