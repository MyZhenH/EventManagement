import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import Navbar from './components/layout/Navbar';
import EventList from './components/events/EventList';
import EventDetails from './components/events/EventDetails';
import MyEvents from './components/events/MyEvents';
import Login from './components/auth/Login';

function App() {
  return (
    <Router>
      <AuthProvider>
        <div className="min-h-screen bg-gray-50">
          <Navbar />
          <Routes>
            {/* Public routes */}
            <Route path="/" element={<EventList />} />
            <Route path="/events/:eventId" element={<EventDetails />} />
            <Route path="/login" element={<Login />} />

            {/* Protected routes */}
            <Route path="/my-events" element={<MyEvents />} />
          </Routes>
        </div>
      </AuthProvider>
    </Router>
  );
}

export default App;